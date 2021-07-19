package kh.com.petbreedding.Shop.model.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.Shop.model.service.ReservationService;
import kh.com.petbreedding.Shop.model.service.ShopPayService;
import kh.com.petbreedding.Shop.model.vo.HairShopReservation;
import kh.com.petbreedding.Shop.model.vo.HospitalReservation;
import kh.com.petbreedding.bmypage.model.vo.HairSalon;
import kh.com.petbreedding.bmypage.model.vo.Hospital;
import kh.com.petbreedding.bmypage.model.vo.MedicalType;
import kh.com.petbreedding.bmypage.model.vo.Style;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.ClientInfoService;
import kh.com.petbreedding.mypage.model.service.MyPointService;
import kh.com.petbreedding.mypage.model.service.NoticeService;
import kh.com.petbreedding.mypage.model.vo.MyPet;
import kh.com.petbreedding.mypage.model.vo.Notice;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService revService;
	
	@Autowired
	private ClientInfoService clientInfoService;
	
	@Autowired
	private MyPointService myPointService;
	
	@Autowired
	private NoticeService noticeService;
	
	//미용실 예약하기
	@RequestMapping(value = "shopReservation", method = RequestMethod.GET)
	public String revList(Locale locale, String har_num, Model model, String cl_num) {

		List<Style> list = revService.revList(har_num);
		List<MyPet> list2 = revService.revList2(cl_num);
		List<Style> list3 = revService.revList3(har_num);
				
		model.addAttribute("style", list);
		model.addAttribute("pet", list2);
		model.addAttribute("style2", list3);
		
		
		return "/user/uShop/salonReservation";
	}
	
	//미용실 예약 처리
	@RequestMapping(value="doReservation")
	@ResponseBody
	public String insertHairRev(HairShopReservation hrv) {
		
		revService.insertHairRev(hrv);
		String result = hrv.getHar_rnum();
		
		// 알림 내역에 인서트
		String cl_num = hrv.getCl_num();
		String bp_id = noticeService.getbp_id(hrv.getHar_num());
		
		if(bp_id!=null && !bp_id.equals("")) {
			Notice notice = new Notice();
			notice.setNotReceiver(cl_num);
			notice.setNotPublisher(bp_id);
			notice.setRefNum("HAR000"+result);
			
			int insertNotice = 0;
			insertNotice = noticeService.inReservaion(notice);
			
			if(insertNotice==1) {
				System.out.println("알림 인서트 성공!");
			}else {
				System.out.println("알림 인서트 실패ㅠㅠ");
			}
		}
		
		return result;
	}
	
	//미용실 결제화면
	@RequestMapping(value = "/shopPayment", method = RequestMethod.GET)
	public String shopPayment(String har_rnum, Model model, String cl_num) {

		List<HairShopReservation> list = revService.shopPayment(har_rnum);
		String result2 = clientInfoService.anotherMenu(har_rnum);
		int getPrice = clientInfoService.getPrice(har_rnum);
		
	    int point = myPointService.CurrPointSelectOne(cl_num);
	    model.addAttribute("point", point);
	
		model.addAttribute("myRev", list);
		model.addAttribute("another", result2);
		model.addAttribute("totalPrice", getPrice);
		
		
		return "/user/uShop/shopPayment";
	}
	
	//미용실 시간체크
	@RequestMapping(value="checkTime")
	@ResponseBody
	public List<String> checkTime(HairShopReservation hrv) {
		
		List<String> list = revService.checkTime(hrv);

		return list;
	}
	
	//미용실 주휴일 확인
	@RequestMapping(value="checkDayOff")
	@ResponseBody
	public List<HairSalon> checkDayOff(String har_num){
		
		List<HairSalon> list = revService.checkDayOff(har_num);
		return list;
	}
	
	/*************  병원  **************/
	//동물병원 결제화면
	@RequestMapping(value = "/shopHosPayment", method = RequestMethod.GET)
	public String shopHosPayment(String hos_rnum, Model model, String cl_num) {

		
		List<HospitalReservation> list = revService.shopPayment2(hos_rnum);
		model.addAttribute("myRev", list);
		
		int point = myPointService.CurrPointSelectOne(cl_num);
	    model.addAttribute("point", point);
		
		return "/user/uShop/HosPayment";
	}
	
	
	//병원 예약페이지
	@RequestMapping(value = "shopHosReservation", method = RequestMethod.GET)
	public String revHosList(Locale locale,  Model model, String cl_num, String hos_num) {
		
		List<MedicalType> list = revService.hosMenu(hos_num);
		List<MyPet> list2 = revService.revList2(cl_num);
		model.addAttribute("menu", list);
		model.addAttribute("pet", list2);
		
		return "/user/uShop/hosReservation";
	}
	
	
	
	//병원 예약 처리
	@RequestMapping(value="doHosReservation")
	@ResponseBody
	public String insertHosRev(HospitalReservation hos) {
		
		revService.insertHosRev(hos);
		String result = hos.getHos_rnum();
		
		// 알림 내역에 인서트
		String cl_num = hos.getCl_num();
		String bp_id = noticeService.getbp_id(hos.getHos_num());
		
		if(bp_id!=null && !bp_id.equals("")) {
			Notice notice = new Notice();
			notice.setNotReceiver(cl_num);
			notice.setNotPublisher(bp_id);
			notice.setRefNum("HOS000"+result);
			
			int insertNotice = 0;
			insertNotice = noticeService.inReservaion(notice);
			
			if(insertNotice==1) {
				System.out.println("알림 인서트 성공!");
			}else {
				System.out.println("알림 인서트 실패ㅠㅠ");
			}
		}
				
		return result;
	}
	
	//병원 시간체크
	@RequestMapping(value="checkTime2")
	@ResponseBody
	public List<String> checkTime2(HospitalReservation hos) {
		
		List<String> list = revService.checkTime2(hos);

		return list;
	}
	
	//미용실 주휴일 확인
	@RequestMapping(value="checkDayOff2")
	@ResponseBody
	public List<Hospital> checkDayOff2(String hos_num){
		System.out.println("!!!!!!!!!!hos_num!!!!!!!!!!!! "+hos_num);
		
		List<Hospital> list = revService.checkDayOff2(hos_num);
		return list;
	}
}
