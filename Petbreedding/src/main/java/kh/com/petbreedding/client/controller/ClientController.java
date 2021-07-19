package kh.com.petbreedding.client.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.client.model.service.ClientService;
import kh.com.petbreedding.client.model.service.MessageService;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientInfoService clientInfoService;
	
	//이메일 회원가입 페이지로 이동
	@RequestMapping(value = "/uJoin", method = RequestMethod.GET)
	public String openClientJoin(Locale locale, Model model) {
		
		return "/user/uMember/uJoin";
	}
	
	//이메일 회원가입 처리
	@RequestMapping(value = "/client/uJoin", method = RequestMethod.POST)
	@ResponseBody
	public String ClientJoin(Client client, HttpSession session) {
		
		logger.info(client.toString());
		
		int result = clientService.insertClient(client);

		return String.valueOf(result);
		
	}
	
	//sns 회원가입 페이지 이동
	@RequestMapping(value = "snsJoin")
	@ResponseBody
	public String SnsJoin(Client client, HttpSession session) {
		
		return "/user/uMember/snsJoin";
		
	}
	
	
	
	
	// 회원 정보 수정 페이지
	@RequestMapping("uModify")
	public String openClientModify(Locale locale, Model model) {
		
		
		return "/user/uMember/uModify";

	}
		
	// 회원 정보 수정 처리
	@RequestMapping("mypage/uModify")
	@ResponseBody
	public int updateClientInfo(Client client, HttpSession session) {
		
		int result = clientInfoService.updateClientInfo(client);
		if(result>0) {
			session.setAttribute("client", client);
		}
		return result;

	}

	@RequestMapping("uDelete")
	// 회원 탈퇴
	public String deleteClient(Locale locale, Model model) {

		return "/user/uMember/uDelete";

	}
	
	@RequestMapping("uDeleteDo")
	@ResponseBody
	// 회원 탈퇴
	public int deleteClientDo(String cl_num, HttpSession session) {
		clientService.deltePoint(cl_num);
		int result = clientService.deleteClient(cl_num);
		if(result >0) {
			session.invalidate();		
		}
		
		return result;
	}
		
	//회원가입 - 이메일 중복 확인
	@RequestMapping("checkEmail")
	@ResponseBody
	public int  checkEmail(String email) {
		int result = clientService.checkEmail(email);
		return result;
	}
	
	//회원가입 - 닉네임 중복 확인
	@RequestMapping("checkNickName")
	@ResponseBody
	public int  checkNickName(String nickname) {
		int result = clientService.checkNickName(nickname);
		return result;
	}
	
	//회원가입 - 휴대폰 중복 확인
	@RequestMapping("checkHp")
	@ResponseBody
	public int  checkHp(String tel) {
		System.out.println("tel : "+ tel);
		int result = clientService.checkHp(tel);
		return result;
	}
	
	//휴대전화 인증번호 받기 
	@RequestMapping(value = "phone", method = RequestMethod.POST)
	@ResponseBody
	public String sendSms(String tel) {
		int num = (int)(Math.random() * (9999 - 1000 + 1)) + 1000;
		String randomNumber = String.valueOf(num);
		MessageService.sendMessage(tel, randomNumber);
		
		System.out.println(randomNumber);
		return randomNumber;
	}
	
	
}
