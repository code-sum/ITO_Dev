package egovframework.example.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.review.service.ReviewVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("ReviewDAO")
public class ReviewDAO extends EgovAbstractDAO{

	/* 게시판 목록 조회 */
	public List<?> SelectReviewList(ReviewVO vo) {
		return (List<?>) list("reviewDAO.SelectReviewList",vo);
	}
	
}