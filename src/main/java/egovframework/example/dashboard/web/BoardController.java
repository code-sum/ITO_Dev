package egovframework.example.dashboard.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.dashboard.service.BoardService;
import egovframework.example.dashboard.service.BoardVO;


@Controller
@RequestMapping("/dashboard/")
public class BoardController {
		
	@Autowired
	private BoardService boardService;
	
	// Set logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    // Get class name for logger
    private final String className = this.getClass().toString();
	
	
	/**
	 * 대시보드 초기화면 
	 */
	@RequestMapping("mainIndex.do")
	public String mainIndex(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
	      
	      logger.info("+ Start " + className + ".mainIndex");
	      logger.info("   - paramMap : " + paramMap);
	      
	      logger.info("+ End " + className + ".mainIndex");

	      return "dashboard/boardList";
	   }
	
	
	/** 
	 * 약국 목록 조회
	 */
	@RequestMapping("boardlist.do")
	public String boardlist(Model model, @RequestParam Map<String, Object> paramMap, HttpServletRequest request,
	         HttpServletResponse response, HttpSession session) throws Exception {
		
		logger.info("+ Start " + className + ".boardlist");
        logger.info("   - paramMap : " + paramMap);
		
        int pagenum = Integer.parseInt((String) paramMap.get("pagenum"));
        int pageSize = Integer.parseInt((String) paramMap.get("pageSize"));
        int pageindex = (pagenum - 1) * pageSize;
        
        paramMap.put("pageSize", pageSize);
        paramMap.put("pageindex", pageindex);
        
        List<BoardVO> boardsearchlist = boardService.boardlist(paramMap);
        int totalcnt = boardService.countboardlist(paramMap);
        
        model.addAttribute("boardsearchlist", boardsearchlist);
        model.addAttribute("totalcnt", totalcnt);
        
        logger.info("+ End " + className + ".boardlist");

        return "dashboard/boardListGrd";
	}
	
}