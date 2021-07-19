package kh.com.petbreedding.Admin.model.service;

import java.util.List;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.common.model.vo.Pagination;

public interface AdminService {

	public int countMwait();
	public List<BPartner> waitList(Pagination page); //제휴승인대기
	public int confirmBP(List<String> list);
	public int refuseBP(List<String> list);
	
	public int countMdelete();
	public List<BPartner> deleteList(Pagination page);
	public int deleteBP(List<String> list);
	public int backBP(List<String> list);
	
	
	//차트
	public int getMemberCount();
	public int getBpCount();
	
	
	public int getMemChart(String reg_date);
	public int getBpChart(String reg_date);
	
	public int getAllPrice(String pay_date);
	public int getRealPrice(String pay_date);
	
	public int getUltraAll();
	public int getBpAll();
	
	public int getHarUltra();
	public int getHosUltra();
	
}
