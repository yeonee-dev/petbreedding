package kh.com.petbreedding.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.B_comment;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.common.model.vo.Pagination;

@Repository("boardDao")
public class BoardDao {
		
	@Autowired
	private SqlSession sqlSession;
	
	
		// 게시글 작성
		public int insertBoard(Board board) {
			return sqlSession.insert("Board.insertBoard", board);
		}
		
		// 게시글 수정
		public int updateBoard(Board board) {
			return sqlSession.update("Board.updateBoard", board);
		}
		
		// 게시글 삭제
		public int deleteBoard(String bo_num) {
			return sqlSession.delete("Board.deleteBoard", bo_num);
		}
		
		//전체 글 수 조회
		public int listCount() { 
			return sqlSession.selectOne("Board.listCount");
		}
		
		// 게시글 보기
		public Board selectBoardDetail(String boNum) {
			Board board = null;
			board = sqlSession.selectOne("Board.selectOneBoard", boNum);
			return board;
		} 
		
		// 게시글 리스트 조회
		public List<Board> selectBoardList(Pagination page) {
			return sqlSession.selectList("Board.selectBoardList", page);
		}
		
		 // 게시글 검색 조회
		public List<Board> searchList(String keyword) {
			 return sqlSession.selectList("Board.searchList", keyword);
		}
		
		 // 글 조회 수 증가
		public int addReadCount(String bo_num) {
			 return sqlSession.update("Board.addReadCount", bo_num);
		}

		//내가 쓴 글 개수 
		public int myBoardCount(String cl_num) {
			return sqlSession.selectOne("Board.myBoardCount", cl_num);
		}
		
		//내가 쓴 글 조회
		public List<Board> myBoardList(Map<String, String> map){
			return sqlSession.selectList("Board.myBoardList", map);
		}
		
		//내가 쓴 글 삭제 
		public int myBoardDelete(List<String> list) {
			return sqlSession.delete("Board.myBoardDelete", list);
		}
		
}
