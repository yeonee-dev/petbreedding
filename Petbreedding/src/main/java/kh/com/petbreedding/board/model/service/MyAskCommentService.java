package kh.com.petbreedding.board.model.service;

import java.util.List;

import kh.com.petbreedding.board.model.vo.MyAskComment;

public interface MyAskCommentService {
	// <!-- [관리자] 해당 문의 사항의 댓글 조회 -->
	public List<MyAskComment> myAskCommentSelectOne(String qna_num);
	// <!-- [고객, 사업자] 해당 문의 사항의 댓글 조회 -->
	public MyAskComment myAskCommentSelectOneCB(String qna_num);
	// <!-- 문의 사항 댓글 시퀀스 더미 테이블을 이용해 가져오기 -->
	public String getMyAskCommentSeq();
	// <!-- 문의 사항 댓글 등록 -->
	public int myAskCommentInsert(MyAskComment maComment);
	//	문의 사항 댓글 수정
	public int myAskCommentUpdate(MyAskComment maComment);
	// 문의 사항 댓글 삭제
	public int myAskCommentDelete(String qnac_num, String qna_num);
}
