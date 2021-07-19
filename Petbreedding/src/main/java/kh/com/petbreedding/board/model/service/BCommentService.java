package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.B_comment;

public interface BCommentService {
	public List<B_comment> bCommentSelectListA();
	
	public List<B_comment> bCommentSelectListC(String bo_num);
	
	public String getbCommentSeq();
	
	public int bCommentInsert(B_comment bComment);
	
	public int bCommentUpdate(B_comment bComment);
	
	public int bCommentDelete(String co_num,String bo_num);
	
	
	public int myBoardCMCount(String cl_num);//내가쓴 댓글 갯수
	public List<B_comment> myBoardCMList(Map<String, String> map);//내가 쓴 댓글 조회
	public int myCommentDelete(List<String> list);
	
}
