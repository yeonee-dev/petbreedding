package kh.com.petbreedding.bmypage.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;

@Repository("bInfoDao")
public class BInfoDao {
	
	@Autowired
	SqlSession sqlSession;
	
	
	// 사업자 정보 수정 
	public int updateBPInfo(BPartner bP) {
		return sqlSession.update("Modify.modifyBP", bP);
	} 
	
	
	
}
