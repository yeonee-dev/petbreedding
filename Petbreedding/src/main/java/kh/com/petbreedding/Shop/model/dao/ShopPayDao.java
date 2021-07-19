package kh.com.petbreedding.Shop.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;

@Repository("shopPayDao")
public class ShopPayDao {

	@Autowired
	private SqlSession sqlSession;
	
	
//	미용실 결제 테이블 저장
	public int harPay(HarPay harPay) {
		return sqlSession.insert("shopPay.harPay", harPay);
	}

//	미용실 예약 상태 변경
	public int harRevUp(String har_rnum) {
		return sqlSession.update("shopPay.harRevUp", har_rnum);
	}
	
//	동물병원 결제 테이블 저장
	public int hosPay(HosPay hosPay) {
		return sqlSession.insert("shopPay.hosPay", hosPay);
	}

//	동물병원 예약 상태 변경
	public int hosRevUp(String hos_rnum) {
		return sqlSession.update("shopPay.hosRevUp", hos_rnum);
	}
	
	//병원 매출관리
	public int hosAllPrice(String hos_num) {
		return sqlSession.selectOne("shopPay.HosAllPrice", hos_num);
	}
	
	//미용실 매출관리(이번달 매출)
	public int harAllPrice(String har_num) {
		return sqlSession.selectOne("shopPay.HarAllPrice", har_num);
	}
	
	//미용실 1년차트
	public List<HarPay> HarsixPrice(String har_num) {
		return sqlSession.selectList("shopPay.HarsixPrice", har_num);
	}
	
	//병원 1년차트
	public List<HosPay> HosYearPrice(String hos_num){
		return sqlSession.selectList("shopPay.hosYearPrice", hos_num);
	}
	//최근 1년 날짜 구하기
	public List<HarPay> payYear() {
		return sqlSession.selectList("shopPay.yearMonth");
	}
	
	public void updateRevByScheduled(){
		try {
			sqlSession.update("shopPay.updateRevByScheduled");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void updateRevByScheduled2(){
		try {
			sqlSession.update("shopPay.updateRevByScheduled2");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
}
