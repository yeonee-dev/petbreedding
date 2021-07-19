package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;

public interface ShopPayService {
	
	public int harPay(HarPay harPay);
	public int harRevUp(String har_rnum);
	
	public int hosPay(HosPay hosPay);
	public int hosRevUp(String hos_rnum);
	
	public int hosAllPrice(String hos_num);
	public int harAllPrice(String har_num);
	
	public List<HarPay> HarsixPrice(String har_num);
	public List<HosPay> HosYearPrice(String hos_num);
	public List<HarPay> payYear();
}
