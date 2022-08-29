package com.yyw.community.mycommunity.service;

import com.yyw.community.mycommunity.dto.FollowFanDTO;
import com.yyw.community.mycommunity.entity.FollowFan;
import com.yyw.community.mycommunity.entity.FollowFanExample;
import com.yyw.community.mycommunity.mapper.FollowFanExtMapper;
import com.yyw.community.mycommunity.mapper.FollowFanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/21
 */
@Service
public class FollowFanService {
    @Autowired
    private FollowFanExtMapper followFanExtMapper;

    @Autowired
    private FollowFanMapper followFanMapper;

    public Integer insert(FollowFan followFan) {
        FollowFanExample followFanExample = new FollowFanExample();
        followFanExample.createCriteria().andFollowIdEqualTo(followFan.getFollowId()).andFanIdEqualTo(followFan.getFanId());
        List<FollowFan> record = followFanMapper.selectByExample(followFanExample);
        if (record.size() > 0 || followFan.getFollowId().equals(followFan.getFanId())) {
            return 500;
        } else {
            int rows = followFanMapper.insert(followFan);
            if (rows != 1) {
                return 500;
            } else {
                return 200;
            }
        }
    }

    public Integer getFanCount(Long id) {
        return followFanExtMapper.selectFans(id).size();
    }

    public Integer getFollowCount(Long id) {
        return followFanExtMapper.selectFollows(id).size();
    }

    public List<FollowFanDTO> getFans(Long id) {
        return followFanExtMapper.selectFans(id);
    }

    public List<FollowFanDTO> getFollows(Long id) {
        return followFanExtMapper.selectFollows(id);
    }

    public Integer isFollowed(Long followId, Long fanId) {
        FollowFanExample followFanExample = new FollowFanExample();
        followFanExample.createCriteria().andFollowIdEqualTo(followId).andFanIdEqualTo(fanId);
        List<FollowFan> res = followFanMapper.selectByExample(followFanExample);
        if(res.size() == 0){
            return 0;
        } else {
            return 1;
        }
    }
    public Integer delete(FollowFan followFan) {
        FollowFanExample followFanExample = new FollowFanExample();
        followFanExample.createCriteria().andFollowIdEqualTo(followFan.getFollowId()).andFanIdEqualTo(followFan.getFanId());
        if (followFan.getFollowId().equals(followFan.getFanId())) {
            return 500;
        }
        int rows = followFanMapper.deleteByExample(followFanExample);
        if (rows != 1) {
            return 500;
        } else {
            return 200;
        }
    }
}
