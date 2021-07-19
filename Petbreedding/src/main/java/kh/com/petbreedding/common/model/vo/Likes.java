package kh.com.petbreedding.common.model.vo;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;

public class Likes {

	private String like_num;
	private String cl_num;
	private String har_num;
	private String hos_num;
	private HairSalon hairSalon;
	private Hospital hospital;
	private String bp_type;
	private String har_img;
	private int count;
	
	
	
	@Override
	public String toString() {
		return "Likes [like_num=" + like_num + ", cl_num=" + cl_num + ", har_num=" + har_num + ", hos_num=" + hos_num
				+ ", hairSalon=" + hairSalon + ", hospital=" + hospital + ", bp_type=" + bp_type + ", har_img="
				+ har_img + ", count=" + count + "]";
	}
	public String getLike_num() {
		return like_num;
	}
	public String getCl_num() {
		return cl_num;
	}
	public String getHar_num() {
		return har_num;
	}
	public String getHos_num() {
		return hos_num;
	}
	public void setLike_num(String like_num) {
		this.like_num = like_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public void setHar_num(String har_num) {
		this.har_num = har_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}
	public HairSalon getHairSalon() {
		return hairSalon;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHairSalon(HairSalon hairSalon) {
		this.hairSalon = hairSalon;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public String getBp_type() {
		return bp_type;
	}
	public void setBp_type(String bp_type) {
		this.bp_type = bp_type;
	}
	public String getHar_img() {
		return har_img;
	}
	public void setHar_img(String har_img) {
		this.har_img = har_img;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
