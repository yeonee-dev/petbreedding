package kh.com.petbreedding.mypage.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Repository("myPointDao")
public class MyPointDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//	포인트 조회
	public List<MyPoint> myPointSelectList(MyPoint myPoint) {
		return sqlSession.selectList("MyPoint.myPointSelectList", myPoint);
	}
	
	public int CurrPointSelectOne(String clNum) {
		return sqlSession.selectOne("MyPoint.CurrPointSelectOne", clNum);
	}
	
	public int myPointInit(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointInit", myPoint);
	}
	
	public int myPointInsert(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointInsert", myPoint);
	}
	
	public int myPointUpdate(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointUpdate", myPoint);
	}
	
	public int myPointCancle(MyPoint myPoint) {
		return sqlSession.insert("MyPoint.myPointCancle", myPoint);
	}
	
	//3개월
	public List<MyPoint> myPoint3m(String clNum) {
		return sqlSession.selectList("MyPoint.myPoint3m",clNum);
	}
	
	//6개월
	public List<MyPoint> myPoint6m(String clNum) {
		return sqlSession.selectList("MyPoint.myPoint6m",clNum);
	}
	
	//12개월
	public List<MyPoint> myPoint12m(String clNum) {
		return sqlSession.selectList("MyPoint.myPoint12m",clNum);
	}
	
	//기간별 조회
	public List<MyPoint> myPointDate(Map<String, String> list) {
		return sqlSession.selectList("MyPoint.myPointDate", list);
	}
	
}



