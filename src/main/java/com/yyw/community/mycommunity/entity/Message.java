package com.yyw.community.mycommunity.entity;

public class Message {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.creator
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.receiver
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private Long receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.content
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.status
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.gmt_create
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    private Long gmtCreate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.creator
     *
     * @return the value of message.creator
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.creator
     *
     * @param creator the value for message.creator
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.receiver
     *
     * @return the value of message.receiver
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.receiver
     *
     * @param receiver the value for message.receiver
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.content
     *
     * @return the value of message.content
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.content
     *
     * @param content the value for message.content
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.status
     *
     * @return the value of message.status
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.status
     *
     * @param status the value for message.status
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.gmt_create
     *
     * @return the value of message.gmt_create
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.gmt_create
     *
     * @param gmtCreate the value for message.gmt_create
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}