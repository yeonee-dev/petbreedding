package kh.com.petbreedding.mypage.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.board.model.service.MyAskCommentService;
import kh.com.petbreedding.board.model.service.MyAskService;
import kh.com.petbreedding.board.model.vo.Board;
import kh.com.petbreedding.board.model.vo.MyAsk;
import kh.com.petbreedding.board.model.vo.MyAskComment;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.vo.Pagination;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;
import kh.com.petbreedding.mypage.model.service.MyPointService;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.MyPoint;
import kh.com.petbreedding.mypage.model.vo.Notice;

@Controller
public class ClientInfoCotroller {

	@Autowired
	private ClientInfoService clientInfoService;

	@Autowired
	private MyPointService myPointService;

	@Autowired
	private MyAskService myAskService;

	@Autowired
	private MyAskCommentService myAskCommentService;

	@Autowired
	private NoticeService noticeService;

	// ????????????
	@RequestMapping("/mypage")
	public String myReservationList(String cl_num, Model model) {
		if (cl_num != null) {
			List<HairShopReservation> result = clientInfoService.myReservationList(cl_num);
			int status0 = clientInfoService.status0(cl_num);
			int status1 = clientInfoService.status1(cl_num);
			int status2 = clientInfoService.status2(cl_num);
			int point = myPointService.CurrPointSelectOne(cl_num);
			model.addAttribute("myRev", result);
			model.addAttribute("status0", status0);
			model.addAttribute("status1", status1);
			model.addAttribute("status2", status2);
			model.addAttribute("point", point);
		} else {
			System.out.println("cl_num??? ??????");
		}

		return "/user/uMyPage/myReservationList";
	}

	// ????????? ?????? ??????
	@RequestMapping("/mypage2")
	@ResponseBody
	public List<HairShopReservation> myRevDateList(String cl_num, String res_date, String res_date2) {

		Map<String, String> list = new HashMap<String, String>();
		list.put("cl_num", cl_num);
		list.put("res_date", res_date);
		list.put("res_date2", res_date2);

		List<HairShopReservation> result = clientInfoService.myRevDateList(list);
		return result;
	}

	// ????????? ?????? ????????? ??????
	@RequestMapping("/revdetail")
	public String myReservationDetail(String har_rnum, Model model) {

		List<HairShopReservation> result = clientInfoService.myRevDetail(har_rnum);
		String result2 = clientInfoService.anotherMenu(har_rnum);
		int getPrice = clientInfoService.getPrice(har_rnum);

		model.addAttribute("myRev", result);
		model.addAttribute("another", result2);
		model.addAttribute("totalPrice", getPrice);

		return "/user/uMyPage/myReservationDetail";
	}

	// ????????? ?????? ??????
	@RequestMapping("/cancleRev")
	@ResponseBody
	public int cancleRev(String har_rnum, HttpSession session) {
		int result = clientInfoService.cancleRev(har_rnum);

		// ?????? ?????????
		Client client = (Client) session.getAttribute("client");
		String cl_num = client.getCl_num();
		String bp_id = noticeService.getbp_idforPay(har_rnum);

		Notice notice = new Notice();
		notice.setNotReceiver(cl_num);
		notice.setNotPublisher(bp_id);
		notice.setRefNum(har_rnum);

		int noticeResult = 0;
		noticeResult = noticeService.inCancleRev(notice);

		if (noticeResult == 1) {
			System.out.println("?????? ?????? ?????? ????????? ??????");
		} else {
			System.out.println("?????? ?????? ?????? ????????? ??????");
		}

		return result;
	}

	// ???????????? ?????? ????????? ??????
	@RequestMapping("/revdetail2")
	public String myReservationDetail2(String hos_rnum, Model model) {

		List<HospitalReservation> result = clientInfoService.myRevDetail2(hos_rnum);
		model.addAttribute("myRev", result);

		return "/user/uMyPage/myHosReservationDetail";
	}

	// ???????????? ?????? ??????
	@RequestMapping("/cancleRev2")
	@ResponseBody
	public int cancleRev2(String hos_rnum, HttpSession session) {
		int result = clientInfoService.cancleRev2(hos_rnum);

		// ?????? ?????????
		Client client = (Client) session.getAttribute("client");
		String cl_num = client.getCl_num();
		String bp_id = noticeService.getbp_idforPay(hos_rnum);

		Notice notice = new Notice();
		notice.setNotReceiver(cl_num);
		notice.setNotPublisher(bp_id);
		notice.setRefNum(hos_rnum);

		int noticeResult = 0;
		noticeResult = noticeService.inCancleRev(notice);

		if (noticeResult == 1) {
			System.out.println("?????? ?????? ?????? ????????? ??????");
		} else {
			System.out.println("?????? ?????? ?????? ????????? ??????");
		}
		return result;
	}


