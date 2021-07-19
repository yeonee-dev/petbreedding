package kh.com.petbreedding.Shop.model.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HarPay;
import kh.com.petbreedding.Shop.model.vo.HosPay;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.MyPointService;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.MyPoint;
import kh.com.petbreedding.mypage.model.vo.Notice;

@Controller
public class ShopPayController {

	@Autowired
	private ShopPayService shopPayService;
	
	@Autowired
	private MyPointService myPointService;
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("harPay")
	@ResponseBody
	public int harPay(HarPay harPay, HttpSession session) {

		int result = shopPayService.harPay(harPay);
		
		// 알림 내역에 인서트
		Client client = (Client) session.getAttribute("client");
		
		String revNum = harPay.getHar_rnum();
		String cl_num = client.getCl_num();
		String bp_id = noticeService.getbp_idforPay(revNum);
		
		if(bp_id!=null && !bp_id.equals("")) {
			Notice notice = new Notice();
			notice.setNotReceiver(cl_num);
			notice.setNotPublisher(bp_id);
			notice.setRefNum(revNum);
			
			int insertNotice = 0;
			insertNotice = noticeService.inPay(notice);
			
			if(insertNotice==1) {
				System.out.println("알림 인서트 성공!");
			}else {
				System.out.println("알림 인서트 실패ㅠㅠ");
			}
		}

		return result;
	}
	
	//결제시 포인트 사용
	@RequestMapping("myPoint")
	@ResponseBody
	public int myPointUpdate(MyPoint myPoint, HttpSession session) {
		int result = myPointService.myPointUpdate(myPoint);
		
		// 알림 내역에 인서트
		Client client = (Client) session.getAttribute("client");
		String cl_num = client.getCl_num();
		String shopName = myPoint.getExpFrom();
		
		Notice notice = new Notice();
		notice.setNotReceiver(cl_num);
		notice.setRefNum(shopName);
		
		int noticeResult = 0;
		
		noticeResult = noticeService.inPointUsing(notice);
		
		if(noticeResult==1) {
			System.out.println("알림 인서트 성공");
		} else {
			System.out.println("알림 인서트 실패");
		}
		
		return result;
	}
	//결제취소시 포인트 롤백
	@RequestMapping("myPointCancle")
	@ResponseBody
	public int myPointCancle(MyPoint myPoint) {
		int result = myPointService.myPointCancle(myPoint);
		return result;
	}
	
	@RequestMapping("harRevUp")
	@ResponseBody
	public int harRevUp(String har_rnum) {
		int result = shopPayService.harRevUp(har_rnum);
		return result;
	}
	
	@RequestMapping("hosPay")
	@ResponseBody
	public int hosPay(HosPay hosPay, HttpSession session) {
		
		int result = shopPayService.hosPay(hosPay);
		
		// 알림 내역에 인서트
		Client client = (Client) session.getAttribute("client");
		
		String revNum = hosPay.getHos_rnum();
		String cl_num = client.getCl_num();
		String bp_id = noticeService.getbp_idforPay(revNum);
		
		if(bp_id!=null && !bp_id.equals("")) {
			System.out.println("비피아이디 잘 가져와서 들어왔죠?");
			Notice notice = new Notice();
			notice.setNotReceiver(cl_num);
			notice.setNotPublisher(bp_id);
			notice.setRefNum(revNum);
						
			int insertNotice = 0;
			insertNotice = noticeService.inPay(notice);
			
			if(insertNotice==1) {
				System.out.println("알림 인서트 성공!");
			}else {
				System.out.println("알림 인서트 실패ㅠㅠ");
			}
		}
		return result;
	}
	
	@RequestMapping("hosRevUp")
	@ResponseBody
	public int hosRevUp(String hos_rnum) {
		int result = shopPayService.hosRevUp(hos_rnum);
		return result;
	}
}
