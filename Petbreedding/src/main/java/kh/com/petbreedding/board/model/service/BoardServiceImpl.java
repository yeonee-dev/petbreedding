package kh.com.petbreedding.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.BoardDao;
import kh.com.petbreedding.board.model.vo.B_comment;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.common.model.vo.Pagination;

@Service("boarService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public int insertBoard(Board board) {
		int result = -1;
		
		try {
			result = boardDao.insertBoard(board);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateBoard(Board board) {
			int boUpdResult = -1;
		try {
			boUpdResult = boardDao.updateBoard(board);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return boUpdResult;
	}

	@Override
	public int deleteBoard(String bo_num) {
		
		int boDelResult = -1; 
		
		try {
			boDelResult = boardDao.deleteBoard(bo_num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return boDelResult;
	}
	
	//	게시판 리스트 조회
	@Override
	public List<Board> selectBoardList(Pagination page) {
		List<Board> board = null;
		
		try {
			board = boardDao.selectBoardList(page);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(board);
		return board;
	}

	// 게시판 상세 조회
	@Override
	public Board selectBoardDetail(int chk, String boNum) {
		Board board = null;
		
		try {
			if(chk == 0)
				boardDao.addReadCount(boNum);
			board = boardDao.selectBoardDetail(boNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}

	@Override
	public int listCount() {
		int result = -1;
		try {
			result = boardDao.listCount();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Board> searchList(String keyword) {
		List<Board> searchResult = null;
		
		try {
			searchResult = boardDao.searchList(keyword);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return searchResult;
	}

	@Override
	public int myBoardCount(String cl_num) {
		int result = -1;
		try {
			result = boardDao.myBoardCount(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Board> myBoardList(Map<String, String> map) {
		List<Board> result = null;
		try {
			result = boardDao.myBoardList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int myBoardDelete(List<String> list) {
		int result = -1;
		try {
			result = boardDao.myBoardDelete(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}




}
