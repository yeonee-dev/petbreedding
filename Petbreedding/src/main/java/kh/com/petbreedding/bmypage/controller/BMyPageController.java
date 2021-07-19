package kh.com.petbreedding.bmypage.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;
import kh.com.petbreedding.bmypage.model.service.BInfoService;
import kh.com.petbreedding.bmypage.model.service.ShopService;
import kh.com.petbreedding.bmypage.model.vo.HairDayOff;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.HairSalonImg;
import kh.com.petbreedding.bmypage.model.vo.HosDayOff;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.HospitalImg;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.service.MyAskCommentService;
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.service.OftenQnaService;
import kh.com.petbreedding.board.model.service.ReviewCommentService;
import kh.com.petbreedding.board.model.service.ReviewService;
import kh.com.petbreedding.board.model.vo.B_comment;
import kh.com.petbreedding.board.model.vo.CustomerService;
import kh.com.petbreedding.board.model.vo.MyAsk;
import kh.com.petbreedding.board.model.vo.MyAskComment;
import kh.com.petbreedding.board.model.vo.OftenQna;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.board.model.vo.ReviewComment;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class BMyPageController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private BInfoService bInfoService;

	@Autowired
	private MyAskService myAskService;
	
	@Autowired
	private MyAskCommentService myAskCommentService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewCommentService reviewCommentService;

	@Autowired
	private CustomerServiceService customerServiceService;
	
	@Autowired
	private OftenQnaService oftenQnaService;
	
	@Autowired
	private ShopPayService shopPayService;
	
	// 사장님 마이 페이지 내정보 수정
	@RequestMapping(value = "/bMyPageUpdate", method = RequestMethod.GET)
	public String bMyPageUpdate(Locale locale, Model model) {

		// TODO Auto-generated method stub
		return "/bPartner/bMyPage/bMyPageUpdate";
	}

	// 사장님 마이 페이지 내정보 수정 처리
	@RequestMapping(value = "bP/bMyPageUpdate", method = RequestMethod.POST)
	@ResponseBody
	public int bMyPageUpdateDo(BPartner bP, HttpSession session) {

		int result = bInfoService.updateBPInfo(bP);
		if (result > 0) {
			session.setAttribute("bP", bP);
		}
		return result;
	}

	// 사장님 마이 페이지 공지사항
	@RequestMapping(value = "/bNotice")
	public String bNotice(Locale locale, Model model, Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		
		int total = customerServiceService.ListBCount();
		
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		Map<String, String> paging = new HashMap<String, String>();
		paging.put("start", Integer.toString(page.getStart()));
		paging.put("end", Integer.toString(page.getEnd()));
		List<CustomerService> list = customerServiceService.CustomerServiceSelectListB(paging);
		
		model.addAttribute("paging", page);
		model.addAttribute("notice", list);
		return "/bPartner/bBoard/bNotice";
	}

	// 사장님 마이 페이지 자주 묻는 질문
	@RequestMapping(value = "/bFAQ", method = RequestMethod.GET)
	public String bFAQ(Locale locale, Model model,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="10") String cntPerPage
			) {
		
		int total = oftenQnaService.BOftenCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<OftenQna> list = oftenQnaService.BOftenQna(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", page);
		
		
		return "/bPartner/bBoard/bFAQ";
	}

	// 사장님 마이 페이지 1:1문의 내역
	@RequestMapping(value = "/bQna")
	public String bQna(Model md, String user_num, Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		int total = myAskService.clBpListCount(user_num);
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNum", user_num);
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<MyAsk> myAskList = myAskService.MyAskSelectList(map);
		md.addAttribute("paging", page);
		md.addAttribute("bQnaList", myAskList);
		md.addAttribute("user_num", user_num);
		System.out.println("[세훈] @일대일 사장님 문의 컨트롤러 myAskList : " + myAskList);

		return "/bPartner/bBoard/bQna";
	}
	
	// 사장님 마이 페이지 1:1 문의 자세히 보기
	@RequestMapping("/bQnaDetail")
	public String askDetail(HttpSession session, String qna_num, Model md) {

		System.out.println("[세훈] @일대일 문의  상세 컨트롤러 qna_num : " + qna_num);

		MyAsk myAskDetail = new MyAsk();
		MyAskComment maComment = new MyAskComment();

		myAskDetail = myAskService.MyAskSelectDetail(qna_num);
		maComment = myAskCommentService.myAskCommentSelectOneCB(qna_num);

		System.out.println("[세훈] @일대일 문의 상세 컨트롤러 myAskDetail : " + myAskDetail);
		System.out.println("[세훈] @일대일 문의 상세 컨트롤러 maComment : " + maComment);

		md.addAttribute("myAskDetail", myAskDetail);
		md.addAttribute("maComment", maComment);

		return "/bPartner/bBoard/bQnaDetail";
	}

	// 사장님 마이 페이지 1:1문의하기
	@RequestMapping(value = "/bQna/writeFrm")
	public String bQnaWrite(Model md, String user_num) {
		System.out.println(user_num);
		md.addAttribute("user_num", user_num);
		return "/bPartner/bBoard/bQnaWrite";
	}

	// 사장님 메뉴관리 페이지 이동
	// 등록미용실 메뉴(메인+서브) 조회
	// TODO: 동물병원도 똑같이 작업..~~ 
	@RequestMapping(value = "/bMenu", method = RequestMethod.GET)
	public ModelAndView bMenu(HttpServletResponse res, HttpSession session) {

		System.out.println("  BMyPageController 실행 - bMenu()  ");
		// 로그인한 사업자 정보 가져오기
		BPartner bpVO = (BPartner) session.getAttribute("bP");
		String bpId = bpVO.getBp_Id();
		ModelAndView mv = new ModelAndView();

		if (bpId == null) {
			System.out.println("로그인 안됨");
		} else {
			
			int bpType = bpVO.getBp_type();
			System.out.println("사업자 타입:"+bpType);
			
			
			if(bpType==0) {	// 0이면 미용실
				
				String harNum = (shopService.selectHarInfo(bpId)).getHarNum();
				System.out.println("미용실 번호::" + harNum);

				List<Style> styleList = shopService.selectStyleList(harNum);
				System.out.println("미용실 스타일 리스트::" + styleList);

//				for (int i = 0; i < styleList.size(); i++) {
//					System.out.println(styleList.get(i));
//				}
				
				mv.addObject("menuList", styleList);
				
				
			} else {	// 1이면 동물병원
				
				String hosNum = (shopService.selectHosInfo(bpId)).getHosNum();
				System.out.println("동물병원 번호:"+hosNum);
				
				List<MedicalType> medList = shopService.selectMedList(hosNum);
				System.out.println("동물병원 진료 정보 리스트:"+medList);
				
				mv.addObject("menuList", medList);
			}

			

			mv.setViewName("/bPartner/bShop/bMenu");
			

			System.out.println(mv);

		}

		return mv;

	}

	// 사장님 메뉴관리 - 미용실 스타일 등록
	// TODO: 동물병원 진료 메뉴 등록
	
	@RequestMapping(value = "bp/bMenu/write", method = RequestMethod.POST)
	public String bMenuWrite(HttpServletRequest req, Style styleVO, MedicalType medVO) {

		System.out.println("****** BMyPageController 실행 ******");

		// 세션에 있는 로그인 정보 가져오기
		HttpSession session = req.getSession();
		BPartner bp = (BPartner) session.getAttribute("bP");

		String bpId = bp.getBp_Id();
		System.out.println("로그인한 사업주 ID::" + bpId);
		int bPType = bp.getBp_type();

		// bPType이 0이면 미용실, 1이면 동물병원
		if (bPType == 0) {

			// TODO
			// 1.로그인한 사업주의 미용실 정보 조회
			HairSalon harVO = shopService.selectHarInfo(bpId);
			System.out.println("미용실 정보:"+harVO);
			String harNum = harVO.getHarNum();
			styleVO.setHarNum(harNum);
			System.out.println("메뉴 등록할 미용실 번호::" + harNum);

			// 2.미용실 메뉴 등록
			// 2-1.주메뉴 등록

			// 조건: style_deep 0
			int styleDeep = styleVO.getStyle_deep();

			if (styleDeep == 0) {
				shopService.insertStyleMAinMenu(styleVO);
				System.out.println("미용실 메인메뉴::" + styleVO);
			}

			// 2-2.서브메뉴 등록
			// 조건: style_deep 1, STYLE_NUM=STYLE_NUM2
			if (styleDeep == 1) {
				shopService.insertStyleSubMenu(styleVO);
				System.out.println("미용실 서브메뉴::" + styleVO);
			}
		} else {

			//TODO
			// 동물병원
			
			//1.로그인한 사업주의 동물병원 정보 조회
			Hospital hosVO = shopService.selectHosInfo(bpId);
			System.out.println("동물병원 정보:"+hosVO);
			String hosNum = hosVO.getHosNum();
			System.out.println("진료종류 등록할 동물병원 번호:"+hosNum);
			medVO.setHosNum(hosNum);
			
			//2.동물병원 진료정보 등록
			shopService.insertMedicalType(medVO);
			
		}

		System.out.println("!!!!!!!!! 사업장 메뉴 추가 완료 !!!!!!");

		// TODO:alert 추가하기

		return "redirect:/bMenu";

	}

	// 사장님 메뉴 관리 - 스타일 수정
	// TODO: 진료 종류 수정 
	@RequestMapping(value = "/bp/bMenu/rewrite")
	public String bMenuReWrite(HttpSession session, HttpServletRequest req, Style styleVO, MedicalType medVO) {

		System.out.println("  BMyPageController 실행 - bMenuReWrite()  ");


		// 로그인한 사업자 정보 가져오기
		BPartner bpVO = (BPartner) session.getAttribute("bP");
		String bpId = bpVO.getBp_Id();

		if (bpId == null) {
			System.out.println("로그인 안 됨");
		} else {

			
			int result = 0;
			
			int bpType = bpVO.getBp_type();
			System.out.println("사업자 타입:"+bpType);
			
			if(bpType==0) {
				
				System.out.println("입력 받은 스타일 정보:" + styleVO);
				String styleNum = null;
				styleNum = styleVO.getStyle_num();
				System.out.println("수정할 스타일 번호:" + styleNum);
				result = shopService.updateStyle(styleVO);
				
			} else {
				System.out.println("입력 받은 진료 종류 정보:"+medVO);
				String medNum = null;
				medNum = medVO.getMedNum();
				System.out.println("수정할 진료 정보 번호:"+medNum);
				result = shopService.updateMedicalType(medVO);
			}
			
			if (result > 0) {
				System.out.println("!! 메뉴 수정 성공 !!");
			} else {
				System.out.println("!! 메뉴 수정 실패 !!");
			}

			
		}
		return "redirect:/bMenu";
	}

	// 사장님 메뉴관리 - 스타일 삭제
	@RequestMapping(value = "/bp/bMenu/delete")
	public String bMenuDelete(HttpSession session, HttpServletRequest req, Style styleVO, MedicalType medVO) {

		System.out.println("  BMyPageController 실행 - bMenuDelete()  ");


		// 로그인한 사업자 정보 가져오기
		BPartner bpVO = (BPartner) session.getAttribute("bP");
		String bpId = bpVO.getBp_Id();

		if (bpId == null) {
			System.out.println("로그인 안 됨");
		} else {

			int result = 0;
			
			int bpType = bpVO.getBp_type();
			System.out.println("사업자 타입:"+bpType);
			
			if(bpType==0) {	// 미용실 - 스타일
				
				System.out.println("입력 받은 스타일 정보:" + styleVO);
				String styleNum = null;
				styleNum = styleVO.getStyle_num();
				System.out.println("삭제할 스타일 번호:" + styleNum);
				result = shopService.deleteStyle(styleNum);
				
			} 
			
			if(bpType==1){	// 동물병원 - 진료 종류
				
				System.out.println("입력 받은 진료 종류 정보:"+medVO);
				
				String medNum = null;
				medNum = medVO.getMedNum();
				System.out.println("삭제할 진료 정보 번호:"+medNum);
				result = shopService.deleteMedicalType(medNum);
			}
			
			if (result > 0) {
				System.out.println("!! 메뉴 삭제 성공 !!");
			} else {
				System.out.println("!! 메뉴 삭제 실패 !!");
			}

		}

		return "redirect:/bMenu";
	}

	// 사장님 매출관리
	@RequestMapping(value = "/bCalculate", method = RequestMethod.GET)
	public String bCalculate(HttpServletResponse res, HttpSession session,
			Model model,
			HosPay hospay,
			HairSalon harVO
			) {
		// 세션에 있는 로그인 정보 가져오기
		BPartner bp = (BPartner) session.getAttribute("bP");
		String bpId = bp.getBp_Id();
		
	
		
		
		List<HarPay> list= null;
		List<HarPay> pay_date = null;
		String month = "";
		
		
		System.out.println("로그인한 사업주 ID::" + bpId);
		//이번달 총 매출액
		if(bp.getBp_type() == 0) {
			
			HairSalon har = shopService.selectHarInfo(bpId);
			String harnum = har.getHarNum();
			System.out.println("사업장 번호" + harnum);
			int harPrice = shopPayService.harAllPrice(harnum);
			list =  shopPayService.HarsixPrice(harnum); 
			pay_date = shopPayService.payYear();
			String[] arr = new String[12]; 
			
			//최근 12개월 날짜 구하기
			String[] regArr = new String[12];
			for(int i=0; i<regArr.length; i++) {
				regArr[i] = "";
				regArr[i] += pay_date.get(i);
				System.out.println("날짜" + regArr[i]);
			}
			
			//최근 12개월간 매출액 
			int intArr[] = new int[arr.length];
			for(int i=0; i<list.size(); i++) {
				arr[i] = "";
				arr[i] += list.get(i);
				intArr[i] = Integer.parseInt(arr[i]);
				System.out.println(arr[i]);
			}
			model.addAttribute("year", intArr);
//			
			
			model.addAttribute("month", regArr);
			model.addAttribute("har", harPrice);
			
			return "/bPartner/bSales/bcalculate";
		}else if(bp.getBp_type() == 1) {
			Hospital hos = shopService.selectHosInfo(bpId);
			String hos_num = hos.getHosNum();
			pay_date = shopPayService.payYear();
			
			System.out.println("사업장 번호" + hos_num);
			
			//결제금액 
			int hosPrice = shopPayService.hosAllPrice(hos_num);
			
			
			//최근 12개월 날짜 구하기
			String[] regArr = new String[12];
			for(int i=0; i<regArr.length; i++) {
				regArr[i] = "";
				regArr[i] += pay_date.get(i);
				System.out.println("날짜" + regArr[i]);
			}
			
			//최근 12개월 매출액 구하기
			List<HosPay> list2 = null;
			String[] hosArr = new String[12];
			int[] hosInt = new int[hosArr.length];
			list2 = shopPayService.HosYearPrice(hos_num);
			for(int i=0; i<list2.size(); i++) {
				hosArr[i] = "";
				hosArr[i] += list2.get(i);
				hosInt[i] = Integer.parseInt(hosArr[i]);
				System.out.println(hosInt[i]);
			}
			 
		   	model.addAttribute("year2", hosInt);
		   	model.addAttribute("month2", regArr);
		   	model.addAttribute("hos", hosPrice);
			return "/bPartner/bSales/bcalculate";
		}

        //1년 
     
		return "/bPartner/bSales/bcalculate";
		
	}

	// 사장님 사업장 관리 - 사업자 등록 페이지 이동
	@RequestMapping(value = "/bShop", method = RequestMethod.GET)
	public String bShop() {
		return "/bPartner/bShop/bShopInfo";
	}
	

	// 사장님 사업장 관리 - 사업장 등록 기능 + 이미지 + 로그인 연동 + BP 테이블에서 사업장 등록여부 상태 1로 바꾸기
	@RequestMapping(value = "bp/bShop/write")
	public String bShopWrite(
			HttpServletRequest hrequest
			, HairSalon harVO
			, Hospital hosVO
			,@RequestParam(value = "shopDayOff") List<String> dayOffList
			, MultipartHttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		
		String savePath = request.getRealPath("resources/uploadFile/shop"); // 파일이 저장될 위치
		
		// 세션에 있는 로그인 정보 가져오기
		HttpSession session = hrequest.getSession();
		BPartner bp = (BPartner) session.getAttribute("bP");
		String bpId = bp.getBp_Id();

		int bPType = bp.getBp_type();
		
		
		int result = -1;
		
		// bPType이 0이면 미용실, 1이면 동물병원
		if (bPType == 0) {

			harVO.setBpId(bpId);
			
			System.out.println("등록할 미용실 정보::"+harVO);
			
			// 미용실 기본 정보 등록
			// TODO 대표 사진 등록 
			
			MultipartFile mf = request.getFile("shopMainImg"); // input type="file" name="shopMainImg"
			UUID uuid = UUID.randomUUID(); 
			String originalfileName = mf.getOriginalFilename();
			String saveName = uuid.toString() + "_" + originalfileName;
			File uploadFile = new File(savePath + "//" + saveName);
			
			try {
				mf.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			harVO.setShopMImg(originalfileName);
			result = shopService.insertHarInfo(harVO);
			
			if(result>0) {
				System.out.println(" !! 미용실 기본 정보 등록 성공 !!");
				System.out.println("등록한 미용실 정보:"+harVO);
				
				shopService.updateBpReg(bpId);	// 사업장 등록 상태 컬럼 1로 변경 
				
				mv.addObject("vo",harVO);
				
				
			} else {
				System.out.println(" !! 미용실 기본 정보 등록 실패 !! ");
			}


			// 미용실 주휴일 설정
			// 1:월요일 ~ 7:일요일
			HairDayOff harVO2 = new HairDayOff();
			System.out.println("미용실 주휴일 LIST::" + dayOffList);

			for (String dayoff : dayOffList) {
				harVO2.setShopDayOff(dayoff);
				System.out.println("LIST 타입 변환중~~ dayoff 값::" + dayoff);
				shopService.insertHarDayOff(harVO2);

			}

		} else {

						hosVO.setBpId(bpId);
			
						// 동물병원 기본 정보 등록
						// TODO: 동물병원 대표 사진 등록 
			
						MultipartFile mf = request.getFile("shopMainImg"); // input type="file" name="shopMainImg"
						UUID uuid = UUID.randomUUID(); 
						String originalfileName = mf.getOriginalFilename();
						String saveName = uuid.toString() + "_" + originalfileName;
						File uploadFile = new File(savePath + "//" + saveName);
						
						try {
							mf.transferTo(uploadFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						hosVO.setShopMImg(originalfileName);
						result = shopService.insertHosInfo(hosVO);

						if(result>0) {
							System.out.println(" !! 동물병원 기본 정보 등록 성공 !!");
							System.out.println("등록한 동물병원 정보:"+hosVO);
							
							shopService.updateBpReg(bpId);	// 사업장 등록상태 컬럼 1로 변경
							
							mv.addObject("vo",hosVO);	// mv.setViewName("/bPartner/bShop/bShopInfo");
							
							
						} else {
							System.out.println(" !! 동물병원 기본 정보 등록 실패 !! ");
						}
			
			
			// 동물병원 주휴일 설정
			// 1:월요일 ~ 7:일요일
			HosDayOff hosVO2 = new HosDayOff();
			System.out.println("동물병원 주휴일 LIST::" + dayOffList);

			for (String dayoff : dayOffList) {
				hosVO2.setShopDayOff(dayoff);
				System.out.println("LIST 타입 변환중~~ dayoff 값::" + dayoff);
				shopService.insertHosDayOff(hosVO2);

			}

		}

		// 파일 업로드

		

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mfList = request.getFiles("shopImg");// 업로드 파라미터

		if (mfList.size() == 1 && mfList.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mfList.size(); i++) {

				UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
				String originalfileName = mfList.get(i).getOriginalFilename(); // 본래 파일명
				String saveName = uuid.toString() + "_" + originalfileName; // 저장될 이름
				File uploadFile = new File(savePath + "//" + saveName); // 복사될 위치

				// 파일 저장
				try {

					mfList.get(i).transferTo(uploadFile);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("원본 파일명:" + originalfileName);

				if (bPType == 0) { // 미용실 매장 사진 등록

					HairSalonImg harVO3 = new HairSalonImg();
					harVO3.setShopImg(originalfileName); // DB에는 원본 파일명 저장 
					shopService.insertHarImg(harVO3);

					System.out.println(harVO3.toString());


				} else { // 동물병원 매장 사진 등록

					HospitalImg hosVO3 = new HospitalImg();
					hosVO3.setShopImg(originalfileName);
					shopService.insertHosImg(hosVO3);

					System.out.println(hosVO3.toString());
					

				}

			}
		}

		

		System.out.println("!! 사업장 등록 완료 !!");

		// TODO:alert 추가하기
		mv.setViewName("/bPartner/bShop/bShopInfo");
		
		return "redirect:/bShop/update"; // TODO:수정해야됨!!!!
	}

	
	// 사업장 관리 - 사업장 수정 페이지로 이동 + 사업장 목록 불러오기
	@RequestMapping(value = "/bShop/update")
	public ModelAndView bShopUpdate(HttpServletResponse res, HttpSession session) {

		// 로그인한 사업자 정보 가져오기
		BPartner bpVO = (BPartner) session.getAttribute("bP");
		String bpId = bpVO.getBp_Id();
		int bPType = bpVO.getBp_type();

		ModelAndView mav = new ModelAndView();

		if (bpId == null) {
			System.out.println("로그인 안됨");
		} else {

			if (bPType == 0) { // 미용실
				HairSalon vo = shopService.selectHarInfo(bpId);
				mav.setViewName("/bPartner/bShop/bShopInfo");
				mav.addObject("vo", vo);
			} else { // 동물병원
				Hospital vo = shopService.selectHosInfo(bpId);
				mav.setViewName("/bPartner/bShop/bShopInfo");
				mav.addObject("vo", vo);
			}

		}

		return mav;

	}

	// 사업장 관리 - 사업장 수정 실행
	@RequestMapping(value = "bp/bShop/update")
	public ModelAndView bShopUpdateDo(HttpServletRequest req, HairSalon harVO, Hospital hosVO,
			@RequestParam(value = "shopDayOff") List<String> dayOffList, MultipartHttpServletRequest mulitreq) {

		System.out.println("***** 사업장 수정 컨트롤러 실행 *****");
		
		ModelAndView mv = new ModelAndView();
		
		String savePath = mulitreq.getRealPath("resources/uploadFile/shop"); // 파일이 저장될 위치
		
		// 로그인 정보 가져오기
		HttpSession session = req.getSession();
		BPartner bp = (BPartner) session.getAttribute("bP");
		String bpId = bp.getBp_Id();

		int bPType = bp.getBp_type();

		// 미용실 번호 가져오기
		String harNum = req.getParameter("harNum");
		System.out.println("미용실 번호::" + harNum);

		// 미용실 VO new 생성
		HairDayOff harVO2 = new HairDayOff();
		HairSalonImg harVO3 = new HairSalonImg();

		// 동물병원 번호 가져오기
		String hosNum = req.getParameter("hosNum");
		System.out.println("동물병원 번호:" + hosNum);

		// 동물병원 VO new 생성
		HosDayOff hosVO2 = new HosDayOff();
		HospitalImg hosVO3 = new HospitalImg();

		// bPType이 0이면 미용실, 1이면 동물병원
		if (bPType == 0) {

			// 미용실 기본 정보 수정
			// ++ 대표 사진 수정
			MultipartFile mf = mulitreq.getFile("shopMainImg"); // input type="file" name="shopMainImg"
			UUID uuid = UUID.randomUUID(); 
			String originalfileName = mf.getOriginalFilename();
			String saveName = uuid.toString() + "_" + originalfileName;
			File uploadFile = new File(savePath + "//" + saveName);
			
			try {
				mf.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			harVO.setShopMImg(originalfileName);
			System.out.println("수정할 미용실 정보:"+harVO);
			
			shopService.updateHarInfo(harVO);
			
			mv.addObject("vo", harVO);

			// 예전 미용실 매장 사진 삭제
			shopService.deleteHarImg(harNum);

			// 미용실 주휴일 삭제
			shopService.deleteHarDayOff(harNum);

			// 수정된 미용실 주휴일 입력
			// 1:월요일 ~ 7:일요일
			System.out.println("미용실 주휴일 LIST::" + dayOffList);

			for (String dayoff : dayOffList) {
				harVO2.setHarNumDayOff(harNum);
				harVO2.setShopDayOff(dayoff);
				System.out.println("수정할 미용실 번호::" + harNum);
				System.out.println("LIST 타입 변환중~~ dayoff 값::" + dayoff);
				harVO2.toString();
				shopService.insertNewHarDayOff(harVO2);

			}

		} else {

			// 동물병원 기본 정보 수정
			// ++ 대표 사징 수정
			MultipartFile mf = mulitreq.getFile("shopMainImg"); // input type="file" name="shopMainImg"
			UUID uuid = UUID.randomUUID(); 
			String originalfileName = mf.getOriginalFilename();
			String saveName = uuid.toString() + "_" + originalfileName;
			File uploadFile = new File(savePath + "//" + saveName);
			
			try {
				mf.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hosVO.setShopMImg(originalfileName);
			System.out.println("수정할 동물병원 정보:"+hosVO);
			shopService.updateHosInfo(hosVO);
			
			mv.addObject("vo", hosVO);
			

			// 동물병원 예전 사진 삭제
			shopService.deleteHosImg(hosNum);

			// 동물병원 주휴일 삭제
			shopService.deleteHosDayOff(hosNum);

			// 동물병원 주휴일 수정
			// 1:월요일 ~ 7:일요일
			System.out.println("동물병원 주휴일 LIST::" + dayOffList);

			for (String dayoff : dayOffList) {
				hosVO2.setHosNumDayOff(hosNum);
				hosVO2.setShopDayOff(dayoff);
				System.out.println("수정할 동물병원 번호::" + hosNum);
				System.out.println("LIST 타입 변환중~~ dayoff 값::" + dayoff);
				hosVO2.toString();

				shopService.insertNewHosDayOff(hosVO2);


			}
		}

		// 파일 업로드
		
		

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mfList = mulitreq.getFiles("shopImg");// 업로드 파라미터

		if (mfList.size() == 1 && mfList.get(0).getOriginalFilename().equals("")) {

		} else {

			for (int i = 0; i < mfList.size(); i++) {

				UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
				String originalfileName = mfList.get(i).getOriginalFilename(); // 본래 파일명
				String saveName = uuid.toString() + "_" + originalfileName; // 저장될 이름
				File uploadFile = new File(savePath + "//" + saveName); // 복사될 위치
				
				// 파일 저장
				try {

					mfList.get(i).transferTo(uploadFile);

				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("파일명:" + originalfileName);

				if (bPType == 0) { // 미용실 매장 사진 등록

					harVO3.setShopImg(originalfileName); // DB에는 원본 파일명 저장
					harVO3.setHarNum(harNum);

					shopService.insertNewHarImg(harVO3);

					System.out.println(harVO3.toString());


				} else { // 동물병원 매장 사진 등록

					hosVO3.setShopImg(originalfileName);
					hosVO3.setHosNum(hosNum);

					shopService.insertNewHosImg(hosVO3);
					System.out.println(hosVO3.toString());
				}

			}

		}
		System.out.println("!! 사업장 수정 완료 !!");
		
		mv.setViewName("/bPartner/bShop/bShopInfo");
		
		return mv; 
	}

	// 업체 리뷰 관리 페이지로 이동
	@RequestMapping(value = "/bReview")
	public String bReview(
			Model md
			,HttpSession ses
			,BPartner bP
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {

		
		if(bP == null) {
			md.addAttribute("msg", "로그인이 필요합니다");
			md.addAttribute("url", "/bLogin");
			return "common/redirect";
		}
		
		bP = (BPartner) ses.getAttribute("bP");
		String bp_id = bP.getBp_Id();
		
		int total = reviewService.getRevCount(bp_id);
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		map.put("bpId", bp_id);
		
		System.out.println("[세훈] @업체 리뷰 조회 컨트롤러 bp_id : " + bp_id);
		
		List<Review> brvList =  new ArrayList<Review>();
		
		brvList = reviewService.reviewSelectList(map);
		int brvCount = reviewService.getRevCount(bp_id);
		
		System.out.println("[세훈] @업체 리뷰 조회 컨트롤러 brvList : " + brvList);
		
		md.addAttribute("brvList", brvList);
		md.addAttribute("brvCount", brvCount);
		md.addAttribute("paging", page);
		
		return "/bPartner/bShop/bReview";
	}
	
	
	//	사업자 리뷰  모달
	@ResponseBody
	@RequestMapping(value = "/brmodal", produces="text/plain;charset=UTF-8")
	public String brModal(
			String rev_num
			,HttpServletRequest req
			,HttpServletResponse res
			) {
		
		res.setCharacterEncoding("UTF-8");
		
		System.out.println("[세훈] @사업자 리뷰 조회 컨트롤러 rev_num : " + rev_num);
		Review rv = new Review();
		rv = reviewService.reviewSelectOne(rev_num);
		
		
		Gson gson = new GsonBuilder().create();
		String jsonOutPut = gson.toJson(rv);
		
		System.out.println("[세훈] @사업자 리뷰 조회 컨트롤러 rv : " + rv.toString());
		
		
		return jsonOutPut;
	}
	
	//	사업자 리뷰 댓글 등록
	@RequestMapping(value = "/brwrite")
	public String brWrite(
			HttpServletRequest req
			,HttpServletResponse res
			,Model md
			) {
		
		res.setCharacterEncoding("UTF-8");
		
		String bp_id = req.getParameter("revBpIdVal");
		String rev_num = req.getParameter("revNumVal");
		String revc_cont = req.getParameter("revcCont");
		
		System.out.println("[세훈] @사업자 리뷰 댓글  등록 컨트롤러 bp_id : " + bp_id);
		System.out.println("[세훈] @사업자 리뷰 댓글  등록 컨트롤러 rev_num : " + rev_num);
		System.out.println("[세훈] @사업자 리뷰 댓글  등록 컨트롤러 revcCont : " + revc_cont);
		
		ReviewComment revCmnt = new ReviewComment();
		
		revCmnt.setBpId(bp_id);
		revCmnt.setRevNum(rev_num);
		revCmnt.setRevcCont(revc_cont);
		
		
		int revcResult = reviewCommentService.reviewCommentInsert(revCmnt);
		System.out.println("[세훈] @사업자 리뷰 댓글  등록 컨트롤러 revcResult : " + revcResult);
		
		
		if(revcResult > 0) {
			System.out.println("사업자 리뷰 댓글 등록 성공");
			md.addAttribute("msg", "사업자 리뷰 댓글 등록 성공");
			md.addAttribute("url","/bReview");
		} else {
			System.out.println("사업자 리뷰 댓글 실패");
			md.addAttribute("msg", "사업자 리뷰 댓글 등록 실패");
			md.addAttribute("url","/bReview");
		}
		
		return "common/redirect";
		
	}

}
