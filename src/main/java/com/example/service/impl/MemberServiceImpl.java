package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.mapper.TblMemberMapper;
import com.example.orm.model.TblMember;
import com.example.orm.model.TblMemberExample;
import com.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private TblMemberMapper tblMemberMapper;
	
	@Override
	public TblMember getById(String id) {
		TblMember member = tblMemberMapper.selectByPrimaryKey(id);
		if(member == null || member.getDeleteFlg().equals("1")) {
			return null;
		}
		return member;
	}

	@Override
	public void addMember(TblMember member) {
		tblMemberMapper.insertSelective(member);
	}

	@Override
	public void deleteById(TblMember member) {
		tblMemberMapper.updateByPrimaryKey(member);
	}

	@Override
	public void updateById(TblMember member) {
		tblMemberMapper.updateByPrimaryKey(member);
	}

	@Override
	public List<TblMember> getAll() {
		TblMemberExample example = new TblMemberExample();
		List<TblMember> list = tblMemberMapper.selectByExample(example);
		return list;
	}

}
