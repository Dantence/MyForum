package com.yyw.community.mycommunity.entity;

public class UserHobby {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_hobby.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_hobby.user_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_hobby.hobby_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer hobbyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_hobby.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_hobby.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_hobby.id
     *
     * @return the value of t_user_hobby.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_hobby.id
     *
     * @param id the value for t_user_hobby.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_hobby.user_id
     *
     * @return the value of t_user_hobby.user_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_hobby.user_id
     *
     * @param userId the value for t_user_hobby.user_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_hobby.hobby_id
     *
     * @return the value of t_user_hobby.hobby_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getHobbyId() {
        return hobbyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_hobby.hobby_id
     *
     * @param hobbyId the value for t_user_hobby.hobby_id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_hobby.gmt_create
     *
     * @return the value of t_user_hobby.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_hobby.gmt_create
     *
     * @param gmtCreate the value for t_user_hobby.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_hobby.gmt_modified
     *
     * @return the value of t_user_hobby.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_hobby.gmt_modified
     *
     * @param gmtModified the value for t_user_hobby.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}