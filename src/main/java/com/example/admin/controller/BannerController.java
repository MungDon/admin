package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.admin.dto.request.banner.ReqBannerInsert;
import com.example.admin.dto.response.banner.ResBannerList;
import com.example.admin.service.BannerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller					//관리자페이지는 내수준에서 아직 하기 어려운 관계로 추후 공부후 이어갈 예정
@RequiredArgsConstructor	// 개발실력 좀 더 올라갈때 까지 잠정중단~~
@RequestMapping("/banner")
public class BannerController {
	
	private final BannerService bannerService;
	/*배너관리 목록페이지*/
	@GetMapping("")
	public String bannerList(Model model){
		ResBannerList list = bannerService.bannerLists();
		model.addAttribute("banner", list);
		model.addAttribute("search", list.getKeyword());
		
		return "bannerlist";
	}
	/*배너관리등록 폼*/
	@GetMapping("/add")
	public String bannerAddForm() {
	return "banneradd";
	}
	
	/*배너관리등록*/
	@PostMapping("/add")
	public String insertBanner(ReqBannerInsert insert, HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession(false);
		if(session == null) {
			return "redirect:/admin/login";
		}
		insert.setAdmin_sid((Long)session.getAttribute("admin_sid"));
		bannerService.insertBanner(insert);
		return "redirect:/banner";
	}
}
