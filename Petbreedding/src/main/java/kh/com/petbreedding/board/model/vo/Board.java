package kh.com.petbreedding.board.model.vo;


import org.springframework.stereotype.Component;

@Component
public class Board {
	
	private String boNum;
	private String clNum;
	private String clNickName;
	private String boTitle;
	private String boCont;
	private String boImg;
	private String boDate; 
	private int boView;
	private int bocChk;
	
	@Override
	public String toString() {
		return "Board [boNum=" + boNum + ", clNum=" + clNum + ", clNickName=" + clNickName + ", boTitle=" + boTitle
				+ ", boCont=" + boCont + ", boImg=" + boImg + ", boDate=" + boDate + ", boView=" + boView + ", bocChk="
				+ bocChk + "]";
	}

	public String getBoNum() {
		return boNum;
	}

	public void setBoNum(String boNum) {
		this.boNum = boNum;
	}

	public String getClNum() {
		return clNum;
	}

	public void setClNum(String clNum) {
		this.clNum = clNum;
	}

	public String getClNickName() {
		return clNickName;
	}

	public void setClNickName(String clNickName) {
		this.clNickName = clNickName;
	}

	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public String getBoCont() {
		return boCont;
	}

	public void setBoCont(String boCont) {
		this.boCont = boCont;
	}

	public String getBoImg() {
		return boImg;
	}

	public void setBoImg(String boImg) {
		this.boImg = boImg;
	}

	public String getBoDate() {
		return boDate;
	}

	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}

	public int getBoView() {
		return boView;
	}

	public void setBoView(int boView) {
		this.boView = boView;
	}

	public int getBocChk() {
		return bocChk;
	}

	public void setBocChk(int bocChk) {
		this.bocChk = bocChk;
	}
	
	
}
