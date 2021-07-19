package kh.com.petbreedding.mypage.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Notice {
	
	private String notNum;
	private String notCon;
	private String notReceiver;
	private String notPublisher;
	private String refNum;
	private String refClass;
	private int readState;
	private String shopNum;
	private String shopName;
	private String shopImg;
	private String boTitle;
	private String qnaTitle;
	private String notTime;
	private String revNum;
	
	public String getRevNum() {
		return revNum;
	}
	public void setRevNum(String revNum) {
		this.revNum = revNum;
	}
	public String getNotTime() {
		return notTime;
	}
	public void setNotTime(String notTime) {
		this.notTime = notTime;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getBoTitle() {
		return boTitle;
	}
	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getNotNum() {
		return notNum;
	}
	public void setNotNum(String notNum) {
		this.notNum = notNum;
	}
	public String getNotCon() {
		return notCon;
	}
	public void setNotCon(String notCon) {
		this.notCon = notCon;
	}
	public String getNotReceiver() {
		return notReceiver;
	}
	public void setNotReceiver(String notReceiver) {
		this.notReceiver = notReceiver;
	}
	public String getNotPublisher() {
		return notPublisher;
	}
	public void setNotPublisher(String notPublisher) {
		this.notPublisher = notPublisher;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getRefClass() {
		return refClass;
	}
	public void setRefClass(String refClass) {
		this.refClass = refClass;
	}
	public int getReadState() {
		return readState;
	}
	public void setReadState(int readState) {
		this.readState = readState;
	}
	
	
}
