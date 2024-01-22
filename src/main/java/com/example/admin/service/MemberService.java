package com.example.admin.service;

import org.springframework.stereotype.Service;

import com.example.admin.dto.request.member.ReqMemberInsert;
import com.example.admin.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
		private final MemberMapper memberMapper;
		/*회원가입*/
		public void userInsert(ReqMemberInsert insert) {
			memberMapper.insertUser(insert);
		}
}  
