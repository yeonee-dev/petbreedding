package kh.com.petbreedding.common.model.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.common.model.dao.LikesDao;
import kh.com.petbreedding.common.model.vo.Likes;


@Service("likesService")
public class LikesServiceImpl implements LikesService{

	@Autowired
	private LikesDao likesDao;

	@Override
	public int insertLikes(Likes likes) {
		int result = -1;
		try {
			result = likesDao.insertLikes(likes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Likes> selectLikes(String cl_num) {
		List<Likes> result = null;
		try {
			result = likesDao.selectLikes(cl_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delLikes(Likes likes) {
		int result = -1;
		try {
			result = likesDao.delLikes(likes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int clickLike(Likes likes) {
		int result = -1;
		try {
			result = likesDao.clickLike(likes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String countSalon(String har_num) {
		String result = null;
		try {
			result = likesDao.countSalon(har_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String countHos(String hos_num) {
		String result = null;
		try {
			result = likesDao.countHos(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
