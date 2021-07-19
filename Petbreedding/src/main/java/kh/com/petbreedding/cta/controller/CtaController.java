package kh.com.petbreedding.cta.controller;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.cta.model.service.CtaService;
import kh.com.petbreedding.cta.model.vo.Cta;
import kh.com.petbreedding.cta.model.vo.CtaPay;

@Controller
@RequestMapping("/cta/*")
public class CtaController {
	
	@Autowired
	private CtaService ctaService;
	
	
	//울트라콜 페이지 조회
	@RequestMapping("cta")
	public ModelAndView ctalist(
			HttpSession session,
			HttpServletResponse res
			) throws Exception {
		BPartner vo = (BPartner) session.getAttribute("bP");
		CtaPay pay = new CtaPay();
		System.out.println("view ctrl들어옴");
		String bp_Id =  vo.getBp_Id();
		System.out.println(bp_Id);
		List<Cta> list = ctaService.listAll();
		System.out.println("db갔다옴");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("bPartner/bSales/cta");
		mav.addObject("list", list);
		mav.addObject("cta", ctaService.mycta(bp_Id));
		return mav;
	}
	//울트라콜 결제 페이지 조회
	@RequestMapping(value="ctapay", method = RequestMethod.GET)
	public ModelAndView ctapay(
			@RequestParam String CM_TYPE,
			HttpSession session
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bPartner/bSales/ctaPay");
		mav.addObject("vo", ctaService.read(CM_TYPE));
		return mav;
	}
	//ajax로 결제정보 저장
	@RequestMapping(value="ctapaydata", method = RequestMethod.POST)
	public String ctapaydata(
			CtaPay pay,
			HttpSession session,
			HttpServletResponse res
			) throws Exception {
		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id =  vo.getBp_Id();
		
		//울트라콜 기존에 있는지 조회하기 위해 존재
		CtaPay cta = null;
		cta = ctaService.mycta(bp_id);
		
		ctaService.mycta(bp_id);
		
		ctaService.insertpay(pay);
		//울트라콜 충전 이력이 없으면 처음 insert
		if(cta == null) {
			ctaService.insertCta(pay);
			System.out.println("mycta 없음 ctrl");
		//이미 충전 이력이 있다면 콜수 업데이트 
		}else {
			System.out.println("이미있음");
			//update문 
			 ctaService.updatecta(pay);
		}
		return "";
	}
	
	//울트라콜 1씩 차감 
	@RequestMapping("ctadel")
	public String delcta(
			HttpSession session,
			HttpServletResponse res
			) throws Exception{
		BPartner vo = (BPartner) session.getAttribute("bP");
		String bp_id =  vo.getBp_Id();
		System.out.println("ctadel ctrl 들어옴");
		ctaService.delcta(bp_id);
		
		return "redirect:cta";
	}
	
	//울트라콜 결제완료시
		@RequestMapping(value = "/successCta", method = RequestMethod.GET)
		public String successPay(Locale locale, Model model) {
			return "bPartner/bSales/ctasuccess";
		}
	

}
