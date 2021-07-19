package kh.com.petbreedding.common.model.service;

import java.util.HashMap;
import java.util.List;

import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;

public interface LoginService {
	
	public Client login(Client client); // 이메일 로그인
	public BPartner blogin(BPartner bP); //사업자 로그인
	public Admin mLogin(Admin admin); //관리자 로그인
	
	public List<Client> selectMember(String nickname);
	
}
