package kh.com.petbreedding.cta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.cta.model.dao.CtaDao;
import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

@Service("ctaService")
public class CtaServiceImpl implements CtaService {
	@Autowired
	private CtaDao ctaDao;

	@Override
	public List<Cta> listAll() {
		List<Cta> list = null;
		System.out.println("service들어옴");
		try {
			list=ctaDao.listAll();
			System.out.println("리스트들어옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cta read(String CM_TYPE) {
		Cta vo = null;
		System.out.println("read service 들어옴");
		try {
			vo = ctaDao.read(CM_TYPE);
			System.out.println("read들어옴");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertpay(CtaPay pay) {
		int result = -1;
		
		
	    try {
	    	result = ctaDao.insertpay(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return result;
	}

	@Override
	public int insertCta(CtaPay pay) {
		int result = -1;
	
		
		try {
			result = ctaDao.insertCta(pay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CtaPay mycta(String bp_id) throws Exception {
		System.out.println("mycta 조회 들어옴");
		CtaPay list = null;
		try {
			list = ctaDao.mycta(bp_id);
			if(list != null) {
				System.out.println("mycta 있음");
			}else {
				System.out.println("mycta 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updatecta(CtaPay cta) throws Exception {
		int result = -1;
		System.out.println("cta업데이트 들어옴 ");
		
		try {
			result = ctaDao.updatecta(cta);
			if(result > 0) {
				System.out.println("cta 충전 됨");
			}else {
				System.out.println("cta 충전 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delcta(String BP_ID) throws Exception {
		int result = -1;
		System.out.println("cta 차감 들어옴");
		try {
			result = ctaDao.delcta(BP_ID);
			if(result > 0) {
				System.out.println("차감 성공");
			}else {
				System.out.println("차감 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<HairSalon> ctabuylist() throws Exception {
		List<HairSalon> list = null;
		System.out.println("울트라콜 결제 매장 리스트 들어옴");
		try {
			list = ctaDao.ctabuylist();
			if(list != null) {
				System.out.println("울트라 결제 매장 리스트 조회 성공");
			}else {
				System.out.println("울트라 결제매장 리스트 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
