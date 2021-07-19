package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.OftenQnaDao;
import kh.com.petbreedding.board.model.vo.OftenQna;

@Service("oftenQnaService")
public class OftenQnaServiceImpl implements OftenQnaService{

	@Autowired
	private OftenQnaDao oftenQnaDao;

	
	@Override
	public int allOftenCount() {
		int result = -1;
		try {
			result = oftenQnaDao.allOftenCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public List<OftenQna> allOftenQna(Map<String, String> map) {
		List<OftenQna> result = null;
		try {
			result = oftenQnaDao.allOftenQna(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int insertOftenQna(OftenQna oftenQna) {
		int result = -1;
		try {
			result = oftenQnaDao.insertOftenQna(oftenQna);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int COftenCount() {
		int result = -1;
		try {
			result = oftenQnaDao.COftenCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<OftenQna> COftenQna(Map<String, String> map) {
		List<OftenQna> result = null;
		try {
			result = oftenQnaDao.COftenQna(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int BOftenCount() {
		int result = -1;
		try {
			result = oftenQnaDao.BOftenCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<OftenQna> BOftenQna(Map<String, String> map) {
		List<OftenQna> result = null;
		try {
			result = oftenQnaDao.BOftenQna(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}





}
