package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import kh.com.petbreedding.mypage.model.vo.Notice;

public interface NoticeService {
	
	public int notificationRead(String notReceiver);
	public List<Notice> unreadNotList(String notReceiver);
	public List<Notice> getNoticeList(String notReceiver);
	public String getbp_id(String shopNum);
	public String getbp_idforPay(String refNum);
	public String getOrigClNum(String refNum);
	public String getclNumInQna(String refNum);
	public int inReservaion(Notice notice);
	public int inPay(Notice notice);
	public int inUnreadChat(Notice notice);
	public int inBoard(Notice notice);
	public int inQna(Notice notice);
	public int inPointSave(Notice notice);
	public int inPointUsing(Notice notice);
	public int inCancleRev(Notice notice);
	public int updateReadState(String notNum);
	public int deleteNotice(String notNum);
	
}
