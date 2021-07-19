package kh.com.petbreedding.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.MyAskCommentDao;
import kh.com.petbreedding.board.model.dao.MyAskDao;
import kh.com.petbreedding.board.model.vo.MyAskComment;

@Service("myAskCommentService")
public class MyAskCommentServiceImpl implements MyAskCommentService {
	
	@Autowired
	private MyAskCommentDao myAskCommentDao;

	@Override
	public List<MyAskComment> myAskCommentSelectOne(String qna_num) {
		List<MyAskComment> result = null;
		
		try {
			result = myAskCommentDao.myAskCommentSelectOne(qna_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public MyAskComment myAskCommentSelectOneCB(String qna_num) {
		MyAskComment result = null;
		try {
			result = myAskCommentDao.myAskCommentSelectOneCB(qna_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getMyAskCommentSeq() {
		String result = null;
		
		try {
			result = myAskCommentDao.getMyAskCommentSeq();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int myAskCommentInsert(MyAskComment maComment) {
		int result = -1;
		int uResult = -1;
		String qnac_num = "";
		
		try {
			String qna_num = maComment.getQnaNum();
			System.out.println("[세훈] @문의 사항 댓글 서비스 qna_num : " + qna_num);
			qnac_num = myAskCommentDao.getMyAskCommentSeq();
			System.out.println("[세훈] @문의 사항 댓글 서비스 qnac_num : " + qnac_num);
			maComment.setQnacNum(qnac_num);
			
			result = myAskCommentDao.myAskCommentInsert(maComment);
			uResult = myAskCommentDao.myAskChkUpdate(qna_num); // 댓글 Insert 하고 바로 이어서 해당 문의 글 답변 여부 Update
			if(uResult > 0) {
				System.out.println("[세훈] @문의사항 댓글 서비스 : 답변 여부 업데이트 성공");
			} else {
				System.out.println("[세훈] @문의사항 댓글 서비스 : 답변 여부 업데이트 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int myAskCommentDelete(String qnac_num, String qna_num) {
		int macDelResult = -1;
		int qnarChkUpdResult = -1;
		
		System.out.println("[세훈] @문의사항 댓글 삭제 서비스 : " + qnac_num);
		try {
			macDelResult = myAskCommentDao.myAskCommentDelete(qnac_num);
			qnarChkUpdResult = myAskCommentDao.updateQnarChk(qna_num);
			
			if(qnarChkUpdResult > 0) {
				System.out.println("문의 사항 댓글 체크 업데이트 성공");
			} else {
				System.out.println("문의 사항 댓글 체크 업데이트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return macDelResult;
		
	}

	//	문의 사항 댓글 수정
	@Override
	public int myAskCommentUpdate(MyAskComment maComment) {
		int macUpdResult = -1;
		
		try {
			macUpdResult = myAskCommentDao.myAskCommentUpdate(maComment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return macUpdResult;
	}



}
