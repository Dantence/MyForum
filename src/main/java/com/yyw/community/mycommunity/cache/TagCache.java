package com.yyw.community.mycommunity.cache;


import com.yyw.community.mycommunity.dto.TagDTO;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dantence
 * @date 2022/7/19
 */
public class TagCache {
    public static List<TagDTO> getTags() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO t1 = new TagDTO();
        t1.setCategoryName("开发相关");
        t1.setTags(Arrays.asList("Java", "Cpp", "C", "SpringBoot", "Python", "HTML", "CSS", "JavaScript", "MySQL", "golang",
                                 "node.js", "shell", "rust", "php", "asp.net", "swift", "bash", "less", "lua", "C#", "git",
                                 "github", "mysql", "redis", "mongodb", "vim", "intellij-idea", "Vue", "React"));
        tagDTOS.add(t1);

        TagDTO t2 = new TagDTO();
        t2.setCategoryName("校园");
        t2.setTags(Arrays.asList("日常", "树洞", "食堂", "宿舍", "体育馆", "图书馆", "教室", "失物招领", "交易", "广告", "活动", "竞赛", "课程",
                                 "考研", "就业", "论文", "教程"));
        tagDTOS.add(t2);

        TagDTO t3 = new TagDTO();
        t3.setCategoryName("科技");
        t3.setTags(Arrays.asList("科技", "前沿"));
        tagDTOS.add(t3);

        TagDTO t4 = new TagDTO();
        t4.setCategoryName("历史");
        t4.setTags(Arrays.asList("历史", "历史观"));
        tagDTOS.add(t4);

        TagDTO t5 = new TagDTO();
        t5.setCategoryName("政治");
        t5.setTags(Arrays.asList("政治", "二十大"));
        tagDTOS.add(t5);

        TagDTO t6 = new TagDTO();
        t6.setCategoryName("军事");
        t6.setTags(Arrays.asList("武器", "陆军", "海军", "空军"));
        tagDTOS.add(t6);

        TagDTO t7 = new TagDTO();
        t7.setCategoryName("音乐");
        t7.setTags(Arrays.asList("音乐", "音乐风格"));
        tagDTOS.add(t7);

        TagDTO t8 = new TagDTO();
        t8.setCategoryName("游戏");
        t8.setTags(Arrays.asList("游戏", "游戏类型"));
        tagDTOS.add(t8);

        TagDTO t9 = new TagDTO();
        t9.setCategoryName("书籍");
        t9.setTags(Arrays.asList("书籍", "书籍类型"));
        tagDTOS.add(t9);

        TagDTO t10 = new TagDTO();
        t10.setCategoryName("情感");
        t10.setTags(Arrays.asList("情感", "心理"));
        tagDTOS.add(t10);

        TagDTO t11 = new TagDTO();
        t11.setCategoryName("娱乐");
        t11.setTags(Arrays.asList("娱乐圈", "吃瓜"));
        tagDTOS.add(t11);

        TagDTO t12 = new TagDTO();
        t12.setCategoryName("影视");
        t12.setTags(Arrays.asList("电影", "电视剧", "综艺"));
        tagDTOS.add(t12);

        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String [] splitTag = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = getTags();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        return Arrays.stream(splitTag).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
    }
}
