package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kh.com.petbreedding.board.model.vo.MyAsk;

public interface MyAskService {
	public int listCount();
	public int listCountClBp(MyAsk myAsk);
	public int listCountAll(int qnaChk);
	public int clBpListCount(String user_num);
	public List<MyAsk> MyAskSelectList(Map<String, Object> map);
	public List<MyAsk> MyAskSelectListM(Map<String, String> map);
	public List<MyAsk> MyAskSelectListClBpM(Map<String, String> map);
	public List<MyAsk> MyAskSelectListClBpAllM(Map<String, String> map);
	public MyAsk MyAskSelectDetail(String qna_num);
	public int MyAskInsert(MyAsk myAsk);
	public int MyAskDelete(String qna_num);
}
