package kh.com.petbreedding.board.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.com.petbreedding.board.model.vo.B_comment;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.CustomerService;
import kh.com.petbreedding.board.model.vo.OftenQna;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.vo.Pagination;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.Notice;
import kh.com.petbreedding.board.model.service.BCommentService;
import kh.com.petbreedding.board.model.service.BoardService;
import kh.com.petbreedding.board.model.service.CustomerServiceService;
import kh.com.petbreedding.board.model.service.OftenQnaService;
import kh.com.petbreedding.board.model.service.ReviewService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private CustomerServiceService customerServiceService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private BCommentService bCommentService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private OftenQnaService oftenQnaService;
	
	public static final int LIMIT = 5;
	
	// 게시글 목록 + 페이징 + 검색
	@RequestMapping(value = "/fboardlist")
	// TODO 병원 번호, 미용실 번호 GET 방식으로 들고 들어와서 파라미터로 넣어줘야함 -
	// @RequestParam(name="harNum") String harNum
	public ModelAndView fboardlist(ModelAndView mv, HttpServletRequest req, Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			,@RequestParam(name = "keyword", required = false) String keyword) {

		List<Board> boardList = null;
		int total = boardService.listCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		if (keyword != null && !keyword.equals("")) {
			boardList = boardService.searchList(keyword);
			total = boardList.size();
			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			mv.addObject("boardList", boardList);
		} else {
			page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			boardList = boardService.selectBoardList(page);
			mv.addObject("boardList", boardList);
		}
		
		mv.addObject("paging", page);

		System.out.println("[세훈] @컨트롤러 boardList : " + boardList.toString());
		mv.setViewName("/user/uBoard/fboardList");

		return mv;
	}

	// 게시글 상세
	@RequestMapping(value = "/fboardcon", method = RequestMethod.GET)
	public ModelAndView fboardcon(ModelAndView mv, @RequestParam(name = "boNum") String boNum,
			@RequestParam(name = "page", defaultValue = "1") int page, String userType) {

		int currentPage = page;
		System.out.println("[세훈] @자유 게시글 상세 컨트롤러 userType : " + userType);
		Board board = boardService.selectBoardDetail(0, boNum);
		System.out.println("[세훈] @자유 게시글 상세 컨트롤러 board : " + board);

		mv.setViewName("/user/uBoard/fboardcon");
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("board", board);
		if(userType != null && userType != "") {
			mv.addObject("userType", userType);
		}

		return mv;
	}

	// 게시글 작성 폼
	@RequestMapping(value = "/bwriteFrm")
	public String bWrite(
			Model md
			,int type
			,Client cl
			,HttpServletRequest req
//			,HttpSession session
			) {
		
//		cl = (Client) session.getAttribute("client"); 
//		
//		 if(cl==null) { //TODO: 로그인 안됐다는경고.또는 이동 위치 변경 
//			System.out.println("로그인 안했음");
//			md.addAttribute("msg", "로그인이 필요합니다");
//			md.addAttribute("url","/uLogin");
//			return "common/redirect"; 
//		 }
		
		String boNum = req.getParameter("boUpdBoNum");
		String boTitle = req.getParameter("boUpdBoTitle");
		String boCont = req.getParameter("boUpdBoCont");
		
		md.addAttribute("type", type);
		md.addAttribute("boUpdBoNum", boNum);
		md.addAttribute("boUpdBoTitle", boTitle);
		md.addAttribute("boUpdBoCont", boCont);
		
		
		System.out.println("[세훈] @자유 게시글 등록 폼 컨트롤러 type : " + type);
		return "/user/uBoard/bwrite";
	}

	// 게시글 수정페이지
	@RequestMapping(value = "/bupdateFrm")
	public ModelAndView bUpdate(
			ModelAndView md, String boNum, String boTitle, String boCont
			) {
		System.out.println("boNum : "+ boNum);
		System.out.println("boTitle : "+ boTitle);
		System.out.println("boCont : "+ boCont);
		md.addObject("boUpdBoNum", boNum);
		md.addObject("boUpdBoTitle", boTitle);
		md.addObject("boUpdBoCont", boCont);
		md.setViewName("/user/uBoard/bUpdate");
		
		return md;
	}
	
	
	
	@RequestMapping(value = "/bwrite")
	public String bwrite(
			Model md
			,Client cl
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			,HttpSession session
			) {
		res.setContentType("text/html; charset=utf-8");
		
		
		 cl = (Client) session.getAttribute("client"); 
		 
		
		String cl_num = cl.getCl_num();
		String cl_nickName = cl.getNickname();
		String boTitle = req.getParameter("boTitle");
		String bo_content = req.getParameter("boContent");
			
		Board board = new Board();
		board.setClNum(cl_num);
		board.setClNickName(cl_nickName);
		board.setBoTitle(boTitle);
		board.setBoCont(bo_content);
		String src = "";
		
		//이미지 경로 찾아오기
		Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
		Matcher matcher = pattern.matcher(bo_content);
		while(matcher.find()){
			System.out.println("img추출하러왔어용");
            src = matcher.group(1);
        }
		System.out.println("!!!!!!! src : "+ src);
		if(src == null || src == "" ) { 
			System.out.println("이미지는 없습니다.");
		} else {
			try { 
				URL imgURL = new URL(src);
				String extension = src.substring(src.lastIndexOf(".")+1); 
				UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성 
				String fileName = uuid.toString() + "_" + board;
				BufferedImage image = ImageIO.read(imgURL); 
				File file = new File("/resources/uploadFile/fboard"); 
				if(!file.exists()) { 
					file.mkdirs(); 
				}
				ImageIO.write(image, extension, file); 
				board.setBoImg(src); 
			} 
			catch (Exception e) { 
				e.printStackTrace(); 
			}
		}
		 
		  int result = boardService.insertBoard(board);
		  
			if(result > 0) {
				md.addAttribute("msg", "자유게시판 글 등록 성공");
				md.addAttribute("url","/fboardlist");
			} else {
				md.addAttribute("msg", "자유게시판 글 등록 실패");
				md.addAttribute("url","/fboardlist");
			}
			
			return "common/redirect";	
	}
	
	//	자유게시판 글 수정
	
	@RequestMapping(value = "/bupdate")
	public String bupdate(
			Model md
			,String cl_num
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			,HttpSession session
			) {
		res.setContentType("text/html; charset=utf-8");

		String boTitle = req.getParameter("boTitle");
		String bo_content = req.getParameter("boContent");
		String bo_num = req.getParameter("boUpdBoNum");
		
		Board board = new Board();
		board.setBoTitle(boTitle);
		board.setBoCont(bo_content);
		board.setBoNum(bo_num);
		String src = "";
		//이미지 경로 찾아오기
		Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>"); //img 태그 src 추출 정규표현식
		Matcher matcher = pattern.matcher(bo_content);
		while(matcher.find()){
            System.out.println("*****************img경로***************** "+ matcher.group(1));
            src = matcher.group(1);
        }
		
		if(src != null || src != "") { 
			try { 
				URL imgURL = new URL(src);
				String extension = src.substring(src.lastIndexOf(".")+1); 
				UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성 
				String fileName = uuid.toString() + "_" + board;
				BufferedImage image = ImageIO.read(imgURL); 
				File file = new File("/resources/uploadFile/fboard"); 
				if(!file.exists()) { 
					file.mkdirs(); 
				}
				ImageIO.write(image, extension, file); 
				System.out.println("이미지 업로드완료!");
				board.setBoImg(src); 
			} 
			catch (Exception e) { 
				e.printStackTrace(); 
			}
		} 
		
		 
				
		
		  System.out.println("[세훈] @글 수정 컨트롤러 board : " + board.toString());
		 
		  int result = boardService.updateBoard(board);
		  
			if(result > 0) {
				System.out.println("자유게시판 글 수정 성공");
				md.addAttribute("msg", "자유게시판 글 수정 성공");
				md.addAttribute("url","/fboardlist");
			} else {
				System.out.println("공지사항 수정 실패");
				md.addAttribute("msg", "자유게시판 글 수정 실패");
				md.addAttribute("url","/fboardlist");
			}
			
			return "common/redirect";	
	}
	
	//	자유게시판 글 삭제
	@RequestMapping(value = "/bdelete")
	public String bdelete(String bo_num) {
		
		System.out.println("[세훈] @게시판 글 삭제 컨트롤러 bo_num : " + bo_num);
		
		int boDelResult = boardService.deleteBoard(bo_num);
		
		if(boDelResult > 0) {
			System.out.println("게시판 글 삭제 성공");
		} else {
			System.out.println("게시판 글 삭제 실패");
		}
		
		return "redirect:/fboardlist";
	}

	// 게시판 댓글 조회
	@RequestMapping(value = "/bocList")
	public void bocList(Model md, 
			HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");

		PrintWriter out = res.getWriter();

		String bo_num = req.getParameter("boNum");
		System.out.println("[세훈] @게시판 댓글 조회 컨트롤러 boNum : " + bo_num);

		String bocJson = "";
		List<B_comment> bocList = new ArrayList<B_comment>();

		if(bocList != null) {
			bocList = bCommentService.bCommentSelectListC(bo_num);
			Gson jobj = new GsonBuilder().create();
			bocJson = jobj.toJson(bocList);
		}

		System.out.println("[세훈] @게시판 댓글 조회 컨트롤러 bocJson : " + bocJson);

		out.println(bocJson);
		out.flush();
		out.close();
	}

	// 게시판 댓글 달기
	@RequestMapping(value = "/bocWrite")
	public void bocWrite(Model md, HttpServletRequest req, HttpServletResponse res, HttpSession ses, Client cl) {
		cl = (Client) ses.getAttribute("client");
		String cl_nickName = cl.getNickname();
		String cl_num = cl.getCl_num();
		String bo_num = req.getParameter("getBoNum");
		String co_cont = req.getParameter("getBocCont");

		System.out.println("[세훈] @게시판 댓글 등록 컨트롤러 bo_num : " + bo_num);
		System.out.println("[세훈] @게시판 댓글 등록 컨트롤러 boc_cont : " + co_cont);
		System.out.println("[세훈] @게시판 댓글 등록 컨트롤러 cl_num : " + cl_num);
		System.out.println("[세훈] @게시판 댓글 등록 컨트롤러 cl_nickName : " + cl_nickName);

		if (co_cont != null && co_cont != "" && bo_num != null && bo_num != "") {
			B_comment bComment = new B_comment();

			bComment.setClNum(cl_num);
			bComment.setClNickName(cl_nickName);
			bComment.setBoNum(bo_num);
			bComment.setCoCont(co_cont.replaceAll("\n", "<br>"));

			System.out.println("[세훈] @게시판 댓글 등록 컨트롤러 bComment : " + bComment.toString());
			bCommentService.bCommentInsert(bComment);
		}

		// 알림 인서트
		// 댓글 작성자 말고 글번호로 댓글이 작성된 글의 글쓴이를 찾아옴
		String origClNum = "";
		origClNum = noticeService.getOrigClNum(bo_num);
		System.out.println("origClNum" + origClNum);

		// insert를 위한 notice vo에 필요한 값들 set해주기
		Notice notice = new Notice();
		notice.setNotReceiver(origClNum);
		notice.setRefNum(bo_num); // 여기서는 참고번호가 글번호

		int result = 0;
		result = noticeService.inBoard(notice);

		if (result == 1) {
			System.out.println("댓글 작성시 알림 인서트 성공!");
		} else {
			System.out.println("알림 인서트 실패");
		}
	}
	
	// 게시판 댓글 삭제
	@RequestMapping(value = "/bcdelete")
	@ResponseBody
	public void bcdelete(String co_num, String bo_num) {
		
		System.out.println("[세훈] @게시판 댓글 삭제 컨트롤러 co_num : " + co_num);
		System.out.println("[세훈] @게시판 댓글 삭제 컨트롤러 bo_num : " + bo_num);
		int bocDelResult = bCommentService.bCommentDelete(co_num, bo_num);
		
		if(bocDelResult > 0) {
			System.out.println("게시판 댓글 삭제 성공");
		} else {
			System.out.println("게시판 댓글 삭제 실패");
		}
		
	}
	
	// 게시판 댓글 수정
	@RequestMapping(value = "/bcupdate")
	@ResponseBody
	public void bcupdate(String co_num, String bo_num, String contVal) {
		
		System.out.println("[세훈] @게시판 댓글 수정 컨트롤러 co_num : " + co_num);
		System.out.println("[세훈] @게시판 댓글 수정 컨트롤러 contVal : " + contVal);
		
		String co_cont = contVal;
		
		B_comment bComment = new B_comment();
		
		bComment.setCoNum(co_num);
		bComment.setCoCont(co_cont);
		
		int bocUpdResult = bCommentService.bCommentUpdate(bComment);
		
		if(bocUpdResult > 0) {
			System.out.println("게시판 댓글 수정 성공");
		} else {
			System.out.println("게시판 댓글 수정 실패");
		}
		
	}
	
	//	리뷰 조회
	@ResponseBody
	@RequestMapping(value = "/rList")
	public void rList(
			HttpServletRequest req
			,HttpServletResponse res
			,String bp_id
			,int type
			,int p
			,Pagination page
			) throws IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json; charset=UTF-8");
		
		System.out.println("[세훈] @리뷰 조회 컨트롤러 bp_id : " + bp_id);
		System.out.println("[세훈] @리뷰 조회 컨트롤러 type : " + type);
		System.out.println("[세훈] @리뷰 조회 컨트롤러 p : " + p);
		
		int total = reviewService.getRevCount(bp_id);
		System.out.println("[세훈] @리뷰 조회 컨트롤러 total : " + total);
		page = new Pagination(total, p, LIMIT);
		
		PrintWriter out = res.getWriter();
		String rvJson = "";
		
		List<Review> rList = new ArrayList<Review>();
		
		if(rList != null) {
			if(type == 1) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("start", Integer.toString(page.getStart()));
				map.put("end", Integer.toString(page.getEnd()));
				map.put("bpId", bp_id);
				
				rList = reviewService.revRevcSelectListDesc(map);
				
				Map<String, Object> mapResult = new HashMap<String, Object>();
				mapResult.put("paging", page);
				mapResult.put("list", rList);
				
				Gson jobj = new GsonBuilder().create();
				rvJson = jobj.toJson(mapResult);
				
			} else if(type == 2) {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("start", Integer.toString(page.getStart()));
				map.put("end", Integer.toString(page.getEnd()));
				map.put("bpId", bp_id);
				
				rList = reviewService.revRevcSelectListAsc(map);
				
				Map<String, Object> mapResult = new HashMap<String, Object>();
				mapResult.put("paging", page);
				mapResult.put("list", rList);
				
				Gson jobj = new GsonBuilder().create();
				rvJson = jobj.toJson(mapResult);
				
			} else {
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("start", Integer.toString(page.getStart()));
				map.put("end", Integer.toString(page.getEnd()));
				map.put("bpId", bp_id);
				
				rList = reviewService.revRevcSelectListUpToDate(map);
				
				Map<String, Object> mapResult = new HashMap<String, Object>();
				mapResult.put("paging", page);
				mapResult.put("list", rList);
				
				Gson jobj = new GsonBuilder().create();
				rvJson = jobj.toJson(mapResult);
			}
		}

		System.out.println("[세훈] @게시판 댓글 조회 컨트롤러 bocJson : " + rvJson);

		out.println(rvJson);
		out.flush();
		out.close();
