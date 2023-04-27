package com.iu.base.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.board.notice.NoticeVO;
import com.iu.base.member.MemberService;
import com.iu.base.member.MemberVO;
import com.iu.base.member.memberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
	
	@Autowired
	private memberDAO memberDAO;
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private MailManager mailManager;
	
//	@Scheduled(cron = "50 * * * * *")
	public void test() throws Exception {
		List<MemberVO> ar = memberDAO.getBirth();
		for(MemberVO memberVO:ar) {
			mailManager.send(memberVO.getEmail(), "생일축하", "생일축하합니다");
		}
//		NoticeVO noticeVO = new NoticeVO();
//		
//		noticeVO.setTitle("생일축하합니다");
//		StringBuffer sb = new StringBuffer();
//		
//		sb.append("오늘은 ");
//		for(MemberVO memberVO:ar) {
//			sb.append(memberVO.getName());
//			sb.append(", ");
//			
//			
//		}
//		sb.append("생일 입니다!!");
//		noticeVO.setContents(sb.toString());
//		
//		noticeVO.setWriter("ADMIN");
//		
//		noticeDAO.setInsert(noticeVO);
		
		
		
		
//		int result = memberDAO.setBirthUser();
		
//		int result = memberDAO.setEnabled();
////		List<MemberVO> ar = memberDAO.getList();
////		for(MemberVO memberVO:ar) {
////			log.error("id : {}", memberVO.getUserName());
////			if(memberDAO.getLastTime(memberVO)>=3) {
////				memberDAO.setEnabledUpdate(memberVO);
////			}
////		}
	}

}
