package kh.com.petbreedding.mypage.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.petbreedding.mypage.model.vo.MyPet;

public interface MyPetService {
	
	public List<MyPet> selectPetInfo();  // 반려동물 정보 보기
	public void insertPetInfo(MyPet mypet);
	public List<MyPet> eachPetInfo(String cl_num);
	public int updatePetInfo(MyPet mypet) throws Exception;
	public MyPet read(String pet_num);
	public int deletePetInfo(String pet_num);
}
