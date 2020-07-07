package com.example.orm.mapper;

import com.example.orm.model.MtBook;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MtBookMapper {

//	@Select("SELECT * FROM mt_book")
	public List<MtBook> getAll();
	
	public void insertBook(MtBook book);

	public MtBook getById(String id);

	public void deleteById(String id);

	public void updateById(MtBook book);
}