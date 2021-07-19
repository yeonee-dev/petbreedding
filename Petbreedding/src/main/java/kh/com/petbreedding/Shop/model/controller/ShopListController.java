package kh.com.petbreedding.Shop.model.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.Shop.model.service.ShopListService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class ShopListController {

	@Autowired
	private ShopListService shopListService;
	
	@Autowired
	private LikesService likeService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	// 사업장 전체 리스트  - 최신순 정렬
	// 쪼개기 작업중..~ 
	@RequestMapping(value = "/shopList/all/new", method = RequestMethod.GET)
	public ModelAndView allShopList(
			ModelAndView mv
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam Long shopType
			, HttpServletRequest request
			) throws Exception {
		
		// shopType 0은 미용실, 1은 동물병원
		
		if (shopType == 0) {
			
			String har_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 미용실 리스트 
			List<HairSalon> ctaHar = shopListService.selectCtaHar();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
			mv.addObject("ctaHar", ctaHar);
			
			for(int i =0; i<ctaHar.size(); i++) {
				
				har_num = ctaHar.get(i).getHarNum();
				bpId = ctaHar.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countSalon(har_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			
			
			// 미용실 전체 리스트 카운팅
			int total = shopListService.countALLHarList();
			
			
			
			
			// 미용실 전체 리스트 - 최신순 정렬 페이징 
			Pagination all_new_page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			System.out.println("미용실 전체 리스트 - 최신순 정렬 페이징 정보 보여줘 ~~~~~~"+all_new_page);
			mv.addObject("all_new_paging", all_new_page);
			
			List<HairSalon> allHarListNew = shopListService.selectAllHarListNew(all_new_page);
			System.out.println("미용실 전체 리스트 - 최신순 정렬 :: " + allHarListNew);
			mv.addObject("allShopListNew", allHarListNew);
			
			
			List<String> countList = new ArrayList<String>();
			List<String> avgList = new ArrayList<String>();
			List<String> revCountList = new ArrayList<String>();
			
			for(int i =0; i<allHarListNew.size(); i++) {
	
				// 찜한 숫자 가져오기
				// + 별점 출력 
				
				
				har_num = allHarListNew.get(i).getHarNum();
				bpId = allHarListNew.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList.add(count);
				System.out.println("미용실 최신순 정렬 찜 정보 보여줘~~"+countList);
				mv.addObject("new_count", countList);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList.add(revAvg);
				System.out.println("미용실 최신순 정렬 평균 별점 정보 보여줘~~"+avgList);
				mv.addObject("new_revAvg", avgList);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList.add(revCount);
				System.out.println("미용실 최신순 정렬 리뷰 건수 정보 보여줘~~"+revCountList);
				mv.addObject("new_revCount", revCountList);
				
				
			}
			
			
			
		} 
		
		
		// shopType 0은 미용실, 1은 동물병원
		
		if(shopType==1) {
			
			String hos_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 동물병원 리스트 
			List<Hospital> ctaHos = shopListService.selectCtaHos();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 동물병원 리스트 보여줘~~ "+ctaHos);
			mv.addObject("ctaHos", ctaHos);
			
			for(int i =0; i<ctaHos.size(); i++) {
				
				hos_num = ctaHos.get(i).getHosNum();
				bpId = ctaHos.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countHos(hos_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			// 동물병원 전체 리스트 카운팅
			int total = shopListService.countAllHosList();
			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			mv.addObject("all_new_paging", page);
			
			List<Hospital> allHosListNew = shopListService.selectAllHosListNew(page);
			System.out.println("동물병원 전체 리스트 - 최신순 정렬 :: " + allHosListNew);
			
			mv.addObject("allHosListNew", allHosListNew);
			
			List<String> countList1 = new ArrayList<String>();
			List<String> avgList1 = new ArrayList<String>();
			List<String> revCountList1 = new ArrayList<String>();
			
			for(int i =0; i<allHosListNew.size(); i++) {
	
				// 찜한 숫자 가져오기
				// + 별점 출력 
				
				
				hos_num = allHosListNew.get(i).getHosNum();
				bpId = allHosListNew.get(i).getBpId();
				
				String count = likeService.countHos(hos_num); //찜
				countList1.add(count);
				mv.addObject("new_count", countList1);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList1.add(revAvg);
				mv.addObject("new_revAvg", avgList1);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList1.add(revCount);
				mv.addObject("new_revCount", revCountList1);
				
				
			}
			

			
			
			
		}
				mv.setViewName("/user/uShop/shopList");
				
				return mv;
		
	}
	
	
	//사업장 전체 리스트 - 인기순 정렬
	// 미용실 작업완료 ~!
	// 동물병원 작업완료~~!
	@RequestMapping(value = "/shopList/all/likes", method = RequestMethod.GET)
	public ModelAndView allShopListLikes(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam Long shopType
			, HttpServletRequest request
			) throws Exception {
		
		// shopType 0은 미용실, 1은 동물병원
		if (shopType == 0) {
			
			String har_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 미용실 리스트 
			List<HairSalon> ctaHar = shopListService.selectCtaHar();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
			mv.addObject("ctaHar", ctaHar);
			
			for(int i =0; i<ctaHar.size(); i++) {
				
				har_num = ctaHar.get(i).getHarNum();
				bpId = ctaHar.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countSalon(har_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			
			
			// 미용실 전체 리스트 카운팅
			int total = shopListService.countALLHarList();
			
			// 미용실 전체 리스트 - 인기순 정렬 페이징 
			Pagination all_likes_page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			System.out.println("미용실 전체 리스트 - 인기순 정렬 페이징 정보 보여줘 ~~~~~~"+all_likes_page);
			mv.addObject("all_likes_page", all_likes_page);
			
			List<HairSalon> allHarListLike = shopListService.selectAllHarListLike(all_likes_page);
			System.out.println("미용실 전체 리스트 - 인기순 정렬 :: " + allHarListLike);
			mv.addObject("allShopListLike", allHarListLike);
			List<String> countList2 = new ArrayList<String>();
			List<String> avgList2 = new ArrayList<String>();
			List<String> revCountList2 = new ArrayList<String>();
			
			for(int i =0; i<allHarListLike.size(); i++) {
				
				har_num = allHarListLike.get(i).getHarNum();
				bpId = allHarListLike.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList2.add(count);
				mv.addObject("like_count", countList2);
				
				String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
				avgList2.add(revAvg);
				System.out.println("평균 별점 보여줘!!!!!!!!!!"+revAvg);
				System.out.println(avgList2);
				mv.addObject("like_revAvg", avgList2);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList2.add(revCount);
				mv.addObject("like_revCount", revCountList2);
				
				
		}
		} // 미용실 끝
		
		if(shopType==1) {
			
			String hos_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 동물병원 리스트 
			List<Hospital> ctaHos = shopListService.selectCtaHos();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 동물병원 리스트 보여줘~~ "+ctaHos);
			mv.addObject("ctaHos", ctaHos);
			
			for(int i =0; i<ctaHos.size(); i++) {
				
				hos_num = ctaHos.get(i).getHosNum();
				bpId = ctaHos.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countHos(hos_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			
				// 동물병원 전체 리스트 카운팅
						int total = shopListService.countAllHosList();
						Pagination page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
						mv.addObject("all_hos_likes_paging", page);
			
						List<Hospital> allHosListLike = shopListService.selectAllHosListLike(page);
						System.out.println("동물병원 전체 리스트 - 인기순 정렬 :: " + allHosListLike);
						mv.addObject("allHosListLike", allHosListLike);
						List<String> countList2 = new ArrayList<String>();
						List<String> avgList2 = new ArrayList<String>();
						List<String> revCountList2 = new ArrayList<String>();
						
						for(int i =0; i<allHosListLike.size(); i++) {
							
							hos_num = allHosListLike.get(i).getHosNum();
							bpId = allHosListLike.get(i).getBpId();
							
							String count = likeService.countSalon(hos_num); //찜
							countList2.add(count);
							mv.addObject("like_count", countList2);
							
							String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
							avgList2.add(revAvg);
							System.out.println("평균 별점 보여줘!!!!!!!!!!"+revAvg);
							System.out.println(avgList2);
							mv.addObject("like_revAvg", avgList2);
							
							String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
							revCountList2.add(revCount);
							mv.addObject("like_revCount", revCountList2);
							
						}
		} // 동물병원 끝
				mv.setViewName("/user/uShop/shopList");
				return mv;
		
	}
	
	// 사업장 전체 리스트 - 별점순 정렬
	// 미용실 작업완료
	// 동물병원 작업중~~~~
	@RequestMapping(value = "/shopList/all/review", method = RequestMethod.GET)
	public ModelAndView allShopListRev(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam Long shopType
			, HttpServletRequest request
			) throws Exception {
		
		
			if (shopType == 0) {
			
			String har_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 미용실 리스트 
			List<HairSalon> ctaHar = shopListService.selectCtaHar();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
			mv.addObject("ctaHar", ctaHar);
			
			for(int i =0; i<ctaHar.size(); i++) {
				
				har_num = ctaHar.get(i).getHarNum();
				bpId = ctaHar.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countSalon(har_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			
			
			// 미용실 전체 리스트 카운팅
			int total = shopListService.countALLHarList();
			
			Pagination all_rev_page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			System.out.println("미용실 전체 리스트 - 별점순 정렬 페이징 정보 보여줘 ~~~~~~"+all_rev_page);
			mv.addObject("all_rev_page", all_rev_page);
			
			
			List<HairSalon> allHarListRev = shopListService.selectAllHarListRev(all_rev_page);
			System.out.println("미용실 전체 리스트 - 별점순 정렬::"+allHarListRev);
			mv.addObject("allHarListRev", allHarListRev);
			List<String> countList3 = new ArrayList<String>();
			List<String> revCountList3 = new ArrayList<String>();
			
			for(int i=0; i<allHarListRev.size();i++) {
				har_num = allHarListRev.get(i).getHarNum();
				bpId = allHarListRev.get(i).getBpId();
				
				String count = likeService.countSalon(har_num); //찜
				countList3.add(count);
				mv.addObject("rev_count", countList3);
				
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				revCountList3.add(revCount);
				mv.addObject("rev_revCount", revCountList3);
			}
			
			}//미용실 끝
			
			// 동물병원 시작 
			if(shopType==1) {	
				
				String hos_num = null;
				String bpId = null;
				
				List<String> ctaCountList = new ArrayList<String>();
				List<String> ctaAvgList = new ArrayList<String>();
				List<String> ctaRevCountList = new ArrayList<String>();
				
				// 울트라콜 동물병원 리스트 
				List<Hospital> ctaHos = shopListService.selectCtaHos();
				System.out.println("잔여수 높은 순으로 정렬된 울트라 동물병원 리스트 보여줘~~ "+ctaHos);
				mv.addObject("ctaHos", ctaHos);
				
				for(int i =0; i<ctaHos.size(); i++) {
					
					hos_num = ctaHos.get(i).getHosNum();
					bpId = ctaHos.get(i).getBpId();
					
					//찜한 숫자
					String count = likeService.countHos(hos_num);
					ctaCountList.add(count);
					mv.addObject("cta_count", ctaCountList);
					
					//별점 평균
					String revAvg = shopListService.selectShopRevAvg(bpId);	
					ctaAvgList.add(revAvg);
					System.out.println();
					mv.addObject("cta_revAvg", ctaAvgList);
					
					//리뷰 숫자 
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					ctaRevCountList.add(revCount);
					mv.addObject("cta_revCount", ctaRevCountList);
				}
				
				
					// 동물병원 전체 리스트 카운팅
							int total = shopListService.countAllHosList();
							Pagination page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
							mv.addObject("all_rev_page", page);
				
							
							List<Hospital> allHosListRev = shopListService.selectAllHosListRev(page);
							System.out.println("동물병원 전체 리스트 - 별점순 정렬::"+allHosListRev);
							mv.addObject("allHosListRev", allHosListRev);
							List<String> countList3 = new ArrayList<String>();
							List<String> revCountList3 = new ArrayList<String>();
							
							for(int i=0; i<allHosListRev.size();i++) {
								hos_num = allHosListRev.get(i).getHosNum();
								bpId = allHosListRev.get(i).getBpId();
								
								String count = likeService.countHos(hos_num);
								countList3.add(count);
								mv.addObject("rev_count", countList3);
								
								String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
								revCountList3.add(revCount);
								mv.addObject("rev_revCount", revCountList3);
							}
			} // 동물병원 끝
			
			
				
				mv.setViewName("/user/uShop/shopList");
				return mv;
		
	}
	
	// 사업장 검색 리스트 정렬 - 최신순
	// 사업장 검색 결과 정렬
	// 쪼개기 작업중~~~!!
	@RequestMapping(value = "/shopList/search/new", method = RequestMethod.GET)
	public ModelAndView searchNewShopList(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(value="shopType") Long shopType
			,@RequestParam (value="selectlocCon", defaultValue="") String searchLoc1
			,@RequestParam (value="selectChooseLoc", defaultValue="") String searchLoc2
			,@RequestParam(value="keyword", defaultValue="") String keyword
			, HttpServletRequest request
			) throws Exception{
		
		
		System.out.println("shopType은???"+shopType);
		
		// 미용실(0)
		
		if(shopType==0) {
			
			String har_num = null;
			String bpId = null;
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 미용실 리스트 
			List<HairSalon> ctaHar = shopListService.selectCtaHar();
			System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
			mv.addObject("ctaHar", ctaHar);
			
			for(int i =0; i<ctaHar.size(); i++) {
				
				har_num = ctaHar.get(i).getHarNum();
				bpId = ctaHar.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countSalon(har_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
		
			
			
			// 위치만 설정한 경우
				System.out.println("위치만 설정함!!!!!!!");
				System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
				
				
				Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 mv.addObject("searchLoc1", searchLoc1);
				 mv.addObject("searchLoc2", searchLoc2);
				 
				// 검색 결과 카운팅
					int total1 = shopListService.countHarListLocNew(map1); 
					System.out.println("미용실 검색 결과 개수는?"+total1);
					Pagination page1 = null;
					page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
					mv.addObject("loc_new_paging", page1);
					int start1 = page1.getStart();
					int end1 = page1.getEnd();
					map1.put("start", start1);
					map1.put("end", end1);
					mv.addObject("map1", map1);
					System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
			
					
			// 미용실 위치 검색 최신순 정렬		 
			 List<HairSalon> harListLocNew = shopListService.selectHarListLocNew(map1);
			 System.out.println("위치로 검색한 미용실 최신순으로 정렬해줘!!!:"+harListLocNew);
			 mv.addObject("harListLocNew", harListLocNew);
			 
				List<String> countList = new ArrayList<String>();
				List<String> avgList = new ArrayList<String>();
				List<String> revCountList = new ArrayList<String>();
				
				for(int i =0; i<harListLocNew.size(); i++) {
		
					// 찜한 숫자 가져오기
					// + 별점 출력 
					har_num = harListLocNew.get(i).getHarNum();
					bpId = harListLocNew.get(i).getBpId();
					
					String count = likeService.countSalon(har_num); //찜
					countList.add(count);
					mv.addObject("loc_new_count", countList);
					
					String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
					avgList.add(revAvg);
					mv.addObject("loc_new_revAvg", avgList);
					
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					revCountList.add(revCount);
					mv.addObject("loc_new_revCount", revCountList);
				}
				

			}
			
			
		
		
		// 동물병원(1)
		if(shopType==1) {
			
			String hos_num = null;
			String bpId = null;
			
			
			List<String> ctaCountList = new ArrayList<String>();
			List<String> ctaAvgList = new ArrayList<String>();
			List<String> ctaRevCountList = new ArrayList<String>();
			
			// 울트라콜 동물병원 리스트 
			List<Hospital> ctaHos = shopListService.selectCtaHos();
			System.out.println("잔여수 높은 순으로 정렬된 동물병원 리스트 보여줘~~ "+ctaHos);
			mv.addObject("ctaHos", ctaHos);
			
			for(int i =0; i<ctaHos.size(); i++) {
				
				hos_num = ctaHos.get(i).getHosNum();
				bpId = ctaHos.get(i).getBpId();
				
				//찜한 숫자
				String count = likeService.countHos(hos_num);
				ctaCountList.add(count);
				mv.addObject("cta_count", ctaCountList);
				
				//별점 평균
				String revAvg = shopListService.selectShopRevAvg(bpId);	
				ctaAvgList.add(revAvg);
				System.out.println();
				mv.addObject("cta_revAvg", ctaAvgList);
				
				//리뷰 숫자 
				String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
				ctaRevCountList.add(revCount);
				mv.addObject("cta_revCount", ctaRevCountList);
			}
			
			
			
			
			
							System.out.println("위치만 설정함!!!!!!!");
							System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
							
							
							Map<String,Object> map1 = new HashMap<String,Object>();
							 map1.put("searchLoc1", searchLoc1);
							 map1.put("searchLoc2", searchLoc2);
							 mv.addObject("searchLoc1", searchLoc1);
							 mv.addObject("searchLoc2", searchLoc2);
							 
							// 검색 결과 카운팅
								int total1 = shopListService.countHosListLocNew(map1); 
								System.out.println("동물병원 검색 결과 개수는?"+total1);
								Pagination page1 = null;
								page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
								mv.addObject("loc_new_paging", page1);
								int start1 = page1.getStart();
								int end1 = page1.getEnd();
								map1.put("start", start1);
								map1.put("end", end1);
								mv.addObject("map1", map1);
								System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
						
								
						// 동물병원 위치 검색 최신순 정렬		 
						 List<Hospital> hosListLocNew = shopListService.selectHosListLocNew(map1);
						 System.out.println("위치로 검색한 동물병원 최신순으로 정렬해줘!!!:"+hosListLocNew);
						 mv.addObject("hosListLocNew", hosListLocNew);
						 
							List<String> countList = new ArrayList<String>();
							List<String> avgList = new ArrayList<String>();
							List<String> revCountList = new ArrayList<String>();
							
							for(int i =0; i<hosListLocNew.size(); i++) {
					
								// 찜한 숫자 가져오기
								// + 별점 출력 
								hos_num = hosListLocNew.get(i).getHosNum();
								bpId = hosListLocNew.get(i).getBpId();
								
								String count = likeService.countHos(hos_num);//찜 수
								countList.add(count);
								mv.addObject("loc_new_count", countList);
								
								String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
								avgList.add(revAvg);
								mv.addObject("loc_new_revAvg", avgList);
								
								String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
								revCountList.add(revCount);
								mv.addObject("loc_new_revCount", revCountList);
							}
							
//							
//								// 동물병원 위치 검색 결과 별점순 정렬
//								List<Hospital> hosListLocRev = shopListService.selectHosListLocRev(map1);
//								System.out.println("위치로 검색한 동물병원 별점순으로 정렬해줘!!!!"+hosListLocRev);
//								mv.addObject("hosListLocRev", hosListLocRev);
//								
//								List<String> countList3 = new ArrayList<String>();
//								List<String> revCountList3 = new ArrayList<String>();
//								
//								for(int i =0; i<hosListLocRev.size(); i++) {
//									
//									// 찜한 숫자 가져오기
//									// + 별점 출력 
//									hos_num = hosListLocRev.get(i).getHosNum();
//									bpId = hosListLocRev.get(i).getBpId();
//									
//									String count = likeService.countHos(hos_num);//찜 수
//									countList3.add(count);
//									mv.addObject("loc_rev_count", countList3);
//									System.out.println("찜수 리스트 보여줘**********"+countList3);
//									
//									String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
//									revCountList3.add(revCount);
//									System.out.println("리뷰 개수 리스트 보여주ㅝ*****"+revCountList3);
//									mv.addObject("loc_rev_revCount", revCountList3);
//								}
//			
			
			
			
		}
		
		mv.setViewName("/user/uShop/shopList");
		return mv;
		
		 
		
	}
	
	// 사업장 검색 리스트 정렬 - 인기순
	// 미용실 작업완료
	// 동물병원 작업 완료 
	@RequestMapping(value = "/shopList/search/like", method = RequestMethod.GET)
	public ModelAndView searchLikeShopList(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(value="shopType") Long shopType
			,@RequestParam (value="selectlocCon", defaultValue="") String searchLoc1
			,@RequestParam (value="selectChooseLoc", defaultValue="") String searchLoc2
			, HttpServletRequest request
			) throws Exception {
		
		System.out.println("shopType은???"+shopType);
		
			// 미용실(0)
			
			if(shopType==0) {
				
				String har_num = null;
				String bpId = null;
				
				List<String> ctaCountList = new ArrayList<String>();
				List<String> ctaAvgList = new ArrayList<String>();
				List<String> ctaRevCountList = new ArrayList<String>();
				
				// 울트라콜 미용실 리스트 
				List<HairSalon> ctaHar = shopListService.selectCtaHar();
				System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
				mv.addObject("ctaHar", ctaHar);
				
				for(int i =0; i<ctaHar.size(); i++) {
					
					har_num = ctaHar.get(i).getHarNum();
					bpId = ctaHar.get(i).getBpId();
					
					//찜한 숫자
					String count = likeService.countSalon(har_num);
					ctaCountList.add(count);
					mv.addObject("cta_count", ctaCountList);
					
					//별점 평균
					String revAvg = shopListService.selectShopRevAvg(bpId);	
					ctaAvgList.add(revAvg);
					System.out.println();
					mv.addObject("cta_revAvg", ctaAvgList);
					
					//리뷰 숫자 
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					ctaRevCountList.add(revCount);
					mv.addObject("cta_revCount", ctaRevCountList);
				}
				
				 
				// 위치만 설정한 경우
						System.out.println("위치만 설정함!!!!!!!");
						System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
						
						
						Map<String,Object> map1 = new HashMap<String,Object>();
						 map1.put("searchLoc1", searchLoc1);
						 map1.put("searchLoc2", searchLoc2);
						 mv.addObject("searchLoc1", searchLoc1);
						 mv.addObject("searchLoc2", searchLoc2);
						 
						 	// 검색 결과 카운팅
							int total1 = shopListService.countHarListLocNew(map1); 
							System.out.println("미용실 검색 결과 개수는?"+total1);
							Pagination page1 = null;
							page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
							mv.addObject("loc_like_paging", page1);
							int start1 = page1.getStart();
							int end1 = page1.getEnd();
							map1.put("start", start1);
							map1.put("end", end1);
							mv.addObject("map1", map1);
							System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
				 
							
						// 미용실 위치 검색 결과 인기순 정렬 
							
						 List<HairSalon> harListLocLike = shopListService.selectHarListLocLike(map1);
						 System.out.println("위치로 검색한 미용실 인기순으로 정렬해줘!!!:"+harListLocLike);
						 mv.addObject("harListLocLike", harListLocLike);
						
							List<String> countList2 = new ArrayList<String>();
							List<String> avgList2 = new ArrayList<String>();
							List<String> revCountList2 = new ArrayList<String>();
						
							for(int i =0; i<harListLocLike.size(); i++) {
								
								// 찜한 숫자 가져오기
								// + 별점 출력 
								har_num = harListLocLike.get(i).getHarNum();
								bpId = harListLocLike.get(i).getBpId();
								
								String count = likeService.countSalon(har_num); //찜
								countList2.add(count);
								mv.addObject("loc_like_count", countList2);
								
								String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
								avgList2.add(revAvg);
								mv.addObject("loc_like_revAvg", avgList2);
								
								String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
								revCountList2.add(revCount);
								mv.addObject("loc_like_revCount", revCountList2);
							}
			} // 미용실 끝 !
			
			
			
			if(shopType==1) {
				
				String hos_num = null;
				String bpId = null;
				
				
				List<String> ctaCountList = new ArrayList<String>();
				List<String> ctaAvgList = new ArrayList<String>();
				List<String> ctaRevCountList = new ArrayList<String>();
				
				// 울트라콜 동물병원 리스트 
				List<Hospital> ctaHos = shopListService.selectCtaHos();
				System.out.println("잔여수 높은 순으로 정렬된 동물병원 리스트 보여줘~~ "+ctaHos);
				mv.addObject("ctaHos", ctaHos);
				
				for(int i =0; i<ctaHos.size(); i++) {
					
					hos_num = ctaHos.get(i).getHosNum();
					bpId = ctaHos.get(i).getBpId();
					
					//찜한 숫자
					String count = likeService.countHos(hos_num);
					ctaCountList.add(count);
					mv.addObject("cta_count", ctaCountList);
					
					//별점 평균
					String revAvg = shopListService.selectShopRevAvg(bpId);	
					ctaAvgList.add(revAvg);
					System.out.println();
					mv.addObject("cta_revAvg", ctaAvgList);
					
					//리뷰 숫자 
					String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
					ctaRevCountList.add(revCount);
					mv.addObject("cta_revCount", ctaRevCountList);
				}
				
				System.out.println("위치만 설정함!!!!!!!");
				System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
				
				
				Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 mv.addObject("searchLoc1", searchLoc1);
				 mv.addObject("searchLoc2", searchLoc2);
				 
				// 검색 결과 카운팅
					int total1 = shopListService.countHosListLocNew(map1); 
					System.out.println("동물병원 검색 결과 개수는?"+total1);
					Pagination page1 = null;
					page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
					mv.addObject("loc_like_paging", page1);
					int start1 = page1.getStart();
					int end1 = page1.getEnd();
					map1.put("start", start1);
					map1.put("end", end1);
					mv.addObject("map1", map1);
					System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
				
				
				// 동물병원 위치 검색 결과 인기순 정렬 
				
				 List<Hospital> hosListLocLike = shopListService.selectHosListLocLike(map1);
				 System.out.println("위치로 검색한 동물병원 인기순으로 정렬해줘!!!:"+hosListLocLike);
				 mv.addObject("hosListLocLike", hosListLocLike);
				
					List<String> countList2 = new ArrayList<String>();
					List<String> avgList2 = new ArrayList<String>();
					List<String> revCountList2 = new ArrayList<String>();
				
					for(int i =0; i<hosListLocLike.size(); i++) {
						
						// 찜한 숫자 가져오기
						// + 별점 출력 
						hos_num = hosListLocLike.get(i).getHosNum();
						bpId = hosListLocLike.get(i).getBpId();
						
						String count = likeService.countHos(hos_num);//찜 수
						countList2.add(count);
						mv.addObject("loc_like_count", countList2);
						
						String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
						avgList2.add(revAvg);
						mv.addObject("loc_like_revAvg", avgList2);
						
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						revCountList2.add(revCount);
						mv.addObject("loc_like_revCount", revCountList2);
					}
				
				
				
			}
		
		
		
			mv.setViewName("/user/uShop/shopList");
			return mv;
		
	}


	
	// 사업장 검색 리스트 정렬 - 별점순 
	// 미용실 작업 완료
	// TODO: 동물병원 
	@RequestMapping(value = "/shopList/search/rev", method = RequestMethod.GET)
	public ModelAndView searchReviewShopList(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(value="shopType") Long shopType
			,@RequestParam (value="selectlocCon", defaultValue="") String searchLoc1
			,@RequestParam (value="selectChooseLoc", defaultValue="") String searchLoc2
			, HttpServletRequest request
			) throws Exception {
		
				System.out.println("shopType은???"+shopType);
				
				// 미용실(0)
				
				if(shopType==0) {
					
					String har_num = null;
					String bpId = null;
					
					List<String> ctaCountList = new ArrayList<String>();
					List<String> ctaAvgList = new ArrayList<String>();
					List<String> ctaRevCountList = new ArrayList<String>();
					
					// 울트라콜 미용실 리스트 
					List<HairSalon> ctaHar = shopListService.selectCtaHar();
					System.out.println("잔여수 높은 순으로 정렬된 울트라 미용실 리스트 보여줘~~ "+ctaHar);
					mv.addObject("ctaHar", ctaHar);
					
					for(int i =0; i<ctaHar.size(); i++) {
						
						har_num = ctaHar.get(i).getHarNum();
						bpId = ctaHar.get(i).getBpId();
						
						//찜한 숫자
						String count = likeService.countSalon(har_num);
						ctaCountList.add(count);
						mv.addObject("cta_count", ctaCountList);
						
						//별점 평균
						String revAvg = shopListService.selectShopRevAvg(bpId);	
						ctaAvgList.add(revAvg);
						System.out.println();
						mv.addObject("cta_revAvg", ctaAvgList);
						
						//리뷰 숫자 
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						ctaRevCountList.add(revCount);
						mv.addObject("cta_revCount", ctaRevCountList);
					}
					
					 
					// 위치만 설정한 경우
							System.out.println("위치만 설정함!!!!!!!");
							System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
							
							
							Map<String,Object> map1 = new HashMap<String,Object>();
							 map1.put("searchLoc1", searchLoc1);
							 map1.put("searchLoc2", searchLoc2);
							 mv.addObject("searchLoc1", searchLoc1);
							 mv.addObject("searchLoc2", searchLoc2);
							 
							// 검색 결과 카운팅
								int total1 = shopListService.countHarListLocNew(map1); 
								System.out.println("미용실 검색 결과 개수는?"+total1);
								Pagination page1 = null;
								page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
								mv.addObject("loc_rev_paging", page1);
								int start1 = page1.getStart();
								int end1 = page1.getEnd();
								map1.put("start", start1);
								map1.put("end", end1);
								mv.addObject("map1", map1);
								System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
					 
						// 미용실 위치 검색 결과 별점순 정렬
						List<HairSalon> harListLocRev = shopListService.selectHarListLocRev(map1);
						System.out.println("위치로 검색한 미용실 별점순으로 정렬해줘!!!!"+harListLocRev);
						mv.addObject("harListLocRev", harListLocRev);
						
						List<String> countList3 = new ArrayList<String>();
						List<String> revCountList3 = new ArrayList<String>();
						
						for(int i =0; i<harListLocRev.size(); i++) {
							
							// 찜한 숫자 가져오기
							// + 별점 출력 
							har_num = harListLocRev.get(i).getHarNum();
							bpId = harListLocRev.get(i).getBpId();
							
							String count = likeService.countSalon(har_num); //찜
							countList3.add(count);
							mv.addObject("loc_rev_count", countList3);
							System.out.println("찜수 리스트 보여줘**********"+countList3);
							
							String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
							revCountList3.add(revCount);
							System.out.println("리뷰 개수 리스트 보여주ㅝ*****"+revCountList3);
							mv.addObject("loc_rev_revCount", revCountList3);
						}
		
		
						
				}// 미용실 끝 
				
				if(shopType==1) {
					
					String hos_num = null;
					String bpId = null;
					
					
					List<String> ctaCountList = new ArrayList<String>();
					List<String> ctaAvgList = new ArrayList<String>();
					List<String> ctaRevCountList = new ArrayList<String>();
					
					// 울트라콜 동물병원 리스트 
					List<Hospital> ctaHos = shopListService.selectCtaHos();
					System.out.println("잔여수 높은 순으로 정렬된 동물병원 리스트 보여줘~~ "+ctaHos);
					mv.addObject("ctaHos", ctaHos);
					
					for(int i =0; i<ctaHos.size(); i++) {
						
						hos_num = ctaHos.get(i).getHosNum();
						bpId = ctaHos.get(i).getBpId();
						
						//찜한 숫자
						String count = likeService.countHos(hos_num);
						ctaCountList.add(count);
						mv.addObject("cta_count", ctaCountList);
						
						//별점 평균
						String revAvg = shopListService.selectShopRevAvg(bpId);	
						ctaAvgList.add(revAvg);
						System.out.println();
						mv.addObject("cta_revAvg", ctaAvgList);
						
						//리뷰 숫자 
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						ctaRevCountList.add(revCount);
						mv.addObject("cta_revCount", ctaRevCountList);
					}
					
					System.out.println("위치만 설정함!!!!!!!");
					System.out.println("검색한 주소는????"+searchLoc1+searchLoc2);
					
					
					Map<String,Object> map1 = new HashMap<String,Object>();
					 map1.put("searchLoc1", searchLoc1);
					 map1.put("searchLoc2", searchLoc2);
					 mv.addObject("searchLoc1", searchLoc1);
					 mv.addObject("searchLoc2", searchLoc2);
					 
					// 검색 결과 카운팅
						int total1 = shopListService.countHosListLocNew(map1); 
						System.out.println("동물병원 검색 결과 개수는?"+total1);
						Pagination page1 = null;
						page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
						mv.addObject("loc_rev_paging", page1);
						int start1 = page1.getStart();
						int end1 = page1.getEnd();
						map1.put("start", start1);
						map1.put("end", end1);
						mv.addObject("map1", map1);
						System.out.println("map 정보 보여줘 !!!!!!!!"+map1);
					
						
						// 동물병원 위치 검색 결과 별점순 정렬
						List<Hospital> hosListLocRev = shopListService.selectHosListLocRev(map1);
						System.out.println("위치로 검색한 동물병원 별점순으로 정렬해줘!!!!"+hosListLocRev);
						mv.addObject("hosListLocRev", hosListLocRev);
						
						List<String> countList3 = new ArrayList<String>();
						List<String> revCountList3 = new ArrayList<String>();
						
						for(int i =0; i<hosListLocRev.size(); i++) {
							
							// 찜한 숫자 가져오기
							// + 별점 출력 
							hos_num = hosListLocRev.get(i).getHosNum();
							bpId = hosListLocRev.get(i).getBpId();
							
							String count = likeService.countHos(hos_num);//찜 수
							countList3.add(count);
							mv.addObject("loc_rev_count", countList3);
							System.out.println("찜수 리스트 보여줘**********"+countList3);
							
							String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
							revCountList3.add(revCount);
							System.out.println("리뷰 개수 리스트 보여주ㅝ*****"+revCountList3);
							mv.addObject("loc_rev_revCount", revCountList3);
						}
	
					
				}
				
				
				
				mv.setViewName("/user/uShop/shopList");
				return mv;
	}


	// 사업장 검색 - 위치 + 키워드 
	// 미용실 작업중
	// TODO: 동물병원 
	@RequestMapping(value = "/shopList/search/keyword", method = RequestMethod.GET)
	public ModelAndView searchKewordShopList(
			ModelAndView mv
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(value="shopType") Long shopType
			,@RequestParam (value="selectlocCon", defaultValue="") String searchLoc1
			,@RequestParam (value="selectChooseLoc", defaultValue="") String searchLoc2
			,@RequestParam(value="keyword", defaultValue="") String keyword
			, HttpServletRequest request) throws Exception {
		
			
		if(shopType==0) {
			
			// 키워드+위치 검색한 경우 
				 System.out.println("위치 설정+키워드 검색!!!");
				 System.out.println("설정한 주소는????"+searchLoc1+searchLoc2);
				 System.out.println("검색한 키워드는????"+keyword);
				 mv.addObject("keyword", keyword);
				 mv.addObject("searchLoc1", searchLoc1);
				 mv.addObject("searchLoc2", searchLoc2);
				 
				 Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 map1.put("keyword", keyword);
				 
				 
				 
				 // 검색 결과 카운팅
				 
				 int total1 = shopListService.countKeywordHarList(map1);
				 System.out.println("검색된 미용실은 몇 개???"+total1);
				 
				 Pagination page1 = null;
				 page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
				 System.out.println("페이지 객체 정보는????"+page1);
				 mv.addObject("keyword_paging", page1);
				 
				 int start1 = page1.getStart();
				 int end1 = page1.getEnd();
				 map1.put("start", start1);
				 map1.put("end", end1);
				 System.out.println("위치 키워드 페이징 map 정보 보여줘~~"+map1);
				 
				 
				 // 키워드 위치 검색 미용실 최신순 정렬
				 List<HairSalon> keywordHarListNew = shopListService.selectKeywordHarListNew(map1);
				 System.out.println("위치로 검색한 미용실 최신순으로 정렬해줘!!!:"+keywordHarListNew);
				 mv.addObject("keywordHarListNew", keywordHarListNew);
				 
					List<String> countList1 = new ArrayList<String>();
					List<String> avgList1 = new ArrayList<String>();
					List<String> revCountList1 = new ArrayList<String>();
					
					for(int i =0; i<keywordHarListNew.size(); i++) {
			
						// 찜한 숫자 가져오기
						// + 별점 출력 
						String har_num = keywordHarListNew.get(i).getHarNum();
						String bpId = keywordHarListNew.get(i).getBpId();
						
						String count = likeService.countSalon(har_num); //찜
						countList1.add(count);
						mv.addObject("keyword_new_count", countList1);
						
						String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
						avgList1.add(revAvg);
						mv.addObject("keyword_new_revAvg", avgList1);
						
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						revCountList1.add(revCount);
						mv.addObject("keyword_new_revCount", revCountList1);
					}
					
					
		}
		
		if(shopType==1) {
			// 키워드+위치 검색한 경우 
				 System.out.println("위치 설정+키워드 검색!!!");
				 System.out.println("설정한 주소는????"+searchLoc1+searchLoc2);
				 System.out.println("검색한 키워드는????"+keyword);
				 mv.addObject("searchLoc1", searchLoc1);
				 mv.addObject("searchLoc2", searchLoc2);
				 mv.addObject("keyword", keyword);
				 
				 Map<String,Object> map1 = new HashMap<String,Object>();
				 map1.put("keyword", keyword);
				 map1.put("searchLoc1", searchLoc1);
				 map1.put("searchLoc2", searchLoc2);
				 
				 System.out.println("map정보 출력!!!!"+map1);
				 
				 // 검색 결과 카운팅
				 
				 int total1 = shopListService.countKeywordHosList(map1);
				 System.out.println("검색된 동물병원은 몇 개???"+total1);
				 
				 Pagination page1 = null;
				 page1 = new Pagination(total1, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
				 mv.addObject("hos_keyword_paging", page1);
				 
				 int start1 = page1.getStart();
				 int end1 = page1.getEnd();
				 map1.put("start", start1);
				 map1.put("end", end1);
				 System.out.println("위치 키워드 페이징 map 정보 보여줘~~"+map1);
				 
				 
				 // 키워드 위치 검색 동물병원 최신순 정렬
				 List<Hospital> keywordHosListNew = shopListService.selectKeywordHosListNew(map1);
				 System.out.println("키워드랑 위치로 검색한 동물병원 최신순으로 정렬해줘!!!:"+keywordHosListNew);
				 mv.addObject("keywordHosListNew", keywordHosListNew);
				 
					List<String> countList1 = new ArrayList<String>();
					List<String> avgList1 = new ArrayList<String>();
					List<String> revCountList1 = new ArrayList<String>();
					
					for(int i =0; i<keywordHosListNew.size(); i++) {
			
						// 찜한 숫자 가져오기
						// + 별점 출력 
						String hos_num = keywordHosListNew.get(i).getHosNum();
						String bpId = keywordHosListNew.get(i).getBpId();
						
						String count = likeService.countHos(hos_num); //찜
						countList1.add(count);
						mv.addObject("keyword_new_count", countList1);
						
						String revAvg = shopListService.selectShopRevAvg(bpId);	// 평균 별점
						avgList1.add(revAvg);
						mv.addObject("keyword_new_revAvg", avgList1);
						
						String revCount = shopListService.selectShopRevCount(bpId); //리뷰건수
						revCountList1.add(revCount);
						mv.addObject("keyword_new_revCount", revCountList1);
					}
					
					
		}
		
		
				mv.setViewName("/user/uShop/shopList");
				return mv;
	}





} //컨트롤러 끝 ~! 

