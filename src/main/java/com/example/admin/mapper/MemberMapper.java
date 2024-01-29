package com.example.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.admin.dto.request.member.ReqMemberInsert;
import com.example.admin.dto.response.member.ResEmailNameChk;
import com.example.admin.dto.response.member.ResLoginUser;

@Mapper
public interface MemberMapper {
	/*회원가입*/	
	void insertUser(ReqMemberInsert insert);
	
	/*이메일 체크*/
	ResEmailNameChk emailChk(ReqMemberInsert insert );
	
	/*회원명*/
	ResEmailNameChk nameChk(ReqMemberInsert insert);
	
	/*로그인*/
	ResLoginUser loginUser(ReqMemberInsert insert);
	
		
}
