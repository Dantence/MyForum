package com.yyw.community.mycommunity.entity;

public class Ads {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.title
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.url
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.image
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.gmt_start
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtStart;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.gmt_end
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtEnd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.status
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.position
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Integer position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_ads.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    private Long gmtModified;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.id
     *
     * @return the value of t_ads.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.id
     *
     * @param id the value for t_ads.id
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.title
     *
     * @return the value of t_ads.title
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.title
     *
     * @param title the value for t_ads.title
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.url
     *
     * @return the value of t_ads.url
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.url
     *
     * @param url the value for t_ads.url
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.image
     *
     * @return the value of t_ads.image
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.image
     *
     * @param image the value for t_ads.image
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.gmt_start
     *
     * @return the value of t_ads.gmt_start
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtStart() {
        return gmtStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.gmt_start
     *
     * @param gmtStart the value for t_ads.gmt_start
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtStart(Long gmtStart) {
        this.gmtStart = gmtStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.gmt_end
     *
     * @return the value of t_ads.gmt_end
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtEnd() {
        return gmtEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.gmt_end
     *
     * @param gmtEnd the value for t_ads.gmt_end
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtEnd(Long gmtEnd) {
        this.gmtEnd = gmtEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.status
     *
     * @return the value of t_ads.status
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.status
     *
     * @param status the value for t_ads.status
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.position
     *
     * @return the value of t_ads.position
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.position
     *
     * @param position the value for t_ads.position
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.gmt_create
     *
     * @return the value of t_ads.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.gmt_create
     *
     * @param gmtCreate the value for t_ads.gmt_create
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_ads.gmt_modified
     *
     * @return the value of t_ads.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_ads.gmt_modified
     *
     * @param gmtModified the value for t_ads.gmt_modified
     *
     * @mbg.generated Mon Nov 07 13:39:31 CST 2022
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}