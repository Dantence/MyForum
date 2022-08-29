package com.yyw.community.mycommunity.mapper;

import com.yyw.community.mycommunity.dto.FollowFanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/21
 */
public interface FollowFanExtMapper {
    List<FollowFanDTO> selectFans(Long id);

    List<FollowFanDTO> selectFollows(Long id);
}
