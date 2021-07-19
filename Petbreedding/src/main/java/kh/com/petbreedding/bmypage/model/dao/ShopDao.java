package kh.com.petbreedding.bmypage.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.common.model.vo.Pagination;

@Repository("shopDao")
public class ShopDao {

	@Autowired
	private SqlSession sqlSession;
	

	// 사업장 등록 - BP 테이블에서 사업장 등록여부 상태 1로 바꾸기
	public int updateBpReg(String bpId) {
		System.out.println(" !! ShopDao - updateBpReg() 실행 !!");
		return sqlSession.insert("Shop.updateBpReg", bpId);
	}
	
	// 공통
	
	public String selectRevVal(String bpId) {
		System.out.println("Shop Dao 진입 - selectRevVal() 실행");
		return sqlSession.selectOne("Shop.selectRevVal",bpId);
	}
	
	public String selectCountReview(String bpId) {
		System.out.println("Shop Dao 진입  selectCountReview() 실행");
		return sqlSession.selectOne("Shop.selectCountReview",bpId);
	}
	
	// 울트라콜 
	
	// 울트라콜 미용실 리스트 출력 (평균 별점 포함)
	public List<HairSalon> selectCtaHarList() {
		System.out.println("Shop Dao 진입 - selectCtaHarList() 실행");
		return sqlSession.selectList("Shop.selectCtaHarList");
	}
	
	// 평균 별점
	public String selectCtaRevVal(String bpId) {
		System.out.println("Shop Dao 진입 - selectCtaRevVal() 실행");
		return sqlSession.selectOne("Shop.selectCtaRevVal",bpId);
	}
	
	// 리뷰 건수
	public String selectCountCtaReview(String bpId) {
		System.out.println("Shop Dao 진입  selectCountCtaReview() 실행");
		return sqlSession.selectOne("Shop.selectCountCtaReview",bpId);
	}
	
	/* 
	 * 미용실
	 * 
	 * 
	 * */
	
	
	// 미용실 리스트 총 갯수 
	public int countHarList() {
		System.out.println("~~ ShopDao ~~");
		return sqlSession.selectOne("Shop.countHarList");
	}
	
	//	TODO
	//	미용실 리스트 : 최신순
	public List<HairSalon> selectHarListNew(Pagination page){
		System.out.println("~~~ShopDao 진입~~~");
		return sqlSession.selectList("Shop.selectHarListNew", page);
	}
	
	
	//	미용실 리스트 : 별점순
	public List<HairSalon> selectHarListRev(Pagination page) {
		System.out.println("~~~ShopDao 진입~~~");
		return sqlSession.selectList("Shop.selectHarListRev", page);
	}
	
	//	미용실 리스트 : 인기순(찜순)
	public List<HairSalon> selectHarListLikes(Pagination page) {
		System.out.println("~~~ShopDao 진입~~~");
		return sqlSession.selectList("Shop.selectHarListLikes", page);
	}
	
	
	// 미용실 전체 리스트 조회 (shopController)
	public List<HairSalon> selectHarList(Pagination page) {
		
		System.out.println("~~~ShopDao 진입~~~");
//		System.out.println("다오 진입");
//		int startRow = (currentPage -1) * limit;
//		RowBounds row = new RowBounds(startRow, limit);
//		System.out.println("다오 끝");
		return sqlSession.selectList("Shop.selectHarList", page);
	}
	
		
	
	
	// 미용실 기본 정보 입력 
	public int insertHarInfo(HairSalon vo) {
		
		System.out.println(" !! ShopDao - insertHarInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHarInfo", vo);
		
	}
	
	// 미용실 기본 정보 불러오기
	public HairSalon selectHarInfo(String bpId) {
		
		System.out.println(" !! ShopDao - selectHarInfo() 실행 !!");
		System.out.println("bp id:"+bpId);
		
		return sqlSession.selectOne("Shop.selectHarInfo", bpId);
		
		
	}
	
	// 미용실 기본 정보 수정
	public int updateHarInfo(HairSalon vo) {
		System.out.println(" !! ShopDao - updateHarInfo() 실행 !!");
		return sqlSession.insert("Shop.updateHarInfo", vo);
	}
	
	
	//미용실 이미지 첨부
	public int insertHarImg(HairSalonImg vo) {
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHarImg", vo);
	}
	
