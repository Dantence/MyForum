package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.Notification;
import com.yyw.community.mycommunity.entity.NotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NotificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    long countByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insert(Notification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insertSelective(Notification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Notification> selectByExampleWithRowbounds(NotificationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Notification> selectByExample(NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    Notification selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExampleSelective(@Param("record") Notification record, @Param("example") NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExample(@Param("record") Notification record, @Param("example") NotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKeySelective(Notification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKey(Notification record);
}