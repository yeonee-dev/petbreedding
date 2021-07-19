package kh.com.petbreedding.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.B_comment;

@Repository("bCommentDao")
public class BCommentDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<B_comment> bCommentSelectListA() {
		return sqlSession.selectList("boardComment.bCommentSelectListA");
	}
	
	public List<B_comment> bCommentSelectListC(String bo_num) {
		return sqlSession.selectList("boardComment.bCommentSelectListC", bo_num);
	}
	
	public String getbCommentSeq() {
		return sqlSession.selectOne("boardComment.getbCommentSeq");
	}
	
	public int bCommentInsert(B_comment bComment) {
		return sqlSession.insert("boardComment.bCommentInsert", bComment);
	}
	
	public int bocChkUpdate(String bo_num) {
		return sqlSession.update("boardComment.bocChkUpdate", bo_num);
	}
	
	public int bCommentUpdate(B_comment bComment) {
		return sqlSession.update("boardComment.bCommentUpdate", bComment);
	}
	
	public int bCommentDelete(String co_num) {
		return sqlSession.delete("boardComment.bCommentDelete", co_num);
	}
	
	
	//내가 쓴 댓글 개수 
	public int myBoardCMCount(String cl_num) {
		return sqlSession.selectOne("boardComment.myBoardCMCount", cl_num);
	}
	
	//내가 쓴 댓글 조회
	public List<B_comment> myBoardCMList(Map<String, String> map){
		return sqlSession.selectList("boardComment.myBoardCMList", map);
	}
	//내가 쓴 댓글 삭제
	public int myCommentDelete(List<String> list) {
		return sqlSession.delete("boardComment.myCommentDelete", list);
	}
}
