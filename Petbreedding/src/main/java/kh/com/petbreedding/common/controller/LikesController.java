package kh.com.petbreedding.common.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.petbreedding.common.model.service.LikesService;
import kh.com.petbreedding.common.model.vo.Likes;

@Controller
public class LikesController {
	
	@Autowired
	LikesService likeService;
	
	// 동물병원/미용실 찜하기
	@RequestMapping("/insertLikes")
	@ResponseBody
	public int insertLikes(Likes likes) {
		
		int result = likeService.insertLikes(likes);		
		return result;
		
	}
	
	// 내 찜 목록
	@RequestMapping("/myzzim")
	public String myZzim() {
		return "/user/uMyPage/myzzim";
	}
		
	//내 찜 목록 조회
	@RequestMapping("/myzzimList")
	@ResponseBody
	public List<Likes> myZzim(String cl_num) {
		List<Likes> likes = likeService.selectLikes(cl_num);
		return likes;
	}
	
	// 동물병원/미용실 찜해제
	@RequestMapping("/delLikes")
	@ResponseBody
	public int delLikes(Likes likes) {
		
		int result = likeService.delLikes(likes);
		return result;

	}
	
	//찜했니 안했니 
	@RequestMapping("clickLike")
	@ResponseBody
	public int clickLike(Likes likes) {
		
		int result = likeService.clickLike(likes);
		return result;
	}
}
