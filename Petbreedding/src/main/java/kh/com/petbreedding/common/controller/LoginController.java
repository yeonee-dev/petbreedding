package kh.com.petbreedding.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.OAuth2AccessToken;

import kh.com.petbreedding.HomeController;
import kh.com.petbreedding.Admin.model.vo.Admin;
import kh.com.petbreedding.BP.model.vo.BPartner;
import kh.com.petbreedding.client.model.service.ClientService;
import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.common.model.service.LoginService;
import kh.com.petbreedding.common.model.vo.KakaoLogin;
import kh.com.petbreedding.common.model.vo.NaverLogin;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	KakaoLogin kakaoLogin;
	/* NaverLoginBO */
	private NaverLogin naverLogin;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLogin(NaverLogin naverLogin) {
		this.naverLogin = naverLogin;
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//  ????????? ???????????? ??????
	@RequestMapping(value = "/uLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String openLogin(Locale locale, Model model, HttpSession session) {
		
		/* ????????????????????? ?????? URL??? ???????????? ????????? naverLogin???????????? getAuthorizationUrl????????? ?????? */
		String naverAuthUrl = naverLogin.getAuthorizationUrl(session);
		String kakaoUrl = KakaoLogin.getAuthorizationUrl(session);

		/* System.out.println("?????????:" + naverAuthUrl); */
		
		//?????????
		model.addAttribute("url", naverAuthUrl);
		
		// ????????? 
		model.addAttribute("kakao_url", kakaoUrl);


        
		return "/user/uMember/uLogin";
	}
	
	//  ?????????????????? ???????????? ??????
	@RequestMapping(value = "/bLogin", method = RequestMethod.GET)
	public String openbLogin(Locale locale, Model model) {
		return "/bPartner/bMember/bLogin";
	}
	
	//????????? ????????? ???????????? ??????
	@RequestMapping(value = "/mLogin", method = RequestMethod.GET)
	public String openmLogin(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
		return "/admin/aMember/mLogin";
	}
	
	// ?????? ????????? ??????
	@RequestMapping( value="/member/doLoginU", method = RequestMethod.POST)
	@ResponseBody
	public String doLoginU(Client client, HttpSession session ,HttpServletRequest req,HttpServletResponse res, RedirectAttributes rttr) {

		Client result = loginService.login(client);
		session = req.getSession();

		if(result == null) {
			System.out.println("????????? ??????");
			session.setAttribute("client", null);
			return "/uLogin";
			
		}else {
			System.out.println("????????? ??????!");
			session.setAttribute("client", result);
			return "/";
		}	
	}
	// ????????? ???????????? ?????? ???????????? ??????
	@RequestMapping(value = "/bWait")
	public String bWait(Locale locale, Model model) {
		return "/bPartner/bMember/bWait";
	}
	
	// ????????? ????????? ??????
	@RequestMapping("/member/doLoginB")
	@ResponseBody
	public String doLoginB(BPartner bP, HttpSession session ,HttpServletRequest req,HttpServletResponse res, RedirectAttributes rttr) {
		
		BPartner result = loginService.blogin(bP);
		session = req.getSession();
		
		if(result == null) {
			System.out.println("????????? ??????");
			session.setAttribute("bP", null);
			return "/bLogin";
		}else {
			System.out.println("????????? ??????!");
			session.setAttribute("bP", result);
			int bp_aprve = result.getBp_aprve();
			
			if(bp_aprve == 1) {
				return "/bReservation";
			}else {
				return "/bWait";
			}
		}
	}
	
	// ????????? ????????? ??????
	@RequestMapping("/member/doLoginM")
	@ResponseBody
	public String doLoginM(Admin admin, HttpSession session ,HttpServletRequest req,HttpServletResponse res, RedirectAttributes rttr) {
		System.out.println("admin : "+ admin);
		Admin result = loginService.mLogin(admin);
		session = req.getSession();
		System.out.println("result : "+ result);
		
		if(result == null) {
			System.out.println("????????? ??????");
			session.setAttribute("admin", null);
			return "/mLogin";
		}else {
			System.out.println("????????? ??????!");
			session.setAttribute("admin", result);
			return "/mClient";
		}
		
	}
	
	
	
	// ????????? ?????????
	@RequestMapping(value = "/kakaoLogin",produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		//???????????? node??? ?????????
		JsonNode node = KakaoLogin.getAccessToken(code);
		//accessToken??? ???????????? ????????? ????????? ????????????
		JsonNode accessToken = node.get("access_token");
		//????????? ??????
		JsonNode userInfo = KakaoLogin.getKakaoUserInfo(accessToken); 
		String email = null; 
		String nickname = null;
		
		
		// ???????????? ??????????????? ???????????? Get properties 
		JsonNode properties = userInfo.path("properties"); 
		JsonNode kakao_account = userInfo.path("kakao_account"); 
		
		System.out.println("properties : "+ userInfo);
//		System.out.println("kakao_account : "+ kakao_account);

		email = kakao_account.path("email").asText(); 
		nickname = properties.path("nickname").asText(); 
		
		int checkEmail = clientService.checkEmail(email);
		
		if(checkEmail == 0 ) { //???????????? ????????? ????????? ??????
			
			mv.addObject("email",email);
			mv.addObject("nickname", nickname);
			mv.setViewName("/user/uMember/snsJoin2");
			return mv;
			
		}else { //?????? ?????? ???????????????
			List<Client> result = loginService.selectMember(nickname);
			String cl_num = result.get(0).getCl_num();
			String name = result.get(0).getName();
			String tel = result.get(0).getTel();
			Client client = new Client();
			client.setCl_num(cl_num);
			client.setEmail(email);
			client.setName(name);
			client.setNickname(nickname);
			client.setTel(tel);
			session.setAttribute("client",client);
			mv.addObject("result", apiResult);
		}	
	
		mv.setViewName("/common/index");

		return mv;
	}
	
	
	//????????? ????????? ????????? callback?????? ?????????
	@RequestMapping(value = "naverLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverLogin.getAccessToken(session, code, state);
		
		//1. ????????? ????????? ????????? ????????????.
		apiResult = naverLogin.getUserProfile(oauthToken); //String????????? json?????????
		/* System.out.println("apiResult : "+ apiResult); */
		/** apiResult json ??????
		{"resultcode":"00",
		"message":"success",
		"response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		//2. String????????? apiResult??? json????????? ??????
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. ????????? ??????
		//Top?????? ?????? _response ??????
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		
		//response??? nickname??? ??????
		 String nickname = (String)response_obj.get("nickname");
		 String email = (String)response_obj.get("email");
		 String name = (String)response_obj.get("name");
			/* String tel = (String)response_obj.get("mobile"); */
		 System.out.println(nickname);
		 
		 int checkEmail = clientService.checkEmail(email);
		
		if(checkEmail == 0) { //???????????? ????????? ????????? ??????
			
			model.addAttribute("email",email);
			model.addAttribute("name",name);
			model.addAttribute("nickname", nickname);
			
			return "/user/uMember/snsJoin";
			
		}else { //?????? ?????? ???????????????
			List<Client> result = loginService.selectMember(nickname);
			String cl_num = result.get(0).getCl_num();
			/* String name = result.get(0).getName(); */
			String tel = result.get(0).getTel();
			Client client = new Client();
			client.setCl_num(cl_num);
			client.setEmail(email);
			client.setName(name);
			client.setNickname(nickname);
			client.setTel(tel);
			session.setAttribute("client",client);
			model.addAttribute("result", apiResult);
		}
		
		/*
		 * //4.?????? ????????? ???????????? ?????? session.setAttribute("client",response_obj); //?????? ??????
		 * model.addAttribute("result", apiResult);
		 */
		
		return "/common/index";
	}

	
	// ????????? ????????????
	@RequestMapping("/logout")
	public String logout(Client client, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	// ????????? ????????????
		@RequestMapping("/blogout")
		public String blogout(BPartner bP, HttpSession session) {
			
			session.invalidate();
			
			return "redirect:/bIndex";
			
		}
	
		// ????????? ????????????
		@RequestMapping("/mlogout")
		public String mlogout(Admin admin, HttpSession session) {
			
			session.invalidate();
			
			return "redirect:/mLogin";
			
		}
	
}
