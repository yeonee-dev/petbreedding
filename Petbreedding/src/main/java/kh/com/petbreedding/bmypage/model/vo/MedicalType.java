package kh.com.petbreedding.bmypage.model.vo;

public class MedicalType {

	private String medNum;	//진료번호
	private String medName;	//진료명
	private String medPrice; //진료가격
	private String hosNum; //병원번호
	
	
	
	@Override
	public String toString() {
		return "MedicalType [medNum=" + medNum + ", medName=" + medName + ", medPrice=" + medPrice + ", hosNum="
				+ hosNum + "]";
	}
	
	
	
	public String getHosNum() {
		return hosNum;
	}



	public void setHosNum(String hosNum) {
		this.hosNum = hosNum;
	}



	public String getMedNum() {
		return medNum;
	}
	public void setMedNum(String medNum) {
		this.medNum = medNum;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedPrice() {
		return medPrice;
	}
	public void setMedPrice(String medPrice) {
		this.medPrice = medPrice;
	}
	
	
}
