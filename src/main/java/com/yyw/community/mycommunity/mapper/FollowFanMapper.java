package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.FollowFan;
import com.yyw.community.mycommunity.entity.FollowFanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FollowFanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    long countByExample(FollowFanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int deleteByExample(FollowFanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int insert(FollowFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int insertSelective(FollowFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    List<FollowFan> selectByExampleWithRowbounds(FollowFanExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    List<FollowFan> selectByExample(FollowFanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    FollowFan selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int updateByExampleSelective(@Param("record") FollowFan record, @Param("example") FollowFanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int updateByExample(@Param("record") FollowFan record, @Param("example") FollowFanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int updateByPrimaryKeySelective(FollowFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table follow_fan
     *
     * @mbg.generated Fri Jul 22 02:20:54 CST 2022
     */
    int updateByPrimaryKey(FollowFan record);
}