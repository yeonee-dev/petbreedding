package kh.com.petbreedding.mypage.model.vo;

import org.springframework.stereotype.Component;

//CL_NUM              VARCHAR2(20) 
//POINT_NUM           VARCHAR2(20) 
//INDEXS     NOT NULL NUMBER(1)    
//EXP_DATE   NOT NULL VARCHAR2(20) 
//EXP_TYPE   NOT NULL VARCHAR2(20) 
//EXP_FROM   NOT NULL VARCHAR2(20) 
//EXP_ID     NOT NULL VARCHAR2(20) 
//EXP_POINT  NOT NULL NUMBER(5)    
//CURR_POINT NOT NULL NUMBER(5)   

@Component
public class MyPoint {
	private String clNum;
	private String pointNum;
	private int indexs;
	private String expDate;
	private String expType;
	private String expFrom;
	private String expId;
	private int expPoint;
	private int currPoint;
	
	@Override
	public String toString() {
		return "MyPoint [clNum=" + clNum + ", pointNum=" + pointNum + ", indexs=" + indexs + ", expDate=" + expDate
				+ ", expType=" + expType + ", expFrom=" + expFrom + ", expId=" + expId + ", expPoint=" + expPoint
				+ ", currPoint=" + currPoint + "]";
	}

	public String getClNum() {
		return clNum;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

	public String getPointNum() {
		return pointNum;
	}

	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}

	public int getIndexs() {
		return indexs;
	}

	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public String getExpFrom() {
		return expFrom;
	}

	public void setExpFrom(String expFrom) {
		this.expFrom = expFrom;
	}

	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public int getExpPoint() {
		return expPoint;
	}

	public void setExpPoint(int expPoint) {
		this.expPoint = expPoint;
	}

	public int getCurrPoint() {
		return currPoint;
	}

	public void setCurrPoint(int currPoint) {
		this.currPoint = currPoint;
	}
	
	
	
}
