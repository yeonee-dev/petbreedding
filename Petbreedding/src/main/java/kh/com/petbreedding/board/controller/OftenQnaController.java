package kh.com.petbreedding.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kh.com.petbreedding.board.model.service.OftenQnaService;
import kh.com.petbreedding.board.model.vo.OftenQna;
import kh.com.petbreedding.common.model.vo.Pagination;

@Controller
public class OftenQnaController {

	@Autowired
	private OftenQnaService oftenQnaService;
	
	//전체 목록 보여주기
	@RequestMapping("oftenQna")
	public String oftenQna(Model model, Pagination page
			,@RequestParam(value="nowPage", defaultValue ="1") String nowPage
			, @RequestParam(value="cntPerPage", defaultValue ="5") String cntPerPage
			) {
		
		int total = oftenQnaService.allOftenCount();
		page = new Pagination(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", Integer.toString(page.getStart()));
		map.put("end", Integer.toString(page.getEnd()));
		List<OftenQna> list = oftenQnaService.allOftenQna(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", page);
		return "/admin/aBoard/mOftenQna";
	}
	
	
//	자주묻는질문 등록폼
	@RequestMapping("oftenQnaWrite")
	public String oftenQnaWrite() {
		return "/admin/aBoard/mOftenQnaWrite";
	}
	//자주묻는 질문 등록 실행
	@RequestMapping("oftenQnaWriteDo")
	public String oftenQnaWriteDo(String oftenQnaTitle, String oftenQnaCont, int oftenQnaType) {
		
		OftenQna oftenQna = new OftenQna();
		oftenQna.setOf_title(oftenQnaTitle);
		oftenQna.setOf_cont(oftenQnaCont);
		oftenQna.setOf_type(oftenQnaType);
		
		oftenQnaService.insertOftenQna(oftenQna);
		
		return "/admin/aBoard/mOftenQna";
	}
	
	
}
