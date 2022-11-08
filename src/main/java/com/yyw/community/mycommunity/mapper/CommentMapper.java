package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.Comment;
import com.yyw.community.mycommunity.entity.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    long countByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int insertSelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Comment> selectByExampleWithRowbounds(CommentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    Comment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_comment
     *
     * @mbg.generated Wed Nov 09 01:52:56 CST 2022
     */
    int updateByPrimaryKey(Comment record);
}