//		return rvJson;
	}
	

	// 리뷰 작성
	@RequestMapping(value = "/rwrite")
	public String rwrite(HttpSession session
			,MultipartHttpServletRequest req
			,HttpServletResponse res
			,Client cl
			,@RequestParam(name = "revCont") String revCont, @RequestParam(name = "selectedVal") int revVal
			,Model md
			){
		res.setContentType("text/html; charset=utf-8");
		System.out.println("리뷰 등록 컨트롤러 진입");
		cl = (Client) session.getAttribute("client");

		String cl_num = cl.getCl_num();
		String clNickName = cl.getNickname();
		String har_num = req.getParameter("har_num");
		String har_name = req.getParameter("har_name");
		String har_rnum = req.getParameter("har_rname");

		System.out.println("리퀘스트 겟 파라메타" + req.getParameter("selectedVal"));
		System.out.println("[세훈] @리뷰 등록 컨트롤러 har_num : " + har_num);
		System.out.println("[세훈] @리뷰 등록 컨트롤러 har_name : " + har_name);
		System.out.println("[세훈] @리뷰 등록 컨트롤러 clNum : " + cl_num);
		System.out.println("[세훈] @리뷰 등록 컨트롤러 clNickName : " + clNickName);

		Review rv = new Review();

		rv.setClNickName(clNickName);
		rv.setClNum(cl_num);
		rv.setRevCont(revCont);
		rv.setRevVal(revVal);

		// 파일업로드
		String path = req.getRealPath("/resources/uploadFile/review"); // 자징될 위치
		MultipartFile mf = req.getFile("reviewImg"); // 업로드 파라미터
		
		if(!mf.isEmpty()) {
			
			System.out.println(mf);
			UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
			String originalfileName = mf.getOriginalFilename(); // 업로드 파일 원본 이름 저장
			String saveName = uuid.toString() + "_" + originalfileName; // 저장될 이름
			File uploadFile = new File(path + "//" + saveName); // 복사될 위치
			try {
				mf.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			rv.setRevImg(saveName);
			System.out.println("[세훈] 리뷰 이미지 경로 : " + saveName);
		} else {
			String saveName = "none";
			rv.setRevImg(saveName);
			System.out.println("[세훈] 리뷰 이미지 경로 : " + saveName);
		}



		System.out.println("[세훈 ] 리뷰 등록 컨트롤러 rv : " + rv.toString());
		int result = reviewService.insertReview(rv, har_num, har_name, har_rnum);

		if(result > 0) {
			System.out.println("리뷰 등록 성공");
			md.addAttribute("msg", "리뷰 등록 성공");
			md.addAttribute("url","/mypage?cl_num="+cl_num+"");
		} else {
			System.out.println("리뷰 등록 실패");
			md.addAttribute("msg", "리뷰 등록 실패");
			md.addAttribute("url","/mypage?cl_num="+cl_num+"");
		}
		
		// 알림인서트
		Notice notice = new Notice();
		notice.setNotReceiver(cl_num);
		notice.setRefNum(har_name);

		int noticeResult = 0;
		noticeResult = noticeService.inPointSave(notice);
		if (noticeResult == 1) {
			System.out.println("리뷰 등록 시 알림 인서트 성공");
		} else {
			System.out.println("알림 인서트 실패");
		}
		
		return "common/redirect";

	}
	
	//내가 쓴 글
	@RequestMapping(value = "/myboard", method = RequestMethod.GET)
	public String myboard(String cl_num, Model model,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		
		int total = boardService.myBoardCount(cl_num);
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cl_num", cl_num);
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<Board> list = boardService.myBoardList(map); 
		
		model.addAttribute("paging", page);
		model.addAttribute("myList", list);
		
		return "/user/uMyPage/myboard";
	}
	// 내가 쓴 글 삭제
	@RequestMapping(value = "/myBoarddelete")
	@ResponseBody
	public int myBoardDelete( @RequestParam(value = "arr[]") List<String> list) {
		
		int result = boardService.myBoardDelete(list);
		return result;
	}
	
	//내가 쓴 댓글
	@RequestMapping(value = "/myreply", method = RequestMethod.GET)
	public String myreply(String cl_num, Model model,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="10") String cntPerPage
			) {
		
		int total = bCommentService.myBoardCMCount(cl_num);
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		Map<String, String> map = new HashMap<String, String>();
		map.put("cl_num", cl_num);
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<B_comment> list = bCommentService.myBoardCMList(map);
		model.addAttribute("paging", page);
		model.addAttribute("myList", list);

		return "/user/uMyPage/myreply";
	}
	
	// 내가 쓴 댓글 삭제
	@RequestMapping(value = "/mycdelete")
	@ResponseBody
	public int myCommentDelete( @RequestParam(value = "arr[]") List<String> list) {
		
		int result = bCommentService.myCommentDelete(list);
		return result;
	}

	// 유저 공지사항 리스트 조회
	@RequestMapping(value = "/UcustomerService", method = RequestMethod.GET)
	public String UcustomerService(Model md) {

		List<CustomerService> csList = null;

		csList = customerServiceService.CustomerServiceSelectListC();

		md.addAttribute("csList", csList);

		return "/user/uBoard/UcustomerService";
	}

	
	//자주묻는 질문 조회
	@RequestMapping(value = "/oftenqna", method = RequestMethod.GET)
	public String oftenqna(Locale locale, Model model, Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		int total = oftenQnaService.COftenCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		
		List<OftenQna> list = oftenQnaService.COftenQna(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", page);
		return "/user/uBoard/oftenqna";
	}

	
	
	
	@RequestMapping(value = "/mypet", method = RequestMethod.GET)
	public String mypet(Locale locale, Model model) {
		return "/user/uMyPage/mypet";
	}

	@RequestMapping(value = "/mypetRegister", method = RequestMethod.GET)
	public String mypetRegister(Locale locale, Model model) {
		return "/user/uMyPage/mypetRegister";
	}


}