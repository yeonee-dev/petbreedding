package kh.com.petbreedding.BP.model.vo;

public class BPartner {
	private String bp_Id;  	//사업자 회원번호
	private String bp_pwd;	
	private String bp_name;
	private String bp_tel;
	private String bp_bank;
	private String bp_acnt;		//사업자 계좌번호
	private String bp_email;	
	private String bp_num;		//사업자번호
	private int bp_type;		//사업장 구분( 0 : 미용실, 1 :동물병원)
	private int bp_aprve;		//사업자 승인여부( 0 : false / 1: true)
	private int bp_delete;		//사업자 제휴취소여부( 0 : false / 1: true)
	private int bp_reg;			//사업장 등록 여부 (0:false / 1:true)	
	private String reg_date;  	//사업자 가입날짜
	

	
	@Override
	public String toString() {
		return "BPartner [bp_Id=" + bp_Id + ", bp_pwd=" + bp_pwd + ", bp_name=" + bp_name + ", bp_tel=" + bp_tel
				+ ", bp_bank=" + bp_bank + ", bp_acnt=" + bp_acnt + ", bp_email=" + bp_email + ", bp_num=" + bp_num
				+ ", bp_type=" + bp_type + ", bp_aprve=" + bp_aprve + ", bp_delete=" + bp_delete + ", bp_reg=" + bp_reg
				+ ", reg_date=" + reg_date + "]";
	}
	public int getBp_reg() {
		return bp_reg;
	}
	public void setBp_reg(int bp_reg) {
		this.bp_reg = bp_reg;
	}
	public String getBp_Id() {
		return bp_Id;
	}
	public void setBp_Id(String bp_Id) {
		this.bp_Id = bp_Id;
	}
	public String getBp_pwd() {
		return bp_pwd;
	}
	public void setBp_pwd(String bp_pwd) {
		this.bp_pwd = bp_pwd;
	}
	public String getBp_name() {
		return bp_name;
	}
	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	public String getBp_tel() {
		return bp_tel;
	}
	public void setBp_tel(String bp_tel) {
		this.bp_tel = bp_tel;
	}
	public String getBp_bank() {
		return bp_bank;
	}
	public void setBp_bank(String bp_bank) {
		this.bp_bank = bp_bank;
	}
	public String getBp_acnt() {
		return bp_acnt;
	}
	public void setBp_acnt(String bp_acnt) {
		this.bp_acnt = bp_acnt;
	}
	public String getBp_email() {
		return bp_email;
	}
	public void setBp_email(String bp_email) {
		this.bp_email = bp_email;
	}
	public String getBp_num() {
		return bp_num;
	}
	public void setBp_num(String bp_num) {
		this.bp_num = bp_num;
	}
	public int getBp_type() {
		return bp_type;
	}
	public void setBp_type(int bp_type) {
		this.bp_type = bp_type;
	}
	public int getBp_aprve() {
		return bp_aprve;
	}
	public void setBp_aprve(int bp_aprve) {
		this.bp_aprve = bp_aprve;
	}

	public int getBp_delete() {
		return bp_delete;
	}

	public void setBp_delete(int bp_delete) {
		this.bp_delete = bp_delete;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}

