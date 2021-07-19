package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.BCommentDao;
import kh.com.petbreedding.board.model.vo.B_comment;

@Service("bCommentService")
public class BCommentServiceImpl implements BCommentService {
	
	@Autowired
	private BCommentDao bCommentDao;

	@Override
	public List<B_comment> bCommentSelectListA() {
		List<B_comment> bcSeListA = null;
		
		try {
			bcSeListA = bCommentDao.bCommentSelectListA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeListA;
	}

	@Override
	public List<B_comment> bCommentSelectListC(String bo_num) {
		List<B_comment> bcSeListC = null;
		
		try {
			bcSeListC = bCommentDao.bCommentSelectListC(bo_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeListC;
	}

	@Override
	public String getbCommentSeq() {
		String bcSeq = null;
		
		try {
			bcSeq = bCommentDao.getbCommentSeq();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcSeq;
	}

	@Override
	public int bCommentInsert(B_comment bComment) {
		int bcInsert = -1;
		int bocChk = -1; 
		String bo_num = bComment.getBoNum();
		
		try {
			
			String co_num = bCommentDao.getbCommentSeq();
			bComment.setCoNum(co_num);
			System.out.println("[세훈] @게시판 댓글 등록 서비스 co_num : " + co_num);
			bcInsert = bCommentDao.bCommentInsert(bComment);
			bocChk = bCommentDao.bocChkUpdate(bo_num);
			
			if(bocChk > 0) {
				System.out.println("게시판 댓글 갯수 체크 업데이트 성공");
			} else {
				System.out.println("게시판 댓글 갯수 체크 업데이트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcInsert;
	}
	
	@Override
	public int bCommentUpdate(B_comment bComment) {
		int bcUpdResult = -1;
		
		try {
			bcUpdResult = bCommentDao.bCommentUpdate(bComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bcUpdResult;
	}

	@Override
	public int bCommentDelete(String co_num, String bo_num) {
		int bcDeleteResult = -1;
		int bocChk = -1; 
		
		try {
			bcDeleteResult = bCommentDao.bCommentDelete(co_num);
			bocChk = bCommentDao.bocChkUpdate(bo_num); 
			
			if(bocChk > 0) {
				System.out.println("게시판 댓글 갯수 체크 업데이트 성공");
			} else {
				System.out.println("게시판 댓글 갯수 체크 업데이트 실패");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return bcDeleteResult;
 	}

	
	@Override
	public int myBoardCMCount(String cl_num) {
		int result = -1;
		try {
			result = bCommentDao.myBoardCMCount(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<B_comment> myBoardCMList(Map<String, String> map) {
		List<B_comment> result = null;
		try {
			result = bCommentDao.myBoardCMList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int myCommentDelete(List<String> list) {
		int result = -1;
		try {
			result = bCommentDao.myCommentDelete(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
