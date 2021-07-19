package kh.com.petbreedding.Shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.BpReservationDao;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;

@Service("bprevService")
public class BpReservationServiceImpl implements BpReservationService{

	@Autowired
	private BpReservationDao bprevDao;

	@Override
	public List<HairShopReservation> revList(HairShopReservation vo) throws Exception {
		List<HairShopReservation> list = null;
		try {
			list = bprevDao.revList(vo);
			if(list != null){
				System.out.println("내 예약 리스트 있음");
			}else {
				System.out.println("내 예약 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<HairShopReservation> revAllList(String bp_id) throws Exception {
		List<HairShopReservation> list = null;
		try{
			list =  bprevDao.revAllList(bp_id);
			if(list != null) {
				System.out.println("전체 예약 리스트 있음");
			}else {
				System.out.println("전체 예약 리스트 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<HairShopReservation> revAllListDate(HairShopReservation vo) throws Exception {
		List<HairShopReservation> list = null;
		
		try {
			list = bprevDao.revAllListDate(vo);
			if(list != null) {
				System.out.println("날짜별 전체 예약 들어옴");
			}else {
				System.out.println("날짜별 전체예약 안들어옴");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public HairShopReservation revharcon(String har_rnum) throws Exception {
		HairShopReservation list = null;
		
		try {
			list = bprevDao.revharcon(har_rnum);
			if(list != null) {
				System.out.println("예약 상세페이지 들어옴");
			}else {
				System.out.println("예약 상세페이지 못 들어옴");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	@Override
	public List<HospitalReservation> revHosList(HospitalReservation vo) throws Exception {
		List<HospitalReservation> list = null;
		try {
			list = bprevDao.revHosList(vo);
			if(list != null) {
				System.out.println("병원 옵션별 리스트 있음");
			}else {
				System.out.println("병원 옵션별 리스트 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return list;
	}

	@Override
	public List<HospitalReservation> revAllHosListDate(HospitalReservation vo) throws Exception {
		List<HospitalReservation> list = null;
		try {
			list = bprevDao.revAllHosListDate(vo);
			if(list != null) {
				System.out.println("병원 날짜별 조회 있음 ");
			}else {
				System.out.println("병원 날짜별 조회 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<HospitalReservation> revHosAllList(String bp_id) throws Exception {
		List<HospitalReservation> list = null;
		try {
			list = bprevDao.revHosAllList(bp_id);
			if(list != null) {
				System.out.println("병원 전체 리스트 있음");
			}else {
				System.out.println("병원 전체 리스트 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public HospitalReservation revhoscon(String hos_rnum) throws Exception {
		HospitalReservation list = null;
		
		try {
			list = bprevDao.revhoscon(hos_rnum);
			if(list != null) {
				System.out.println("병원 상세페이지 들어옴");
			}else {
				System.out.println("병원 상세페이지 못 들어옴");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	@Override
	public int delrevHar(String har_rnum) throws Exception {
		int result = 0;
		try {
			result = bprevDao.delrevHar(har_rnum);
			if(result > 0) {
				System.out.println("결제취소 들어옴");
			}else {
				System.out.println("결제취소 못 들어옴 ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delrevHos(String hos_rnum) throws Exception {
		int result=0;
		try {
			result = bprevDao.delrevHos(hos_rnum);
			if(result > 0) {
				System.out.println("병원 결체취소 들어옴");
			}else {
				System.out.println("병원 결제취소 못들어옴 ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	
	
	

}
