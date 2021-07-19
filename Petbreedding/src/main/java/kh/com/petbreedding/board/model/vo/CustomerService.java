package kh.com.petbreedding.board.model.vo;

//ANN_NUM   NOT NULL VARCHAR2(10)   
//ADMIN_ID           VARCHAR2(50)   
//ANN_TITLE NOT NULL VARCHAR2(100)  
//ANN_CONT  NOT NULL VARCHAR2(3000) 
//ANN_DATE  NOT NULL VARCHAR2(20)

public class CustomerService {
	private String annNum;
	private String adminId;
	private String annTitle;
	private String annCont;
	private String annDate;
	private String annType;
	
	@Override
	public String toString() {
		return "CustomerService [annNum=" + annNum + ", adminId=" + adminId + ", annTitle=" + annTitle + ", annCont="
				+ annCont + ", annDate=" + annDate + ", annType=" + annType + "]";
	}

	public String getAnnNum() {
		return annNum;
	}

	public void setAnnNum(String annNum) {
		this.annNum = annNum;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAnnTitle() {
		return annTitle;
	}

	public void setAnnTitle(String annTitle) {
		this.annTitle = annTitle;
	}

	public String getAnnCont() {
		return annCont;
	}

	public void setAnnCont(String annCont) {
		this.annCont = annCont;
	}

	public String getAnnDate() {
		return annDate;
	}

	public void setAnnDate(String annDate) {
		this.annDate = annDate;
	}

	public String getAnnType() {
		return annType;
	}

	public void setAnnType(String annType) {
		this.annType = annType;
	}
	

	
}
