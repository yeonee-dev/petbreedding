package kh.com.petbreedding.BP.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.BP.model.service.BPartnerService;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.service.MessageService;

@Controller
public class BPController {
	
	@Autowired
	private BPartnerService bService;
	
//	@Autowired
//	private MessageService messageService;

	// 사장님회원가입 페이지로 이동
	@RequestMapping(value = "/bJoin", method = RequestMethod.GET)
	public String bJoin(Locale locale, Model model) {
		return "/bPartner/bMember/bJoin";
	}

	// 사장님 승인 대기 페이지로 이동
	@RequestMapping(value = "/bJoinSuccess", method = RequestMethod.GET)
	public String bjoinSuccess(Locale locale, Model model) {
		return "/bPartner/bMember/bJoinSuccess";

	}

	//회원가입 처리
	@RequestMapping(value = "bPartner/bJoin", method = RequestMethod.POST)
	@ResponseBody
	public String bPartnerJoin(BPartner bP, HttpSession session) {
		
		int result = bService.insertBP(bP);

		return String.valueOf(result);
	}
	
	//회원가입 - 이메일 중복 확인
	@RequestMapping("checkBemail")
	@ResponseBody
	public int  checkBemail(String bp_email) {
		int result = bService.checkEmail(bp_email);
		return result;
	}
	
	//회원가입 - 사업자번호 중복 확인
	@RequestMapping("checkBNum")
	@ResponseBody
	public int  checkBNum(String bp_num) {
		int result = bService.checkBpNum(bp_num);
		return result;
	}
	
	//회원가입 - 휴대폰 중복 확인
	@RequestMapping("checkBHp")
	@ResponseBody
	public int  checkBHp(String bp_tel) {
		System.out.println("tel : "+ bp_tel);
		int result = bService.checkHp(bp_tel);
		return result;
	}
	
	//휴대전화 인증번호 받기 
	@RequestMapping(value = "Bphone", method = RequestMethod.POST)
	@ResponseBody
	public String sendSms(String bp_tel) {
		int num = (int)(Math.random() * (9999 - 1000 + 1)) + 1000;
		String randomNumber = String.valueOf(num);
		String tel = bp_tel;
		MessageService.sendMessage(tel, randomNumber);
		
		System.out.println(randomNumber);
		return randomNumber;
	}
	

	//회원탈퇴
	@RequestMapping(value = "bDeleteDo")
	@ResponseBody
	public int deleteBPDo(String bp_Id, HttpSession session) {
		
		int result = bService.deleteBP(bp_Id);
		if(result>0) {
			session.invalidate();
		}
		return result;
	}
	
}
