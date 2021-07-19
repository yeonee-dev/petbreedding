package kh.com.petbreedding.bmypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.dao.BInfoDao;


@Service("bInfoService")
public class BInfoServiceImpl implements BInfoService{

	@Autowired
	private BInfoDao bInfoDao;

	@Override
	public int updateBPInfo(BPartner bP) {
		int result = -1;
		try {
			result = bInfoDao.updateBPInfo(bP);
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!error!!!!!!!!!! : "+ e);
			
		}
		
		return result;
	}
}
