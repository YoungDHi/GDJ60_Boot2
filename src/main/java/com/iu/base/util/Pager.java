package com.iu.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	//검색
	//검색종류(사용할 column)
	private String kind;
	//검색어
	private String search;
	
	//Paging
	//page 번호 담을 변수
	private Long page;
	//한페이지에 보여줄 글의 갯수
	private Long perPage;
	//시작 index 번호
	private Long startRow;
	//전체 page의 갯수
	private Long totalPage;
	
	//한블럭당 출력할 번호의 갯수
	private Long perBlock;
	//curBlock의 시작번호
	private Long startNum;
	//curBlock의 끝번호
	private Long lastNum;
	
	//이전블럭 유무
	private boolean pre;
	//다음불럭 유무
	private boolean next;
	
	//시작 index 번호를 계산하는 메서드
	public void makeStartRow() {
		//page = 1, startRow=0
		//page = 2, startRow=10
		//page = 3, startRow=20
		this.startRow=(this.getPage()-1)*this.getPerPage();
	}
	
	//startNum, lastNum 계산하는 메서드
	public void makeNum(Long totalCount) {
		//1. 전체 글의 갯수 구하기
		//2. 전체 글의 갯수로 전체 페이지의 갯수 구하기
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		//3. 전체 페이지로 전체 블럭의 갯수 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.perBlock !=0) {
			totalBlock++;
		}
		//4. page 번호로 현재 블럭 번호 구하기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		//5. 현재 블럭 번호로 시작 번호와 끝번호 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		//6. 현재블럭 번호가 마지막 블럭이라면 끝번호는 전체 페이지 번호와 같음
		if(curBlock==totalBlock) {
			lastNum=totalPage;
			this.next=true;
		}
		//7. 이전 블럭, 다음블럭 가능한지 유무
		if(curBlock==1) {
			this.pre=true;
		}
	}
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage=10L;
		}
		return this.perPage;
	}
	
	public Long getPage() {
		if(this.page == null || this.page == 0) {
			this.page=1L;
		}
		return this.page;
	}
	
	public Long getPerBlock() {
		if(this.perBlock == null || this.perBlock<1) {
			this.perBlock=5L;
		}
		return this.perBlock;
	}
	
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return this.search;
	}

}
