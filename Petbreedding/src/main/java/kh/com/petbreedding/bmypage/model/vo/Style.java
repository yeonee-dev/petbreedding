package kh.com.petbreedding.bmypage.model.vo;

public class Style {
	
	private String style_num; //스타일 번호
	private String harNum; // 미용실 번호
	private String style_name; //스타일 이름
	private int price; //스타일 가격
	private int style_time; //스타일 소요시간
	private int style_deep; //스타일 종류 (0 : 메인메뉴  1: 서브메뉴)
	private int style_num2; //서브스타일번호
	

	
	@Override
	public String toString() {
		return "Style [style_num=" + style_num + ", harNum=" + harNum + ", style_name=" + style_name + ", price="
				+ price + ", style_time=" + style_time + ", style_deep=" + style_deep + ", style_num2=" + style_num2
				+ "]";
	}

	public int getStyle_num2() {
		return style_num2;
	}

	public void setStyle_num2(int style_num2) {
		this.style_num2 = style_num2;
	}

	public String getStyle_num() {
		return style_num;
	}

	public void setStyle_num(String style_num) {
		this.style_num = style_num;
	}

	public String getHarNum() {
		return harNum;
	}
	public void setHarNum(String harNum) {
		this.harNum = harNum;
	}
	public String getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStyle_time() {
		return style_time;
	}
	public void setStyle_time(int style_time) {
		this.style_time = style_time;
	}
	public int getStyle_deep() {
		return style_deep;
	}
	public void setStyle_deep(int style_deep) {
		this.style_deep = style_deep;
	}
	
	

}
