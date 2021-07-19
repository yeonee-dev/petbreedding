package kh.com.petbreedding.board.model.vo;

import org.springframework.stereotype.Component;

//QNA_NUM   NOT NULL VARCHAR2(10)   
//USER_NUM  NOT NULL VARCHAR2(20)   
//QNA_TITLE NOT NULL VARCHAR2(100)  
//QNA_CONT  NOT NULL VARCHAR2(3000) 
//QNA_IMG            VARCHAR2(200)  
//QNA_DATE  NOT NULL VARCHAR2(20)   
//QNA_WR             VARCHAR2(50)   
//QNAR_CHK           NUMBER(1)   

@Component
public class MyAsk {
	private String qnaNum;
	private String userNum;
	private String qnaTitle;
	private String qnaCont;
	private String qnaImg;
	private String qnaDate;
	private String qnaWr;
	private int qnaType;
	private int qnaChk;
	
	@Override
	public String toString() {
		return "MyAsk [qnaNum=" + qnaNum + ", userNum=" + userNum + ", qnaTitle=" + qnaTitle + ", qnaCont=" + qnaCont
				+ ", qnaImg=" + qnaImg + ", qnaDate=" + qnaDate + ", qnaWr=" + qnaWr + ", qnaType=" + qnaType
				+ ", qnaChk=" + qnaChk + "]";
	}

	public String getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(String qnaNum) {
		this.qnaNum = qnaNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaCont() {
		return qnaCont;
	}

	public void setQnaCont(String qnaCont) {
		this.qnaCont = qnaCont;
	}

	public String getQnaImg() {
		return qnaImg;
	}

	public void setQnaImg(String qnaImg) {
		this.qnaImg = qnaImg;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaWr() {
		return qnaWr;
	}

	public void setQnaWr(String qnaWr) {
		this.qnaWr = qnaWr;
	}

	public int getQnaType() {
		return qnaType;
	}

	public void setQnaType(int qnaType) {
		this.qnaType = qnaType;
	}

	public int getQnaChk() {
		return qnaChk;
	}

	public void setQnaChk(int qnaChk) {
		this.qnaChk = qnaChk;
	}
	
	
}
