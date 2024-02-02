package com.example.admin.dto.response.banner;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ResBannerList {
	
		private Long banner_sid; 						//배너게시글 PK
		private String title;								//배너 제목
		private String main_content;					//메인 내용
		private String sub_content;					//서브내용
		private Date start_date;						//시작날짜
		private Date end_date;							//끝나는날짜
		private String exposure_yn;					//노출여부
		private String delete_yn;						//삭제여부
		private LocalDateTime created_date;	//생성일자
		

}
