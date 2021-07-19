package kh.com.petbreedding.Admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Admin.model.dao.AdminDao;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.common.model.vo.Pagination;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao aDao;
	
	
	@Override
	public int countMwait() {
		int result = -1;
		try {
			result = aDao.countMwait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<BPartner> waitList(Pagination page) {
		List<BPartner> list = null;
		try {
			list = aDao.waitList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int confirmBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.confirmBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int refuseBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.refuseBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	@Override
	public int countMdelete() {
		int result = -1;
		try {
			result = aDao.countMdelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<BPartner> deleteList(Pagination page) {
		List<BPartner> list = null;
		try {
			list = aDao.deleteList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int deleteBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.deleteBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int backBP(List<String> list) {
		int result = -1;
		try {
			result = aDao.backBP(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int getMemberCount() {
		int result = 0;
			try {
				result =  aDao.getMemberCount();
			if(result > 0) {
				System.out.println("회원수 차트조회 들어옴");
			}else {
				System.out.println("=====회원수 차트조회 실패=======");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getBpCount() {
		int result = 0;
	try {
		result =  aDao.getBpCount();
		if(result > 0 ) {
			System.out.println("사업자수 차트조회 들어옴");
		}else {
			System.out.println("=====사업자수 차트조회 실패======");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
		
		return result;
	}

	@Override
	public int getMemChart(String reg_date) {
		int result = 0;
		try {
			result = aDao.getMemChart(reg_date);
			
			if(result > 0) {
				System.out.println("멤버 날짜별 차트 들어옴");
			}else {
				System.out.println("*****멤버 날짜별 차트조회 실패****");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getBpChart(String reg_date) {
		int result = 0;
		try {
			result = aDao.getBpChart(reg_date);
			if(result > 0) {
				System.out.println("사업자 날짜별 차트 들어옴");
			}else {
				System.out.println("*****사업자 날짜별 차트조회 들어옴****");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getAllPrice(String pay_date) {

		int result = 0;
		try {
			result = aDao.getAllPrice(pay_date);
			if(result >  0) {
				System.out.println("총 매출액 들어옴");
			}else {
				System.out.println("총 매출액 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int getRealPrice(String pay_date) {
		int result = 0;
		try {
			result = aDao.getRealPrice(pay_date);
			if(result > 0) {
				System.out.println("순매출액 들어옴");
			}else {
				System.out.println("순 매출액 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getUltraAll() {
		int result = 0;
		try {
			result = aDao.getUltraAll();
			if(result > 0) {
				System.out.println("울트라콜 점유율 들어옴");
			}else {
				System.out.println("울트라콜 점유율 조회 실페");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getBpAll() {
		int result = 0;
		try {
			result = aDao.getBpAll();
			if(result > 0) {
				System.out.println("사업장 점유율 들어옴");
			}else {
				System.out.println("사업장 점유율 조회 실페");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getHarUltra() {
		int result = 0;
		try {
			result = aDao.getHarUltra();
			if(result > 0) {
				System.out.println("미용실 울트라 점유율 들어옴");
			}else {
				System.out.println("미용실 울트라 점유율 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getHosUltra() {
		int result = 0;
		try {
			result = aDao.getHosUltra();
			if(result>0) {
				System.out.println("병원 울트라 점유율 들어옴");
			}else {
				System.out.println("병원 울트라 점유율 조회 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
