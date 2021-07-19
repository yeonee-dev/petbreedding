package kh.com.petbreedding.Chat.model.vo;

import org.springframework.stereotype.Component;

@Component
public class ChatMessage {

	private String mId;
	private String mSender;
	private String mReceiver;
	private String mContent;
	private String mSendTime;
	private String chatId;
	private String cl_num;
	private String bp_id;
	private int mUnreadCount;
	private String mSenderemail;
	private String mSenderName;
	private int bp_type;
	private String mImg;
	private int invisibleClient;
	private int invisibleBp;
	
	public int getInvisibleClient() {
		return invisibleClient;
	}
	public void setInvisibleClient(int invisibleClient) {
		this.invisibleClient = invisibleClient;
	}
	public int getInvisibleBp() {
		return invisibleBp;
	}
	public void setInvisibleBp(int invisibleBp) {
		this.invisibleBp = invisibleBp;
	}
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
	public String getmSenderName() {
		return mSenderName;
	}
	public void setmSenderName(String mSenderName) {
		this.mSenderName = mSenderName;
	}
	public String getmSenderemail() {
		return mSenderemail;
	}
	public void setmSenderemail(String mSenderemail) {
		this.mSenderemail = mSenderemail;
	}
	public int getmUnreadCount() {
		return mUnreadCount;
	}
	public void setmUnreadCount(int mUnreadCount) {
		this.mUnreadCount = mUnreadCount;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmSender() {
		return mSender;
	}
	public void setmSender(String mSender) {
		this.mSender = mSender;
	}
	public String getmReceiver() {
		return mReceiver;
	}
	public void setmReceiver(String mReceiver) {
		this.mReceiver = mReceiver;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getmSendTime() {
		return mSendTime;
	}
	public void setmSendTime(String mSendTime) {
		this.mSendTime = mSendTime;
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
}