	// ???????????????
	@RequestMapping("/point")
	public String point(String cl_num, Model md, HttpSession session) {
		
		// ?????? ?????? ??????????????? ???????????? ???
		if(cl_num==null||cl_num.equals("")) {
			Client client = (Client) session.getAttribute("client");
			cl_num = client.getCl_num();
		}
		
		MyPoint myPoint = new MyPoint();
		myPoint.setClNum(cl_num);

		int currPoint = myPointService.CurrPointSelectOne(cl_num);

		md.addAttribute("currPoint", currPoint);

		return "/user/uMyPage/point";
	}

	// ????????? ????????? ?????? 3??????
	@RequestMapping("/pointDate")
	@ResponseBody
	public List<MyPoint> pointDate(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint3m(clNum);

		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// ????????? ????????? ?????? 6??????
	@RequestMapping("/pointDate2")
	@ResponseBody
	public List<MyPoint> pointDate2(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint6m(clNum);

		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// ????????? ????????? ?????? 12??????
	@RequestMapping("/pointDate3")
	@ResponseBody
	public List<MyPoint> pointDate3(String clNum, Model model) {

		List<MyPoint> pointList = myPointService.myPoint12m(clNum);

		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// ????????? ?????? ?????? ??????
	@RequestMapping("/pointDate4")
	@ResponseBody
	public List<MyPoint> pointDate3(String clNum, String expDate, String expDate2, Model model) {

		Map<String, String> list = new HashMap<String, String>();
		list.put("clNum", clNum);
		list.put("expDate", expDate);
		list.put("expDate2", expDate2);
		List<MyPoint> pointList = myPointService.myPointDate(list);

		model.addAttribute("pointList", pointList);

		return pointList;
	}

	// 1:1 ?????? ??????
	@RequestMapping("/mypage/ask")
	public String ask(
			HttpSession session
			,String user_num
			,Model md
			,Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {

		int total = myAskService.clBpListCount(user_num);
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.out.println("[??????] @????????? ?????? ???????????? user_num : " + user_num);

		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userNum", user_num);
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));

		List<MyAsk> myAskList = myAskService.MyAskSelectList(map);
		
		md.addAttribute("paging", page);
		md.addAttribute("myAskList", myAskList);
		md.addAttribute("user_num", user_num);
		System.out.println("[??????] @????????? ?????? ???????????? myAskList : " + myAskList);

		return "/user/uMyPage/myAsk";
	}

	// 1:1 ?????? ????????? ??????
	@RequestMapping("/mypage/askdetail")
	public String askDetail(HttpSession session, String qna_num, Model md) {

		System.out.println("[??????] @????????? ??????  ?????? ???????????? qna_num : " + qna_num);

		MyAsk myAskDetail = new MyAsk();
		MyAskComment maComment = new MyAskComment();

		myAskDetail = myAskService.MyAskSelectDetail(qna_num);
		maComment = myAskCommentService.myAskCommentSelectOneCB(qna_num);

		System.out.println("[??????] @????????? ?????? ?????? ???????????? myAskDetail : " + myAskDetail);
		System.out.println("[??????] @????????? ?????? ?????? ???????????? maComment : " + maComment);

		md.addAttribute("myAskDetail", myAskDetail);
		md.addAttribute("maComment", maComment);

		return "/user/uMyPage/myAskDetail";
	}

	// 1:1 ?????? ?????? ???
	@RequestMapping(value = "/maWriteForm")
	public String maWriteForm(Model md, String user_num) {
		md.addAttribute("user_num", user_num);
		return "/user/uMyPage/myAskRegister";
	}

	// 1:1 ?????? ??????
	@RequestMapping(value = "/maWrite")
	public String maWrite(Model md, HttpSession session, MultipartHttpServletRequest req, HttpServletResponse res,
			Client cl, BPartner bP) throws Exception {

		cl = (Client) session.getAttribute("client");
		bP = (BPartner) session.getAttribute("bP");
		
		res.setContentType("text/html; charset=utf-8");

		String user_num = req.getParameter("user_num");
		String qna_title = req.getParameter("myAskTitle");
		String qna_cont = req.getParameter("myAskCont");

		System.out.println("myAskTitle" + qna_title);
		System.out.println("myAskCont" + qna_cont);
		System.out.println("user_num" + user_num);

		MyAsk myAsk = new MyAsk();
		myAsk.setUserNum(user_num);
		myAsk.setQnaCont(qna_cont);
		myAsk.setQnaTitle(qna_title);

		// ???????????????
		MultipartFile mf = req.getFile("myAskImg"); // ????????? ????????????
		if (!mf.isEmpty()) {

			String path = req.getRealPath("/resources/uploadFile/myAsk"); // ????????? ??????
			UUID uuid = UUID.randomUUID(); // ?????? ?????? ??????
			String fileName = mf.getOriginalFilename(); // ????????? ?????? ?????? ?????? ??????
			String saveName = uuid.toString() + "_" + fileName; // ????????? ??????
			File uploadFile = new File(path + "//" + saveName); // ????????? ??????

			try {
				mf.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			myAsk.setQnaImg(saveName);

			System.out.println("[??????] ?????? ????????? ?????? : " + saveName);
		} else {
			String saveName = "none";
			myAsk.setQnaImg(saveName);
		}

		System.out.println("[?????? ]" + myAsk.toString());
		int result = myAskService.MyAskInsert(myAsk);

		if (result > 0) {
			if(cl != null) {
				System.out.println("?????? ?????? ??????");
				md.addAttribute("msg", "?????? ?????? ??????");
				md.addAttribute("url", "/mypage/ask?user_num=" + user_num + "");
			} else {
				System.out.println("?????? ?????? ??????");
				md.addAttribute("msg", "?????? ?????? ??????");
				md.addAttribute("url", "/bQna?user_num=" + user_num + "");
			}
		} else {
			if(cl != null) {
				System.out.println("?????? ?????? ??????");
				md.addAttribute("msg", "?????? ?????? ??????");
				md.addAttribute("url", "/uLogin");
			} else {
				System.out.println("?????? ?????? ??????");
				md.addAttribute("msg", "?????? ?????? ??????");
				md.addAttribute("url", "/bLogin");
			}
		}

		return "common/redirect";

	}

	// ?????? ??? ??? / ????????? BoardController

	// ???????????? LikesController

	// ?????? ?????? ????????????
	@RequestMapping("/mypage/selectClienInfo")
	public String selectClientInfo(HttpSession session) {

		return null;

	}

	// ?????? ??????
	@RequestMapping("/noticelist")
	public ModelAndView getNoticeList(ModelAndView mv, HttpSession session) {
		List<Notice> list = null;

		Client client = (Client) session.getAttribute("client");
		String cl_num = "";
		if (session != null) {
			cl_num = client.getCl_num();
			list = noticeService.getNoticeList(cl_num);
		}
		
		// ??? ?????? ?????? ???????????? ??????
		List<Notice> unreadList = noticeService.unreadNotList(cl_num);
		if(unreadList!=null) {
			for(int i=0; i<unreadList.size(); i++) {
				String notNum = unreadList.get(i).getNotNum();
				int result = 0;
				result = noticeService.updateReadState(notNum);
				if(result==1) {
					System.out.println("??? ?????? ?????? ?????? ??????!");
				}else {
					System.out.println("??? ?????? ?????? ?????? ?????? ??????");
				}
			}
		}

		mv.addObject("noticeList", list);
		mv.setViewName("/user/uMyPage/myNotice");
		return mv;
	}

	// ?????? ??????
	@RequestMapping("/notdelete.do")
	@ResponseBody
	public int noticeDelete(String notNum) {

		int result = 0;
		result = noticeService.deleteNotice(notNum);

		if (result == 1) {
			System.out.println("?????? ?????? ??????!");

		} else {
			System.out.println("?????? ?????? ??????!");
		}

		return result;
	}
	
	// ?????? ?????? ?????? ????????????
	@RequestMapping("/notification.do")
	@ResponseBody
	public int noticeRead(HttpSession session) {

		int result = 0;

			Client client = (Client) session.getAttribute("client");
			String cl_num = "";
			if (client != null) {
			cl_num = client.getCl_num();
			result = noticeService.notificationRead(cl_num);
			
			if (result!=0) {
				System.out.println("?????? ????????? ???????????? ??????!");
			} else {
				System.out.println("?????? ????????? ???????????? ??????!");
			}
		}
		return result;
	}

	// ???????????? ?????? ????????? ClientController

}