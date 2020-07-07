package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orm.mapper.TblBookMapper;
import com.example.orm.model.MtBook;
import com.example.orm.model.TblBook;
import com.example.orm.model.TblBookExample;
import com.example.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private TblBookMapper tblBookMapper;
	
	@Override
	public List<MtBook> getAll() {
		return null;
//		return mtBookMapper.getAll();
	}
	
	@Override
	public void addBook(TblBook book) {
		tblBookMapper.insert(book);
	}

	@Override
	public TblBook getById(String id) {
		return tblBookMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public TblBook getByIdAndFlag(String bookId) {
		TblBookExample example = new TblBookExample();
		example.createCriteria().andDeleteFlgEqualTo("0").andBookIdEqualTo(bookId);
		try {
			TblBook result = tblBookMapper.selectByExample(example).get(0);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(String id) {
		tblBookMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(TblBook book){
		int result = tblBookMapper.updateByPrimaryKey(book);
		System.out.println(result);
//		if(result == 0) throw new RuntimeException();
		return result;
	}
	

}
