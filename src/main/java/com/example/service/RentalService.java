package com.example.service;

import java.util.List;

import com.example.orm.model.TblRental;

public interface RentalService {

	TblRental getByBookIdAndStatus(String bookId);

	void insertRental(TblRental newRental);
	
	List<TblRental> getByBookId(String bookId);
	
	List<TblRental> getByMemberId(String memberId);
	
	List<String> getListBookIdByMemberId(String memberId);

	TblRental getByBookIdAndMemberId(String bookId, String memberId);

	void returnBook(TblRental rental);

}
