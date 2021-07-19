package kh.com.petbreedding.Admin.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kh.com.petbreedding.Admin.model.service.AdminService;
import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.board.model.service.BoardService;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.service.MyAskCommentService;
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.vo.B_comment;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.CustomerService;
import kh.com.petbreedding.board.model.vo.MyAsk;
import kh.com.petbreedding.board.model.vo.MyAskComment;
import kh.com.petbreedding.common.model.vo.Pagination;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.Notice;
@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerServiceService customerServiceService;
	
	@Autowired
	private MyAskService myAskService;
	
	@Autowired
	private MyAskCommentService myAskCommentService;
	
	@Autowired NoticeService noticeService;
	
	@Autowired
	private BoardService boardService;
	
	public static final int LIMIT = 5;
	
	//관리자 회원관리 (차트)
	@RequestMapping(value = "/mClient", method = RequestMethod.GET)
	public String mClient(Locale locale, Model model) {
		

		int total = 0;
		int total2 = 0;
		
		total = adminService.getMemberCount();
		total2 = adminService.getBpCount();

		//reg_date 구하기 
		  String[] regArr = new String[12];
	        String reg_date = "";

	        for(int i=0; i < regArr.length; i++){
	           if(i < 9){
	        	   reg_date +=  "20210" + (i+1);
	           
	           }else{
	        	   reg_date += "2021" + (i+1);
	          
	           }
	            regArr[i] = reg_date;
	            reg_date = "";
	            System.out.println(regArr[i]);
	        }
	      
	      //사용자 날짜별 카운트
	      int[] cntArr = new int[12];
	      for(int i=0; i<cntArr.length; i++) {
	    	  System.out.println("카운트 들어옴!");
	    	  cntArr[i] = adminService.getMemChart(regArr[i]);
	      }
	      //사업자 날짜별 카운트
	      int[] bpcntArr = new int[12];
	      for(int i=0; i < bpcntArr.length; i++) {
	    	  bpcntArr[i] = adminService.getBpChart(regArr[i]);
	      }
	      
		
		model.addAttribute("total" , total);
		model.addAttribute("total2", total2);
		model.addAttribute("chart", regArr);
		model.addAttribute("cnt", cntArr);
		model.addAttribute("cnt2", bpcntArr);
		return "/admin/aSales/mClient";
	}
		//관리자 매출관리
		@RequestMapping(value = "/mSales", method = RequestMethod.GET)
		public String mSales(Locale locale, Model model) {
			//최근 6개월 pay_date 구하기 
			  String[] regArr = new String[12];
		        String pay_date = "";

		        for(int i=0; i < regArr.length; i++){
		        	if(i<9) {
		        	pay_date +=  "2021-0" + (i+1);
		        	}else {
		        	pay_date += "2021-" + (i+1); 
		        	}
		          
		            regArr[i] = pay_date;
		            pay_date = "";
		            System.out.println(regArr[i]);
		        }
		  
		        //매출엑
		        int[] cntArr = new int[6];
			      for(int i=0; i<cntArr.length; i++) {
			    	  System.out.println("카운트 들어옴!~~~~~~~~~~~~");
			    	  cntArr[i] = adminService.getAllPrice(regArr[i]);
			      }
			   //순이익 
			     int[] realArr = new int[6];
			     for(int i=0; i< realArr.length; i++) {
			    	 System.out.println("순 매출액 차트 들어옴");
			    	 realArr[i] = adminService.getRealPrice(regArr[i]);
			     }
			     
			   //연간 매출액
			     
			    int[] yearArr = new int[12];
			    for(int i=0; i<yearArr.length; i++) {
			    	System.out.println("연간매출액 차트 들어옴");
			    	yearArr[i] = adminService.getAllPrice(regArr[i]);
			    }
		        
			    //울트라 점유율 
			    int ultra = adminService.getUltraAll();
			    
			    //사업장 점유율
			    int bp = adminService.getBpAll();
			   
			    //미용실 울트라 점유율
			    int harUltra = adminService.getHarUltra();
			    
			    //병원 울트라 점유율
			    int hosUltra = adminService.getHosUltra();
			    
			 model.addAttribute("chart", regArr);
			 model.addAttribute("cnt", cntArr);
			 model.addAttribute("real",realArr);
			 model.addAttribute("year", yearArr);
			 model.addAttribute("ultra", ultra);
			 model.addAttribute("bp", bp);
			 model.addAttribute("har", harUltra);
			 model.addAttribute("hos", hosUltra);
			return "/admin/aSales/mSales";
		}
	// 사업장관리 - 제휴 승인 목록조회
	@RequestMapping(value = "/mwaitList", method = RequestMethod.GET)
	public String waitList( Model model,Pagination page,
			@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage) {
		
		int total = adminService.countMwait();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BPartner> list = adminService.waitList(page);
		model.addAttribute("paging", page);
		model.addAttribute("bP", list);
		
		return "/admin/aShop/mWaitforPartner";
	}
	
	//제휴 승인 처리
	@RequestMapping(value = "/confirmBP", method = RequestMethod.POST)
	@ResponseBody
	public int confirmBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.confirmBP(list);
		
		return result;
	}
	
	//제휴 거절 처리
	@RequestMapping(value = "/refuseBP", method = RequestMethod.POST)
	@ResponseBody
	public int refuseBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.refuseBP(list);
		
		return result;
	}
	
	// 사업장관리 - 제휴 취소 목록 조회
	@RequestMapping(value = "/mcancel", method = RequestMethod.GET)
	public String mCancel( Model model,Pagination page,
			@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage) {
		int total = adminService.countMdelete();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		List<BPartner> list = adminService.deleteList(page);
		model.addAttribute("paging", page);
		model.addAttribute("bP", list);
		
		return "/admin/aShop/mCancelPartner";
	}
	//제휴 취소 승인
	@RequestMapping(value = "/deleteBP", method = RequestMethod.POST)
	@ResponseBody
	public int deleteBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.deleteBP(list);
		
		return result;
	}
	
	//제휴 취소 취소
	@RequestMapping(value = "/backBP", method = RequestMethod.POST)
	@ResponseBody
	public int backBP(@RequestParam(value = "arr[]") List<String> list) {
		
		int result = adminService.backBP(list);
		
		return result;
	}
	
	
	// 게시글 관리 (문의게시판 목록)
	@RequestMapping(value = "/mboard")
	public String mboard(
			Model md
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) throws IOException {
		
		int total = myAskService.listCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<MyAsk> myAskList = myAskService.MyAskSelectListM(map);
		
		md.addAttribute("paging", page);
		md.addAttribute("myAskList", myAskList);
		
		return "/admin/aBoard/mboard";
	}
	
	// 게시글 관리 (문의게시판 목록 ajax)
	@ResponseBody
	@RequestMapping(value = "/mboardAjax", produces="text/plain;charset=UTF-8")
	public String mboardAjax(
			Pagination page
			,HttpServletResponse res
			,HttpServletRequest req
			,int qnaType
			,int qnaChk
			,int p
			) throws IOException {
		
		res.setCharacterEncoding("UTF-8");
		
		System.out.println("[세훈] @관리자 문의 사항 목록 qnaType : " + qnaType);
		System.out.println("[세훈] @관리자 문의 사항 목록 qnaChk : " + qnaChk);
		System.out.println("[세훈] @관리자 문의 사항 목록 qnaChk : " + p);
		
		String myAskJson = "";
		
		if(qnaType == 0) {
			//	qnaChk 타입에 맞는 1:1 문의 개수 확인
			int total = myAskService.listCountAll(qnaChk);
			System.out.println("[세훈] @관리자 문의 사항 목록 전체 선택 total : " + total);
			page = new Pagination(total, p, LIMIT);
			
			Map<String, String> map = new HashMap<String, String>();
			List<MyAsk> myAskList = new ArrayList<MyAsk>();
			
			map.put("start", Integer.toString(page.getStart()));
			map.put("end", Integer.toString(page.getEnd()));
			map.put("qnaChk", Integer.toString(qnaChk));
			myAskList = myAskService.MyAskSelectListClBpAllM(map);
			
			Map<String, Object> mapResult = new HashMap<String, Object>();
			mapResult.put("paging", page);
			mapResult.put("list", myAskList);
			
			Gson jobj = new GsonBuilder().create();
			myAskJson = jobj.toJson(mapResult);
			System.out.println("[세훈] @관리자 문의 사항 리스트 myAskJson : " + myAskJson.toString());
			
		} else {
			MyAsk myAsk = new MyAsk();
			myAsk.setQnaType(qnaType);
			myAsk.setQnaChk(qnaChk);
			
//			qnaType, qnaChk 타입에 맞는 1:1 문의 개수 확인
			int total = myAskService.listCountClBp(myAsk);
			System.out.println("[세훈] @관리자 문의 사항 목록 고객, 사업자 선택 total : " + total);
			page = new Pagination(total, p, LIMIT);
			
			Map<String, String> map = new HashMap<String, String>();
			List<MyAsk> myAskList = new ArrayList<MyAsk>();
			map.put("start", Integer.toString(page.getStart()));
			map.put("end", Integer.toString(page.getEnd()));
			
			map.put("qnaType", Integer.toString(qnaType));
			map.put("qnaChk", Integer.toString(qnaChk));
			myAskList = myAskService.MyAskSelectListClBpM(map);
			
			Map<String, Object> mapResult = new HashMap<String, Object>();
			mapResult.put("paging", page);
			mapResult.put("list", myAskList);
			
			Gson jobj = new GsonBuilder().create();
			myAskJson = jobj.toJson(mapResult);
			System.out.println("[세훈] @관리자 문의 사항 리스트 myAskJson : " + myAskJson.toString());
		}
		
		return myAskJson;
	}
	// 게시글 관리 (문의게시판 글상세)
	@RequestMapping(value = "/mboardcon")
	public String mboardcon(
			Model md
			,String qna_num
			,@RequestParam(name = "page", defaultValue = "1") int page
			) {
		
		MyAsk mAsk = new MyAsk();
		
		mAsk = myAskService.MyAskSelectDetail(qna_num);
		md.addAttribute("mAsk", mAsk);
		
		
		return "/admin/aBoard/mboardcon";
	}
	
	// 게시글 관리 (문의게시판 글 삭제)
	@RequestMapping(value = "/mboardDelete")
	public String mboardDelete(String qna_num) {
		
		System.out.println("[세훈] @관리자 문의 사항 삭제 qna_num : " + qna_num);
		
		int result = myAskService.MyAskDelete(qna_num);
		
		if(result > 0) {
			System.out.println("문의 사항 삭제 성공");
		} else {
			System.out.println("문의 사항 삭제 실패");
		}
		
		return "redirect:/mboard";
	}
	
	// 게시글 관리 (문의게시판 댓글)
	@RequestMapping(value = "/macList", produces = "application/text; charset=UTF-8")
	public void macList(
			Model md
			,String qna_num
			,HttpServletRequest req
			,HttpServletResponse res
			) throws SQLException, IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		String result = "";
		List<MyAskComment> mAskComment = new ArrayList<MyAskComment>();
		
		System.out.println(qna_num);
		mAskComment = myAskCommentService.myAskCommentSelectOne(qna_num);
		
		if(mAskComment != null) {
			Gson jobj = new GsonBuilder().create();
			result = jobj.toJson(mAskComment);
		}
		
		
		System.out.println("[세훈] : result : " + result);
		
		out.println(result);
		out.flush();
		out.close();
		
	}
	
	// 게시글 관리 (문의 게시판 댓글 달기)
	@RequestMapping(value = "/macWrite")
	public void macWrite(
			Model md
			,HttpServletRequest req
			,HttpServletResponse res
			,HttpSession ses
			,Admin ad
			) throws IOException {
		
		ad = (Admin) ses.getAttribute("admin");
		
		PrintWriter out = res.getWriter();
		
		String qna_num = req.getParameter("qna_num");
		String maCommentText = req.getParameter("maCommentText");
		
		System.out.println("[세훈] @문의 댓글 달기 컨트롤러 qna_num : " + qna_num);
		System.out.println("[세훈] @문의 댓글 달기 컨트롤러 maCommentText : " + maCommentText);
		
		if(maCommentText != null && maCommentText != "" && qna_num != null && qna_num != "") {
			
			MyAskComment maComment = new MyAskComment();
			String admin_id = ad.getAdmin_id();
			System.out.println("[세훈] @문의 댓글 달기 컨트롤러 admin_id : " + admin_id);
			
			maComment.setQnaNum(qna_num);
			maComment.setQnacCont(maCommentText.replaceAll("\n", "<br>"));
			maComment.setAdminId(admin_id);
			
			System.out.println("[세훈] @문의 댓글 달기 컨트롤러 maComment : " + maComment.toString());
			myAskCommentService.myAskCommentInsert(maComment);
			
		}
		// 알림 인서트
		String cl_num = noticeService.getclNumInQna(qna_num);
		System.out.println("qna 댓글에 clnum 찾아오기" + cl_num);

		Notice notice = new Notice();

		notice.setNotReceiver(cl_num);
		notice.setRefNum(qna_num);

		int result = 0;

		result = noticeService.inQna(notice);

		if (result == 1) {
			System.out.println("알림 인서트 성공!");
		} else {
			System.out.println("알림 인서트 실패");
		}
	}
	
	// 게시판 댓글 수정
	@RequestMapping(value = "/macUpdate")
	@ResponseBody
	public void macUpdate(String qnac_num, String qnac_cont) {
		
		System.out.println("[세훈] @문의 댓글 수정 컨트롤러 qnac_num : " + qnac_num);
		System.out.println("[세훈] @문의 댓글 수정 컨트롤러 qnac_cont : " + qnac_cont);
		
		MyAskComment maComment = new MyAskComment();
		maComment.setQnacNum(qnac_num);
		maComment.setQnacCont(qnac_cont);
		
		int macUpdResult = myAskCommentService.myAskCommentUpdate(maComment);
		
		if(macUpdResult > 0) {
			System.out.println("[관리자] 문의 댓글 수정 성공");
		} else {
			System.out.println("[관리자] 문의 댓글 수정 실패");
		}
		
	}
	
	// 관리자 문의사항 댓글 삭제
	@RequestMapping(value = "/macDelete")
	@ResponseBody
	public void macDelete(String qnac_num, String qna_num) {
		
		System.out.println("[세훈] @문의사항 댓글 삭제 컨트롤러 qnac_num : " + qnac_num);
		System.out.println("[세훈] @문의사항 댓글 삭제 컨트롤러 qna_num : " + qna_num);
		
		int macDelResult = myAskCommentService.myAskCommentDelete(qnac_num, qna_num);
		
		if(macDelResult > 0) {
			System.out.println("게시판 댓글 삭제 성공");
		} else {
			System.out.println("게시판 댓글 삭제 실패");
		}
		
	}
	
	// 게시글 관리 (공지사항게시판 목록)
	@RequestMapping(value = "/mservice")
	public String mservice(
			Model md
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			,@RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		
		int total = customerServiceService.CustomerServiceListCount();
		System.out.println("[세훈] @관리자 공지사항 목록 전체리스트 total : " + total);
		
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<CustomerService> cusList = customerServiceService.CustomerServiceSelectListA(map);
		System.out.println("[세훈] @관리자 공지사항 목록 전체리스트 cusList : " + cusList);
		
		md.addAttribute("paging", page);
		md.addAttribute("cusList", cusList);
		
		return "/admin/aBoard/mservice";
	}
	
	
	// 게시글 관리 (공지사항 목록 ajax)
	@ResponseBody
	@RequestMapping(value = "/mserviceAjax", produces="text/plain;charset=UTF-8")
	public String mserviceAjax(
			Pagination page
			,HttpServletResponse res
			,HttpServletRequest req
			,int annType
			,int p
			) throws IOException {
		
		res.setCharacterEncoding("UTF-8");
		
		System.out.println("[세훈] @관리자 공지사항 목록 annType : " + annType);
		System.out.println("[세훈] @관리자 공지사항 목록 p : " + p);
		
		String myServiceJson = "";
		
//		if(annType == 0) {
//			//	annType이 0이면 공지사항 전체 조회
//			int total = customerServiceService.CustomerServiceListCount();
//			System.out.println("[세훈] @관리자 공지사항 목록 전체 선택 total : " + total);
//			page = new Pagination(total, p, LIMIT);
//			
//			Map<String, Object> map = new HashMap<String, Object>();
//			List<CustomerService> mserviceList = new ArrayList<CustomerService>();
//			
//			map.put("start", Integer.toString(page.getStart()));
//			map.put("end", Integer.toString(page.getEnd()));
//			mserviceList = customerServiceService.CustomerServiceSelectListA(map);
//			
//			Map<String, Object> mapResult = new HashMap<String, Object>();
//			mapResult.put("paging", page);
//			mapResult.put("list", mserviceList);
//			
//			Gson jobj = new GsonBuilder().create();
//			myServiceJson = jobj.toJson(mapResult);
//			System.out.println("[세훈] @관리자 공지사항 전체 리스트 myAskJson : " + myServiceJson.toString());
//			
//		} else {
			
//			annType 타입에 맞는 공지사항 조회
			int total = customerServiceService.CustomerServiceListCountS(annType);
			System.out.println("[세훈] @관리자 공지사항 목록 고객, 사업자 선택 total : " + total);
			page = new Pagination(total, p, LIMIT);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<CustomerService> mserviceList = new ArrayList<CustomerService>();
			
			map.put("start", Integer.toString(page.getStart()));
			map.put("end", Integer.toString(page.getEnd()));
			map.put("annType", Integer.toString(annType));
			
			mserviceList = customerServiceService.CustomerServiceSelectListS(map);
			
			Map<String, Object> mapResult = new HashMap<String, Object>();
			mapResult.put("paging", page);
			mapResult.put("list", mserviceList);
			
			Gson jobj = new GsonBuilder().create();
			myServiceJson = jobj.toJson(mapResult);
			System.out.println("[세훈] @관리자 공지사항 리스트 annType 선택 myAskJson : " + myServiceJson.toString());
//		}
		
		return myServiceJson;
	}
	
	
	//	문의 게시판 상세 페이지 조회
	@RequestMapping(value = "/mserviceDetail")
	public String mserviceDetail(
			Model md
			,String ann_num
			) {
		
		System.out.println("[세훈] @공지사항  상세 컨트롤러 ann_num : " + ann_num);
		
		CustomerService csDetail = new CustomerService();
		
		csDetail = customerServiceService.CustomerServiceSelectOne(ann_num);
		System.out.println("[세훈] @공지사항  상세 컨트롤러 csDetail : " + csDetail);
		
		md.addAttribute("csDetail", csDetail);
		
		return "/admin/aBoard/mserviceDetail";
		
	}
	// 게시글 관리 (공지사항게시판 내용)
	@RequestMapping(value = "/mservicecon", method = RequestMethod.GET)
	public String mservicecon(Locale locale, Model model) {
		return "/admin/aBoard/mservicecon";
	}
	
	// 게시글 관리 (공지사항게시판 등록 폼)
	@RequestMapping(value = "/mserviceRegisterFrm")
	public ModelAndView mserviceRegisterFrm(ModelAndView mv, int type, HttpServletRequest req) {
		
		System.out.println("[세훈] @공지사항  등록 폼 컨트롤러 type : " + type);
		
		if(type == 2) {
			String updAnnTitle = req.getParameter("updAnnTitle");
			String updAnnCont = req.getParameter("updAnnCont");
			String updAnnNum = req.getParameter("updAnnNum");
			mv.addObject("updAnnTitle", updAnnTitle);
			mv.addObject("updAnnCont", updAnnCont);
			mv.addObject("updAnnNum", updAnnNum);
		}
		
		mv.addObject("type", type);
		mv.setViewName("/admin/aBoard/mServiceRegister");
		
		return mv;
	}
	
	// 게시글 관리 (공지사항게시판 등록)
	@RequestMapping(value = "/msRegister")
	public String msRegister(
			Model md
			,Admin ad
			,HttpSession session
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			) {
		
		res.setContentType("text/html; charset=utf-8");
		
		ad = (Admin) session.getAttribute("admin");
		
		
			//	공지사항 등록
			String admin_id = ad.getAdmin_id();
			String ann_type = req.getParameter("mServiceSelect");
			String ann_title = req.getParameter("mServiceTitle");
			String ann_cont = req.getParameter("mServiceCont");
			
			CustomerService cs = new CustomerService();
			
			cs.setAdminId(admin_id);
			cs.setAnnCont(ann_cont);
			cs.setAnnTitle(ann_title);
			cs.setAnnType(ann_type);
			
			int result = 0;
			
			result = customerServiceService.CustomerServiceInsert(cs);
			
			if(result > 0) {
				System.out.println("공지사항 등록 성공");
				md.addAttribute("msg", "공지사항 등록 성공");
				md.addAttribute("url","/mservice");
			} else {
				System.out.println("공지사항 등록 실패");
				md.addAttribute("msg", "공지사항 등록 실패");
				md.addAttribute("url","/mservice");
			}
			
			return "common/redirect";
	}
	
	
	// 게시글 관리 (공지사항게시판 수정)
	@RequestMapping(value = "/msModify")
	public String msModify(
			Model md
			,HttpSession session
			,HttpServletRequest req
			,HttpServletResponse res
			) {
		
		res.setContentType("text/html; charset=utf-8");
		
		
		
		//	공지사항 수정
		String ann_num = req.getParameter("updAnnNum");
		String ann_title = req.getParameter("mServiceTitle");
		String ann_cont = req.getParameter("mServiceCont");
		String ann_type = req.getParameter("mServiceSelect");
		
		CustomerService cs = new CustomerService();
		
		cs.setAnnNum(ann_num);
		cs.setAnnTitle(ann_title);
		cs.setAnnCont(ann_cont);
		cs.setAnnType(ann_type);
		
		int csUpdResult = 0;
		
		csUpdResult = customerServiceService.CustomerServiceUpdate(cs);
		
		if(csUpdResult > 0) {
			System.out.println("공지사항 수정 성공");
			md.addAttribute("msg", "공지사항 수정 성공");
			md.addAttribute("url","/mservice");
		} else {
			System.out.println("공지사항 수정 실패");
			md.addAttribute("msg", "공지사항 수정 실패");
			md.addAttribute("url","/mservice");
		}
		
		return "common/redirect";
	}
	
	// 게시글 관리 (공지사항게시판 삭제)
	@RequestMapping(value = "/msDelete")
	public String msDelete(
			ModelAndView mv
			,String ann_num
			) {
		
		System.out.println("[세훈] @공지사항  삭제 컨트롤러 ann_num : " + ann_num);
		
		int result = customerServiceService.CustomerServiceDelete(ann_num);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		return "redirect:/mservice";
	}
	// 게시글 관리 (자유게시판 목록)
	@RequestMapping(value = "/mfreeboard")
	public String mfreeboard(
			@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,Pagination page
			,Model md
			) {

		int total = boardService.listCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));

		List<Board> list = boardService.selectBoardList(page);

		md.addAttribute("paging", page);
		md.addAttribute("myList", list);

		System.out.println("[세훈] @관리자 게시판 목록 조회 컨트롤러 page : " + page);
		System.out.println("[세훈] @관리자 게시판 목록 조회 컨트롤러 list : " + list);
		
		return "/admin/aBoard/mfreeboard";
	}
	// 게시글 관리 (자유게시판 내용)
	// ?? 해당 파일이 없어요?
	@RequestMapping(value = "/mfreecon", method = RequestMethod.GET)
	public String mfreecon(Locale locale, Model model) {
		return "/admin/aBoard/mfreecon";
	}
	
	
	
}