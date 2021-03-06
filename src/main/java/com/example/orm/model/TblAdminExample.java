package com.example.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblAdminExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public TblAdminExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andAdminIdIsNull() {
			addCriterion("admin_id is null");
			return (Criteria) this;
		}

		public Criteria andAdminIdIsNotNull() {
			addCriterion("admin_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdminIdEqualTo(String value) {
			addCriterion("admin_id =", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotEqualTo(String value) {
			addCriterion("admin_id <>", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdGreaterThan(String value) {
			addCriterion("admin_id >", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
			addCriterion("admin_id >=", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdLessThan(String value) {
			addCriterion("admin_id <", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdLessThanOrEqualTo(String value) {
			addCriterion("admin_id <=", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdLike(String value) {
			addCriterion("admin_id like", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotLike(String value) {
			addCriterion("admin_id not like", value, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdIn(List<String> values) {
			addCriterion("admin_id in", values, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotIn(List<String> values) {
			addCriterion("admin_id not in", values, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdBetween(String value1, String value2) {
			addCriterion("admin_id between", value1, value2, "adminId");
			return (Criteria) this;
		}

		public Criteria andAdminIdNotBetween(String value1, String value2) {
			addCriterion("admin_id not between", value1, value2, "adminId");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameIsNull() {
			addCriterion("admin_family_name is null");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameIsNotNull() {
			addCriterion("admin_family_name is not null");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameEqualTo(String value) {
			addCriterion("admin_family_name =", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameNotEqualTo(String value) {
			addCriterion("admin_family_name <>", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameGreaterThan(String value) {
			addCriterion("admin_family_name >", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameGreaterThanOrEqualTo(String value) {
			addCriterion("admin_family_name >=", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameLessThan(String value) {
			addCriterion("admin_family_name <", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameLessThanOrEqualTo(String value) {
			addCriterion("admin_family_name <=", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameLike(String value) {
			addCriterion("admin_family_name like", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameNotLike(String value) {
			addCriterion("admin_family_name not like", value, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameIn(List<String> values) {
			addCriterion("admin_family_name in", values, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameNotIn(List<String> values) {
			addCriterion("admin_family_name not in", values, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameBetween(String value1, String value2) {
			addCriterion("admin_family_name between", value1, value2, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFamilyNameNotBetween(String value1, String value2) {
			addCriterion("admin_family_name not between", value1, value2, "adminFamilyName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameIsNull() {
			addCriterion("admin_fisrt_name is null");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameIsNotNull() {
			addCriterion("admin_fisrt_name is not null");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameEqualTo(String value) {
			addCriterion("admin_fisrt_name =", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameNotEqualTo(String value) {
			addCriterion("admin_fisrt_name <>", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameGreaterThan(String value) {
			addCriterion("admin_fisrt_name >", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameGreaterThanOrEqualTo(String value) {
			addCriterion("admin_fisrt_name >=", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameLessThan(String value) {
			addCriterion("admin_fisrt_name <", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameLessThanOrEqualTo(String value) {
			addCriterion("admin_fisrt_name <=", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameLike(String value) {
			addCriterion("admin_fisrt_name like", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameNotLike(String value) {
			addCriterion("admin_fisrt_name not like", value, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameIn(List<String> values) {
			addCriterion("admin_fisrt_name in", values, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameNotIn(List<String> values) {
			addCriterion("admin_fisrt_name not in", values, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameBetween(String value1, String value2) {
			addCriterion("admin_fisrt_name between", value1, value2, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andAdminFisrtNameNotBetween(String value1, String value2) {
			addCriterion("admin_fisrt_name not between", value1, value2, "adminFisrtName");
			return (Criteria) this;
		}

		public Criteria andRegistIdIsNull() {
			addCriterion("regist_id is null");
			return (Criteria) this;
		}

		public Criteria andRegistIdIsNotNull() {
			addCriterion("regist_id is not null");
			return (Criteria) this;
		}

		public Criteria andRegistIdEqualTo(String value) {
			addCriterion("regist_id =", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdNotEqualTo(String value) {
			addCriterion("regist_id <>", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdGreaterThan(String value) {
			addCriterion("regist_id >", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdGreaterThanOrEqualTo(String value) {
			addCriterion("regist_id >=", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdLessThan(String value) {
			addCriterion("regist_id <", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdLessThanOrEqualTo(String value) {
			addCriterion("regist_id <=", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdLike(String value) {
			addCriterion("regist_id like", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdNotLike(String value) {
			addCriterion("regist_id not like", value, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdIn(List<String> values) {
			addCriterion("regist_id in", values, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdNotIn(List<String> values) {
			addCriterion("regist_id not in", values, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdBetween(String value1, String value2) {
			addCriterion("regist_id between", value1, value2, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistIdNotBetween(String value1, String value2) {
			addCriterion("regist_id not between", value1, value2, "registId");
			return (Criteria) this;
		}

		public Criteria andRegistDateIsNull() {
			addCriterion("regist_date is null");
			return (Criteria) this;
		}

		public Criteria andRegistDateIsNotNull() {
			addCriterion("regist_date is not null");
			return (Criteria) this;
		}

		public Criteria andRegistDateEqualTo(Date value) {
			addCriterion("regist_date =", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateNotEqualTo(Date value) {
			addCriterion("regist_date <>", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateGreaterThan(Date value) {
			addCriterion("regist_date >", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateGreaterThanOrEqualTo(Date value) {
			addCriterion("regist_date >=", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateLessThan(Date value) {
			addCriterion("regist_date <", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateLessThanOrEqualTo(Date value) {
			addCriterion("regist_date <=", value, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateIn(List<Date> values) {
			addCriterion("regist_date in", values, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateNotIn(List<Date> values) {
			addCriterion("regist_date not in", values, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateBetween(Date value1, Date value2) {
			addCriterion("regist_date between", value1, value2, "registDate");
			return (Criteria) this;
		}

		public Criteria andRegistDateNotBetween(Date value1, Date value2) {
			addCriterion("regist_date not between", value1, value2, "registDate");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIsNull() {
			addCriterion("update_id is null");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIsNotNull() {
			addCriterion("update_id is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateIdEqualTo(String value) {
			addCriterion("update_id =", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotEqualTo(String value) {
			addCriterion("update_id <>", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdGreaterThan(String value) {
			addCriterion("update_id >", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdGreaterThanOrEqualTo(String value) {
			addCriterion("update_id >=", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLessThan(String value) {
			addCriterion("update_id <", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLessThanOrEqualTo(String value) {
			addCriterion("update_id <=", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdLike(String value) {
			addCriterion("update_id like", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotLike(String value) {
			addCriterion("update_id not like", value, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdIn(List<String> values) {
			addCriterion("update_id in", values, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotIn(List<String> values) {
			addCriterion("update_id not in", values, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdBetween(String value1, String value2) {
			addCriterion("update_id between", value1, value2, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateIdNotBetween(String value1, String value2) {
			addCriterion("update_id not between", value1, value2, "updateId");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNull() {
			addCriterion("update_date is null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIsNotNull() {
			addCriterion("update_date is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateDateEqualTo(Date value) {
			addCriterion("update_date =", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotEqualTo(Date value) {
			addCriterion("update_date <>", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThan(Date value) {
			addCriterion("update_date >", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("update_date >=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThan(Date value) {
			addCriterion("update_date <", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
			addCriterion("update_date <=", value, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateIn(List<Date> values) {
			addCriterion("update_date in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotIn(List<Date> values) {
			addCriterion("update_date not in", values, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateBetween(Date value1, Date value2) {
			addCriterion("update_date between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
			addCriterion("update_date not between", value1, value2, "updateDate");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNull() {
			addCriterion("delete_flg is null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNotNull() {
			addCriterion("delete_flg is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgEqualTo(String value) {
			addCriterion("delete_flg =", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotEqualTo(String value) {
			addCriterion("delete_flg <>", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThan(String value) {
			addCriterion("delete_flg >", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThanOrEqualTo(String value) {
			addCriterion("delete_flg >=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThan(String value) {
			addCriterion("delete_flg <", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThanOrEqualTo(String value) {
			addCriterion("delete_flg <=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLike(String value) {
			addCriterion("delete_flg like", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotLike(String value) {
			addCriterion("delete_flg not like", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIn(List<String> values) {
			addCriterion("delete_flg in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotIn(List<String> values) {
			addCriterion("delete_flg not in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgBetween(String value1, String value2) {
			addCriterion("delete_flg between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotBetween(String value1, String value2) {
			addCriterion("delete_flg not between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.tbl_admin
	 * @mbg.generated  Thu Oct 31 17:03:11 ICT 2019
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.tbl_admin
     *
     * @mbg.generated do_not_delete_during_merge Thu Oct 31 16:56:13 ICT 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}