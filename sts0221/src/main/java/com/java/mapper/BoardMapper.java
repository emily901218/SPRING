package com.java.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.java.vo.BoardVo;

@Mapper//sqlSessionTemplate
public interface BoardMapper {
	
	public List<BoardVo> selectBoardList(int startrow, int endrow);

	public int selectCount();

	public BoardVo selectOne(int bno);
	
	//조회숭 1증가
	public void updateBhitUp(int bno);

	//파일첨부 게시글 저장
	public void insertBoard(BoardVo boardVo);

	//게시글 수정
	public void updateBoard(BoardVo boardVo);

	//게시글 삭제
	public void deleteBoard(int bno);

	//게시글 답변달기
	public void insertReply(BoardVo boardVo);

	//게시글 답변달기 step 1증가
	public void updateReplyStepUp(BoardVo boardVo);

	
	
}
