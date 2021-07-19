package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import kh.com.petbreedding.board.model.vo.Review;

public interface ReviewService {
	public List<Review> reviewSelectList(Map<String, String> map); // 사업자 리뷰 조회
	public Review reviewSelectOne(String rev_num); // 사업자  모달 리뷰 조회 
	public List<Review> revRevcSelectListUpToDate(Map<String, String> map); // 상세페이지 리뷰, 댓글 조회 최신순
	public List<Review> revRevcSelectListDesc(Map<String, String> map); // 상세페이지 리뷰, 댓글 조회 별점 높은 순
	public List<Review> revRevcSelectListAsc(Map<String, String> map); // 상세페이지 리뷰, 댓글 조회 별점 낮은 순
	public int insertReview(Review rv, String har_num, String har_name, String har_rnum);
	public int getRevCount(String bp_id);	//	사업자 리뷰 개수 받아오기
	public String getRevValAvg(String bp_id); // 리뷰 평균 값 조회
}

