package kh.com.petbreedding.Shop.model.vo;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.vo.MyPet;

public class HairShopReservation {
	private String har_rnum; //미용실 예약번호
	private String cl_num; //고객번호
	private String pet_num; //펫번호
	private String style_num; //메인 스타일 번호
	private String har_num; //헤어샵 번호
	private String res_date; //예약날짜 (YYYY-MM-DD)
	private String res_status; //예약상태  (0 : 결제대기, 1 : 결제완료, 2: 이용완료 , 3: 결제취소)
	private String res_time; //예약시간( HH:MM)
	private String style_num2; //추가 스타일 번호
	private int res_chk;
	private String har_name;
	private Client client;
	private MyPet pet;
	private Style style;
	private HairSalon hairSalon;
	private int startIndex;
	private int cntPerPage;
	private String name;
	private String bp_id;
	
	@Override
	public String toString() {
		return "HairShopReservation [har_rnum=" + har_rnum + ", cl_num=" + cl_num + ", pet_num=" + pet_num
				+ ", style_num=" + style_num + ", har_num=" + har_num + ", res_date=" + res_date + ", res_status="
				+ res_status + ", res_time=" + res_time + ", style_num2=" + style_num2 + ", res_chk=" + res_chk
				+ ", har_name=" + har_name + ", client=" + client + ", pet=" + pet + ", style=" + style + ", hairSalon="
				+ hairSalon + ", startIndex=" + startIndex + ", cntPerPage=" + cntPerPage + ", name=" + name
				+ ", bp_id=" + bp_id + "]";
	}

	public String getHar_rnum() {
		return har_rnum;
	}

	public void setHar_rnum(String har_rnum) {
		this.har_rnum = har_rnum;
	}

	public String getCl_num() {
		return cl_num;
	}

	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}

	public String getPet_num() {
		return pet_num;
	}

	public void setPet_num(String pet_num) {
		this.pet_num = pet_num;
	}

	public String getStyle_num() {
		return style_num;
	}

	public void setStyle_num(String style_num) {
		this.style_num = style_num;
	}

	public String getHar_num() {
		return har_num;
	}

	public void setHar_num(String har_num) {
		this.har_num = har_num;
	}

	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getRes_status() {
		return res_status;
	}

	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}

	public String getRes_time() {
		return res_time;
	}

	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}

	public String getStyle_num2() {
		return style_num2;
	}

	public void setStyle_num2(String style_num2) {
		this.style_num2 = style_num2;
	}

	public int getRes_chk() {
		return res_chk;
	}

	public void setRes_chk(int res_chk) {
		this.res_chk = res_chk;
	}

	public String getHar_name() {
		return har_name;
	}

	public void setHar_name(String har_name) {
		this.har_name = har_name;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public MyPet getPet() {
		return pet;
	}

	public void setPet(MyPet pet) {
		this.pet = pet;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public HairSalon getHairSalon() {
		return hairSalon;
	}

	public void setHairSalon(HairSalon hairSalon) {
		this.hairSalon = hairSalon;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBp_id() {
		return bp_id;
	}

	public void setBp_id(String bp_id) {
		this.bp_id = bp_id;
	}

	
	

}
