package kh.com.petbreedding.Shop.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.common.model.vo.Pagination;

@Repository("shopListDao")
public class ShopListDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 사업장 공통
	
		// 사업장별 평균 별점
		public String selectShopRevAvg(String bp_id) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectOne("shopList.selectShopRevAvg", bp_id);
		};
		
		// 사업장별 등록된 리뷰 갯수
		public String selectShopRevCount(String bp_id) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectOne("shopList.selectShopRevCount", bp_id);
		};
		
		
	// 울트라콜 매장 
		
		// 울트라콜 동물병원 출력
		public List<Hospital> selectCtaHos(){
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectList("shopList.selectCtaHos");
			
		}
		
		// 울트라콜 미용실 출력
		public List<HairSalon> selectCtaHar() {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectList("shopList.selectCtaHar");
		}
		
		
	// 동물병원 
		
		
		// 동물병원 위치 설정 + 키워드 검색
		
		// 동물병원 위치 설정 + 키워드 검색 카운팅
		public int countKeywordHosList(Map<String,Object> map) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectOne("shopList.countKeywordHosList",map);
		};
		
		// 동물병원 위치 설정 + 키워드 검색 최신순 정렬
		public List<Hospital> selectKeywordHosListNew(Map<String,Object> map) {
			System.out.println("~~ ShopListDao 진입 ~~");
			return sqlSession.selectList("shopList.selectKeywordHosListNew",map);
		}
		
		// 동물병원 전체 리스트
		
		
			// 동물병원 전체 리스트 카운팅
			public int countAllHosList() {
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectOne("shopList.countAllHosList");
			};
		
			// 동물병원 전체 리스트 최신순 정렬
					
			public  List<Hospital> selectAllHosListNew(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHosListNew", page);
			}
			// 동물병원 전체 리스트 인기순 정렬
			
			public  List<Hospital> selectAllHosListLike(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHosListLike", page);
			}
			// 동물병원 전체 리스트 별점순 정렬
			
			public  List<Hospital> selectAllHosListRev(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHosListRev", page);
			}
			
			// 동물병원 위치(주소) 검색
			
					// 동물병원 위치 검색카운팅
					public  int countHosListLocNew(Map<String,Object> map){
						System.out.println("~~ ShopListDao 진입 ~~");
						return sqlSession.selectOne("shopList.countHosListLocNew", map);
					}
					
					// 동물병원 위치 검색 최신순 정렬
					public List<Hospital> selectHosListLocNew(Map<String,Object> map) {
						System.out.println("~~ ShopListDao 진입 ~~");
						return sqlSession.selectList("shopList.selectHosListLocNew",map);
					}
						
					// 동물병원 위치 검색 인기순 정렬
					public List<Hospital> selectHosListLocLike(Map<String,Object> map) {
						System.out.println("~~ ShopListDao 진입 ~~");
						return sqlSession.selectList("shopList.selectHosListLocLike",map);
					}
					// 동물병원 위치 검색 별점순 정렬
					public List<Hospital> selectHosListLocRev(Map<String,Object> map) {
						System.out.println("~~ ShopListDao 진입 ~~");
						return sqlSession.selectList("shopList.selectHosListLocLike",map);
					}
					
			
		
		
	
	// 미용실 
		
		
		// 미용실 위치 설정 및 키워드 검색
			
			// 위치 및 키워드 결과 리스트 카운팅
			public int countKeywordHarList(Map<String,Object> map) {
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectOne("shopList.countKeywordHarList",map);
			}
			
			// 위치 및 키워드 결과 리스트 최신순 정렬
			public List<HairSalon> selectKeywordHarListNew(Map<String,Object> map) {
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectKeywordHarListNew",map);
			}
		
		
		// 미용실 전체 리스트
		
			// 미용실 전체 리스트 카운팅
			public int countALLHarList() {
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectOne("shopList.countALLHarList");
			};
			
			// 미용실 전체 리스트 최신순 정렬 
			public  List<HairSalon> selectAllHarListNew(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListNew", page);
			}
			
			// 미용실 전체 리스트 인기순 정렬
			public List<HairSalon> selectAllHarListLike(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListLike", page);
			}
			
			// 미용실 전체 리스트 별점순 정렬
			public List<HairSalon> selectAllHarListRev(Pagination page){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectAllHarListRev", page);
			}
		
		// 미용실 위치(주소) 검색
			
			// 카운팅
				// 미용실 위치 검색 최신순 카운팅
				public  int countHarListLocNew(Map<String,Object> map){
					System.out.println("~~ ShopListDao 진입 ~~");
					return sqlSession.selectOne("shopList.countHarListLocNew", map);
				}
			
			
			// 미용실 위치 검색 최신순 정렬
			public  List<HairSalon> selectHarListLocNew(Map<String,Object> map){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectHarListLocNew", map);
			}
			// 미용실 위치 검색 인기순 정렬
			public  List<HairSalon> selectHarListLocLike(Map<String,Object> map){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectHarListLocLike", map);
			}
			// 미용실 위치 검색 별점순 정렬
			public  List<HairSalon> selectHarListLocRev(Map<String,Object> map){
				System.out.println("~~ ShopListDao 진입 ~~");
				return sqlSession.selectList("shopList.selectHarListLocRev", map);
			}
		
		
	

}
