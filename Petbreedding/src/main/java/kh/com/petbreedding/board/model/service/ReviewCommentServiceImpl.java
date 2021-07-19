package kh.com.petbreedding.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.petbreedding.board.model.dao.ReviewCommentDao;
import kh.com.petbreedding.board.model.dao.ReviewDao;
import kh.com.petbreedding.board.model.vo.ReviewComment;

@Service("reviewCommentService")
public class ReviewCommentServiceImpl implements ReviewCommentService {
	
	@Autowired
	private ReviewCommentDao reviewCommentDao;
	@Autowired
	private ReviewDao reviewDao;

	//	리뷰 댓글 등록
	@Override
	public int reviewCommentInsert(ReviewComment revCmnt) {
		int revcResult = -1;
		int revcUpd = -1;
		String rev_num = revCmnt.getRevNum();
		System.out.println("[세훈] @사업자 리뷰 댓글  등록 서비스 rev_num : " + rev_num);
		
		try {
			System.out.println("[세훈] @사업자 리뷰 댓글  등록 서비스 revCmnt : " + revCmnt);
			revcResult = reviewCommentDao.reviewCommentInsert(revCmnt);
			System.out.println("[세훈] @사업자 리뷰 댓글  등록 서비스 revcResult : " + revcResult);
			revcUpd = reviewDao.updateCmntChk(rev_num);
			if(revcUpd > 0) {
				System.out.println("리뷰 댓글 개수 체크 업데이트 성공");
			} else {
				System.out.println("리뷰 댓글 개수 체크 업데이트 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return revcResult;
	}

}
