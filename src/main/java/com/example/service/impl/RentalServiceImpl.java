package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.mapper.TblRentalMapper;
import com.example.orm.model.TblRental;
import com.example.orm.model.TblRentalExample;
import com.example.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService{
	
	@Autowired
	private TblRentalMapper tblRentalMapper;

	@Override
	public TblRental getByBookIdAndStatus(String bookId) {
		TblRentalExample example = new TblRentalExample();
		example.createCriteria().andBookIdEqualTo(bookId).andStatusEqualTo(1).andDeleteFlgEqualTo("0");
		try {
			TblRental ren = tblRentalMapper.selectByExample(example).get(0);
			return ren;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insertRental(TblRental newRental){
		tblRentalMapper.insert(newRental);
	}

	@Override
	public List<TblRental> getByBookId(String bookId) {
		TblRentalExample example = new TblRentalExample();
		example.createCriteria().andBookIdEqualTo(bookId).andStatusEqualTo(1);
		List<TblRental> rentals = tblRentalMapper.selectByExample(example);
		return rentals;
	}

	@Override
	public List<TblRental> getByMemberId(String memberId) {
		TblRentalExample example = new TblRentalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andStatusEqualTo(1);
		List<TblRental> rentals = tblRentalMapper.selectByExample(example);
		if(rentals.size() == 0) {
			return null;
		}
		return rentals;
	}

	@Override
	public TblRental getByBookIdAndMemberId(String bookId, String memberId) {
		TblRentalExample example = new TblRentalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andBookIdEqualTo(bookId).andStatusEqualTo(1);
		List<TblRental> rentals = tblRentalMapper.selectByExample(example);
		if(rentals.isEmpty()) 
			return null;
		return rentals.get(0);
	}

	@Override
	public List<String> getListBookIdByMemberId(String memberId) {
		TblRentalExample example = new TblRentalExample();
		example.createCriteria().andMemberIdEqualTo(memberId).andStatusEqualTo(1);
		List<TblRental> rentals = tblRentalMapper.selectByExample(example);
		List<String> result = new ArrayList<String>();
		for(int i=0; i<rentals.size(); i++) {
			result.add(rentals.get(i).getBookId());
		}
		return result;
	}
	
	@Override
	public void returnBook(TblRental rental) {
		tblRentalMapper.updateByPrimaryKey(rental);
	}

}
