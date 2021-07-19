package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;

public interface BpReservationService {
	public List<HairShopReservation> revList(HairShopReservation vo) throws Exception;
	public List<HairShopReservation> revAllList(String bp_id) throws Exception;
	public List<HairShopReservation> revAllListDate(HairShopReservation vo) throws Exception;
	public HairShopReservation revharcon(String har_rnum) throws Exception;
	public int delrevHar(String har_rnum) throws Exception;
	
	
	public List<HospitalReservation> revHosList(HospitalReservation vo) throws Exception;
	public List<HospitalReservation> revAllHosListDate(HospitalReservation vo) throws Exception;
	public List<HospitalReservation> revHosAllList(String bp_id) throws Exception; 
	public HospitalReservation revhoscon(String hos_rnum) throws Exception;
	public int delrevHos(String hos_rnum) throws Exception;

}