	// 미용실 이미지 리스트 불러오기
	public List<HairSalonImg> selectHarImgList(String harNum){
		System.out.println(" !! ShopDao - selectHarImgList() 실행 !!");
		return  sqlSession.selectList("Shop.selectHarImgList", harNum);
	}
	
	
	// 미용실 이미지 수정 (삭제)
	public int deleteHarImg(String harNum) {
		System.out.println(" !! ShopDao - deleteHarImg() 실행 !!");
		return  sqlSession.insert("Shop.deleteHarImg", harNum);
	}
	
	// 수정된 미용실 이미지 첨부
	public int insertNewHarImg(HairSalonImg vo) {
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHarImg", vo);
	}	
	
	// 미용실 주휴일 입력
	public int insertHarDayOff(HairDayOff vo) {
		System.out.println(" !! ShopDao - insertHarDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHarDayOff", vo);
	}
	
	// 미용실 주휴일 수정 (삭제)
	public int deleteHarDayOff(String harNum) {
		System.out.println(" !! ShopDao - deleteHarDayOff() 실행 !!");
		return sqlSession.insert("Shop.deleteHarDayOff", harNum);		
	}
	
	// 수정된 미용실 주휴일 추가
	public int insertNewHarDayOff(HairDayOff vo) {
		System.out.println(" !! ShopDao - insertNewHarDayOff() 실행 !!");
		vo.toString();
		return sqlSession.insert("Shop.insertNewHarDayOff", vo);	
	}
	
	// 미용실 주메뉴 추가
	public int insertStyleMAinMenu(Style vo) {
		System.out.println(" !! ShopDao - insertStyleMAinMenu() 실행 !!");
		vo.toString();
		return sqlSession.insert("ShopMenu.insertStyleMAinMenu", vo);
	}
	
	// 미용실 서브메뉴 추가
	public int insertStyleSubMenu(Style vo) {
		System.out.println(" !! ShopDao - insertStyleSubMenu() 실행 !!");
		vo.toString();
		return sqlSession.insert("ShopMenu.insertStyleSubMenu", vo);
	}
	
	// 등록한 미용실 메뉴(메인+서브) 조회
	public List<Style> selectStyleList(String harNum){
		System.out.println(" !! ShopDao - selectStyleList() 실행 !!");
		System.out.println("조회할 미용실 번호"+harNum);
		return sqlSession.selectList("ShopMenu.selectStyleList", harNum);
	}
	
	// 미용실 메뉴 수정
	public int updateStyle(Style vo) {
		System.out.println(" !! ShopDao - updateStyle() 실행 !!");
		System.out.println("수정할 미용실 정보::"+vo);
		return sqlSession.update("ShopMenu.updateStyle", vo);
	}
	
	// 미용실 메뉴 삭제
	public int deleteStyle(String styleNum) {
		System.out.println(" !! ShopDao - deleteStyle() 실행 !!");
		System.out.println("삭제할 스타일 번호:"+styleNum);
		return sqlSession.delete("ShopMenu.deleteStyle", styleNum);		
	}
	
	
	/* 
	 * 동물병원
	 * 
	 * 
	 * */
	
	// 동물병원 리스트 총 갯수
	public int countHosList() {
		System.out.println("~~ ShopDao ~~");
		return sqlSession.selectOne("Shop.countHosList");
	}
	
	// 동물병원 전체 리스트 조회 (shopController)
	public List<Hospital> selectHosList(Pagination page) {
		System.out.println("DAO 진입");
//		int startRow = (currentPage -1) * limit;
//		RowBounds row = new RowBounds(startRow, limit);
//		System.out.println("DAO 끝");
		return sqlSession.selectList("Shop.selectHosList", page);
	}
	
	//	동물병원 리스트 : 최신순
	public List<Hospital> selectHosListNew(Pagination page){
		System.out.println("~~~ShopDao 진입~~~ selectHosListNew() 실행");
		return sqlSession.selectList("Shop.selectHosListNew", page);
		
	}
	
	//	TODO
	//	동물병원 리스트 : 거리순
	
	//	동물병원 리스트 : 별점순	
	public List<Hospital> selectHosListRev(Pagination page){
		System.out.println("~~~ShopDao 진입~~~ selectHosListRev() 실행");
		return sqlSession.selectList("Shop.selectHosListRev", page);
	}
	
	
	
