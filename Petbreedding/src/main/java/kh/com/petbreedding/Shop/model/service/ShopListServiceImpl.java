package kh.com.petbreedding.Shop.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.Shop.model.dao.ShopListDao;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.common.model.vo.Pagination;

@Service("shopListService")
public class ShopListServiceImpl implements ShopListService {

	@Autowired
	ShopListDao shopListDao;
	
	
	// 사업장 공통
		
		// 사업장별 평균 별점
		@Override
		public String selectShopRevAvg(String bp_id) {
			System.out.println("shopListService selectShopRevVal() 실행");
			String revVal = "";
			revVal = shopListDao.selectShopRevAvg(bp_id);
			return revVal;
		}
		
		// 사업장별 등록된 리뷰 갯수
		@Override
		public String selectShopRevCount(String bp_id) {
			System.out.println("shopListService selectShopRevVal() 실행");
			String revCount = "";
			revCount = shopListDao.selectShopRevCount(bp_id);
			return revCount;
		}
	
		
		// 울트라콜
		
			// 울트라콜 미용실 리스트
			@Override
			public List<HairSalon> selectCtaHar() {
				System.out.println("shopListService selectCtaHar() 실행");
				List<HairSalon> list = null;
				try {
					list = shopListDao.selectCtaHar();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			
			// 울트라콜 동물병원 리스트
			@Override
			public List<Hospital> selectCtaHos() {
				System.out.println("shopListService selectCtaHos() 실행");
				List<Hospital> list = null;
				try {
					list = shopListDao.selectCtaHos();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}

			
		// 동물병원
			
			
			
			
			// 동물병원 위치 설정 및 키워드 검색
			
						// 위치 설정 및 키워드 검색 결과 리스트 카운팅
						@Override
						public int countKeywordHosList(Map<String,Object> map) {
							System.out.println("shopListService countKeywordHosList() 실행");
							int result = -1;
							try {
								result = shopListDao.countKeywordHosList(map);
							} catch (Exception e) {
								e.printStackTrace();
							}
							return result;
						}
						
						@Override
						// 위치 설정 및 키워드 검색 결과 리스트 최신순 정렬
						public List<Hospital> selectKeywordHosListNew(Map<String,Object> map){
							System.out.println("shopListService selectKeywordHosListNew() 실행");
							List<Hospital> list = null;
							try {
								list = shopListDao.selectKeywordHosListNew(map);
							} catch (Exception e) {
								e.printStackTrace();
							}
							return list;
						}
						
						
			
			// 동물병원 위치 검색
			
				// 동물병원 위치 검색 리스트 카운팅
				@Override
				public int countHosListLocNew(Map<String, Object> map) {
					System.out.println("shopListService countHosListLocNew() 실행");
					int result = -1;
					try {
						result = shopListDao.countHosListLocNew(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return result;
				}
				
				// 동물병원 위치 검색 최신순 정렬
				@Override
				public List<Hospital> selectHosListLocNew(Map<String, Object> map) {
					System.out.println("shopListService selectHosListLocNew() 실행");
					List<Hospital> list = null;
					try {
						list = shopListDao.selectHosListLocNew(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
				// 동물병원 위치 검색 인기순 정렬
				@Override
				public List<Hospital> selectHosListLocLike(Map<String, Object> map) {
					System.out.println("shopListService selectHosListLocLike() 실행");
					List<Hospital> list = null;
					try {
						list = shopListDao.selectHosListLocLike(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
				// 동물병원 위치 검색 별점순 정렬
				@Override
				public List<Hospital> selectHosListLocRev(Map<String, Object> map) {
					System.out.println("shopListService selectHosListLocRev() 실행");
					List<Hospital> list = null;
					try {
						list = shopListDao.selectHosListLocRev(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
				
				
				
			// 동물병원 전체 리스트 카운팅
			@Override
			public int countAllHosList() {
				System.out.println("shopListService countAllHosList() 실행");
				int result = -1;
				try {
					result = shopListDao.countAllHosList();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			}
			
			// 동물병원 전체 리스트 최신순 정렬 
			@Override
			public  List<Hospital> selectAllHosListNew(Pagination page){
				System.out.println("shopListService selectAllHosListNew() 실행");
				List<Hospital> list = null;
				try {
					list = shopListDao.selectAllHosListNew(page);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			
			// 동물병원 전체 리스트 인기순 정렬
			@Override
			public List<Hospital> selectAllHosListLike(Pagination page) {
				System.out.println("shopListService selectAllHosListLike() 실행");
				List<Hospital> list = null;
				try {
					list = shopListDao.selectAllHosListLike(page);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			
			// 동물병원 전체 리스트 별점순 정렬
			@Override
			public List<Hospital> selectAllHosListRev(Pagination page) {
				System.out.println("shopListService selectAllHosListRev() 실행");
				List<Hospital> list = null;
				try {
					list = shopListDao.selectAllHosListRev(page);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
						
			
		
		// 미용실
		
		// 미용실 위치 설정 및 키워드 검색
			
			// 위치 설정 및 키워드 검색 결과 리스트 카운팅
			@Override
			public int countKeywordHarList(Map<String,Object> map) {
				System.out.println("shopListService countKeywordHarList() 실행");
				int result = -1;
				try {
					result = shopListDao.countKeywordHarList(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			}
			
			@Override
			// 위치 설정 및 키워드 검색 결과 리스트 최신순 정렬
			public List<HairSalon> selectKeywordHarListNew(Map<String,Object> map){
				System.out.println("shopListService selectKeywordHarListNew() 실행");
				List<HairSalon> list = null;
				try {
					list = shopListDao.selectKeywordHarListNew(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
			
			
	// 미용실 전체 리스트
	
		// 미용실 전체 리스트 카운팅
		@Override
		public int countALLHarList() {
			System.out.println("shopListService countALLHarList() 실행");
			int result = -1;
			try {
				result = shopListDao.countALLHarList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
		// 미용실 전체 리스트 최신순 정렬 
		@Override
		public List<HairSalon> selectAllHarListNew(Pagination page) {
			System.out.println("shopListService selectAllHarListNew() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListNew(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 미용실 전체 리스트 인기순 정렬
		@Override
		public List<HairSalon> selectAllHarListLike(Pagination page) {
			System.out.println("shopListService selectAllHarListLike() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListLike(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		// 미용실 전체 리스트 별점순 정렬 
		@Override
		public List<HairSalon> selectAllHarListRev(Pagination page) {
			System.out.println("shopListService selectAllHarListRev() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectAllHarListRev(page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		
		
	// 미용실 위치 검색
		
		// 카운팅
			//  미용실 위치 검색 최신순 카운팅
			@Override
			public int countHarListLocNew(Map<String,Object> map) {
				System.out.println("shopListService countHarListLocNew() 실행");
				int total = 0;
				try {
					total = shopListDao.countHarListLocNew(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return total;
			}
		
		// 미용실 위치 검색 최신순 정렬
		@Override
		public List<HairSalon> selectHarListLocNew(Map<String,Object> map) {
			System.out.println("shopListService selectHarListLocNew() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectHarListLocNew(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// 미용실 위치 검색 인기순 정렬
		@Override
		public List<HairSalon> selectHarListLocLike(Map<String,Object> map) {
			System.out.println("shopListService selectHarListLocLike() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectHarListLocLike(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// 미용실 위치 검색 별점순 정렬 
		@Override
		public List<HairSalon> selectHarListLocRev(Map<String, Object> map) {
			System.out.println("shopListService selectHarListLocRev() 실행");
			List<HairSalon> list = null;
			try {
				list = shopListDao.selectHarListLocRev(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		

		

		



	
		

		

		

}
