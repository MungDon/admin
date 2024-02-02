package com.example.admin.controller;

import java.util.List;

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

@Controller
@RequiredArgsConstructor
@RequestMapping("/banner")
public class BannerController {
	
	private final BannerService bannerService;
	/*배너관리 목록페이지*/
	@GetMapping("")
	public String bannerList(Model model){
		List<ResBannerList> bannerList = bannerService.bannerLists();
		model.addAttribute("list", bannerList);
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
		HttpSession session= httpServletRequest.getSession(false);
		  if(session == null) {
			  return "redirect;/member/login";
		  }
		bannerService.insertBanner(insert);
		return "redirect:/banner";
	}
}
