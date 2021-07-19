package kh.com.petbreedding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Shop.model.service.BpReservationService;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Likes;
import kh.com.petbreedding.common.model.vo.Pagination;
import kh.com.petbreedding.cta.model.service.CtaService;

//TODO: !!!!!!!! 경로 수정하고 컨트롤러명 변경하기 !!!!!!!!!!

@Controller
public class shopController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public final int STARTPAGE = 1;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ShopService shopService;

	@Autowired
	private CtaService ctaService;

	@Autowired
	private BpReservationService bprevService;

	@Autowired
	private LikesService likeService;
	
	// 사업장 리스트
//	@RequestMapping(value = "/shopList", method = RequestMethod.GET)
//	public ModelAndView shopList(
//			ModelAndView mv
//			,Pagination page
//			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
//			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
//			, @RequestParam(value="keyword", defaultValue="") String keyword
//			,@RequestParam(name="selectlocCon",defaultValue="") String selectLocCon
//			,@RequestParam(name="selectChooseLoc",defaultValue="") String selectChooseLoc
//			, @RequestParam Long shopType
//			, HttpServletRequest request
//			) throws Exception {
//		
//		System.out.println("검색한 키워드는?"+ keyword);
//		System.out.println("선택한 시·도는?"+selectLocCon);
//		System.out.println("선택한 시·군·구는?"+selectChooseLoc);
//		
//		
//		// shopType 0은 미용실, 1은 동물병원
//
//		if (shopType == 0) {
//
//			int harShopType = 0;
//			
//			// 미용실 페이징 
//			int total = shopService.countHarList();	// 등록된 미용실 총 갯수 
//			
//				page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//				
//				mv.addObject("paging", page);
//			
//			
//				List<HairSalon> newHarList = shopService.selectHarListNew(page); // 최신순
//				List<HairSalon> revHarList = shopService.selectHarListRev(page); // 별점순 
//				List<HairSalon> likesHarList = shopService.selectHarListLikes(page); // 인기순
//			
//			
//			
//			System.out.println("미용실 리스트: 최신순 : " + newHarList);
//			System.out.println("미용실 리스트: 별점순: " + revHarList);
//			System.out.println("미용실 리스트: 인기순: " + likesHarList);
//			
//			
//			// 미용실 리스트 - 거리순
//			// TODO 
//			
//			
//			
//			// 찜한 숫자 가져오기
//			// + 별점 출력 
//			String har_num = null;
//			String bpId = null;
//			List<String> list = new ArrayList<String>();
//			List<String> countList = new ArrayList<String>();
//			
//			// 최신순
//			for(int i =0; i<newHarList.size(); i++) {
//				har_num = newHarList.get(i).getHarNum();
//				bpId = newHarList.get(i).getBpId();
//				String count = likeService.countSalon(har_num); //찜
////				String revVal = shopService.selectRevVal(bpId);	// 평균 별점
//					
//				String countRev = shopService.selectCountReview(bpId); //리뷰건수
//				countList.add(countRev);
////				mv.addObject("revVal", revVal);
//				mv.addObject("countRev", countList);
//				System.out.println("************count*****"+count);
//				list.add(count);
//				mv.addObject("count", list);
//			}
//			
//			// 별점순
//			for(int i =0; i<revHarList.size(); i++) {
//				har_num = revHarList.get(i).getHarNum();
//				bpId = revHarList.get(i).getBpId();
//				String count = likeService.countSalon(har_num);
////				String revVal = shopService.selectRevVal(bpId);
//					
//				String countRev = shopService.selectCountReview(bpId);
//				countList.add(countRev);
////				mv.addObject("revVal", revVal);
//				mv.addObject("countRev", countList);
//				System.out.println("************count*****"+count);
//				list.add(count);
//				mv.addObject("count", list);
//			}
//			
//			// TODO:인기순
//			for(int i =0; i<likesHarList.size(); i++) {
//				har_num = likesHarList.get(i).getHarNum();
//				System.out.println("미용실 번호는????"+har_num);
//				bpId = likesHarList.get(i).getBpId();
//				String count = likeService.countSalon(har_num);
////				String revVal = shopService.selectRevVal(bpId);
//				String countRev = shopService.selectCountReview(bpId);
//				countList.add(countRev);
////				mv.addObject("revVal", revVal);
//				mv.addObject("countRev", countList);
//				System.out.println("************count*****"+count);
//				list.add(count);
//				mv.addObject("count", list);
//			}
//			
//			/*
//			 * List<String> list = new ArrayList<String>(); 
//			 * System.out.println("~~~~~~~~~~~~~harNum ~~~~~~~~~"+list);
//			 * HashMap<String,String> salonCount = likeService.countSalon(list);
//			 * System.out.println("!!!!!!!salonList!!!!!!!!! "+ salonCount);
//			 */
////			List<HairSalonImg> harImgList = shopService.selectHarImgList();
//
//			List<HairSalon> ultra = shopService.selectCtaHarList();
//			
//			List<String> ctaCountList = new ArrayList<String>();
//			List<String> list2 = new ArrayList<String>();
//			for(int i =0; i<ultra.size(); i++) {
//				har_num = ultra.get(i).getHarNum();
//				bpId = ultra.get(i).getBpId();
//				String count = likeService.countSalon(har_num);
//				String ctaCountRev = shopService.selectCountCtaReview(bpId); //리뷰건수
//				
//				ctaCountList.add(ctaCountRev);
//				mv.addObject("ctaCountRev", ctaCountList);
//				System.out.println("************count*****"+count);
//				list2.add(count);
//				mv.addObject("count2", list2);
//				
//				System.out.println("울트라콜 미용실 리스트 (평균 별점 포함):"+ultra);
//			}
//			
//			List<HairSalon> harReviewList = shopService.selectHarListRev(page);
//			System.out.println("미용실 리뷰 리스트:: " + harReviewList);
//			mv.addObject("reviewList", harReviewList);
//			
//			
//			mv.addObject("shopType", harShopType);
//			mv.addObject("newHarList", newHarList);
//			mv.addObject("likesHarList", likesHarList);
//			mv.addObject("revHarList", revHarList);
//			mv.addObject("paging", page);
//			mv.addObject("cta", ultra);
//			mv.setViewName("/user/uShop/shopList");
//
//
//		} else {
//
//			int hosShopType = 1;
//			
//			// 동물병원 페이징 
//			int total = shopService.countHosList();	// 등록된 미용실 총 갯수 
//			
//			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
//			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), keyword);
//			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), selectLocCon, selectChooseLoc);			
//			
//			mv.addObject("paging", page);
//
//			
//			//찜한 숫자 가져오기
//			// +별점 출력 
//			String hos_num = null;
//			String bpId = null;
//			List<String> list = new ArrayList<String>();
//			List<String> countList = new ArrayList<String>();
//			
//			
//			// 최신순
//			List<Hospital> newHosList = shopService.selectHosListNew(page);
//			System.out.println("동물병원 리스트 - 최신순 : " + newHosList);
//			
//			for(int i =0; i<newHosList.size(); i++) {
//				hos_num = newHosList.get(i).getHosNum();
//				bpId = newHosList.get(i).getHosNum();
//				String count = likeService.countHos(hos_num);
//				String revVal = shopService.selectRevVal(bpId);
//				String countRev = shopService.selectCountReview(bpId);
//				countList.add(countRev);
//				mv.addObject("revVal", revVal);
//				mv.addObject("countRev", countRev);
//				System.out.println("************count*****"+count);
//				list.add(count);
//				mv.addObject("count", list);
//			}
//			
//			
//			// TODO: 거리순
//			
//			// TODO: 별점순 
//			List<Hospital> revHosList = shopService.selectHosListRev(page);
//			System.out.println("동물병원 리스트 - 별점순 :"+revHosList);
//			
//			for(int i =0; i<revHosList.size(); i++) {
//				hos_num = revHosList.get(i).getHosNum();
//				bpId = revHosList.get(i).getHosNum();
//				String count = likeService.countHos(hos_num);
//				String revVal = shopService.selectRevVal(bpId);
//				String countRev = shopService.selectCountReview(bpId);
//				countList.add(countRev);
//				mv.addObject("revVal", revVal);
//				mv.addObject("countRev", countRev);
//				System.out.println("************count*****"+count);
//				list.add(count);
//				mv.addObject("count", list);
//			}
//			
//			//울트라
//			List<Hospital> ultra2 = shopService.selectCtaHosList();
//			
//			for(int i=0; i<ultra2.size(); i++) {
//				hos_num = ultra2.get(i).getHosNum();
//				bpId = ultra2.get(i).getBpId();
//				String count =  likeService.countHos(hos_num);
//				String ctaCountRev =  shopService.selectCountCtaReview(bpId);
//				
//				countList.add(ctaCountRev);
//				mv.addObject("ctaCountRev",countList);
//				System.out.println("--------병원 count-----"+count);
//				
//				list.add(count);
//				mv.addObject("count2", list);
//				
//				System.out.println("울트라콜 병원 리스트(평균 별점 포함)" + ultra2);
//			}
//
//			
//			mv.addObject("shopType", hosShopType);
////			mv.addObject("shopList", hosList);
//			mv.addObject("newHosList", newHosList);
//			mv.addObject("revHosList", revHosList);
//			mv.addObject("paging", page);
//			mv.addObject("cta2", ultra2);
//			mv.setViewName("/user/uShop/shopList");
//
//
//		}
//
//		return mv;
//		return "/user/uShop/shopList";
//
//	}

