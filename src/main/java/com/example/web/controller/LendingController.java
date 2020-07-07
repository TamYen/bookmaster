package com.example.web.controller;

import java.sql.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.handler.Handler;
import com.example.handler.LendingValidData;
import com.example.orm.model.TblBook;
import com.example.orm.model.TblMember;
import com.example.orm.model.TblRental;
import com.example.service.BookService;
import com.example.service.MemberService;
import com.example.service.RentalService;
import com.example.web.form.LendingForm;

@Controller
public class LendingController {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(LendingController.class);
	
//	@Autowired
//	private LendingService lendingService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RentalService rentalService;

	@GetMapping("/lending")
	public ModelAndView showLending(ModelAndView model) {
		model.setViewName("lending");
		model.addObject("lendingForm", new LendingForm());
		return model;
	}
	
	@GetMapping("/checkbook")
	public ModelAndView searchBook(ModelAndView model, @ModelAttribute("lendingForm") LendingForm form) {
		LOG.info("searchBook running");
		
		LendingValidData validData = new LendingValidData(form.getBookId());
		
		model.setViewName("lending");
		form.setMemberId("");
		
		if(validData.getMsg() != null) {
			model.addObject("msg", validData.getMsg());
			return model;
		}
		
		TblBook book = bookService.getById(form.getBookId());
		
		if(book == null) {
			model.addObject("msg", "本ID" + form.getBookId() + "が見つかりません。");
			model.addObject("lendingForm", form);
			return model;
		}
		
		form.setBookTitle(book.getBookTitle());
		model.addObject("msg", "本が見つかりました。");
		model.addObject("lendingForm", form);
		
		return model;
	}
	
	@Transactional
	@GetMapping("/lend")
	public ModelAndView lendBook(ModelAndView model, @ModelAttribute("lendingForm") LendingForm form){
		LOG.info("lendBook running");
		
		model.setViewName("lending");
		model.addObject("lendingForm", form);
		
		try {
			LendingValidData validData = new LendingValidData(form.getBookId(), form.getMemberId());
			
			if(validData.getMsg() != null) {
				model.addObject("msg", validData.getMsg());
				return model;
			}
			
			TblBook book = bookService.getById(form.getBookId());
			if(book == null) {
				// 3-2-1
				model.addObject("msg", "本ID" + form.getBookId() + "が見つかりません。");
				return model;
			}else { 
				// 3-2-2 -> 3-3
				TblMember mem = memberService.getById(form.getMemberId());
				if(mem == null) {
					// 3-3-1
					model.addObject("msg", "会員ID" + form.getMemberId() + "が見つかりません。");
					return model;
				}else { 
					// 3-3-2 -> 3-4
					TblRental ren = rentalService.getByBookIdAndStatus(form.getBookId());
					if(ren != null) {
						// 3-4-1
						model.addObject("msg", "現在貸し出し中です。");
						return model;
					}else {
						// 3-4-2
						Handler handler = new Handler();
						Date rentalDate = handler.getSqlCurrentDate();
						
						Authentication auth = SecurityContextHolder.getContext().getAuthentication();
						String registId = auth.getName();
						
						TblRental newRental = new TblRental();
						newRental.setBookId(form.getBookId()); // pk1
						newRental.setMemberId(form.getMemberId()); // pk2
						newRental.setRentalDate(rentalDate); // pk3
						newRental.setStatus(1);
						newRental.setRegistId(registId);
						newRental.setRegistDate(new java.util.Date());
						newRental.setDeleteFlg("0");
						
						try {
							rentalService.insertRental(newRental);
							model.addObject("msg", "本を貸し出しました。");
						} catch (RuntimeException e) {
							LOG.error(e.toString());
							model.addObject("msg", "DBエラーが発生しました。");
						}
						
					}
				}
			}
		} catch (Exception e) {
			LOG.info(e.toString());
			model.addObject("msg", "不明なエラーが発生しました。");
		}
		return model;
	}
}
