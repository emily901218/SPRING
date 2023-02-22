package com.java.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardVo {

	
	private int bno,bstep,bhit,bgroup,bindent,topchk;
	private String id,btitle,bcontent,bfile;
	private Timestamp bdate;
	
	
	
}
