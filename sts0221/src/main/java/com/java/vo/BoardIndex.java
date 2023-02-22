package com.java.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardIndex {

	private int bno;
	private int page;
	private String searchTitle;
	private String searchWord;
}
