package kh.com.petbreedding.Shop.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.vo.Style;

@Repository("bprevDao")
public class BpReservationDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<HairShopReservation> revList(HairShopReservation vo) throws Exception {
		return sqlSession.selectList("bprev.harRavListeach",vo);
	}

	public List<HairShopReservation> revAllListDate(HairShopReservation vo) throws Exception {
		return sqlSession.selectList("bprev.hartRavListDate", vo);
	}
	
	public List<HairShopReservation> revAllList(String bp_id) throws Exception {
		return sqlSession.selectList("bprev.hartRavList", bp_id);
	}
	
	// 헤어살롱 예약상세페이지
	public HairShopReservation revharcon(String har_rnum) throws Exception{
		return sqlSession.selectOne("bprev.HarRevCon", har_rnum);
	}
	
	public int delrevHar(String har_rnum) throws Exception{
		return sqlSession.update("bprev.harstatus", har_rnum);
	}
	
	
	//병원
	public List<HospitalReservation> revHosList(HospitalReservation vo) throws Exception{
		return sqlSession.selectList("bprev.hosRevListeach", vo);
	}
	
	public List<HospitalReservation> revAllHosListDate(HospitalReservation vo) throws Exception {
		return sqlSession.selectList("bprev.hosRevListDate", vo);
	}
	
	public List<HospitalReservation> revHosAllList(String bp_id) throws Exception {
		return sqlSession.selectList("bprev.hosrevList", bp_id);
	}
	
	//병원 예약상세페이지
	public HospitalReservation revhoscon(String hos_rnum) throws Exception{
		return sqlSession.selectOne("bprev.HosRevCon", hos_rnum);
	}
	
	//병원 예약취소
	public int delrevHos(String hos_rnum) throws Exception{
		return sqlSession.update("bprev.hosstatus", hos_rnum);
	}
	
	
}
