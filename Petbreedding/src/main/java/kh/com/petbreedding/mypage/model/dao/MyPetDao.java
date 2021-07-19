package kh.com.petbreedding.mypage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetDao {
	

	// 반려동물 정보 보기
	public List<MyPet> selectPetInfo()throws Exception;
	
	// 반려동물 정보 등록
	public void insertPetInfo(MyPet mypet)throws Exception;
	
	//아이디에 해당하는 반려동물 정보 보기
	public List<MyPet> eachPetInfo(String cl_num) throws Exception;
	
	
//	// 반려동물 정보 수정
	public int updatePetInfo(MyPet mypet) throws Exception;
	
	//펫 상세보기
	public MyPet read(String pet_num) throws Exception;
//	
	// 반려동물 정보 삭제
	public int deletePetInfo(String pet_num);
}
