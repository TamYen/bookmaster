package com.example.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.orm.model.TblBook;
import com.example.orm.model.TblRental;
import com.example.service.BookService;
import com.example.service.RentalService;
import com.example.web.form.BookForm;
import com.example.web.form.ReturnForm;

@Controller
@RequestMapping("/bookreturn")
public class ReturnController {
	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private BookService bookService;
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ReturnController.class);
	private String btnReturn = "<button class=\"btn btn-primary\" onclick=\"send()\" style=\"float: right;width: 150px;\">返却</button>";

	@GetMapping("")
	public ModelAndView showReturn(ModelAndView model) {
		model.setViewName("return");
		ReturnForm form = new ReturnForm();
		model.addObject("returnForm", form);
		return model;
	}
	
	@GetMapping("searchmember")
	public ModelAndView searchMember(ModelAndView model, @ModelAttribute("returnForm") ReturnForm form) {
		model.setViewName("return");
		String memberId = form.getMemberId();
		String msg = null;
		
		// 会員IDの入力チェック
		if(memberId.isEmpty()) {
			msg = "会員IDを入力してください。";
		}else if(memberId.matches("[a-zA-Z0-9]+$") == false) {
			msg = "会員IDは半角英数字で入力してください。";
		}
		if(msg != null) {
			model.addObject("msg", msg);
			return model;
		}
		// 貸出検索
		try {
			List<TblRental> rentals = rentalService.getByMemberId(memberId);
			if(rentals == null) {
				LOG.info("memberId not exist or unavailable: " + memberId);
				model.addObject("msg", "貸出されている本はありません。");
				return model;
			}
			
			List<BookForm> books = new ArrayList<BookForm>();
			
			for(int i=0; i<rentals.size(); i++) {
				TblBook tblBook = bookService.getById(rentals.get(i).getBookId());
				BookForm book = new BookForm();
				book.setBookId(tblBook.getBookId());;
				book.setBookTitle(tblBook.getBookTitle());
				books.add(book);
			}
			form.setBooks(books);
			model.addObject("returnForm", form);
			model.addObject("msg", books.size() + "件貸出されています。");
			model.addObject("button", btnReturn);
		} catch (Exception e) {
			LOG.error(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
			return model;
		}
		
		
		return model;
	}
	
	@Transactional
	@GetMapping("/return")
	public ModelAndView returnBooks(ModelAndView model, HttpServletRequest request) {
		try {
			String strBookIds = request.getParameter("bookIds");
			String memberId = request.getParameter("memberId");
			LOG.info("returnBooks member id: " + memberId);
			LOG.info("returnBooks strBookIds: " + strBookIds);
			String[] bookIds = strBookIds.split(",");
			
			String msg = null;
			if(memberId.isEmpty()) {
				msg = "会員IDを入力してください。";
			}else if(memberId.matches("[a-zA-Z0-9]+$") == false) {
				msg = "会員IDは半角英数字で入力してください。";
			}else if(strBookIds.isEmpty()) {
				msg = "返却する本が選択されていません。";
			}
			System.out.println(strBookIds.matches("[,]+$"));
			ReturnForm form = new ReturnForm();
			form.setMemberId(memberId);
			model.setViewName("return");
			
			if(msg != null) {
				model.addObject("msg", msg);
				model.addObject("returnForm", form);
				return model;
			}
			
			//	返却対象確認処理(貸出リストでチェックした分、繰り返す)
			List<TblRental> rentals = new ArrayList<TblRental>();
			
			for(int i=0; i<bookIds.length; i++) {
				TblRental rental = rentalService.getByBookIdAndMemberId(bookIds[i], memberId);
				if(rental == null) {
					model.addObject("msg", "本ID" + bookIds[i] + "の本は貸出されていません。");
					List<BookForm> books = reSearch(memberId);
					if(books == null) {
						model.addObject("returnForm", form);
						return model;
					}
					form.setBooks(books);
					model.addObject("returnForm", form);
					model.addObject("button", btnReturn);
					return model;
				}
				rentals.add(rental);
			}
			
			//	返却処理(貸出リストでチェックした分、繰り返す
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String updateId = auth.getName();
			for(int i=0; i<rentals.size(); i++) {
				rentals.get(i).setUpdateId(updateId);
				rentals.get(i).setReturnDate(new Date());
				rentals.get(i).setStatus(2);
				rentals.get(i).setUpdateDate(new Date());
				rentalService.returnBook(rentals.get(i));
			}
			model.addObject("msg", "返却されました。");
			
			//	貸出再検索
			List<BookForm> books = reSearch(memberId);
			if(books == null) {
				model.addObject("returnForm", form);
				return model;
			}
			form.setBooks(books);
			model.addObject("returnForm", form);
			model.addObject("msg", books.size() + "件貸出されています。");
			model.addObject("button", btnReturn);
		} catch (RuntimeException e) {
			LOG.info(e.toString());
			model.addObject("msg", "DBエラーが発生しました。");
		} catch (Exception e) {
			LOG.error(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
		}
		return model;
	}
	
	public List<BookForm> reSearch(String memberId) {
		List<TblRental> list = rentalService.getByMemberId(memberId);
		if(list == null)
			return null;
		
		List<BookForm> books = new ArrayList<BookForm>();
		for(int i=0; i<list.size(); i++) {
			TblBook tblBook = bookService.getById(list.get(i).getBookId());
			BookForm book = new BookForm();
			book.setBookId(tblBook.getBookId());
			book.setBookTitle(tblBook.getBookTitle());
			books.add(book);
		}
		return books;
	}
}
