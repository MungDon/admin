package com.example.admin.dto.request.banner;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqBannerInsert {
		private Long banner_sid; //배너관리 게시글 pk
		private Long admin_sid; //배너관리 게시글 pk
		private String title; //제목
		private String main_content; //메인문구
		private String sub_content; //서브문구
		private Date start_date;	//시작날짜
		private Date end_date;		//끝난날짜
		private String exposure_yn; //게시글 노출여부
		
}
