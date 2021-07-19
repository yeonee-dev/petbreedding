package kh.com.petbreedding.mypage.model.vo;

import kh.com.petbreedding.bmypage.model.vo.Style;

public class MyPet {

	private String pet_num; //반려동물 번호
	private String cl_num;	//고객번호
	private String pet_name; //반려동물 이름
	private String pet_kind; //품종
	private String pet_birth; //반려동물 생일
	private String pet_gen; //반려동물 성별
	private String pet_neut; //반려동물 중성화 여부
	private String pet_exper; // 반려동물 미용경험 횟수?
	private String pet_vaccin; //반려동물 예방접종 기록
	private String pet_bite; // 반려동물 입질 여부
	private String kneecap; // 반려동물 쓸개골탈구 여부
	private String dislike; // 반려동물이 예민하게 생각하는 부위 (진료, 미용시 주의해야될 요소)
	private String pet_others; // 반려동물 기타 특이사항
	private String pet_img; // 반려동물 사진
	private String pet_weight; //반료동물 몸무게
	private String mbti; //멍BTI
	
	@Override
	public String toString() {
		return "MyPet [pet_num=" + pet_num + ", cl_num=" + cl_num + ", pet_name=" + pet_name + ", pet_kind=" + pet_kind
				+ ", pet_birth=" + pet_birth + ", pet_gen=" + pet_gen + ", pet_neut=" + pet_neut + ", pet_exper="
				+ pet_exper + ", pet_vaccin=" + pet_vaccin + ", pet_bite=" + pet_bite + ", kneecap=" + kneecap
				+ ", dislike=" + dislike + ", pet_others=" + pet_others + ", pet_img=" + pet_img + ", pet_weight="
				+ pet_weight + ", mbti=" + mbti + "]";
	}
	public String getPet_num() {
		return pet_num;
	}
	public void setPet_num(String pet_num) {
		this.pet_num = pet_num;
	}
	public String getCl_num() {
		return cl_num;
	}
	public void setCl_num(String cl_num) {
		this.cl_num = cl_num;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public String getPet_kind() {
		return pet_kind;
	}
	public void setPet_kind(String pet_kind) {
		this.pet_kind = pet_kind;
	}
	public String getPet_birth() {
		return pet_birth;
	}
	public void setPet_birth(String pet_birth) {
		this.pet_birth = pet_birth;
	}
	public String getPet_gen() {
		return pet_gen;
	}
	public void setPet_gen(String pet_gen) {
		this.pet_gen = pet_gen;
	}
	public String getPet_neut() {
		return pet_neut;
	}
	public void setPet_neut(String string) {
		this.pet_neut = string;
	}
	public String getPet_exper() {
		return pet_exper;
	}
	public void setPet_exper(String pet_exper) {
		this.pet_exper = pet_exper;
	}
	public String getPet_vaccin() {
		return pet_vaccin;
	}
	public void setPet_vaccin(String pet_vaccin) {
		this.pet_vaccin = pet_vaccin;
	}
	public String getPet_bite() {
		return pet_bite;
	}
	public void setPet_bite(String pet_bite) {
		this.pet_bite = pet_bite;
	}
	public String getKneecap() {
		return kneecap;
	}
	public void setKneecap(String kneecap) {
		this.kneecap = kneecap;
	}
	public String getDislike() {
		return dislike;
	}
	public void setDislike(String dislike) {
		this.dislike = dislike;
	}
	public String getPet_others() {
		return pet_others;
	}
	public void setPet_others(String pet_others) {
		this.pet_others = pet_others;
	}
	public String getPet_img() {
		return pet_img;
	}
	public void setPet_img(String pet_img) {
		this.pet_img = pet_img;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getPet_weight() {
		return pet_weight;
	}
	public void setPet_weight(String pet_weight) {
		this.pet_weight = pet_weight;
	}

	


}
