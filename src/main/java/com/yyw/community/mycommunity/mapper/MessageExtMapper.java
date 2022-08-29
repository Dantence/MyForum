package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/22
 */
public interface MessageExtMapper {
    List<Message> selectMessages(@Param("id1")Long id1, @Param("id2")Long id2);
}
