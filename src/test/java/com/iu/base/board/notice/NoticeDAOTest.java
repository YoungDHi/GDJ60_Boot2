package com.iu.base.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.base.board.BoardVO;

@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	void getList() throws Exception{
//		List<BoardVO> ar = noticeDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//	}
//	@Test
	void setInsert() throws Exception{
		for(int i=0;i<120;i++) {
			
		BoardVO boardVO = new NoticeVO();
		
		boardVO.setWriter("iu"+i);
		boardVO.setTitle("Insert Test"+i);
		boardVO.setContents("Insert Test"+i);
		
		int result = noticeDAO.setInsert(boardVO);
		
		if(i%10==0) {
			Thread.sleep(500);
		}
		
		}
		System.out.println("종료");
		
	}
	
//	@Test
//	void setUpdate() throws Exception{
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setNum(3L);
//		boardVO.setTitle("바뀐 제목");
//		boardVO.setContents("바뀐 내용");
//		boardVO.setWriter("바뀐 사용자");
//		
//		int result = noticeDAO.setUpdate(boardVO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	void setDelete() throws Exception{
//		BoardVO boardVO = new BoardVO();
//		
//		boardVO.setNum(2L);
//		
//		int result = noticeDAO.setDelete(boardVO);
//		
//		assertEquals(1, result);
//		
//	}

}
