package kh.com.petbreedding.client.model.service;

import kh.com.petbreedding.client.model.vo.Client;

public interface ClientService {
	
	public int insertClient(Client client);	// 이메일 회원가입
	public int checkEmail(String email);	// 이메일 중복 확인 
	public int checkNickName(String nickname); //닉네임 중복 확인
	public int checkHp(String tel); //휴대폰번호 중복 확인
	public int deleteClient(String cl_num); //회원탈퇴
	public int deltePoint(String cl_num); //포인트 정보 삭제
}
