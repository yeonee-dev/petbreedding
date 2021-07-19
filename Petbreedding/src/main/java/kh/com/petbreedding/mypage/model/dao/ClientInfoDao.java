package kh.com.petbreedding.mypage.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientInfoDao")
public class ClientInfoDao {
	
	@Autowired
	SqlSession sqlSession;
	
	// 회원 정보 수정 
	public int updateClientInfo(Client client) {
		return sqlSession.update("Modify.modifyClient", client);
	} 
		
	//예약확인/조회 리스트
	public List<HairShopReservation> myReservationList(String cl_num) {
		return sqlSession.selectList("myRev.myRevList", cl_num);
	}
	
	//예약확인/조회 날짜 검색 리스트
	public List<HairShopReservation> myRevDateList(Map<String, String> list) {
		return sqlSession.selectList("myRev.myRevListDate", list);
	}
	
	//결제대기 상태 카운트
	public int status0(String cl_num) {
		return sqlSession.selectOne("myRev.status0", cl_num);
	}
	
	//결제완료 상태 카운트
	public int status1(String cl_num) {
		return sqlSession.selectOne("myRev.status1", cl_num);
	}
	
	//이용완료 상태 카운트
	public int status2(String cl_num) {
		return sqlSession.selectOne("myRev.status2", cl_num);
	}
	

	
	//미용실 예약확인 상세조회
	public List<HairShopReservation> myRevDetail(String har_rnum){
		return sqlSession.selectList("myRev.myRevDetail", har_rnum);
	}
	public String anotherMenu(String har_rnum){
		return sqlSession.selectOne("myRev.anotherMenu", har_rnum);
	}
	public int getPrice(String har_rnum){
		return sqlSession.selectOne("myRev.getPrice", har_rnum);
	}
	
	//미용실 결제 취소
	public int cancleRev(String har_rnum){
		return sqlSession.update("myRev.cancleRev", har_rnum);
	}
	
	
	//동물병원 예약확인 상세조회
	public List<HospitalReservation> myRevDetail2(String hos_rnum){
		return sqlSession.selectList("myRev.myRevDetail2", hos_rnum);
	}
	//동물병원 결제 취소
	public int cancleRev2(String hos_rnum){
		return sqlSession.update("myRev.cancleRev2", hos_rnum);
	}
}
