package com.example.admin.dto.request.admin;

import lombok.Data;

@Data
public class ReqAdminInsert {
		
		private Long admin_sid;			//관리자PK
		
		private String email;					//관리자 이메일
		
		private String password;				//관리자 비밀번호
		
		private String password_chk;		//관리자 비밀번호
		
		private String admin_name;			//관리자명
		
}
