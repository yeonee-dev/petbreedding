package kh.com.petbreedding.bmypage.model.vo;


import org.springframework.stereotype.Component;

@Component
public class HairSalonImg {
	
	private String imgNum; // 이미지 번호 
	private String harNum;	// 미용실번호
	private String shopImg;	// 미용실 매장 이미지 (파일명)


	@Override
	public String toString() {
		return "HairSalonImg [imgNum=" + imgNum + ", harNum=" + harNum + ", shopImg=" + shopImg + "]";
	}
	
	
	
	public String getHarNum() {
		return harNum;
	}



	public void setHarNum(String harNum) {
		this.harNum = harNum;
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
	
	
	
	
	
}
