package kh.com.petbreedding.Admin.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.common.model.vo.Pagination;


@Repository("aDao")
public class AdminDao {
	
	@Autowired
	SqlSession sqlSession;
	
	//제휴승인대기 목록 총 갯수
	public int countMwait() {
		return sqlSession.selectOne("mWait.countMwait");
	}
	
//	제휴승인대기 목록 조회
	public List<BPartner> waitList(Pagination page) {
		return sqlSession.selectList("mWait.selectMwait", page);
	}
	
	//제휴승인 대기 승인
	public int confirmBP(List<String> list){
		return sqlSession.update("mWait.confirmBP", list);
	}
	
	//제휴승인 대기 거절
	public int refuseBP(List<String> list){
		return sqlSession.delete("mWait.refuseBP", list);
	}
	
	//제휴취소대기 목록 총 갯수
	public int countMdelete() {
		return sqlSession.selectOne("mWait.countMdelete");
	}
	
	//제휴취소대기 목록 조회
	public List<BPartner> deleteList(Pagination page) {
		return sqlSession.selectList("mWait.selectMdelete",page);
	}

	//제휴취소 승인
	public int deleteBP(List<String> list){
		return sqlSession.delete("mWait.deleteBP", list);
	}
	
	
	//제휴취소 취소
	public int backBP(List<String> list){
		return sqlSession.update("mWait.backBP", list);
	}
	
	//사용자 수 
	public int getMemberCount() {
		return sqlSession.selectOne("chart.memberCount");
	}
	
	//사업자수 
	public int getBpCount() {
		return sqlSession.selectOne("chart.bpCount");
	}
	
	//사용자 수 차트
	public int getMemChart(String reg_date) {
		return sqlSession.selectOne("chart.memberMonth", reg_date);
	}
	//사업자 수 차트
	public int getBpChart(String reg_date) {
		return sqlSession.selectOne("chart.bpMonth", reg_date);
	}
	
	//총 매출
	public int getAllPrice(String pay_date) {
		return sqlSession.selectOne("chart.allPayPrice",pay_date);
	}
	//순 매출
	public int getRealPrice(String pay_date) {
		return sqlSession.selectOne("chart.realPayPrice", pay_date);
	}
	//울트라콜 점유율
	public int getUltraAll() {
		return sqlSession.selectOne("chart.ultraAll");
	}
	//사업장 점유율
	public int getBpAll() {
		return sqlSession.selectOne("chart.bpAll");
	}
	//미용실 울트라 점유율
	public int getHarUltra() {
		return sqlSession.selectOne("chart.HarUltra");
	}
	//병원 울트라 점유율
	public int getHosUltra() {
		return sqlSession.selectOne("chart.HosUltra");
	}
}	
	
	
	
