package kh.com.petbreedding.Shop.model.vo;

import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.vo.MyPet;

public class HospitalReservation {
	private String hos_rnum; 	//동물병원 예약번호
	private String cl_num;		//고객번호
	private String pet_num;		//펫번호
	private String med_num;		//예약메뉴번호
	private String hos_num;		//동물병원 번호
	private String hos_date;	//예약날짜
	private String med_num2;	//예약메뉴번호2
	private int hos_status; 	//예약 상태
	private String hos_time; 	//예약 시간
	private int res_chk;
	private MyPet pet;
	private Hospital hospital;
	private MedicalType medical;
	private Client client;
	private String name;
	private String bp_id;
	@Override
	public String toString() {
		return "HospitalReservation [hos_rnum=" + hos_rnum + ", cl_num=" + cl_num + ", pet_num=" + pet_num
				+ ", med_num=" + med_num + ", hos_num=" + hos_num + ", hos_date=" + hos_date + ", med_num2=" + med_num2
				+ ", hos_status=" + hos_status + ", hos_time=" + hos_time + ", res_chk=" + res_chk + ", pet=" + pet
				+ ", hospital=" + hospital + ", medical=" + medical + ", client=" + client + ", name=" + name
				+ ", bp_id=" + bp_id + "]";
	}
	public String getHos_rnum() {
		return hos_rnum;
	}
	public void setHos_rnum(String hos_rnum) {
		this.hos_rnum = hos_rnum;
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
	public String getMed_num() {
		return med_num;
	}
	public void setMed_num(String med_num) {
		this.med_num = med_num;
	}
	public String getHos_num() {
		return hos_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}
	public String getHos_date() {
		return hos_date;
	}
	public void setHos_date(String hos_date) {
		this.hos_date = hos_date;
	}
	public String getMed_num2() {
		return med_num2;
	}
	public void setMed_num2(String med_num2) {
		this.med_num2 = med_num2;
	}
	public int getHos_status() {
		return hos_status;
	}
	public void setHos_status(int hos_status) {
		this.hos_status = hos_status;
	}
	public String getHos_time() {
		return hos_time;
	}
	public void setHos_time(String hos_time) {
		this.hos_time = hos_time;
	}
	public int getRes_chk() {
		return res_chk;
	}
	public void setRes_chk(int res_chk) {
		this.res_chk = res_chk;
	}
	public MyPet getPet() {
		return pet;
	}
	public void setPet(MyPet pet) {
		this.pet = pet;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public MedicalType getMedical() {
		return medical;
	}
	public void setMedical(MedicalType medical) {
		this.medical = medical;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
