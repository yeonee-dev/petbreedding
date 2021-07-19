package kh.com.petbreedding.common.model.service;


import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;

public interface FindService {

	//사용자
	public String findId(Client client); // 아이디 찾기
	public int findPwd(Client client); // 비밀번호 찾기
	public int changePwd(Client client); //비밀번호 재설정
	
	//사업자
	public String findBId(BPartner bP);
	public int findBPwd(BPartner bP);
	public int changeBPwd(BPartner bP);
}
