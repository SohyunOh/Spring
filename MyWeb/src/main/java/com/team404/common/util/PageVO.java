package com.team404.common.util;

import lombok.Data;

@Data
public class PageVO {
	//화면에 페이지네이션을 그리는 클래스
	private int startPage; //페이지네이션의 시작번호
	private int endPage; //페이지네이션의 끝번호
	private boolean prev; //이전버튼활성화여부
	private boolean next; //다음버튼활성화여부
	
	private int pageNum; //조회 페이지번호 
	private int amount; //데이터개수
	private int total; //전체게시글 수
	private Criteria cri; //페이지 기준(번호, 데이터개수)
	
	//PageVO가 생성될때 cri, total반드시 전달 되야하기 때문에 한개로 제한
	public PageVO(Criteria cri, int total) {
		//페이번호, 데이터개수, 전체게시글 수는 전달되는 값에 따라서 초기화
		this.pageNum = cri.getPageNum();
		this.amount = cri.getAmount();
		this.total = total;
		this.cri = cri;
		
		//끝페이지계산
		//사용자가 pageNum를 11번 눌렀다-> 20번, pageNum을 13번 눌렀다 -> 20번
		this.endPage = (int)Math.ceil( this.pageNum / 10.0 ) * 10; 
		//끝페이지를 이용해서 처음페이지계산
		//끝페이지가 20이면 처음페이지는 11, 끝페이지 30이면 처음페이지 21
		this.startPage = endPage - 10 + 1;
		
		//진짜 끝번호 계산
		//데이터가 60개 있다고 가정할때, pageNum 6번 누르면 끝페이지번호 6번
		//데이터가 112개 있다고 가정할때, pageNum 11번 누르면 끝페이지번호 12번
		int realEnd = (int)Math.ceil( this.total / (double)this.amount );
		
		//특정조건에서 endPage를 realEnd변경 
		//123개 게시글이 존재할때, 
		//11번클릭할때: endPage페이지 공식 -> 20, realEnd공식 -> 13
		//2번클릭할때: endPage페이지 공식-> 10, realEnd공식 -> 13
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}

		//이전버튼 활성화여부
		//startPage 1, 11, 21, 31이기 때문에 1초과면 활성화
		this.prev = startPage > 1;
		//다음버튼 활성화여부
		//조건- 진짜 끝번호가 페이지끝번호보다 큰경우 활성화
		this.next = realEnd > this.endPage;
	}
	
	//게터, 세터..
}
