package com.example.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.admin.dto.request.admin.ReqAdminInsert;
import com.example.admin.dto.response.admin.ResEmailNameChk;
import com.example.admin.dto.response.admin.ResLoginAdmin;
import com.example.admin.mapper.AdminMapper;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

	private final AdminMapper adminMapper;

	/* 회원가입 */
	@Transactional
	public void adminInsert(ReqAdminInsert insert) {
		ResEmailNameChk emailChk = adminMapper.emailChk(insert);
		ResEmailNameChk nameChk = adminMapper.nameChk(insert);
		try {
			if (emailChk != null) {
				throw new Exception("이메일 중복되었습니다!");
			}
			if(nameChk != null) {
				 throw new Exception("관리자명이 중복되었습니다!");
			}
			adminMapper.insertAdmin(insert);
		} catch (Exception e) {
			System.out.println("경고 :" + e.getMessage());
		}
	}
	@Transactional
	public ResLoginAdmin loginAdmin(ReqAdminInsert insert) {
		ResLoginAdmin loginChk = adminMapper.loginAdmin(insert);
			try {
				if(loginChk == null) {
				throw new Exception("이메일정보를 확인해주세요");
			}
				if(!loginChk.getPassword().equals(insert.getPassword())){
					throw new Exception("비밀번호정보를 확인해주세요");
				}
			}
			catch(Exception e){
				System.out.println("경고 :" + e.getMessage());
				e.printStackTrace();
			}
		return loginChk;
	}
}
