package com.example.admin.dto.request.member;

import lombok.Data;

@Data
public class ReqMemberInsert {
		
		private Long member_sid;			//회원PK
		
		private String email;					//회원 이메일
		
		private String password;				//회원 비밀번호
		
		private String password_chk;		//회원 비밀번호
		
		private String nick_name;			//회원명
		
}
