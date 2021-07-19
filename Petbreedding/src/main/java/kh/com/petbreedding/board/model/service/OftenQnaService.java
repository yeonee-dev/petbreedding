package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.OftenQna;

public interface OftenQnaService {
	
	public int allOftenCount();
	public List<OftenQna> allOftenQna(Map<String, String> map);
	public int insertOftenQna(OftenQna oftenQna);
	
	public int COftenCount();
	public List<OftenQna> COftenQna(Map<String, String> map);
	
	public int BOftenCount();
	public List<OftenQna> BOftenQna(Map<String, String> map);
}
