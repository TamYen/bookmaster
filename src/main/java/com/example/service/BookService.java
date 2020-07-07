package com.example.service;

import java.util.List;

import com.example.orm.model.MtBook;
import com.example.orm.model.TblBook;


public interface BookService {

	List<MtBook> getAll();

	TblBook getById(String id);

	public void deleteById(String id);

	void addBook(TblBook book);

	int updateById(TblBook book);

	TblBook getByIdAndFlag(String bookId);
}