	// 동물병원 기본 정보 입력
	public int insertHosInfo(Hospital vo) {
		
		System.out.println(" !! ShopDao - insertHosInfo() 실행 !!");
		return sqlSession.insert("Shop.insertHosInfo", vo);
		
	}
	
	// 동물병원 기본 정보 불러오기
	public Hospital selectHosInfo(String bpId){

		System.out.println(" !! ShopDao - selectHosInfo() 실행 !!");
		System.out.println("bp id:"+bpId);
		
		return sqlSession.selectOne("Shop.selectHosInfo", bpId);
		
	}
	
	
	// 동물병원 기본 정보 수정
	public int updateHosInfo(Hospital vo) {
		System.out.println(" !! ShopDao - updateHosInfo() 실행 !!");
		return sqlSession.insert("Shop.updateHosInfo", vo);		
	}
	

	
	// 동물병원 이미지 첨부
	public int insertHosImg(HospitalImg vo) {
		
		System.out.println(" !! ShopDao - insertHarImg() 실행 !!");
		return  sqlSession.insert("Shop.insertHosImg", vo);
	}	
	
	// 동물병원 이미지 리스트 불러오기
	public List<HospitalImg> selectHosImgList(String hosNum){
		System.out.println(" !! ShopDao - selectHosImgList() 실행 !!");
		return  sqlSession.selectList("Shop.selectHosImgList", hosNum);
	}
	
	
	// 동물병원 이미지 수정 (삭제) 
	public int deleteHosImg(String hosNum) {
		
		System.out.println(" !! ShopDao - deleteHosImg() 실행 !!");
		return  sqlSession.insert("Shop.deleteHosImg", hosNum);
	}
	
	// 수정된 동물병원 이미지 추가
	public int insertNewHosImg(HospitalImg vo) {
		System.out.println(" !! ShopDao - insertNewHosImg() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHosImg", vo);
	}	
	
	// 동물병원 주휴일 입력
	public int insertHosDayOff(HosDayOff vo) {
		System.out.println(" !! ShopDao - insertHosDayOff() 실행 !!");
		return sqlSession.insert("Shop.insertHosDayOff", vo);
	}
	
	// 동물병원 주휴일 수정 (삭제)
	public int deleteHosDayOff(String hosNum) {
		System.out.println(" !! ShopDao - deleteHosDayOff() 실행 !!");
		return sqlSession.insert("Shop.deleteHosDayOff", hosNum);
	}
	
	// 수정된 동물병원 주휴일 추가
	public int insertNewHosDayOff(HosDayOff vo) {
		System.out.println(" !! ShopDao - insertNewHosDayOff() 실행 !!");
		return  sqlSession.insert("Shop.insertNewHosDayOff", vo);
	}		
	
	// 동물병원 진료 정보 추가
	public int insertMedicalType(MedicalType vo) {
		
		System.out.println(" !! ShopDao - insertMedicalType() 실행 !!");
		return  sqlSession.insert("ShopMenu.insertMedicalType", vo);
		
	}
	
	// 등록한 동물병원 진료 정보 리스트 조회
	public List<MedicalType> selectMedList(String hosNum){
		System.out.println(" !! ShopDao - selectMedList() 실행 !!");
		System.out.println("조회할 동물병원 번호:"+hosNum);
		return sqlSession.selectList("ShopMenu.selectMedList", hosNum);
	}
	
	// 동물병원 진료 정보 수정
	public int updateMedicalType(MedicalType vo) {
		System.out.println(" !! ShopDao - updateMedicalType() 실행 !!");
		System.out.println("수정할 동물병원 정보::"+vo);
		return sqlSession.update("ShopMenu.updateMedicalType", vo);
	}
	
	// 동물병원 진료 삭제
	public int deleteMedicalType(String medNum) {
		System.out.println(" !! ShopDao - deleteMedicalType() 실행 !!");
		System.out.println("삭제할 진료 종류 번호:" + medNum);
		return sqlSession.delete("ShopMenu.deleteMedicalType", medNum);	
	}
	
	//동물병원 울트라콜 조회
	public List<Hospital> selectCtaHosList() {
		System.out.println("Shop Dao 진입 - selectCtaHosList() 실행");
		return sqlSession.selectList("Shop.selectUltraHos");
	}
}
