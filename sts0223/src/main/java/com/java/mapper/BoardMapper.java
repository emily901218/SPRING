package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.BoardVo;

@Mapper
public interface BoardMapper {


	public List<BoardVo> selectBoardList(int startrow, int endrow);
	public int selectCount();

}
