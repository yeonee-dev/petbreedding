package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ShopPayDao;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;
import kh.com.petbreedding.bmypage.model.dao.ShopDao;


@Service("shopPayService")
public class ShopPayServiceImpl implements ShopPayService{

	
	@Autowired
	private ShopPayDao shopPayDao;
	
	@Override
	public int harPay(HarPay harPay) {
		int result = -1;
		try {
			result = shopPayDao.harPay(harPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int harRevUp(String har_rnum) {
		int result = -1;
		try {
			result = shopPayDao.harRevUp(har_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hosPay(HosPay hosPay) {
		int result = -1;
		try {
			result = shopPayDao.hosPay(hosPay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hosRevUp(String hos_rnum) {
		int result = -1;
		try {
			result = shopPayDao.hosRevUp(hos_rnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int hosAllPrice(String hos_num) {
		int result = 0;
		try {
			result = shopPayDao.hosAllPrice(hos_num);
			if(result > 0) {
				System.out.println("병원 전체 매출액 들어옴");
			}else {
				System.out.println("병원 전체 매출액 조회 못들어옴");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int harAllPrice(String har_num) {
		int result = 0;
		try {
			result = shopPayDao.harAllPrice(har_num);
			if(result > 0) {
				System.out.println("미용실 전체 매출액 들어옴");
			}else {
				System.out.println("미용실 전체 매출액 조회 못 들어옴");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HarPay> HarsixPrice(String har_num) {
		List<HarPay> list = null;
		try {
			list = shopPayDao.HarsixPrice(har_num);
			if(list != null) {
				System.out.println("병원 1년 조회 들어옴");
			}else {
				System.out.println("병원 1년 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HarPay> payYear() {
		List<HarPay> list = null;
		try {
			list = shopPayDao.payYear();
			if(list != null) {
				System.out.println("최근 1년 개월수 있음");
			}else {
				System.out.println("최근 1년 개월수 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HosPay> HosYearPrice(String hos_num) {
		List<HosPay> list = null;
		try {
			list = shopPayDao.HosYearPrice(hos_num);
			if(list != null) {
				System.out.println("병원 1년 차트 조회 들어옴");
			}else {
				System.out.println("병원 1년 차트조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}



}
