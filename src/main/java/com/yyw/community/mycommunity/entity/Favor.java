package com.yyw.community.mycommunity.entity;

public class Favor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favor.id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favor.user_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favor.post_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    private Long postId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column favor.gmt_create
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    private Long gmtCreate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favor.id
     *
     * @return the value of favor.id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favor.id
     *
     * @param id the value for favor.id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favor.user_id
     *
     * @return the value of favor.user_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favor.user_id
     *
     * @param userId the value for favor.user_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favor.post_id
     *
     * @return the value of favor.post_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favor.post_id
     *
     * @param postId the value for favor.post_id
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column favor.gmt_create
     *
     * @return the value of favor.gmt_create
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column favor.gmt_create
     *
     * @param gmtCreate the value for favor.gmt_create
     *
     * @mbg.generated Fri Sep 02 11:36:27 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}