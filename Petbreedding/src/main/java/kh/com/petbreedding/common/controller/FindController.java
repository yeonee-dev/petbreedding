package kh.com.petbreedding.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.FindService;

@Controller
public class FindController {

	@Autowired
	private FindService findService;
	
	
	// 사용자 아이디 찾기
	@RequestMapping("/findId")
	@ResponseBody
	 public String findId(Client client) {
		
		String result = findService.findId(client);
  
		return result;
		
	}
	
	//사용자 비밀번호 찾기
	@RequestMapping("/findPwd")
	@ResponseBody
	public int findPwd(Client client) {

		int result = findService.findPwd(client);		
		return result;
		
	}
	
	//사용자 비밀번호 재설정
	@RequestMapping("/changePwd")
	@ResponseBody
	public int changePwd(Client client) {		
		int result = findService.changePwd(client);	
		return result;
		
	}
	
	
	// 사업자 아이디 찾기
	@RequestMapping("/findBId")
	@ResponseBody
	 public String finBId(BPartner bP) {
		String result = findService.findBId(bP);		
		return result;		
	}
	
	//사업자 비밀번호 찾기
	@RequestMapping("/findBPwd")
	@ResponseBody
	public int findBPwd(BPartner bP) {
		int result = findService.findBPwd(bP);
		return result;
		
	}
	
	//사업자 비밀번호 재설정
	@RequestMapping("/changeBPwd")
	@ResponseBody
	public int changeBPwd(BPartner bP) {		
		int result = findService.changeBPwd(bP);
		return result;
		
	}
}
