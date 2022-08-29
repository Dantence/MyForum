package com.yyw.community.mycommunity.cache;

import com.mysql.jdbc.StringUtils;
import com.yyw.community.mycommunity.dto.TagDTO;

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
        t1.setCategoryName("编程");
        t1.setTags(Arrays.asList("Java", "Cpp", "SpringBoot", "Python", "HTML", "CSS", "JavaScript", "MySQL", "golang",
                                 "node.js", "shell", "rust", "php", "asp.net", "swift", "bash", "less", "lua", "C#"));
        tagDTOS.add(t1);

        TagDTO t2 = new TagDTO();
        t2.setCategoryName("校园");
        t2.setTags(Arrays.asList("食堂", "宿舍", "体育馆", "图书馆", "教室", "失物招领", "交易", "广告", "活动", "竞赛", "课程", "考研", "就业", "树洞"));
        tagDTOS.add(t2);

        TagDTO t3 = new TagDTO();
        t3.setCategoryName("科技");
        t3.setTags(Arrays.asList("核电", "芯片", "航天"));
        tagDTOS.add(t3);

        TagDTO t4 = new TagDTO();
        t4.setCategoryName("历史");
        t4.setTags(Arrays.asList("中国历史", "世界历史", "欧洲历史", "历史观"));
        tagDTOS.add(t4);

        TagDTO t5 = new TagDTO();
        t5.setCategoryName("政治");
        t5.setTags(Arrays.asList("十九大", "二十大"));
        tagDTOS.add(t5);

        TagDTO t6 = new TagDTO();
        t6.setCategoryName("军事");
        t6.setTags(Arrays.asList("航空母舰", "坦克", "战斗机", "军事理论"));
        tagDTOS.add(t6);

        TagDTO t7 = new TagDTO();
        t7.setCategoryName("音乐");
        t7.setTags(Arrays.asList("电音", "说唱", "摇滚", "欧美歌曲", "国语歌曲"));
        tagDTOS.add(t7);

        TagDTO t8 = new TagDTO();
        t8.setCategoryName("游戏");
        t8.setTags(Arrays.asList("原神", "王者荣耀", "我的世界", "英雄联盟", "明日方舟"));
        tagDTOS.add(t8);

        TagDTO t9 = new TagDTO();
        t9.setCategoryName("书籍");
        t9.setTags(Arrays.asList("小说", "散文", "专业书籍"));
        tagDTOS.add(t9);

        TagDTO t10 = new TagDTO();
        t10.setCategoryName("情感");
        t10.setTags(Arrays.asList("两性交往", "心理", "人际交往"));
        tagDTOS.add(t10);

        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        List<String> splitTag = StringUtils.split(tags, ",", true);
        List<TagDTO> tagDTOS = getTags();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        return splitTag.stream().filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
    }
}
