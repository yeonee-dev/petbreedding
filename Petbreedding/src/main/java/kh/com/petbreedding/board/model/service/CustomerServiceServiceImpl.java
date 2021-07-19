package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.CustomerServiceDao;
import kh.com.petbreedding.board.model.vo.CustomerService;

@Service("customerServiceService")
public class CustomerServiceServiceImpl implements CustomerServiceService {
	
	@Autowired
	private CustomerServiceDao customerServiceDao;

	@Override
	public int CustomerServiceListCount() {
		int listCountAll = -1;
		
		try {
			listCountAll = customerServiceDao.CustomerServiceListCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCountAll; 
	}
	@Override
	public int CustomerServiceListCountS(int annType) {
		int listCountSelected = -1;
		
		try {
			listCountSelected = customerServiceDao.CustomerServiceListCountS(annType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[세훈] @관리자 공지사항 목록 고객, 사업자 선택 서비스    listCountSelected	: " + listCountSelected);
		return listCountSelected; 
	}
	@Override
	public List<CustomerService> CustomerServiceSelectListA(Map<String, Object> map) {
		List<CustomerService> ResultListA = null;
		
		try {
			ResultListA = customerServiceDao.CustomerServiceSelectListA(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultListA; 
	}
	@Override
	public List<CustomerService> CustomerServiceSelectListS(Map<String, Object> map) {
		List<CustomerService> ResultListS = null;
		
		try {
			ResultListS = customerServiceDao.CustomerServiceSelectListS(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultListS;
	}
	
	//	공지사항 리스트 조회 (고객)
	@Override
	public List<CustomerService> CustomerServiceSelectListC() {
		List<CustomerService> result = null;
		
		try {
			result = customerServiceDao.CustomerServiceSelectListC();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<CustomerService> CustomerServiceSelectListB(Map<String, String> paging) {
		List<CustomerService> result = null;
		
		try {
			result = customerServiceDao.CustomerServiceSelectListB(paging);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//	공지사항 상세 조회
	@Override
	public CustomerService CustomerServiceSelectOne(String ann_num) {
		CustomerService csDetail = null;
		
		try {
			csDetail = customerServiceDao.CustomerServiceSelectOne(ann_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return csDetail;
	}
	
	//	공지사항 등록
	@Override
	public int CustomerServiceInsert(CustomerService cs) {
		int result = -1;
		
		try {
			result = customerServiceDao.CustomerServiceInsert(cs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//	공지사항 수정
	@Override
	public int CustomerServiceUpdate(CustomerService cs) {
		int csUpdResult = -1;
		
		try {
			csUpdResult = customerServiceDao.CustomerServiceUpdate(cs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return csUpdResult;
	}

	//	공지사항 삭제
	@Override
	public int CustomerServiceDelete(String ann_num) {
		int result = -1;
		
		try {
			result = customerServiceDao.CustomerServiceDelete(ann_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int ListBCount() {
		int result = -1;
		try {
			result = customerServiceDao.ListBCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
