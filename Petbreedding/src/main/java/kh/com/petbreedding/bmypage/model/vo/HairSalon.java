package kh.com.petbreedding.bmypage.model.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HairSalon {

	private String harNum; // 미용실 번호
	private String bpId; // 사업자 고객번호
	private String shopName; // 미용실 이름
	private String shopAddr; // 미용실 주소
	private String shopTel; // 미용실 전화번호
	private String shopTime; // 미용실 영업시간
	private String shopMInfo; // 미용실 메인 소개
	private String shopMImg; //미용실 메인 사진
	private Style style;
	
	private List<HairSalonImg> shopImgList; // 미용실 대표사진들. 미용실 하나가 여러 개의 사진을 가짐.
	private List<String> shopDayOffList; // 미용실 주휴일
	
	private String mon;
	private String tue;
	private String wed;
	private String thu;
	private String fri;
	private String sat;
	private String sun;

	private double avgRevVal;
	private int likes;
	
	private int cta_number;
	
	







	@Override
	public String toString() {
		return "HairSalon [harNum=" + harNum + ", bpId=" + bpId + ", shopName=" + shopName + ", shopAddr=" + shopAddr
				+ ", shopTel=" + shopTel + ", shopTime=" + shopTime + ", shopMInfo=" + shopMInfo + ", shopMImg="
				+ shopMImg + ", style=" + style + ", shopImgList=" + shopImgList + ", shopDayOffList=" + shopDayOffList
				+ ", mon=" + mon + ", tue=" + tue + ", wed=" + wed + ", thu=" + thu + ", fri=" + fri + ", sat=" + sat
				+ ", sun=" + sun + ", avgRevVal=" + avgRevVal + ", likes=" + likes + ", cta_number=" + cta_number + "]";
	}








	public int getCta_number() {
		return cta_number;
	}








	public void setCta_number(int cta_number) {
		this.cta_number = cta_number;
	}








	public int getLikes() {
		return likes;
	}








	public void setLikes(int likes) {
		this.likes = likes;
	}








	public double getAvgRevVal() {
		return avgRevVal;
	}








	public void setAvgRevVal(double avgRevVal) {
		this.avgRevVal = avgRevVal;
	}








	public String getShopMImg() {
		return shopMImg;
	}



	public void setShopMImg(String shopMImg) {
		this.shopMImg = shopMImg;
	}




	public String getHarNum() {
		return harNum;
	}

	public void setHarNum(String harNum) {
		this.harNum = harNum;
	}

	public String getBpId() {
		return bpId;
	}

	public void setBpId(String bpId) {
		this.bpId = bpId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getShopTime() {
		return shopTime;
	}

	public void setShopTime(String shopTime) {
		this.shopTime = shopTime;
	}

	public String getShopMInfo() {
		return shopMInfo;
	}

	public void setShopMInfo(String shopMInfo) {
		this.shopMInfo = shopMInfo;
	}

	public List<HairSalonImg> getShopImgList() {
		return shopImgList;
	}

	public void setShopImgList(List<HairSalonImg> shopImgList) {
		this.shopImgList = shopImgList;
	}

	public List<String> getShopDayOffList() {
		return shopDayOffList;
	}

	public void setShopDayOffList(List<String> shopDayOffList) {
		this.shopDayOffList = shopDayOffList;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}



	public String getMon() {
		return mon;
	}



	public String getTue() {
		return tue;
	}



	public String getWed() {
		return wed;
	}



	public String getThu() {
		return thu;
	}



	public String getFri() {
		return fri;
	}



	public String getSat() {
		return sat;
	}



	public String getSun() {
		return sun;
	}



	public void setMon(String mon) {
		this.mon = mon;
	}



	public void setTue(String tue) {
		this.tue = tue;
	}



	public void setWed(String wed) {
		this.wed = wed;
	}



	public void setThu(String thu) {
		this.thu = thu;
	}



	public void setFri(String fri) {
		this.fri = fri;
	}



	public void setSat(String sat) {
		this.sat = sat;
	}



	public void setSun(String sun) {
		this.sun = sun;
	}

	
	
	
	
}

//
///* HAIR_SALON 테이블 */
//CREATE TABLE HAIR_SALON (
//    HAR_NUM VARCHAR2(20) CONSTRAINT HAIR_SALON_HAR_NUM_PK PRIMARY KEY,
//    BP_ID VARCHAR2(20) CONSTRAINT HAIR_SALON_BP_ID_FK REFERENCES BUSINESS_PARTNER ON DELETE CASCADE NOT NULL,
//    HAR_NAME VARCHAR2(20) NOT NULL,
//    HAR_ADDR VARCHAR2(300) NOT NULL,
//    HAR_TEL VARCHAR2(20) NOT NULL,
//    HOPEN_TIME VARCHAR2(100),
//    HAR_MINFO VARCHAR2(500),
//    HAR_DINFO VARCHAR2(500),
//    HAR_CLICK NUMBER(7) NOT NULL
//);
