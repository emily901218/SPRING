package com.java.service;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface BoardService {

	public Map<String, Object> selectBoardList(int page);

}
