package kh.com.petbreedding.bmypage.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Hospital {
	
	private String hosNum;	// 동물병원 번호
	private String bpId;	// 사업자 고객번호
	private String shopName;	// 동물병원 이름
	private String shopAddr;	// 동물병원 주소
	private String shopTel;	// 동물병원 전화번호
	private String shopTime;	//동물병원영업시간
	private String shopMInfo;	// 동물병원 메인 소개
//	private String hosConn;		// 동물병원 채팅 접속여부
//	private String hosClick;	// 동물병원 잔여 클릭수
	private String shopMImg; // 동물병원 대표 사진 파일명
	
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
		return "Hospital [hosNum=" + hosNum + ", bpId=" + bpId + ", shopName=" + shopName + ", shopAddr=" + shopAddr
				+ ", shopTel=" + shopTel + ", shopTime=" + shopTime + ", shopMInfo=" + shopMInfo + ", shopMImg="
				+ shopMImg + ", mon=" + mon + ", tue=" + tue + ", wed=" + wed + ", thu=" + thu + ", fri=" + fri
				+ ", sat=" + sat + ", sun=" + sun + ", avgRevVal=" + avgRevVal + ", likes=" + likes + ", cta_number="
				+ cta_number + "]";
	}
	public int getLikes() {
		return likes;
	}
	public int getCta_number() {
		return cta_number;
	}




	public void setLikes(int likes) {
		this.likes = likes;
	}
	public void setCta_number(int cta_number) {
		this.cta_number = cta_number;
	}




	public double getAvgRevVal() {
		return avgRevVal;
	}




	public void setAvgRevVal(double avgRevVal) {
		this.avgRevVal = avgRevVal;
	}


	public String getHosNum() {
		return hosNum;
	}

	public void setHosNum(String hosNum) {
		this.hosNum = hosNum;
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


	public String getShopMImg() {
		return shopMImg;
	}


	public void setShopMImg(String shopMImg) {
		this.shopMImg = shopMImg;
	}


	public String getMon() {
		return mon;
	}


	public void setMon(String mon) {
		this.mon = mon;
	}


	public String getTue() {
		return tue;
	}


	public void setTue(String tue) {
		this.tue = tue;
	}


	public String getWed() {
		return wed;
	}


	public void setWed(String wed) {
		this.wed = wed;
	}


	public String getThu() {
		return thu;
	}


	public void setThu(String thu) {
		this.thu = thu;
	}


	public String getFri() {
		return fri;
	}


	public void setFri(String fri) {
		this.fri = fri;
	}


	public String getSat() {
		return sat;
	}


	public void setSat(String sat) {
		this.sat = sat;
	}


	public String getSun() {
		return sun;
	}


	public void setSun(String sun) {
		this.sun = sun;
	}

	
	

	
	
}


///* HOSPITAL 테이블 */
//CREATE TABLE HOSPITAL (
//    HOS_NUM VARCHAR2(20) CONSTRAINT HOSPITAL_HOS_NUM_PK PRIMARY KEY,
//    BP_ID VARCHAR2(20) CONSTRAINT HOSPITAL_BP_ID_FK REFERENCES BUSINESS_PARTNER
//    ON DELETE CASCADE NOT NULL,
//    HOS_NAME VARCHAR2(20) NOT NULL,
//    HOS_ADDR VARCHAR2(300) NOT NULL,
//    HOS_TEL VARCHAR2(20) NOT NULL,
//    OPEN_TIME VARCHAR2(20),
//    HOS_MINFO VARCHAR2(500),
//    HOS_DINFO VARCHAR2(500),
//    HOS_CONN NUMBER(1),
//    HOS_CLICK NUMBER(7) DEFAULT 0 NOT NULL
//);
