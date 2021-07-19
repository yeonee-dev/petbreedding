package kh.com.petbreedding.board.model.vo;

import org.springframework.stereotype.Component;

//QNAC_NUM  NOT NULL VARCHAR2(10)   
//ADMIN_ID           VARCHAR2(50)   
//QNA_NUM            VARCHAR2(50)   
//QNAC_CONT          VARCHAR2(1000) 
//QNAC_DATE          VARCHAR2(20)

@Component
public class MyAskComment {
	private String qnacNum;
	private String adminId;
	private String qnaNum;
	private String qnacCont;
	private String qnacDate;
	
	@Override
	public String toString() {
		return "MyAskComment [qnacNum=" + qnacNum + ", adminId=" + adminId + ", qnaNum=" + qnaNum + ", qnacCont="
				+ qnacCont + ", qnacDate=" + qnacDate + "]";
	}

	public String getQnacNum() {
		return qnacNum;
	}

	public void setQnacNum(String qnacNum) {
		this.qnacNum = qnacNum;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(String qnaNum) {
		this.qnaNum = qnaNum;
	}

	public String getQnacCont() {
		return qnacCont;
	}

	public void setQnacCont(String qnacCont) {
		this.qnacCont = qnacCont;
	}

	public String getQnacDate() {
		return qnacDate;
	}

	public void setQnacDate(String qnacDate) {
		this.qnacDate = qnacDate;
	}
	
	
}
