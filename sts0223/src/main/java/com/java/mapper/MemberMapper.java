package com.java.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.MemberVo;

@Mapper
public interface MemberMapper {

	public MemberVo selectOne();

	public MemberVo selectOne(String id, String pw);


}
