package kh.com.petbreedding.BP.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.BP.model.dao.BPartnerDao;
import kh.com.petbreedding.BP.model.vo.BPartner;

@Service("bService")
public class BPartnerServiceImpl implements BPartnerService{

	@Autowired
	private BPartnerDao bDao;
	
	
	@Override
	public int insertBP(BPartner bP) {
		int result = -1;
		try {
			result = bDao.insertBP(bP);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkEmail(String bp_email) {
		int result = -1;
		try {
			result = bDao.checkEmail(bp_email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkHp(String bp_tel) {
		int result = -1;
		try {
			result = bDao.checkHp(bp_tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkBpNum(String bp_num) {
		int result = -1;
		try {
			result = bDao.checkBpNum(bp_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteBP(String bp_Id) {
		int result = -1;
		try {
			result = bDao.deleteBP(bp_Id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
