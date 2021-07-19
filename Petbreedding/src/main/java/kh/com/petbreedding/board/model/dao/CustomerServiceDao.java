package kh.com.petbreedding.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.CustomerService;

@Repository("customerServiceDao")
public class CustomerServiceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//	관리자 공지사항 전체 개수 조회
	public int CustomerServiceListCount() {
		return sqlSession.selectOne("CustomerService.CustomerServiceListCount");
	}
	
	//	관리자 공지사항 ANN_TYPE  선택 개수 조회
	public int CustomerServiceListCountS(int annType) {
		System.out.println("[세훈] @관리자 공지사항 목록 고객, 사업자 선택 다오    annType	: " + annType);
		return sqlSession.selectOne("CustomerService.CustomerServiceListCountS", annType);
	}
	
	//	관리자 공지 리스트 전체 조회
	public List<CustomerService> CustomerServiceSelectListA(Map<String, Object> map) {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListA", map);
	}
	
	//	관리자 ANN_TYPE 선택 리스트 조회
	public List<CustomerService> CustomerServiceSelectListS(Map<String, Object> map) {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListS", map);
	}
	
	
	//	공지사항 리스트 조회
	public List<CustomerService> CustomerServiceSelectListC() {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListC");
	}
	//사업자 공지사랑 리스트
	public List<CustomerService> CustomerServiceSelectListB(Map<String, String> paging) {
		return sqlSession.selectList("CustomerService.CustomerServiceSelectListB",paging);
	}
	//사업자 공지사항 리스트 개수 조회
	public int ListBCount() {
		return sqlSession.selectOne("CustomerService.ListBCount");
	}
	
	//	공지사항 상세 조회
	public CustomerService CustomerServiceSelectOne(String ann_num) {
		return sqlSession.selectOne("CustomerService.CustomerServiceSelectOne", ann_num);
	}
	
	// 공지사항 등록
	public int CustomerServiceInsert(CustomerService cs) {
		return sqlSession.insert("CustomerService.CustomerServiceInsert", cs);
	}
	
	// 공지사항 수정
	public int CustomerServiceUpdate(CustomerService cs) {
		return sqlSession.update("CustomerService.CustomerServiceUpdate", cs);
	}
	
	// 공지사항 삭제
	public int CustomerServiceDelete(String ann_num) {
		return sqlSession.delete("CustomerService.CustomerServiceDelete", ann_num);
	}
}
