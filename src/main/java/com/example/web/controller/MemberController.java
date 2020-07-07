package com.example.web.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.handler.Handler;
import com.example.handler.MemberValidData;
import com.example.orm.model.TblMember;
import com.example.service.MemberService;
import com.example.web.form.MemberForm;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private static final Logger LOG = Logger.getLogger(MemberController.class.getName());
	
	@GetMapping("/membermaster")
	public ModelAndView showMemberMaster(ModelAndView model, HttpServletRequest request) {
		model.setViewName("member-master");
		try {
			MemberForm memberForm = (MemberForm) request.getSession().getAttribute("memberSession");
			model.addObject("memberForm", memberForm);
		} catch (Exception e) {
			model.addObject("memberForm", new MemberForm());
		}
		request.getSession().setAttribute("memberSession", "");
		return model;
	}
	
	@GetMapping("/addmember/checkdata")
	public ModelAndView addMember(@ModelAttribute("memberForm") MemberForm memberForm, ModelAndView model, HttpServletRequest request) {
		
		MemberValidData validData = new MemberValidData(memberForm);
		validData.checkData();
		System.out.println(validData.getMessage());
		
		if(validData.getMessage() == null) {
			request.getSession().setAttribute("memberSession", memberForm);
			model.addObject("button", "<button id=\"addMember\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">追加</button>");
			model.setViewName("member-confirm");
		}else {
			model.addObject("msg", validData.getMessage());
			request.getSession().setAttribute("memberSession", "");
			model.setViewName("member-master");
		}
		
		return model;
	}
	
	@GetMapping("/addmember")
	public ModelAndView addMember(ModelAndView model, HttpServletRequest request) {
		LOG.info("addMember");
		model.setViewName("member-master");
		
		try {
			MemberForm memberForm = (MemberForm) request.getSession().getAttribute("memberSession");
			model.addObject("memberForm", memberForm);
			
			TblMember mem = memberService.getById(memberForm.getMemberId());
			
			if(mem != null) {
				model.addObject("msg", "本ID" + memberForm.getMemberId() + "は登録されています。別のIDを入力してください。");
				return model;
			}
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String date = memberForm.getBirthYear() + "-" + memberForm.getBirthMonth() + "-" + memberForm.getBirthDate();
			java.sql.Date birthDay;
			try {
				birthDay = new Handler().convertStringToSqlDate(date);
				String registId = auth.getName();
				Date registDate = new Date();
				TblMember newMember = new TblMember(memberForm.getMemberId(), memberForm.getFamilyName(), memberForm.getFamilyNameKana(), memberForm.getFirstName(), memberForm.getFirstNameKana(), memberForm.getAddress(), birthDay, registId, registDate, "0");
				
				memberService.addMember(newMember);
				
				model.addObject("msg", "会員を登録しました。");
			} catch (ParseException e) {
			} catch (Exception e) {
				model.addObject("msg", "DBエラーが発生しました。");
			}
		} catch (Exception e) {
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("memberForm", new MemberForm());
		}
		request.getSession().setAttribute("memberSession", "");
		return model;
	}
	
	@GetMapping("/updatemember/checkdata")
	public ModelAndView updateMember(@ModelAttribute("memberForm") MemberForm memberForm, ModelAndView model, HttpServletRequest request) {
		
		MemberValidData validData = new MemberValidData(memberForm);
		validData.checkData();
		System.out.println(validData.getMessage());
		
		if(validData.getMessage() == null) {
			request.getSession().setAttribute("memberSession", memberForm);
			model.addObject("button", "<button id=\"updateMember\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">更新</button>");
			model.setViewName("member-confirm");
		}else {
			model.addObject("msg", validData.getMessage());
			request.getSession().setAttribute("memberSession", "");
			model.setViewName("member-master");
		}
		
		return model;
	}
	
	@GetMapping("/updatemember")
	public ModelAndView updateMember(ModelAndView model, HttpServletRequest request) {
		model.setViewName("member-master");
		
		try {
			MemberForm memberForm = (MemberForm) request.getSession().getAttribute("memberSession");
			TblMember mem = memberService.getById(memberForm.getMemberId());
			
			model.addObject("memberForm", memberForm);
			
			if(mem == null) {
				model.addObject("msg", "本ID" + memberForm.getMemberId() + "が見つかりません。");
				return model;
			}
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String date = memberForm.getBirthYear() + "-" + memberForm.getBirthMonth() + "-" + memberForm.getBirthDate();
			try {
				java.sql.Date birthDay = new Handler().convertStringToSqlDate(date);
				
				mem.setAddress(memberForm.getAddress());
				mem.setBirthDay(birthDay);
				mem.setMemberFamilyName(memberForm.getFamilyName());
				mem.setMemberFamilyNameKana(memberForm.getFamilyNameKana());
				mem.setMemberFirstName(memberForm.getFirstName());
				mem.setMemberFirstNameKana(memberForm.getFirstNameKana());
				mem.setUpdateId(auth.getName());
				mem.setUpdateDate(new Date());
				
				memberService.updateById(mem);
				
				model.addObject("msg", "本を更新しました。");
			} catch (ParseException e) {
			} catch (Exception e) {
				model.addObject("msg", "DBエラーが発生しました。");
			}
		} catch (Exception e) {
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("memberForm", new MemberForm());
		}
		request.getSession().setAttribute("memberSession", "");
		return model;
	}
	
	@GetMapping("/deletemember/checkdata")
	public ModelAndView deleteMember(@ModelAttribute("memberForm") MemberForm memberForm, ModelAndView model, HttpServletRequest request) {
		String msg = null;
		
		if(memberForm.getMemberId().isEmpty()) {
			msg = "会員ID を入力してください。";
		}else if(memberForm.getMemberId().matches("[a-zA-Z0-9]+$") == false){
			msg = "会員IDは半角英数字で入力してください。";
		}
		
		if(msg == null) {
			request.getSession().setAttribute("memberSession", memberForm);
			model.addObject("button", "<button id=\"deleteMember\" class=\"btn btn-primary\" style=\"height: ; width:120px ;\">削除</button>");
			model.setViewName("member-confirm");
		}else {
			model.addObject("msg", msg);
			request.getSession().setAttribute("memberSession", "");
			model.setViewName("member-master");
		}
		return model;
	}
	
	@GetMapping("/deletemember")
	public ModelAndView deleteMember(ModelAndView model, HttpServletRequest request) {
		
		model.setViewName("member-master");
		
		try {
			MemberForm memberForm = (MemberForm) request.getSession().getAttribute("memberSession");
			
			TblMember member = memberService.getById(memberForm.getMemberId());
			if(member == null) {
				model.addObject("msg", "本ID" + memberForm.getMemberId() +"が見つかりません。");
				model.addObject("memberForm", memberForm);
				return model;
			}
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			member.setUpdateId(auth.getName());
			member.setUpdateDate(new Date());
			member.setDeleteFlg("1");
			memberService.deleteById(member);
			
			model.addObject("msg", "本ID" + memberForm.getMemberId() + "を削除しました。");
			model.addObject("memberForm", new MemberForm());
		} catch (Exception e) {
			model.addObject("msg", "不明なエラーが発生しました。");
			model.addObject("memberForm", new MemberForm());
		}
		
		request.getSession().setAttribute("memberSession", "");
		return model;
	}
	
	@GetMapping("/searchmember")
	public ModelAndView searchMember(@ModelAttribute("memberForm") MemberForm memberForm, ModelAndView model, HttpServletRequest request) {
		String msg = null;
		
		if(memberForm.getMemberId().isEmpty()) {
			msg = "本IDを入力してください。";
		}else if(memberForm.getMemberId().matches("[a-zA-Z0-9]+$") == false){
			msg = "本IDは半角英数字で入力してください。";
		}
		
		if(msg == null) {
			TblMember mem = memberService.getById(memberForm.getMemberId());
			if(mem == null) {
				memberForm.setOnlyId();
				model.addObject("msg", "本ID" + memberForm.getMemberId() + "が見つかりません。");
				model.addObject("memberForm", memberForm);
			}else {
				memberForm.setAddress(mem.getAddress());
				memberForm.setFamilyName(mem.getMemberFamilyName());
				memberForm.setFamilyNameKana(mem.getMemberFamilyNameKana());
				memberForm.setFirstName(mem.getMemberFirstName());
				memberForm.setFirstNameKana(mem.getMemberFirstNameKana());
				System.out.println(mem.getDeleteFlg());
				memberForm.setBirthYear(mem.getBirthDay().toString().substring(0, 4));
				memberForm.setBirthMonth(mem.getBirthDay().toString().substring(5, 7));
				memberForm.setBirthDate(mem.getBirthDay().toString().substring(8, 10));
				model.addObject("msg", "本が見つかりました。");
				model.addObject("memberForm", memberForm);
			}
		}else {
			model.addObject("msg", msg);
		}
		model.setViewName("member-master");
		request.getSession().setAttribute("memberSession", "");
		return model;
	}
	
	@GetMapping("/listmember")
	public ResponseEntity<List<TblMember>> getAll(){
		List<TblMember> list = memberService.getAll();
		return new ResponseEntity<List<TblMember>>(list, HttpStatus.OK);
	}
}
