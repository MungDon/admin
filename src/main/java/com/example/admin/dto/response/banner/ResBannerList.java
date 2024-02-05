package com.example.admin.dto.response.banner;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResBannerList {
	private List<ResBanner> list;
	/*검색*/
	private String keyword;			// 제목검색
	private String status; 			// 상태검색
	private Date start_search;		// 시작날짜 검색
	private Date end_search;		// 끝나는 날짜 검색
	/*페이징*/
	private int page;				// 현재 페이지 번호
	private int data_size;			// 페이지당 출력할 데이터 갯수
	private int page_size;			// 화면하단 페이지 사이즈
	
	public ResBannerList() {
		this.page = 1;				// 객체가 생성되는 시점에 현재 페이지번호를 1로 설정
		this.data_size = 10;		// 페이지당 출력할 데이터의 갯수를 10으로 설정
		this.page_size = 10;		// 페이지 하단에 보여질 페이지 갯수 10으로 설정
	}
	
	public int getOffset() {
		return (page - 1) * data_size; //
	} 
}
