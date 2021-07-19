package kh.com.petbreedding.bmypage.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.common.model.vo.Pagination;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	
	@Override
	public int updateBpReg(String bpId) {
		int result = -1;
		
		try {
			result = shopDao.updateBpReg(bpId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}



	
	@Override
	public int insertHarInfo(HairSalon vo) {

		int result = -1;

		try {
			result = shopDao.insertHarInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int insertHarDayOff(HairDayOff vo) {
		
		int result = -1;

		try {
			result = shopDao.insertHarDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int insertHarImg(HairSalonImg vo) {
		
		int result = -1;
		
		try {
			result = shopDao.insertHarImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosInfo(Hospital vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosDayOff(HosDayOff vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int insertHosImg(HospitalImg vo) {
		int result = -1;
		
		try {
			result = shopDao.insertHosImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int updateHarInfo(HairSalon vo) {
		int result = -1;
		
		try {
			result = shopDao.updateHarInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int deleteHarImg(String harNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHarImg(harNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHarDayOff(String harNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHarDayOff(harNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateHosInfo(Hospital vo) {
		int result = -1;
		
		try {
			result = shopDao.updateHosInfo(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHosImg(String hosNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHosImg(hosNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteHosDayOff(String hosNum) {
		int result = -1;
		
		try {
			result = shopDao.deleteHosDayOff(hosNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public HairSalon selectHarInfo(String bpId) {
		
		HairSalon vo = null;
		
		vo = shopDao.selectHarInfo(bpId);
		
		System.out.println("HairSalon vo::"+ vo);
		
		return vo;
	}

	@Override
	public int insertNewHarDayOff(HairDayOff vo) {
	int result = -1;
		
		try {
			result = shopDao.insertNewHarDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertNewHarImg(HairSalonImg vo) {
	int result = -1;
		
		try {
			result = shopDao.insertNewHarImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Hospital selectHosInfo(String bpId) {
		
		Hospital vo = null;
		vo = shopDao.selectHosInfo(bpId);
		
		System.out.println("Hospital vo::"+vo);
		
		return vo;
	}

	@Override
	public int insertNewHosImg(HospitalImg vo) {
		int result = -1;
		
		try {
			result = shopDao.insertNewHosImg(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertNewHosDayOff(HosDayOff vo) {
		int result = -1;
		
		try {
			result = shopDao.insertNewHosDayOff(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





	@Override
	public int insertStyleMAinMenu(Style vo) { 	// 미용실 메뉴 추가
		
		System.out.println(" ~ Shoservice  insertStyleMAinMenu() 실행  ~");
		int result = -1;
		
		try {
			result = shopDao.insertStyleMAinMenu(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	//미용실 서브메뉴 추가
	@Override
	public int insertStyleSubMenu(Style vo) {
		System.out.println(" ~ Shoservice  insertStyleSubMenu() 실행  ~");
		int result = -1;
		
		try {
			result = shopDao.insertStyleSubMenu(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}




	@Override
	public List<Style> selectStyleList(String harNum) {
		List<Style> styleList = null;
		System.out.println("서비스 진입");
		try {
			styleList = shopDao.selectStyleList(harNum);
		} catch(Exception e) {
		}
		System.out.println("List<Style> selectStyleList ::" + styleList);
		return styleList;
	}



	// 미용실 메뉴 수정
	@Override
	public int updateStyle(Style vo) {
		int result = -1;
		
		System.out.println("shopService  updateStyle() 실행 ! ! ");
		try {
			result = shopDao.updateStyle(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 미용실 메뉴 삭제 
	@Override
	public int deleteStyle(String styleNum) {
		int result = -1;
		
		System.out.println("shopService  deleteStyle() 실행 ! ! ");
		try {
			result = shopDao.deleteStyle(styleNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 미용실 이미지 리스트 불러오기
	@Override
	public List<HairSalonImg> selectHarImgList(String harNum) {
		List<HairSalonImg> harImgList = null;
		System.out.println(" ~ ShopService 진입 ~");
		try {
			harImgList = shopDao.selectHarImgList(harNum);
		} catch(Exception e) {
		}
		System.out.println("List<HairSalonImg> harImgList ::" + harImgList);
		return harImgList;
	}



	// 동물병원 이미지 리스트 불러오기
	@Override
	public List<HospitalImg> selectHosImgList(String hosNum) {
		List<HospitalImg> hosImgList = null;
		System.out.println(" ~ ShopService 진입 ~");
		try {
			hosImgList = shopDao.selectHosImgList(hosNum);
		} catch(Exception e) {
		}
		System.out.println("List<HairSalonImg> harImgList ::" + hosImgList);
		return hosImgList;
	}



	// 동물병원 진료 정보 추가
	@Override
	public int insertMedicalType(MedicalType vo) {
		System.out.println(" ~ Shoservice  insertMedicalType() 실행  ~");
		int result = -1;
		
		try {
			result = shopDao.insertMedicalType(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 등록한 동물병원 진료 정보 리스트 조회
	@Override
	public List<MedicalType> selectMedList(String hosNum) {
		List<MedicalType> medList = null;
		System.out.println(" ~ ShopService 진입 ~");
		try {
			medList = shopDao.selectMedList(hosNum);
		} catch(Exception e) {
		}
		System.out.println("List<MedicalType> medList ::" + medList);
		return medList;
	}



	// 동물병원 진료 정보 수정
	@Override
	public int updateMedicalType(MedicalType vo) {
		System.out.println(" ~ Shoservice  updateMedicalType() 실행  ~");
		int result = -1;
		
		try {
			result = shopDao.updateMedicalType(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 동물병원 진료 정보 삭제
	@Override
	public int deleteMedicalType(String medNum) {
		
		int result = -1;
		
		System.out.println("shopService  deleteMedicalType() 실행 ! ! ");
		try {
			result = shopDao.deleteMedicalType(medNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 미용실 리스트 총 갯수 
	@Override
	public int countHarList() {
		int result = -1;
		try {
			result = shopDao.countHarList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	
	// 미용실 리스트 조회 + 페이징 처리 
	@Override
	public List<HairSalon> selectHarList(Pagination page) {
		List<HairSalon> list = null;
		try {
			list = shopDao.selectHarList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	// 동물병원 리스트 총 갯수
	@Override
	public int countHosList() {
		int result = -1;
		try {
			result = shopDao.countHosList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	// 동물병원 리스트 조회 + 페이징 처리 
	@Override
	public List<Hospital> selectHosList(Pagination page) {
		List<Hospital> list = null;
		try {
			list = shopDao.selectHosList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	// 미용실 리스트 - 최신순
	@Override
	public List<HairSalon> selectHarListNew(Pagination page) {
		
		System.out.println("shopService selectHarListNew() 실행");
		List<HairSalon> list = null;
		try {
			list = shopDao.selectHarListNew(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	// 미용실 리스트 - 별점순 
	@Override
	public List<HairSalon> selectHarListRev(Pagination page) {
		System.out.println("shopService selectHarListRev() 실행");
		List<HairSalon> list = null;
		try {
			list = shopDao.selectHarListRev(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 미용실 리스트 - 인기순(찜순)

	@Override
	public List<HairSalon> selectHarListLikes(Pagination page) {
		System.out.println("shopService selectHarListLikes() 실행");
		List<HairSalon> list = null;
		try {
			list = shopDao.selectHarListLikes(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	// 리뷰 평균 계산
	@Override
	public String selectRevVal(String bpId) {
		String avgRevVal = shopDao.selectRevVal(bpId);
		return avgRevVal;
	}


	// 리뷰 건수
	@Override
	public String selectCountReview(String bpId) {
		String count = shopDao.selectCountReview(bpId);
		return count;
	}
	
	
	/*울트라콜*/
	
	// 울트라콜 미용실 리스트 출력 (평균 별점 포함)
		@Override
		public List<HairSalon> selectCtaHarList() {
			List<HairSalon> ultra = shopDao.selectCtaHarList();
			return ultra;
		}

	// 평균별점
	@Override
	public String selectCtaRevVal(String bpId) {
		String avgRevVal = shopDao.selectCtaRevVal(bpId);
		return avgRevVal;
	}


	// 리뷰건수
	@Override
	public String selectCountCtaReview(String bpId) {
		String count = shopDao.selectCountCtaReview(bpId);
		return count;
	}

	



	// 동물병원 리스트 - 최신순
	@Override
	public List<Hospital> selectHosListNew(Pagination page) {
		System.out.println("shopService selectHosListNew() 실행");
		List<Hospital> list = null;
		try {
			list = shopDao.selectHosListNew(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 동물병원 리스트 - 별점순 
	@Override
	public List<Hospital> selectHosListRev(Pagination page) {
		System.out.println("shopService selectHosListRev() 실행");
		List<Hospital> list = null;
		try {
			list = shopDao.selectHosListRev(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}




	@Override
	public List<Hospital> selectCtaHosList() {
		List<Hospital> list = null;
		try {
			System.out.println("울트라콜 병원 리스트 조회 들어옴");
			list = shopDao.selectCtaHosList();
			if(list != null) {
				System.out.println("울트라콜 병원 리스트 매장 있음");
			}else {
				System.out.println("울트라콜 병원 리스트 매장 없음");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}







	






}
