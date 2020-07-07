package com.example.service;

import java.util.List;

import com.example.orm.model.TblMember;

public interface MemberService {
	TblMember getById(String id);
	void addMember(TblMember member);
	void updateById(TblMember member);
	void deleteById(TblMember member);
	List<TblMember> getAll();
}
