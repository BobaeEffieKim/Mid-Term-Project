package com.dev.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {

	String id;
	String password;
	String name;
	Date birth;
	String gender;
	String email;
	String phone;
	String profile;
	String introduce;
	int dotori;
	
}
