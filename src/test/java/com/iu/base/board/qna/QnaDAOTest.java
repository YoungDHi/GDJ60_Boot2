package com.iu.base.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;
import com.iu.base.util.Pager;

@SpringBootTest
class QnaDAOTest {

	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
//	void getList() throws Exception {
//		Pager pager = new Pager();
//		pager.makeStartRow();
//		pager.makeNum(qnaDAO.getTotalCount(pager));
//		List<BoardVO> ar=qnaDAO.getList(pager);
//		assertNotEquals(0, ar.size());
//	}
	@Test
	void setInset() throws Exception {
		
		for(int i=0;i<120;i++) {
			
		
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("Young"+i);
		boardVO.setContents("Insert Test"+i);
		boardVO.setWriter("Insert Test"+i);
		
		int result=qnaDAO.setInsert(boardVO);
		if(i%10==0) {
			Thread.sleep(500);
		}
		}
		
		System.out.println("종료");
		
	}
	
//	@Test
//	void setUpdate() throws Exception {
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setNum(2L);
//		boardVO.setTitle("test2");
//		boardVO.setWriter("test2");
//		boardVO.setContents("test2");
//		
//		int result = qnaDAO.setUpdate(boardVO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	void setDelete() throws Exception {
//		
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setNum(1L);
//		
//		int result = qnaDAO.setDelete(boardVO);
//		
//		assertEquals(1, result);
//		
//	}

}
