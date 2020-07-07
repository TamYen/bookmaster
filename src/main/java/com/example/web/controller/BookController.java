package com.example.web.controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.handler.BookValidData;
import com.example.handler.Handler;
import com.example.handler.MessageInfo;
import com.example.orm.model.MtBook;
import com.example.orm.model.TblBook;
import com.example.service.BookService;
import com.example.web.form.BookForm;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BookController.class);
		
	Handler handler = new Handler();
	MessageInfo msg = new MessageInfo();
	
	@GetMapping("/bookmaster")
	public ModelAndView showBookMaster(ModelAndView model, HttpServletRequest request) {
		model.setViewName("book-master");
		try {
			BookForm bookForm = (BookForm) request.getSession().getAttribute("bookSession");
			model.addObject("bookForm", bookForm);
		} catch (Exception e) {
			model.addObject("bookForm", new BookForm());
		}
		request.getSession().setAttribute("bookSession", "");
		return model;
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<MtBook>> getAll(){
		List<MtBook> list = bookService.getAll();
		System.out.println(list.get(0).getBookId());
		return new ResponseEntity<List<MtBook>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/addbook/checkdata")
	public ModelAndView addBook(@ModelAttribute("bookForm") BookForm bookForm, ModelAndView model, HttpServletRequest request) {
		LOG.info("addbook checkdata");
		try {
			BookValidData validData = new BookValidData(bookForm);
			if(validData.getMsg() != null) {
				model.addObject("msg", validData.getMsg());
				model.setViewName("book-master");
				request.getSession().setAttribute("bookSession", "");
				return model;
			}
			
			request.getSession().setAttribute("bookSession", bookForm);
			model.setViewName("book-confirm");
			model.addObject("button", "<button id=\"addBook\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">追加</button>");

		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			model.setViewName("book-master");
		}
		return model;
	}
	
	@GetMapping("/updatebook/checkdata")
	public ModelAndView updateBook(@ModelAttribute("bookForm") BookForm bookForm, ModelAndView model, HttpServletRequest request) {
		LOG.info("update book check data");
		try {
			BookValidData validData = new BookValidData(bookForm);
			if(validData.getMsg() != null) {
				model.addObject("msg", validData.getMsg());
				model.setViewName("book-master");
				request.getSession().setAttribute("bookSession", "");
				return model;
			}
			
			request.getSession().setAttribute("bookSession", bookForm);
			model.setViewName("book-confirm");
			model.addObject("button", "<button id=\"updateBook\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">更新</button>");
		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			model.setViewName("book-master");
		}
		return model;
	}
	
	@Transactional
	@GetMapping("/addbook")
	public ModelAndView addBook(ModelAndView model, HttpServletRequest request) {
		
		LOG.info("addBook");
		model.setViewName("book-master");
		
		try {
			BookForm bookForm = (BookForm) request.getSession().getAttribute("bookSession");
			model.addObject("bookForm", bookForm);
			
			TblBook book = bookService.getById(bookForm.getBookId());
			
			if(book != null) {
				model.addObject("msg", "本ID" + bookForm.getBookId() + "は登録されています。別のIDを入力してください。");
				return model;
			}
			
			Date pubDate;
			String date = bookForm.getPubYear() + "-" + bookForm.getPubMonth() + "-" + bookForm.getPubDate();
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String registId = auth.getName();
			try {
				pubDate = new Handler().convertStringToSqlDate(date);
				TblBook newBook = new TblBook(bookForm.getBookId(), bookForm.getBookTitle(), bookForm.getAuthorName(), bookForm.getPublisher(), pubDate, registId, new java.util.Date(), "0");
				bookService.addBook(newBook);
				
				model.addObject("msg", "本を登録しました。");
				request.getSession().setAttribute("bookSession", "");
				
			} catch (ParseException e) {
				model.addObject("msg", "出版年月日が不正です");
			} catch (RuntimeException e) {
				LOG.error(e.toString());
				model.addObject("msg", "DBエラーが発生しました。");
			}
		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("bookForm", new BookForm());
		}
		return model;
	}
	
	@Transactional
	@GetMapping("/updatebook")
	public ModelAndView updateBook(ModelAndView model, HttpServletRequest request) {
		
		LOG.info("updateBook");
		model.setViewName("book-master");
		
		try {
			BookForm bookForm = (BookForm) request.getSession().getAttribute("bookSession");
			model.addObject("bookForm", bookForm);
			
			TblBook book = bookService.getById(bookForm.getBookId());
			
			if(book == null) {
				model.addObject("msg", "本ID" + bookForm.getBookId() + "が見つかりません。");
				return model;
			}
			
			Date pubDate;
			String date = bookForm.getPubYear() + "-" + bookForm.getPubMonth() + "-" + bookForm.getPubDate();
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String updateId = auth.getName();
			try {
				pubDate = new Handler().convertStringToSqlDate(date);
				
				book.setBookTitle(bookForm.getBookTitle());
				book.setAuthorName(bookForm.getAuthorName());
				book.setPublisher(bookForm.getPublisher());
				book.setPublicationDay(pubDate);
				book.setUpdateId(updateId);
				book.setUpdateDate(new java.util.Date());
				
				if(bookService.updateById(book) == 0) throw new RuntimeException();
				
				model.addObject("msg", "本を更新しました。");
				
			} catch (ParseException e) {
				model.addObject("msg", "出版年月日が不正です");
			} catch (RuntimeException e) {
				LOG.error(e.toString());
				model.addObject("msg", "DBエラーが発生しました。");
			}
		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("bookForm", new BookForm());
		}
		request.getSession().setAttribute("bookSession", "");
		return model;
	}
	
	@GetMapping("/searchbook")
	public ModelAndView searchBook(@ModelAttribute("bookForm") BookForm bookForm, ModelAndView model, HttpServletRequest request) {
		try {
			String msg = null;
			model.setViewName("book-master");
			
			if(bookForm.getBookId().isEmpty()) {
				msg = "本IDを入力してください。";
			}else if(bookForm.getBookId().matches("[a-zA-Z0-9]+$") == false) {
				msg = "本IDは半角英数字で入力してください。";
			}
			
			bookForm.setOnlyId();
			
			if(msg != null) {
				model.addObject("msg", msg);
				return model;
			}
			
			try {
				TblBook book = bookService.getByIdAndFlag(bookForm.getBookId());
				if(book == null) {
					model.addObject("msg", "本ID" + bookForm.getBookId() + "が見つかりません。");
					return model;
				}
				
				bookForm.setBookTitle(book.getBookTitle());
				bookForm.setAuthorName(book.getAuthorName());
				bookForm.setPublisher(book.getPublisher());
				bookForm.setPubYear(book.getPublicationDay().toString().substring(0, 4));
				bookForm.setPubMonth(book.getPublicationDay().toString().substring(5, 7));
				bookForm.setPubDate(book.getPublicationDay().toString().substring(8, 10));
				
				model.addObject("msg", "本が見つかりました。");
			} catch (Exception e) {
				model.addObject("msg", "DBエラーが発生しました。");
			}
		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("bookForm", new BookForm());
		}
		
		return model;
	}
	
	@GetMapping("/deletebook/checkdata")
	public ModelAndView deleteMember(@ModelAttribute("bookForm") BookForm bookForm, ModelAndView model, HttpServletRequest request) {
		String msg = null;
		
		if(bookForm.getBookId().isEmpty()) {
			msg = "本ID を入力してください。";
		}else if(bookForm.getBookId().matches("[a-zA-Z0-9]+$") == false){
			msg = "本IDは半角英数字で入力してください。";
		}
		
		if(msg == null) {
			request.getSession().setAttribute("bookSession", bookForm);
			model.addObject("button", "<button id=\"deleteBook\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">削除</button>");
			model.setViewName("book-confirm");
		}else {
			model.addObject("msg", msg);
			request.getSession().setAttribute("bookSession", "");
			model.setViewName("book-master");
		}
		
		return model;
	}
	
	@Transactional
	@GetMapping("/deletebook")
	public ModelAndView deleteBook(ModelAndView model, HttpServletRequest request) {
		
		model.setViewName("book-master");
		
		try {
			BookForm bookForm = (BookForm) request.getSession().getAttribute("bookSession");
			
			TblBook book = bookService.getById(bookForm.getBookId());
			if(book == null) {
				model.addObject("msg", "本ID" + bookForm.getBookId() +"が見つかりません。");
				model.addObject("bookForm", bookForm);
				return model;
			}
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			book.setUpdateId(auth.getName());
			book.setUpdateDate(new java.util.Date());
			book.setDeleteFlg("1");
			bookService.updateById(book);
			
			model.addObject("msg", "本ID" + bookForm.getBookId() + "を削除しました。");
			model.addObject("bookForm", new BookForm());
		} catch (RuntimeException e) {
			LOG.error(e.toString());
			model.addObject("msg", "DBエラーが発生しました。");
		} catch (Exception e) {
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("bookForm", new BookForm());
		}
		
		request.getSession().setAttribute("bookSession", "");
		return model;
	}
	
}
