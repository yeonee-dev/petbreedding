package kh.com.petbreedding.bmypage.model.vo;

public class HospitalImg {
	
	private String imgNum; // 이미지 번호 
	private String hosNum;	// 동물병원 번호
	private String shopImg;	// 미용실 매장 이미지 (파일명)
	
	
	
	@Override
	public String toString() {
		return "HospitalImg [imgNum=" + imgNum + ", hosNum=" + hosNum + ", shopImg=" + shopImg + "]";
	}
	public String getImgNum() {
		return imgNum;
	}
	public void setImgNum(String imgNum) {
		this.imgNum = imgNum;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getHosNum() {
		return hosNum;
	}
	public void setHosNum(String hosNum) {
		this.hosNum = hosNum;
	}
	
	
	
}
