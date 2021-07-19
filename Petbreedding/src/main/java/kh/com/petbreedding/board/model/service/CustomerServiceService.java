package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.CustomerService;

public interface CustomerServiceService {
	public int CustomerServiceListCount();	//	공지사항 전체 개수 조회
	public int CustomerServiceListCountS(int annType);	//	공지사항 ANN_TYPE 선택 개수 조회
	public List<CustomerService> CustomerServiceSelectListA(Map<String, Object> map);	//	관리자 공지 리스트 전체 조회
	public List<CustomerService> CustomerServiceSelectListS(Map<String, Object> map);	//	관리자 ANN_TYPE 선택 리스트 조회
	public List<CustomerService> CustomerServiceSelectListC();	// 공지사항 리스트 조회 (고객)
	public List<CustomerService> CustomerServiceSelectListB(Map<String, String> paging);	// 공지사항 리스트 조회 (사업자고객)
	public CustomerService CustomerServiceSelectOne(String ann_num);	// 공지사항 상세조회
	public int CustomerServiceInsert(CustomerService cs);	// 공지사항 등록
	public int CustomerServiceUpdate(CustomerService cs);	// 공지사항 수정
	public int CustomerServiceDelete(String ann_num);	// 공지사항 삭제
	
	public int ListBCount(); //사업자 공지사항 개수
}
