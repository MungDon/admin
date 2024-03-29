package com.example.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.admin.dto.request.banner.ReqBannerInsert;
import com.example.admin.dto.response.banner.ResBanner;
import com.example.admin.dto.response.banner.ResBannerList;
import com.example.admin.mapper.BannerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService {
		
		private final BannerMapper bannerMapper;
		
		@Transactional
		public void insertBanner(ReqBannerInsert insert) {
			bannerMapper.insertBanner(insert);
		}
		
		@Transactional(readOnly = true)
		public ResBannerList bannerLists(){
			List<ResBanner> banner = bannerMapper.bannerList();
			ResBannerList list = new ResBannerList();
			list.setList(banner);
			return list;
		}
}
