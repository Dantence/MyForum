package com.yyw.community.mycommunity.schedule;

import com.yyw.community.mycommunity.cache.HotTagCache;
import com.yyw.community.mycommunity.entity.Post;
import com.yyw.community.mycommunity.entity.PostExample;
import com.yyw.community.mycommunity.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Dantence
 * @date 2022/9/1
 * 每个标签的热度评估值 = 5 *问题数 + 3 *收藏数 + 2 *回复数
 */
@Component
@Slf4j
public class HotTagTasks {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void hotTagSchedule() {
        List<Post> list = new ArrayList<>();
        Map<String, Long> tagValue = new HashMap<>();
        list = postMapper.selectByExample(new PostExample());
        for (Post post : list) {
            String [] tags = StringUtils.split(post.getTag(), ",");
            for (String tag : tags) {
                Long value = tagValue.get(tag);
                Long delta = 5 + 3 * post.getLikesCount() + 2 * post.getCommentCount();
                if (value != null) {
                    tagValue.put(tag, value + delta);
                } else {
                    tagValue.put(tag, delta);
                }
            }
        }
        hotTagCache.updateTags(tagValue);
    }
}
