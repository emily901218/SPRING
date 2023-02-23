package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.MemberMapper;
import com.java.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public MemberVo selectOne(String id, String pw) {
		MemberVo memberVo = memberMapper.selectOne(id,pw);
		return memberVo;
	}


	
	
	
	

	
	
	
	
	
	
}
