package egovframework.example.region.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.region.service.RegionService;
import egovframework.example.region.service.RegionVO;
import egovframework.example.review.service.ReviewVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service
public class RegionServiceImpl implements RegionService {
	
	// Set logger
	private final Logger logger = LogManager.getLogger(this.getClass());
		
	// Get class name for logger
	private final String className = this.getClass().toString();

	@Autowired
	private RegionMapper regionMapper;
	
	/** 광역시도별 약국 개수 */
	@Override
	public List<RegionVO> pharmacybyregion(Map<String, Object> paramMap) throws Exception {
		return regionMapper.pharmacybyregion(paramMap);
	}
	
	/** 전체 약국 개수 */
	/*
	@Override
	public int counttotal(Map<String, Object> paramMap) throws Exception {
		return regionMapper.counttotal(paramMap);
	}
	*/

}