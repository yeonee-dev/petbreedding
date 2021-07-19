package kh.com.petbreedding.common.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.vo.Client;

@Repository("loginDao")
public class LoginDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 사용자 이메일 로그인
	public Client login(Client client) {
		return sqlSession.selectOne("Login.loginMember", client);
		
	}
	
	// 사업자 이메일 로그인
	public BPartner blogin(BPartner bP) {
		return sqlSession.selectOne("Login.loginBMember", bP);
		
	}

	// 관리자 이메일 로그인
	public Admin mLogin(Admin admin) {
		return sqlSession.selectOne("Login.loginAdmin", admin);
		
	}
	
	//사용자 조회(네이버, 카카오)
	public List<Client> selectMember(String nickname) {
		return sqlSession.selectList("Login.selectMember", nickname);
	}
	
}

