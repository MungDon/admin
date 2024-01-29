package com.example.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.admin.dto.request.member.ReqMemberInsert;
import com.example.admin.dto.response.member.ResEmailNameChk;
import com.example.admin.dto.response.member.ResLoginUser;
import com.example.admin.mapper.MemberMapper;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper memberMapper;

	/* 회원가입 */
	@Transactional
	public void userInsert(ReqMemberInsert insert) {
		ResEmailNameChk emailChk = memberMapper.emailChk(insert);
		ResEmailNameChk nameChk = memberMapper.nameChk(insert);
		try {
			if (emailChk != null) {
				throw new Exception("이메일 중복되었습니다!");
			}
			if(nameChk != null) {
				 throw new Exception("회원명이 중복되었습니다!");
			}
			memberMapper.insertUser(insert);
		} catch (Exception e) {
			System.out.println("경고 :" + e.getMessage());
		}
	}
	@Transactional
	public ResLoginUser loginUser(ReqMemberInsert insert) {
		ResLoginUser login = memberMapper.loginUser(insert);
		try {
			if(login == null) {
			throw new Exception("로그인 정보가 일치하지 않습니다!");
		}
		} catch (Exception e) {
			System.out.println("경고! : " + e.getMessage());
		}
		return login;
	}
}
