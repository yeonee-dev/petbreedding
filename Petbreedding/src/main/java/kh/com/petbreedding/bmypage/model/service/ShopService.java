package kh.com.petbreedding.bmypage.model.service;

import java.util.HashMap;
import java.util.List;

import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.common.model.vo.Pagination;

public interface ShopService {
	
	public int updateBpReg(String bpId); // 사업장 등록 - BP 테이블에서 사업장 등록여부 상태 1로 바꾸기 
	
	/* 공통 */
	
	public String selectRevVal(String bpId);	// 리뷰 평균 계산
	public String selectCountReview(String bpId);	// 리뷰 건수 계산
	
	/* 울트라콜 매장 */
	
	// 울트라콜 미용실 리스트 출력 (평균 별점 포함)
	public List<HairSalon> selectCtaHarList();
	//울트라콜 병원 리스트 출력 (평균 별점 포함)
	public List<Hospital> selectCtaHosList();
	
	
	// 평균 별점
	public String selectCtaRevVal(String bpId) ;
	// 리뷰 건수
	public String selectCountCtaReview(String bpId);
		
//	public List<HairSalon> selectHarList(int currentPage, int limit); // 미용실 전체 리스트 조회 //******TODO:위치이동*******
	public int countHarList(); // 미용실 리스트 총 갯수
	public List<HairSalon> selectHarList(Pagination page);
	public List<HairSalon> selectHarListNew(Pagination page); // 미용실 리스트 - 최신순
	public List<HairSalon> selectHarListRev(Pagination page); // 미용실 리스트 - 별점순
	public List<HairSalon> selectHarListLikes(Pagination page); //TODO: 미용실 리스트 - 인기순
	public int insertHarInfo(HairSalon vo);	// 미용실 기본 정보 입력 
	public HairSalon selectHarInfo(String bpId); // 미용실 기본 정보 불러오기
	public int updateHarInfo(HairSalon vo) ; // 미용실 기본 정보 수정
	public int insertHarImg(HairSalonImg vo); // 미용실 이미지 첨부
	public List<HairSalonImg> selectHarImgList(String harNum); // 미용실 이미지 리스트 불러오기 
	public int deleteHarImg(String harNum); // 미용실 이미지 수정 (삭제)
	public int insertNewHarImg(HairSalonImg vo); // 수정된 미용실 이미지 첨부
	public int insertHarDayOff(HairDayOff vo); // 미용실 주휴일 입력
	public int deleteHarDayOff(String harNum); // 미용실 주휴일 수정 (삭제)
	public int insertNewHarDayOff(HairDayOff vo); // 수정된 미용실 주휴일 추가
	public int insertStyleMAinMenu(Style vo);	// 미용실 메인메뉴 추가
	public int insertStyleSubMenu(Style vo); //미용실 서브메뉴 추가
	public List<Style> selectStyleList(String harNum); // 등록한 미용실 메뉴(메인+서브) 조회
	public int updateStyle(Style vo); // 미용실 메뉴 수정
	public int deleteStyle(String styleNum); // 미용실 메뉴 삭제 
	
	
//	public List<Hospital> selectHosList(int currentPage, int limit); // 동물병원 전체 리스트 조회 //*********TODO:위치이동***********
	public int countHosList(); // 동물병원 리스트 총 갯수
	public List<Hospital> selectHosList(Pagination page);
	public List<Hospital> selectHosListNew(Pagination page); // 동물병원 리스트 - 최신순
	// TODO: 동물병원 리스트 - 거리순
	public List<Hospital> selectHosListRev(Pagination page); // TODO: 동물병원 리스트 - 별점순 
	public int insertHosInfo(Hospital vo);	// 동물병원 기본 정보 입력
	public Hospital selectHosInfo(String bpId); //동물병원 기본 정보 불러오기
	public int updateHosInfo(Hospital vo); // 동물병원 기본 정보 수정
	public int insertHosImg(HospitalImg vo); // 동물병원 이미지 첨부
	public List<HospitalImg> selectHosImgList(String hosNum);
	public int deleteHosImg(String hosNum); // 동물병원 이미지 수정 (삭제) 
	public int insertNewHosImg(HospitalImg vo); // 수정된 동물병원 이미지 추가
	public int insertHosDayOff(HosDayOff vo); // 동물병원 주휴일 입력
	public int deleteHosDayOff(String hosNum); // 동물병원 주휴일 수정 (삭제)
	public int insertNewHosDayOff(HosDayOff vo); // 수정된 동물병원 주휴일 추가
	public int insertMedicalType(MedicalType vo); // 동물병원 진료 정보 추가
	public List<MedicalType> selectMedList(String hosNum); // 등록한 동물병원 진료 정보 리스트 조회
	public int updateMedicalType(MedicalType vo); // 동물병원 진료 정보 수정
	public int deleteMedicalType(String medNum); // 동물병원 진료 종류 삭제
}
