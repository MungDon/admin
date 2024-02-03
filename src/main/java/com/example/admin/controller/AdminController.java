package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.admin.dto.request.admin.ReqAdminInsert;
import com.example.admin.dto.response.admin.ResLoginAdmin;
import com.example.admin.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
		private final AdminService adminService;
		/*회원가입 폼*/
		@GetMapping("")
		public String joinForm() {
			return "join";
		}
		/*관리자정보 저장*/
		@PostMapping("")
		public String join( ReqAdminInsert insert) {
			adminService.adminInsert(insert);
			return "redirect:/admin/login";
		}
		/*관리자 로그인 폼*/
		@GetMapping("/login")
		public String loginForm() { 
			return "login";
		}
		/*관리자 로그인*/
		@PostMapping("/login")
		public String loginAdmin(ReqAdminInsert loginAdmin,HttpServletRequest httpServletRequest) {
			ResLoginAdmin loginId = adminService.loginAdmin(loginAdmin);
			httpServletRequest.getSession().invalidate();
	        HttpSession session = httpServletRequest.getSession(true); 
	        session.setAttribute("admin_sid",loginId.getAdmin_sid());
	        session.setAttribute("admin_name", loginId.getAdmin_name());
	        session.setMaxInactiveInterval(1800);//세션 30분동안 유지
	        return "redirect:/banner";
		}
		
		 @DeleteMapping("/logout")
		 @ResponseBody
		 public void logoutAdmin(HttpServletRequest httpServletRequest) {
			 HttpSession session = httpServletRequest.getSession(false);
			 if(session != null) {
				session.invalidate();
			 }
		 }
}
