package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.Ads;
import com.yyw.community.mycommunity.entity.AdsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AdsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    long countByExample(AdsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByExample(AdsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insert(Ads record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insertSelective(Ads record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Ads> selectByExampleWithRowbounds(AdsExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Ads> selectByExample(AdsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    Ads selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExampleSelective(@Param("record") Ads record, @Param("example") AdsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExample(@Param("record") Ads record, @Param("example") AdsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKeySelective(Ads record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ads
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKey(Ads record);
}