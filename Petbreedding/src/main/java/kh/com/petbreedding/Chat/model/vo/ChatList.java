package kh.com.petbreedding.Chat.model.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class ChatList {
	
    private String chatId;
	private String cl_num;
	private String bp_id;
	private String mContent;
	private Timestamp mSendTime;
	private String shopName;
	private String nickName;
	private int unreadCount;
	private int bp_type;
	private String mImg;
	
	public int getBp_type() {
		return bp_type;
	}
	public void setBp_type(int bp_type) {
		this.bp_type = bp_type;
	}
	public String getmImg() {
		return mImg;
	}
	public void setmImg(String mImg) {
		this.mImg = mImg;
	}
	public int getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getBp_id() {
		return bp_id;
	}
	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public Timestamp getmSendTime() {
		return mSendTime;
	}
	public void setmSendTime(Timestamp mSendTime) {
		this.mSendTime = mSendTime;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}	
	
}
