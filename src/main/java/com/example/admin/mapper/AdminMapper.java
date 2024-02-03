package com.example.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.admin.dto.request.admin.ReqAdminInsert;
import com.example.admin.dto.response.admin.ResEmailNameChk;
import com.example.admin.dto.response.admin.ResLoginAdmin;

@Mapper
public interface AdminMapper {
	/*회원가입*/	
	void insertAdmin(ReqAdminInsert insert);
	
	/*이메일 체크*/
	ResEmailNameChk emailChk(ReqAdminInsert insert); 
	
	/*회원명*/
	ResEmailNameChk nameChk(ReqAdminInsert insert);
	
	/*로그인*/
	ResLoginAdmin loginAdmin(ReqAdminInsert insert);
	
		
}
