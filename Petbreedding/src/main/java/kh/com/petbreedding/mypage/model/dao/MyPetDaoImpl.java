package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

@Repository("mypetDao")
public class MyPetDaoImpl implements MyPetDao {
 @Autowired
 private SqlSession sqlSession;

@Override
public List<MyPet> selectPetInfo() {
	return sqlSession.selectList("pet.petlist");
}

@Override
public void insertPetInfo(MyPet mypet) {
	 sqlSession.insert("pet.insertMyPet", mypet);
}

@Override
public List<MyPet> eachPetInfo(String cl_num) {
	return sqlSession.selectList("pet.eachpet", cl_num);
}

@Override
public int updatePetInfo(MyPet mypet) throws Exception {
	System.out.println("update dao들어옴");
	return sqlSession.update("pet.updatepet", mypet);
}

@Override
public MyPet read(String pet_num) {
	return sqlSession.selectOne("pet.petread", pet_num);
}




@Override
public int deletePetInfo(String pet_num) {
	return sqlSession.delete("pet.petdelete", pet_num);
}
 
 
}
