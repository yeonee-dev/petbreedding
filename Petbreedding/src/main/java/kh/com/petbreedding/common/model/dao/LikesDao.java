package kh.com.petbreedding.common.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.common.model.vo.Likes;

@Repository("likesDao")
public class LikesDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertLikes(Likes likes) {
		return sqlSession.insert("likes.insertLike", likes);
	}
	
	public List<Likes> selectLikes(String cl_num){
		return sqlSession.selectList("likes.selectLike", cl_num);
	}
	
	public int delLikes(Likes likes) {
		return sqlSession.insert("likes.deleteLike", likes);
	}
	
	public int clickLike(Likes likes) {
		return sqlSession.selectOne("likes.clickLike", likes);
	}
	
	public String countSalon(String har_num) {
		return sqlSession.selectOne("likes.countSalon", har_num);
	}
	
	public String countHos(String hos_num) {
		return sqlSession.selectOne("likes.countHos", hos_num);
	}
}
