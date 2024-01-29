package com.example.admin.enums;

public enum Role {
	SUPER("1","메인관리자"),ADMIN("2", "서브관리자");
	
	 private final String code;
	 private final String code_name;
	 
	 Role(String code, String code_name){
		 this.code = code;
		 this.code_name = code_name;
	 }
}
