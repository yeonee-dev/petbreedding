package kh.com.petbreedding.mypage.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.com.petbreedding.mypage.model.vo.MyPoint;

public interface MyPointService {
	public List<MyPoint> myPointSelectList(MyPoint myPoint); // 포인트 조회
	
	public int CurrPointSelectOne(String clNum); // 현재 포인트 조회
	
	public int myPointUpdate(MyPoint myPoint);//포인트 사용
	
	public int myPointCancle(MyPoint myPoint); //포인트 취소
	
	
	//조회
	public List<MyPoint> myPoint3m(String clNum);
	public List<MyPoint> myPoint6m(String clNum);
	public List<MyPoint> myPoint12m(String clNum);
	public List<MyPoint> myPointDate(Map<String, String> list);
}
