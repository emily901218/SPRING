package com.java.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVo {

	
	private String id,pw,name,phone,gender;
	private String hobby;
	

	
	
	
}
