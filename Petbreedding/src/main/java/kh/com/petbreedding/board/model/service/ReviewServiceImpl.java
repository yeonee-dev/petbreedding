package kh.com.petbreedding.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.petbreedding.bmypage.model.dao.ShopDao;
import kh.com.petbreedding.board.model.dao.ReviewDao;
import kh.com.petbreedding.board.model.vo.Review;
import kh.com.petbreedding.mypage.model.dao.MyPointDao;
import kh.com.petbreedding.mypage.model.vo.MyPoint;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private MyPointDao myPointDao;

	// 상세페이지 리뷰, 댓글 조회
	@Override
	public List<Review> revRevcSelectListUpToDate(Map<String, String> map) {
		List<Review> revRevcListUpd = null;
		try {
			System.out.println("[세훈] @리뷰, 댓글 조회 서비스 bp_id : " + map);
			revRevcListUpd = reviewDao.revRevcSelectListUpToDate(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰, 댓글 조회 서비스 revRevcListUpd : " + revRevcListUpd);
		return revRevcListUpd;
	}
	
	//	상세페이지 리뷰, 댓글 평점 높은 순
	@Override
	public List<Review> revRevcSelectListDesc(Map<String, String> map) {
		List<Review> revRevcListDesc = null;
		try {
			System.out.println("[세훈] @리뷰, 댓글 조회 서비스 bp_id : " + map);
			revRevcListDesc = reviewDao.revRevcSelectListDesc(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰, 댓글 조회 서비스 revRevcListDesc : " + revRevcListDesc);
		return revRevcListDesc;
	}

	//	상세페이지 리뷰, 댓글 평점 낯은 순
	@Override
	public List<Review> revRevcSelectListAsc(Map<String, String> map) {
		List<Review> revRevcListAsc = null;
		try {
			System.out.println("[세훈] @리뷰, 댓글 조회 서비스 bp_id : " + map);
			revRevcListAsc = reviewDao.revRevcSelectListAsc(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰, 댓글 조회 서비스 reviewList : " + revRevcListAsc);
		return revRevcListAsc;
	}
	
	@Override
	public List<Review> reviewSelectList(Map<String, String> map) {
		List<Review> reviewList = null;
		
		try {
			System.out.println("[세훈] @리뷰 조회 서비스 bp_id : " + map);
			reviewList = reviewDao.reviewSelectList(map);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰 조회 서비스 reviewList : " + reviewList);
		return reviewList;
	}
	
	@Override
	public Review reviewSelectOne(String rev_num) {
		Review review = null;
		try {
			System.out.println("[세훈] @리뷰 조회 서비스 rev_num : " + rev_num);
			review = reviewDao.reviewSelectOne(rev_num);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[세훈] @리뷰 조회 서비스 review : " + review);
		return review;
	}

	//	리뷰 등록
	@Override
	public int insertReview(Review rv, String har_num, String har_name, String har_rnum) {
		int result = -1;
		int resultPoint = -1;
		int resChk = -1;
		
		String clNum = rv.getClNum();
		System.out.println("[세훈] @리뷰 등록 서비스 clNum : " + clNum);
		int reviewPoint = 300;
		
		try {
			System.out.println("[세훈] @리뷰 등록 서비스 har_num : " + har_num);
			String bp_id = reviewDao.searchBpId(har_num); 
			System.out.println("리뷰 등록 가져온 bp_id" + bp_id);
			System.out.println("리뷰 등록 가져온 rv" + rv);
			rv.setBpId(bp_id);
			String rev_num = reviewDao.getRevNumFromSeq();
			rv.setRevNum(rev_num);
			result = reviewDao.insertReview(rv);
			
			if(har_rnum.contains("HOS")) {
				String hos_rnum = har_rnum;
				System.out.println("[세훈] @리뷰 등록 서비스 hos_rnum : " + hos_rnum);
				resChk = reviewDao.updateHosResChk(hos_rnum);
				if(resChk > 0) {
					System.out.println("병원 리뷰 작성 여부 업데이트 성공");
				} else {
					System.out.println("병원 리뷰 작성 여부 업데이트 실패");
				}
			} else {
				System.out.println("미용실 리뷰 작성 들어왔음");
				System.out.println("[세훈] @리뷰 등록 서비스 har_rnum : " + har_rnum);
				resChk = reviewDao.updateHarResChk(har_rnum);
				
				System.out.println("[세훈] @리뷰 등록 서비스 resChk : " + resChk);
				if(resChk > 0) {
					System.out.println("미용실 리뷰 작성 여부 업데이트 성공");
				} else {
					System.out.println("미용실 리뷰 작성 여부 업데이트 실패");
				}
			}
			
			int currPoint = 0;
			currPoint = myPointDao.CurrPointSelectOne(clNum);
			System.out.println("[세훈] @리뷰 등록 서비스 currPoint : " + currPoint);
			currPoint += reviewPoint;
			
			MyPoint myPoint = new MyPoint();
			myPoint.setClNum(clNum);
			myPoint.setExpFrom(har_name);
			myPoint.setExpId(rev_num);
			myPoint.setExpType("적립");
			myPoint.setPointNum("PO4");
			myPoint.setCurrPoint(currPoint);
			myPoint.setExpPoint(reviewPoint);
			
			resultPoint = myPointDao.myPointInsert(myPoint);
			
			if(resultPoint > 0) {
				System.out.println("포인트 적립 성공 (리뷰 작성)");
			} else {
				System.out.println("포인트 적립 실패 (리뷰 작성)");
			}
			
			
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}

	//	사업자 리뷰 개수 받아오기
	@Override
	public int getRevCount(String bp_id) {
		int revcount = -1;
		
		try {
			revcount = reviewDao.getRevCount(bp_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revcount;
	}

	@Override
	public String getRevValAvg(String bp_id) {
		String revAvgResult = null;
		System.out.println("[세훈] @리뷰 평균 조회 서비스 bp_id : " + bp_id);
		
		try {
			revAvgResult = reviewDao.getRevValAvg(bp_id);
			System.out.println("[세훈] @리뷰 평균 조회 서비스 revAvgResult : " + revAvgResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revAvgResult;
	}





}
