package kh.com.petbreedding.client.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.client.model.vo.Client;

@Repository("clientDao")
public class ClientDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertClient(Client client) { // 이메일 회원가입
		return sqlSession.insert("ClientMap.insertClient", client);
	}
	
	public int checkEmail(String email) {	// 이메일 중복 확인	
		return sqlSession.selectOne("ClientMap.checkEmail", email);	
	}
	
	public int checkNickName(String nickname) {	// 닉네임 중복 확인	
		return sqlSession.selectOne("ClientMap.checkNickName", nickname);	
	}
	
	public int checkHp(String tel) {	// 휴대폰 중복 확인	
		return sqlSession.selectOne("ClientMap.checkHp", tel);	
	}
	
	public int deleteClient(String cl_num) {
		return sqlSession.delete("ClientMap.deleteClient", cl_num);
	}
	
	public int deltePoint(String cl_num) {
		return sqlSession.delete("ClientMap.deltePoint", cl_num);
	}
	
	public String getJoinSeq() {
		return sqlSession.selectOne("ClientMap.getJoinSeq");
	}
	
	public String getClientSeqCurrVal() {
		return sqlSession.selectOne("ClientMap.getClientSeqCurrVal");
	}
	
	public String getClientSeqNextVal() {
		return sqlSession.selectOne("ClientMap.getClientSeqNextVal");
	}
	
}
