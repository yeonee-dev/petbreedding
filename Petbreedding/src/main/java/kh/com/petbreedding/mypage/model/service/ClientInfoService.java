package kh.com.petbreedding.mypage.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.client.model.vo.Client;

public interface ClientInfoService {
	
	public String selectClientInfo(String email); // 회원 정보 불러오기
	public int updateClientInfo(Client client); // 회원 정보 수정 
	public void deleteClient(String email); // 회원 탈퇴
	
	public List<HairShopReservation> myReservationList(String cl_num); //예약확인/조회 리스트 조회
	public List<HairShopReservation> myRevDateList(Map<String, String> list); //날짜 추가 리스트 조회
	public int status0(String cl_num); //결제대기 카운트
	public int status1(String cl_num); //결제완료 카운트
	public int status2(String cl_num); //이용완료 카운트
	
	
	//미용실
	public List<HairShopReservation> myRevDetail(String har_rnum); //예약 상세조회
	public String anotherMenu(String har_rnum); //추가 메뉴
	public int getPrice(String har_rnum); //총합
	public int cancleRev(String har_rnum); //결제취소
	
	//동물병원
	public List<HospitalReservation> myRevDetail2(String hos_rnum);	//예약 상세조회
	public int cancleRev2(String hos_rnum); //결제 취소
	
	
	
}





