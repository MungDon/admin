package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.admin.dto.request.member.ReqMemberInsert;
import com.example.admin.dto.response.member.ResLoginUser;
import com.example.admin.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
		private final MemberService memberService;
		/*회원가입 폼*/
		@GetMapping("")
		public String joinForm() {
			return "join";
		}
		/*회원정보 저장*/
		@PostMapping("")
		public String join( ReqMemberInsert insert) {
			memberService.userInsert(insert);
			return "redirect:/member";
		}
		
		@GetMapping("/login")
		public String loginForm() { 
			return "login";
		}
		
		@PostMapping("/login")
		public String loginUser(ReqMemberInsert loginUser,HttpServletRequest httpServletRequest) {
			ResLoginUser loginId = memberService.loginUser(loginUser);
			httpServletRequest.getSession().invalidate();
	        HttpSession session = httpServletRequest.getSession(true); 
	        session.setAttribute("member_sid",loginId.getMember_sid());
	        session.setMaxInactiveInterval(1800);//세션 30분동안 유지
	        return "redirect:/banner";
		}
		
		 
}
