package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.MyAskDao;
import kh.com.petbreedding.board.model.vo.MyAsk;

@Service("myAskService")
public class MyAskServiceImpl implements MyAskService {
	
	@Autowired
	private MyAskDao myAskDao;
	
	@Override
	public int listCount() {
		int result = -1;
		
		try {
			result = myAskDao.listCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int listCountClBp(MyAsk myAsk) {
		int result = -1;
		
		try {
			result = myAskDao.listCountClBp(myAsk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int listCountAll(int qnaChk) {
		int result = -1;
		
		try {
			result = myAskDao.listCountAll(qnaChk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@Override
	public int clBpListCount(String user_num) {
		int result = -1;
		
		try {
			result = myAskDao.clBpListCount(user_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<MyAsk> MyAskSelectList(Map<String, Object> map) {
		List<MyAsk> result = null;
		System.out.println("[세훈] @일대일 문의 서비스 map : " + map);
		
		try {
			result = myAskDao.MyAskSelectList(map);
			System.out.println("[세훈] @일대일 문의 서비스 result : " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<MyAsk> MyAskSelectListM(Map<String, String> map) {
		List<MyAsk> resultM = null;
		
		try {
			resultM = myAskDao.MyAskSelectListM(map);
			System.out.println("[세훈] @일대일 문의 서비스M result : " + resultM);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultM;
	}
	
	@Override
	public List<MyAsk> MyAskSelectListClBpM(Map<String, String> map) {
		List<MyAsk> resultClBp = null;
		
		try {
			resultClBp = myAskDao.MyAskSelectListClBpM(map);
			System.out.println("[세훈] @일대일 문의 서비스ClBpM resultClBp : " + resultClBp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultClBp;
	}
	
	@Override
	public List<MyAsk> MyAskSelectListClBpAllM(Map<String, String> map) {
		List<MyAsk> resultClBpAll = null;
		
		try {
			resultClBpAll = myAskDao.MyAskSelectListClBpAllM(map);
			System.out.println("[세훈] @일대일 문의 서비스ClBpM resultClBp : " + resultClBpAll);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultClBpAll;
	}
	

	@Override
	public MyAsk MyAskSelectDetail(String qna_num) {
		MyAsk result = null;
		
		try {
			result = myAskDao.MyAskSelectOne(qna_num);
			System.out.println("[세훈] @일대일 문의 상세 서비스 result : " + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int MyAskInsert(MyAsk myAsk) {
		int result = 0;
		String user_num = myAsk.getUserNum();
		if(user_num.contains("CL")) {
			String qna_wr = myAskDao.getClientNickName(user_num);
			myAsk.setQnaWr(qna_wr);
			myAsk.setQnaType(1);
			System.out.println("[세훈] @MyAsk 서비스 qna_wr" + qna_wr);
		} else {
			String qna_wr = myAskDao.getBpNickName(user_num);
			myAsk.setQnaWr(qna_wr);
			myAsk.setQnaType(2);
			System.out.println("[세훈] @MyAsk 사장님 서비스 qna_wr" + qna_wr);
		}
		
		
		
		try {
			result = myAskDao.MyAskInsert(myAsk);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int MyAskDelete(String qna_num) {
		int maDelResult = -1;
		
		try {
			maDelResult = myAskDao.MyAskDelete(qna_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maDelResult;
	}




}
