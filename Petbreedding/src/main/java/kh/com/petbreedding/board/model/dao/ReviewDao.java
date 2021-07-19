package kh.com.petbreedding.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.petbreedding.board.model.vo.Review;

@Repository("reviewDao")
public class ReviewDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 리뷰 시퀀스 번호 받아오기
	public String getRevNumFromSeq() {
		return sqlSession.selectOne("Review.getRevNumFromSeq");
	}
	
	// 상세페이지 리뷰, 댓글 조회 최신순
	public List<Review> revRevcSelectListUpToDate(Map<String, String> map) {
		return sqlSession.selectList("Review.revRevcSelectListUpToDate", map);
	}
	// 상세페이지 리뷰, 댓글 조회 별점 높은 순
	public List<Review> revRevcSelectListDesc(Map<String, String> map) {
		return sqlSession.selectList("Review.revRevcSelectListDescStar", map);
	}
	// 상세페이지 리뷰, 댓글 조회 별점 낮은 순
	public List<Review> revRevcSelectListAsc(Map<String, String> map) {
		return sqlSession.selectList("Review.revRevcSelectListAscStar", map);
	}
	
	// 사업자 리뷰 조회
	public List<Review> reviewSelectList(Map<String, String> map) {
		System.out.println("[세훈] @리뷰 조회 다오 bp_id : " + map);
		return sqlSession.selectList("Review.reviewSelectList", map);
	}
	
	// 사업자 리뷰 조회 모달 리뷰 정보 조회
	public Review reviewSelectOne(String rev_num) {
		System.out.println("[세훈] @사업자 리뷰 조회 다오 bp_id : " + rev_num);
		return sqlSession.selectOne("Review.reviewSelectOne", rev_num);
	}
	
	// 리뷰 등록
	public int insertReview(Review rv) {
		return sqlSession.insert("Review.insertReview", rv);
	}
	
	// 미용실 번호, 병원 번호 har_num 을 가지고 사업자 번호 bp_id 읽어오기
	public String searchBpId(String har_num) {
		return sqlSession.selectOne("Shop.searchBpId", har_num);
	}
	
	// 사업자 리뷰 리스트 개수 받아오기
	public int getRevCount(String bp_id) {
		return sqlSession.selectOne("Review.getRevCount", bp_id);
	}
	
	// 리뷰 댓글 여부 체크 업데이트
	public int updateCmntChk(String rev_num) {
		return sqlSession.update("Review.updateCmntChk", rev_num);
	}
	
	// 미용실 리뷰 작성 여부 업데이트
	public int updateHarResChk(String har_rnum) {
		return sqlSession.update("Review.updateHarResChk", har_rnum);
	}
	
	// 병원 리뷰 작성 여부 업데이트
	public int updateHosResChk(String hos_rnum) {
		return sqlSession.update("Review.updateHosResChk", hos_rnum);
	}
	
	// 리뷰 평균 값 조회
	public String getRevValAvg(String bp_id) {
		return sqlSession.selectOne("Review.getRevValAvg", bp_id);
	}
	
	
	
}
