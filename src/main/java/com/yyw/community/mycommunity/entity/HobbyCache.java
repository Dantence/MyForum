package com.yyw.community.mycommunity.entity;

public class HobbyCache {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.id
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.key
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private Long key;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.hobby_name
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private String hobbyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.interested_num
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private Integer interestedNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.gmt_create
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_hobby_cache.gmt_modified
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.id
     *
     * @return the value of t_hobby_cache.id
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.id
     *
     * @param id the value for t_hobby_cache.id
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.key
     *
     * @return the value of t_hobby_cache.key
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public Long getKey() {
        return key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.key
     *
     * @param key the value for t_hobby_cache.key
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setKey(Long key) {
        this.key = key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.hobby_name
     *
     * @return the value of t_hobby_cache.hobby_name
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public String getHobbyName() {
        return hobbyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.hobby_name
     *
     * @param hobbyName the value for t_hobby_cache.hobby_name
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName == null ? null : hobbyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.interested_num
     *
     * @return the value of t_hobby_cache.interested_num
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public Integer getInterestedNum() {
        return interestedNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.interested_num
     *
     * @param interestedNum the value for t_hobby_cache.interested_num
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setInterestedNum(Integer interestedNum) {
        this.interestedNum = interestedNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.gmt_create
     *
     * @return the value of t_hobby_cache.gmt_create
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.gmt_create
     *
     * @param gmtCreate the value for t_hobby_cache.gmt_create
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_hobby_cache.gmt_modified
     *
     * @return the value of t_hobby_cache.gmt_modified
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_hobby_cache.gmt_modified
     *
     * @param gmtModified the value for t_hobby_cache.gmt_modified
     *
     * @mbg.generated Mon Nov 07 01:03:49 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}