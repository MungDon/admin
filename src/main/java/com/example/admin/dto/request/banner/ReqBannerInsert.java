package com.example.admin.dto.request.banner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqBannerInsert {
		private Long banner_sid; //배너관리 게시글 pk
		private String title; //제목
		private String main_content; //메인문구
		private String sub_content; //서브문구
		private String exposure_yn; //게시글 노출여부
		
}
