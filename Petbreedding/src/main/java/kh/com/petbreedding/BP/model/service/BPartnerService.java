package kh.com.petbreedding.BP.model.service;

import kh.com.petbreedding.BP.model.vo.BPartner;

public interface BPartnerService {

	public int insertBP(BPartner bP);
	public int checkEmail(String bp_email);
	public int checkHp(String bp_tel);
	public int checkBpNum(String bp_num);
	public int deleteBP(String bp_Id);
}
