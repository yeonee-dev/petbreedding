package kh.com.petbreedding.board.model.vo;

import org.springframework.stereotype.Component;

//REVC_NUM VARCHAR2(10) CONSTRAINT REVIEW_COMMENT_REVR_NUM_PK PRIMARY KEY,
//BP_ID VARCHAR2(50) CONSTRAINT REVIEW_COMMENT_BP_ID_FK REFERENCES BUSINESS_PARTNER,
//REV_NUM VARCHAR2(10) CONSTRAINT REVIEW_COMMENT_REV_NUM_FK REFERENCES REVIEW,
//REVC_CONT VARCHAR2(1000) NOT NULL,
//REVC_DATE VARCHAR2(20) NOT NULL,
//DEPTH NUMBER(1) NOT NULL,
//IDX NUMBER NOT NULL

@Component
public class ReviewComment {
	private String revcNum;
	private String bpId;
	private String revNum;
	private String revcCont;
	private String revcDate;
	@Override
	public String toString() {
		return "ReviewComment [revcNum=" + revcNum + ", bpId=" + bpId + ", revNum=" + revNum + ", revcCont=" + revcCont
				+ ", revcDate=" + revcDate + "]";
	}
	public String getRevcNum() {
		return revcNum;
	}
	public void setRevcNum(String revcNum) {
		this.revcNum = revcNum;
	}
	public String getBpId() {
		return bpId;
	}
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}
	public String getRevNum() {
		return revNum;
	}
	public void setRevNum(String revNum) {
		this.revNum = revNum;
	}
	public String getRevcCont() {
		return revcCont;
	}
	public void setRevcCont(String revcCont) {
		this.revcCont = revcCont;
	}
	public String getRevcDate() {
		return revcDate;
	}
	public void setRevcDate(String revcDate) {
		this.revcDate = revcDate;
	}
	
	
	
}
