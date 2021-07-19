package kh.com.petbreedding.board.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.ReviewComment;

@Repository("reviewCommentDao")
public class ReviewCommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//	사업자 리뷰 등록
	public int reviewCommentInsert(ReviewComment revCmnt) {
		return sqlSession.insert("ReviewComment.reviewCommentInsert", revCmnt);
	}
}