//	@RequestMapping(value = "/salonList", method = RequestMethod.GET)	// *********** TODO "/shopList"에 합쳐줘야 됨!!*******
//	public ModelAndView salonList(Locale locale, ModelAndView mv) {
//		List<HairSalon> salonList = shopService.selectHarList(STARTPAGE, 5);
//		System.out.println("컨트롤러 미용실 리스트 : " + salonList);
//		
//		mv.addObject("salonList", salonList);
//		mv.setViewName("/user/uShop/salonList");
//		
//		return mv;
//	}

	// 사업장 상세 페이지
	@RequestMapping(value = "/shopPage")
	public ModelAndView shopPage(
			@RequestParam Long shopType
			, Locale locale
			, ModelAndView mv
			, HttpServletRequest request
			, HttpSession session) throws Exception{
		System.out.println("shopPage 컨트롤러 진입");
		String bpId = request.getParameter("bpId");
		ctaService.delcta(bpId);
		mv.addObject("bp_id", bpId); // 문의하기 버튼 클릭 시 채팅 연결 위해
		System.out.println("매장 타입:" + shopType);
		mv.addObject("shopType", shopType);

//		try {
//			bpId = Integer.parseInt(request.getParameter("bpId"));
//		}catch(Exception e) {
//			e.printStackTrace();
//		}

		// ** 미용실 **
		if (shopType == 0) {

			// 기본 정보 출력
			HairSalon har = shopService.selectHarInfo(bpId);
			System.out.println("미용실 정보::" + har);
			mv.addObject("shopInfo", har);

			// 해당 미용실 번호 출력하기
			String harNum = har.getHarNum();
			System.out.println("미용실 번호:" + harNum);

			// 메뉴(스타일) 출력
			List<Style> styleList = shopService.selectStyleList(harNum);
			System.out.println("스타일 리스트:" + styleList);
			mv.addObject("menuList", styleList);

			// 미용실 사진 출력
			List<HairSalonImg> harImgList = shopService.selectHarImgList(harNum);
			System.out.println("미용실 사진 리스트:" + harImgList);
			mv.addObject("shopImgList", harImgList);
			
			//로그인한 회원이 이 미용실을 찜했는지?
			Client client = (Client) session.getAttribute("client");
			if(client != null) {
				String cl_num = client.getCl_num();
				List<Likes> likes = likeService.selectLikes(cl_num);
				mv.addObject("zzim", likes);
			}else {
				System.out.println("로그인하지 않았습니다.");
			}

		} else {

			// 동물병원

			// 기본 정보 출력
			Hospital hos = shopService.selectHosInfo(bpId);
			System.out.println("동물병원 정보::" + hos);
			mv.addObject("shopInfo", hos);

			// 해당 동물병원 번호 출력하기
			String hosNum = hos.getHosNum();
			System.out.println("동물병원 번호:" + hosNum);

			// TODO
			// 동물병원 진료 정보 출력
			List<MedicalType> medList = shopService.selectMedList(hosNum);
			System.out.println("동물병원 진료 정보 리스트:" + medList);
			mv.addObject("menuList", medList);

			// 동물병원 사진 출력
			List<HospitalImg> hosImgList = shopService.selectHosImgList(hosNum);
			System.out.println("동물병원 사진 리스트:" + hosImgList);
			mv.addObject("shopImgList", hosImgList);
			
			//로그인한 회원이 이 병원을 찜했는지?
			Client client = (Client) session.getAttribute("client");
			if(client != null) {
				String cl_num = client.getCl_num();
				List<Likes> likes = likeService.selectLikes(cl_num);
				mv.addObject("zzim", likes);
			}else {
				System.out.println("로그인하지 않았습니다.");
			}

		}
		
		String revValAvg = reviewService.getRevValAvg(bpId);
		int revCount = reviewService.getRevCount(bpId);
		
		System.out.println("[세훈] @shop 상세페이지 컨트롤러 revValAvg : " + revValAvg);
		System.out.println("[세훈] @shop 상세페이지 컨트롤러 revCount : " + revCount);
		mv.addObject("revValAvg", revValAvg);
		mv.addObject("revCount", revCount);

		mv.setViewName("/user/uShop/shopInfoRead");

		return mv;
	}

	@RequestMapping(value = "/successPay", method = RequestMethod.GET)
	public String successPay(Locale locale, Model model) {
		return "/user/uShop/successPay";
	}

	@RequestMapping(value = "/successRev", method = RequestMethod.GET)
	public String successRev(Locale locale, Model model) {
		return "/user/uShop/successRev";
	}

	// 사업자 예약관리 - 현재 날짜 전체 리스트 (병원, 미용실 포함)
	@RequestMapping(value = "/bReservation")
	public ModelAndView bReservationList(Locale locale, Model model,
			HairShopReservation rev, HttpSession session,
			HttpServletResponse res

	) throws Exception {

		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id = vo.getBp_Id();
		System.out.println("사업자 예약조회 들어옴-----------");
		
		
		List<HairShopReservation> list = null;
		List<HospitalReservation> list2 = null;
		ModelAndView mav = new ModelAndView();

		
		if(vo.getBp_type() == 0) {
			list = bprevService.revAllList(bp_id);
			mav.setViewName("bPartner/bShop/bReservation");
			mav.addObject("list", list);
			
		}else {
			list2 = bprevService.revHosAllList(bp_id);
			mav.setViewName("bPartner/bShop/bReservation");
			mav.addObject("list", list2);
		}
		
		

		return mav;
	}
	
	
	//사업자 미용실 날짜별 전체보기 
	@ResponseBody
	@RequestMapping(value = "/bReservationdate")
	public List<HairShopReservation> bReservationDate(Locale locale, Model model, 
			HairShopReservation rev,
			HttpSession session, 
			HttpServletResponse res) throws Exception {
	
		
		System.out.println("선택된 날짜는" + rev.getRes_date());
		List<HairShopReservation> list = bprevService.revAllListDate(rev);
		return list;
	
	}
	

	// 사업자 미용실 예약관리 개별 선택 리스트
	@ResponseBody
	@RequestMapping(value = "/bReservationkind")
	public List<HairShopReservation> bReservation(Model model, HairShopReservation rev,
			HttpSession session, HttpServletResponse res) throws Exception {

		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id = vo.getBp_Id();
//			List<HairShopReservation> list = bprevService.revList(res_status);
		System.out.println("사업자 예약조회 개별 들어옴");
		System.out.println("선택된 미용실 날짜는" + rev.getRes_date());
		System.out.println("선택된 미용실 예약 상태는" + rev.getRes_status());
		System.out.println("로그인한 사업장은" + rev.getBp_id());
		System.out.println("이름은 " + rev.getName());
		/*
		 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
		 * bprevService.revList(rev)); mav.setViewName("bPartner/bShop/bReservation");
		 */
			List<HairShopReservation> list = bprevService.revList(rev);
			
			return list;
	}
	
	// 사업자 병원 예약관리 개별 선택 리스트
		@ResponseBody
		@RequestMapping(value = "/bReservationHoskind")
		public List<HospitalReservation> bReservationHos(Model model, 
				HospitalReservation rev,
				HttpSession session, HttpServletResponse res) throws Exception {

			System.out.println("병원 예약조회 개별 들어옴");
			System.out.println("선택된 병원예약 날짜는" + rev.getHos_date());
			System.out.println("선택된 병원 예약 상태는" + rev.getHos_status());
			System.out.println("로그인한 사업장은" + rev.getBp_id());
			System.out.println("이름은 " + rev.getName());
			/*
			 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
			 * bprevService.revList(rev)); mav.setViewName("bPartner/bShop/bReservation");
			 */
				List<HospitalReservation> list = bprevService.revHosList(rev);
				
				return list;
		}
		
		//사업자 병원 날짜별 전체보기 
		@ResponseBody
		@RequestMapping(value = "/bHosReservationdate")
		public List<HospitalReservation> bHosReservationDate(
				Model model, 
				HospitalReservation rev,
				HttpSession session, 
				HttpServletResponse res) throws Exception {
		
			
			System.out.println("병원 선택된 날짜는" + rev.getHos_date());
			List<HospitalReservation> list = bprevService.revAllHosListDate(rev);
			return list;
		
		}
		
		
	

		
		// 사업자 미용실 예약확인 상세페이지
		@RequestMapping(value = "/bReservationDetail", method = RequestMethod.GET)
		public ModelAndView bReservationDetail(
				HttpSession session, 
				HttpServletResponse res,
				HospitalReservation hos,
				HairShopReservation rev
				) throws Exception {
				
			ModelAndView mav = new ModelAndView();
			ModelAndView mav2 = new ModelAndView();
			System.out.println("미용실 예약번호는 : " + rev.getHar_rnum());
			System.out.println("병원 예약번호는 : " + hos.getHos_rnum());
			HairShopReservation vo = new HairShopReservation();
			HospitalReservation hoslist = new HospitalReservation();
			
			Client cl =  new Client();
			
			// 채팅 오픈 시 bp_id 필요해서 추가
			BPartner bpartner = (BPartner) session.getAttribute("bP");
			String bp_id = bpartner.getBp_Id();
			
			if(rev.getHar_rnum() != null) {
				vo = bprevService.revharcon(rev.getHar_rnum());
				mav.addObject("list", vo);
				mav.setViewName("/bPartner/bShop/bReservationDetail");
				// 채팅창 오픈 시 bp_id 필요해서 추가
				mav.addObject("bp_id", bp_id);
				return mav ;
				
			}else if(hos.getHos_rnum() != null) {
				hoslist = bprevService.revhoscon(hos.getHos_rnum()); 
				mav2.addObject("list2", hoslist);
				mav2.setViewName("/bPartner/bShop/bReservationDetail2");
				// 채팅 오픈 시 bp_id 필요해서 추가
				mav2.addObject("bp_id", bp_id);
				return mav2;
			}
			return mav;
			
		}
		
		
	//결제 취소
		@RequestMapping(value = "/bReservationCancle", method = RequestMethod.POST)
		public String bReservationCancle(
				HospitalReservation hos,
				HairShopReservation rev
				 ) throws Exception {
			
			if(rev.getHar_rnum() != null) {
				System.out.println("미용실 결제취소 들어옴");
				bprevService.delrevHar(rev.getHar_rnum());
				return "bPartner/bShop/bReservation";
			}else if(hos.getHos_rnum() !=null) {
				System.out.println("병원 결체 취소 들어옴");
				bprevService.delrevHos(hos.getHos_rnum());
				return "bPartner/bShop/bReservation";
			}
			return "";
			
		}
	// 사업자 화상채팅하기
	@RequestMapping(value = "/bFaceChat", method = RequestMethod.GET)
	public String bFaceChat(Locale locale, Model model) {
		return "/bPartner/bShop/bFaceChat";
	}
}
