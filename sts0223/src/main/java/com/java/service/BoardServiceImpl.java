package com.java.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.BoardMapper;
import com.java.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	
	@Autowired
	BoardMapper boardMapper;
	
	
	@Override//전체게시글 가져오기
	public Map<String, Object> selectBoardList(int page) {
		//페이지 page,전체개수 pageCount...listCount,maxpage,startpage,endpage,startrow,endrow
		
		HashMap<String, Object> map = pageMethod(page);
		int startrow = (int)map.get("startrow");
		int endrow = (int)map.get("endrow");
		
		//전체게시글 가져오기
		List<BoardVo> list = boardMapper.selectBoardList(startrow,endrow);
		map.put("list", list);
		map.put("page", page);
		map.put("listCount", map.get("listCount"));
		map.put("maxpage", map.get("maxpage"));
		map.put("startpage", map.get("startpage"));
		map.put("endpage", map.get("endpage"));
		
		return map;
	}//selectBoardList
	
	
	
	private HashMap<String, Object> pageMethod(int page) {
		
		HashMap<String, Object> map = new HashMap<>();
		int rowPerPage = 10; //1페이지당 게시글 개수
		//listCount:총개수,page:현재페이지,maxpage:최대페이지,startpage,endpage,startrow,endrow
		
		int pageList = 5;//하단넘버링 개수 
		int listCount = boardMapper.selectCount();
		int maxpage = (int)(Math.ceil((double)listCount/rowPerPage));
		int startpage = ((page-1)/pageList)*pageList+1;
		int endpage = maxpage;
		if(endpage>startpage+pageList -1) endpage = startpage +pageList-1;
		int startrow = (page-1)*rowPerPage +1;
		int endrow = startrow + rowPerPage-1;
		//-->>
		
		map.put("listCount", listCount);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		return map;
		
	}

	
	
	
	
}
