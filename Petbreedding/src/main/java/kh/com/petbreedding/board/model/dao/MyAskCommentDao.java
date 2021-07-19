package kh.com.petbreedding.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.MyAskComment;

@Repository("myAskCommentDao")
public class MyAskCommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// <!-- [관리자] 해당 문의 사항의 댓글 조회 -->
	public List<MyAskComment> myAskCommentSelectOne(String qna_num) {
		System.out.println("[관리자] @문의사항 댓글 조회 문의사항 번호" + qna_num);
		return sqlSession.selectList("MyAskComment.myAskCommentSelectOne", qna_num);
	}
	
	// <!-- [고객, 사업자] 해당 문의 사항의 댓글 조회 -->
		public MyAskComment myAskCommentSelectOneCB(String qna_num) {
			System.out.println("[고객, 사업자] @문의사항 댓글 조회 문의사항 번호" + qna_num);
			return sqlSession.selectOne("MyAskComment.myAskCommentSelectOneCB", qna_num);
		}
	
	// <!-- 문의 사항 댓글 시퀀스 더미 테이블을 이용해 가져오기 -->
	public String getMyAskCommentSeq() {
		
		System.out.println("[세훈] @문의 댓글 getMyAskCommentSeq 진입");
		return sqlSession.selectOne("MyAskComment.getMyAskCommentSeq");
	}
	
	// <!-- 문의 사항 댓글 등록 -->
	public int myAskCommentInsert(MyAskComment maComment) {
		return sqlSession.insert("MyAskComment.myAskCommentInsert", maComment);
	}
	
	// <!-- 문의 사항 답변 여부 등록  -->
	public int myAskChkUpdate(String qna_num) {
		return sqlSession.update("MyAskComment.myAskChkUpdate", qna_num);
	}
	
	//	문의사항 댓글 수정
	public int myAskCommentUpdate(MyAskComment maComment) {
		return sqlSession.update("MyAskComment.myAskCommentUpdate", maComment);
	}
	
	// <!-- 문의 사항 댓글  삭제  -->
	public int myAskCommentDelete(String qnac_num) {
		System.out.println("[세훈] @문의사항 댓글 삭제 다오 : " + qnac_num);
		return sqlSession.delete("MyAskComment.myAskCommentDelete", qnac_num);
	}
	
	//	문의사항 댓글 여부 체크 엄데이트
	public int updateQnarChk(String qna_num) {
		return sqlSession.update("MyAsk.updateQnarChk", qna_num);
	}
}
