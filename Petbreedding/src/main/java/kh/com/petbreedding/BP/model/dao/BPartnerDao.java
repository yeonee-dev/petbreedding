package kh.com.petbreedding.BP.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;

@Repository("bDao")
public class BPartnerDao {

	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int insertBP(BPartner bP) {
		return sqlSession.insert("BParterMap.insertBP", bP);
	}
	
	//아이디 중복체크
	public int checkEmail(String bp_email) {	// 이메일 중복 확인	
		return sqlSession.selectOne("BParterMap.checkEmail", bp_email);	
	}

	//휴대폰 중복체크
	public int checkHp(String bp_tel) {	// 휴대폰 중복 확인	
		return sqlSession.selectOne("BParterMap.checkHp", bp_tel);	
	}
	
	//사업자번호 중복체크
	public int checkBpNum(String bp_num) {	// 휴대폰 중복 확인	
		return sqlSession.selectOne("BParterMap.checkBpNum", bp_num);	
	}
	
	//회원탈퇴신청
	public int deleteBP(String bp_Id) {
		return sqlSession.update("BParterMap.deleteBP", bp_Id);
	}
}
