package kh.com.petbreedding.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.OftenQna;

@Repository("oftenQnaDao")
public class OftenQnaDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int allOftenCount() {
		return sqlSession.selectOne("oftenQna.allOftenCount");
	}
	
	public List<OftenQna> allOftenQna(Map<String, String> map){
		return sqlSession.selectList("oftenQna.allOftenQna", map);
	}
	
	public int insertOftenQna(OftenQna oftenQna) {
		return sqlSession.insert("oftenQna.insertOftenQna", oftenQna);
	}
	
	
	public int COftenCount() {
		return sqlSession.selectOne("oftenQna.COftenCount");
	}
	
	public List<OftenQna> COftenQna(Map<String, String> map){
		return sqlSession.selectList("oftenQna.COftenQna", map);
	}
	
	public int BOftenCount() {
		return sqlSession.selectOne("oftenQna.BOftenCount");
	}
	
	public List<OftenQna> BOftenQna(Map<String, String> map){
		return sqlSession.selectList("oftenQna.BOftenQna", map);
	}
	
	
	
}
