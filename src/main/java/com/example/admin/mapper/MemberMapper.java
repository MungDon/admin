package com.example.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.admin.dto.request.member.ReqMemberInsert;

@Mapper
public interface MemberMapper {
	/*회원가입*/	
	void insertUser(ReqMemberInsert insert);
		
}
