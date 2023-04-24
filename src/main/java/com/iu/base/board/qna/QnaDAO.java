package com.iu.base.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.iu.base.board.BoardDAO;
import com.iu.base.board.BoardVO;

@Mapper
public interface QnaDAO extends BoardDAO {
	
	//REF UPDATE
	public int setRefUpdate(BoardVO boardVO) throws Exception;

}
