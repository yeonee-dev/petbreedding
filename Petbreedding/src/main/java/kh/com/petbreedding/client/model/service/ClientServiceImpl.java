package kh.com.petbreedding.client.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.client.model.dao.ClientDao;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.dao.MyPointDao;
import kh.com.petbreedding.mypage.model.vo.MyPoint;


@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private MyPointDao myPointDao;
	
	@Override
	public int insertClient(Client client) {
		int result = -1;
		try {
			String cl_num = clientDao.getClientSeqNextVal();
			client.setCl_num(cl_num);
			result = clientDao.insertClient(client);
			String seqJoin = clientDao.getJoinSeq();
			int expPoint = 0;
			int currPoint = 0;
			MyPoint myPoint = new MyPoint();
			String clNum = clientDao.getClientSeqCurrVal();
			System.out.println("[세훈] @클라서비스 포인트 초기화 clNum : " + clNum);
			
			
			myPoint.setClNum(clNum);
			myPoint.setPointNum("PO5");
			myPoint.setExpType("가입");
			myPoint.setExpFrom("이메일 회원가입");
			myPoint.setExpId(seqJoin);
			myPoint.setExpPoint(expPoint);
			myPoint.setCurrPoint(currPoint);
			
			int pointResult = myPointDao.myPointInit(myPoint);
			
			if(pointResult > 0) {
				System.out.println("포인트 초기화 성공");
			} else {
				System.out.println("포인트 초기화 실패");
			}
			
			
//			CL_NUM     NOT NULL VARCHAR2(50) 
//			POINT_NUM           VARCHAR2(20) 
//			INDEXS              NUMBER(5)    
//			EXP_DATE            VARCHAR2(20) 
//			EXP_TYPE            VARCHAR2(20) 
//			EXP_FROM            VARCHAR2(50) 
//			EXP_ID              VARCHAR2(20) 
//			EXP_POINT           NUMBER(5)    
//			CURR_POINT NOT NULL NUMBER(7) 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkEmail(String email) {
		int result = -1;
		try {
			result = clientDao.checkEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkNickName(String nickname) {
		int result = -1;
		try {
			result = clientDao.checkNickName(nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int checkHp(String tel) {
		int result = -1;
		try {
			result = clientDao.checkHp(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteClient(String cl_num) {
		int result = -1;
		try {
			result = clientDao.deleteClient(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}

	@Override
	public int deltePoint(String cl_num) {
		int result = -1;
		try {
			result = clientDao.deltePoint(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}





}
