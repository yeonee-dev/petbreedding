package kh.com.petbreedding.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.petbreedding.client.model.vo.Client;
import kh.com.petbreedding.mypage.model.service.MyPetService;
import kh.com.petbreedding.mypage.model.vo.MyPet;

@Controller
public class MyPetController {

	@Autowired
	private MyPetService myPetService;

	// 마이펫 수첩 메인 페이지 + 정보 불러오기
	@RequestMapping("openMyPet")
	public String openMyPet(HttpSession session) {
		// TODO
		return "user/uMyPage/mypetRegister";
	}

	// 새 동물 등록하기
	@RequestMapping(value = "addmypet", method = RequestMethod.POST)
	public String addMyPet(MultipartHttpServletRequest request) throws Exception {
		MyPet mypet = new MyPet();
		mypet.setCl_num(request.getParameter("cl_num"));
		mypet.setDislike(request.getParameter("dislike"));
		mypet.setKneecap(request.getParameter("kneecap"));
		mypet.setPet_birth(request.getParameter("pet_birth"));
		mypet.setPet_bite(request.getParameter("pet_bite"));
		mypet.setPet_exper(request.getParameter("pet_exper"));
		mypet.setPet_gen(request.getParameter("pet_gen"));
		mypet.setPet_kind(request.getParameter("pet_kind"));
		mypet.setPet_name(request.getParameter("pet_name"));
		mypet.setPet_neut(request.getParameter("pet_neut"));
		mypet.setPet_others(request.getParameter("pet_others"));
		mypet.setPet_vaccin(request.getParameter("pet_vaccin"));
		mypet.setPet_weight(request.getParameter("pet_weight"));

		// 파일업로드
		MultipartFile mf = request.getFile("pet_img"); // 업로드 파라미터
		String path = request.getRealPath("/resources/uploadFile/mypet"); // 자징될 위치
		UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
		String fileName = mf.getOriginalFilename(); // 업로드 파일 원본 이름 저장
		String saveName = uuid.toString() + "_" + fileName; // 저장될 이름
		File uploadFile = new File(path + "//" + saveName); // 복사될 위치
		try {
			mf.transferTo(uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		mypet.setPet_img(saveName);

		myPetService.insertPetInfo(mypet);
		return "redirect:petlist";

	}

	// 반려동물 목록 불러오기
	@RequestMapping("petlist")
	public ModelAndView MyPet(HttpSession session, HttpServletResponse res) throws Exception {
		System.out.println("컨트롤러들어옴");

		Client vo = (Client) session.getAttribute("client");
		String cl_num = vo.getCl_num();
		ModelAndView mav = new ModelAndView();

		if (cl_num == null) {
			System.out.println("로그인 안됨");
		} else {

			List<MyPet> list = myPetService.eachPetInfo(cl_num);
			System.out.println("db들고옴");
			mav.setViewName("user/uMyPage/mypet");
			mav.addObject("list", list);
		}
		// 모델앤뷰
		return mav;

	}

	// 반려동물 상세보기
	@RequestMapping(value = "mypetupdate", method = RequestMethod.GET)
	public String MyPetUpdate(MyPet mypet, Model model) throws Exception {
		System.out.println("업데이트 뷰 컨트롤러들어옴");

		model.addAttribute("list", myPetService.read(mypet.getPet_num()));
		return "user/uMyPage/mypetUpdate";

	}

	// 반려동물 정보 수정
	@RequestMapping(value = "petupdate", method = RequestMethod.POST)
	public String UpdateMyPet(MultipartHttpServletRequest request) throws Exception {
		System.out.println("펫 업데이트 들어옴 ");

		MyPet mypet = new MyPet();
		mypet.setDislike(request.getParameter("dislike"));
		mypet.setKneecap(request.getParameter("kneecap"));
		mypet.setPet_birth(request.getParameter("pet_birth"));
		mypet.setPet_bite(request.getParameter("pet_bite"));
		mypet.setPet_exper(request.getParameter("pet_exper"));
		mypet.setPet_gen(request.getParameter("pet_gen"));
		mypet.setPet_kind(request.getParameter("pet_kind"));
		mypet.setPet_name(request.getParameter("pet_name"));
		mypet.setPet_neut(request.getParameter("pet_neut"));
		mypet.setPet_others(request.getParameter("others"));
		mypet.setPet_vaccin(request.getParameter("pet_vaccin"));
		mypet.setPet_num(request.getParameter("pet_num"));
		mypet.setPet_weight(request.getParameter("pet_weight"));
		
		// 파일업로드
		MultipartFile mf = request.getFile("pet_img"); // 업로드 파라미터
		String path = request.getRealPath("/resources/uploadFile/mypet"); // 자징될 위치
		UUID uuid = UUID.randomUUID(); // 랜덤 숫자 생성
		String fileName = mf.getOriginalFilename(); // 업로드 파일 원본 이름 저장
		String saveName = uuid.toString() + "_" + fileName; // 저장될 이름
		File uploadFile = new File(path + "//" + saveName); // 복사될 위치
		try {
			mf.transferTo(uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		mypet.setPet_img(saveName);


		myPetService.updatePetInfo(mypet);
		return "redirect:petlist";
	}
//	


	// 반려동물 정보 삭제
	@RequestMapping(value = "deletepet", method = RequestMethod.POST)
	public String resvCancel(MyPet mypet) throws Exception {
		System.out.println("반려동물 ctrl 들어옴");

		myPetService.deletePetInfo(mypet.getPet_num());
		return "redirect:petlist";

	}
	
	//멍비티아이
	
	@RequestMapping(value = "mbtipet", method = RequestMethod.GET)
	public String mbti() throws Exception {
		return "user/uMyPage/dogmbti";

	}
	

}
