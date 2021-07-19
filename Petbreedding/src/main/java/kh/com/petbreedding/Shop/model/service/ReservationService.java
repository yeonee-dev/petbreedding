package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface ReservationService {
	
	public List<Style> revList(String har_num);
	public List<MyPet> revList2(String cl_num);
	public List<Style> revList3(String har_num);
	public int insertHairRev(HairShopReservation hrv);
	
	public List<HairShopReservation> shopPayment(String har_rnum);
	public List<String> checkTime(HairShopReservation hrv);
	public List<HairSalon> checkDayOff(String har_num);
	
	
	public List<MedicalType> hosMenu(String hos_num);
	public List<HospitalReservation> shopPayment2(String hos_rnum);
	public int insertHosRev(HospitalReservation hos);
	public List<String> checkTime2(HospitalReservation hos);
	public List<Hospital> checkDayOff2(String hos_num);
}
