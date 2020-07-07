package com.example.orm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.orm.model.TblBook;
import com.example.orm.model.TblBookExample;

@Mapper
public interface TblBookMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	long countByExample(TblBookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int deleteByExample(TblBookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int deleteByPrimaryKey(String bookId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int insert(TblBook record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int insertSelective(TblBook record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	List<TblBook> selectByExample(TblBookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	TblBook selectByPrimaryKey(String bookId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int updateByExampleSelective(@Param("record") TblBook record, @Param("example") TblBookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int updateByExample(@Param("record") TblBook record, @Param("example") TblBookExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int updateByPrimaryKeySelective(TblBook record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_book
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	int updateByPrimaryKey(TblBook record);
}