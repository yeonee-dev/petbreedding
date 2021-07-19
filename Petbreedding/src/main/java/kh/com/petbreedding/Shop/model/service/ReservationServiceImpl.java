package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ReservationDao;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Service("revService")
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao revDao;
	
	@Override
	public List<Style> revList(String har_num) {
		List<Style> result = null;
		try {
			result = revDao.revList(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MyPet> revList2(String cl_num) {
		List<MyPet> result = null;
		try {
			result = revDao.revList2(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Style> revList3(String har_num) {
		List<Style> result = null;
		try {
			result = revDao.revList3(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertHairRev(HairShopReservation hrv) {
		int result = -1;
		try {
			result = revDao.insertHairRev(hrv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HairShopReservation> shopPayment(String har_rnum) {
		List<HairShopReservation> result = null;
		try {
			result = revDao.shopPayment(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> checkTime(HairShopReservation hrv) {
		List<String> result = null;
		try {
			result = revDao.checkTime(hrv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HairSalon> checkDayOff(String har_num) {
		List<HairSalon> result = null;
		try {
			result = revDao.checkDayOff(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//병원
	
	@Override
	public List<MedicalType> hosMenu(String hos_num) {
		List<MedicalType> result = null;
		try {
			result = revDao.hosMenu(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<HospitalReservation> shopPayment2(String hos_rnum) {
		List<HospitalReservation> result = null;
		try {
			result = revDao.shopPayment2(hos_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
		
	@Override
	public int insertHosRev(HospitalReservation hos) {
		int result = -1;
		try {
			result = revDao.insertHosRev(hos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<String> checkTime2(HospitalReservation hos) {
		List<String> result = null;
		try {
			result = revDao.checkTime2(hos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Hospital> checkDayOff2(String hos_num) {
		List<Hospital> result = null;
		try {
			result = revDao.checkDayOff2(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}









}
