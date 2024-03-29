package com.yyw.community.mycommunity.entity;

import java.util.ArrayList;
import java.util.List;

public class HobbyCacheExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public HobbyCacheExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyIsNull() {
            addCriterion("hobby_key is null");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyIsNotNull() {
            addCriterion("hobby_key is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyEqualTo(Long value) {
            addCriterion("hobby_key =", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyNotEqualTo(Long value) {
            addCriterion("hobby_key <>", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyGreaterThan(Long value) {
            addCriterion("hobby_key >", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyGreaterThanOrEqualTo(Long value) {
            addCriterion("hobby_key >=", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyLessThan(Long value) {
            addCriterion("hobby_key <", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyLessThanOrEqualTo(Long value) {
            addCriterion("hobby_key <=", value, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyIn(List<Long> values) {
            addCriterion("hobby_key in", values, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyNotIn(List<Long> values) {
            addCriterion("hobby_key not in", values, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyBetween(Long value1, Long value2) {
            addCriterion("hobby_key between", value1, value2, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyKeyNotBetween(Long value1, Long value2) {
            addCriterion("hobby_key not between", value1, value2, "hobbyKey");
            return (Criteria) this;
        }

        public Criteria andHobbyNameIsNull() {
            addCriterion("hobby_name is null");
            return (Criteria) this;
        }

        public Criteria andHobbyNameIsNotNull() {
            addCriterion("hobby_name is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyNameEqualTo(String value) {
            addCriterion("hobby_name =", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameNotEqualTo(String value) {
            addCriterion("hobby_name <>", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameGreaterThan(String value) {
            addCriterion("hobby_name >", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameGreaterThanOrEqualTo(String value) {
            addCriterion("hobby_name >=", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameLessThan(String value) {
            addCriterion("hobby_name <", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameLessThanOrEqualTo(String value) {
            addCriterion("hobby_name <=", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameLike(String value) {
            addCriterion("hobby_name like", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameNotLike(String value) {
            addCriterion("hobby_name not like", value, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameIn(List<String> values) {
            addCriterion("hobby_name in", values, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameNotIn(List<String> values) {
            addCriterion("hobby_name not in", values, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameBetween(String value1, String value2) {
            addCriterion("hobby_name between", value1, value2, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andHobbyNameNotBetween(String value1, String value2) {
            addCriterion("hobby_name not between", value1, value2, "hobbyName");
            return (Criteria) this;
        }

        public Criteria andInterestedNumIsNull() {
            addCriterion("interested_num is null");
            return (Criteria) this;
        }

        public Criteria andInterestedNumIsNotNull() {
            addCriterion("interested_num is not null");
            return (Criteria) this;
        }

        public Criteria andInterestedNumEqualTo(Integer value) {
            addCriterion("interested_num =", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumNotEqualTo(Integer value) {
            addCriterion("interested_num <>", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumGreaterThan(Integer value) {
            addCriterion("interested_num >", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("interested_num >=", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumLessThan(Integer value) {
            addCriterion("interested_num <", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumLessThanOrEqualTo(Integer value) {
            addCriterion("interested_num <=", value, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumIn(List<Integer> values) {
            addCriterion("interested_num in", values, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumNotIn(List<Integer> values) {
            addCriterion("interested_num not in", values, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumBetween(Integer value1, Integer value2) {
            addCriterion("interested_num between", value1, value2, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andInterestedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("interested_num not between", value1, value2, "interestedNum");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Long value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Long value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Long value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Long value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Long> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Long> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Long value1, Long value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hobby_cache
     *
     * @mbg.generated do_not_delete_during_merge Wed Nov 09 01:52:56 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_hobby_cache
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
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
}