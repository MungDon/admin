package com.example.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.admin.dto.request.banner.ReqBannerInsert;
import com.example.admin.dto.response.banner.ResBannerList;

@Mapper
public interface BannerMapper {
	//배너 등록
	void insertBanner(ReqBannerInsert insert);
	//배너 목록
	List<ResBannerList> bannerList();
}
