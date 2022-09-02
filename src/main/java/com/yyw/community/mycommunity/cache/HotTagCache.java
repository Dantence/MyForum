package com.yyw.community.mycommunity.cache;

import com.yyw.community.mycommunity.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Dantence
 * @date 2022/9/1
 */
@Component
@Data
public class HotTagCache {

    private List<String> hots = new ArrayList<>();

    public void updateTags(Map<String, Long> tags){
        int max = 5;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);

        tags.forEach((name, value) ->{
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setValue(value);
            if(priorityQueue.size() < max) {
                priorityQueue.add(hotTagDTO);
            } else {
                HotTagDTO minHot = priorityQueue.peek();
                if(hotTagDTO.compareTo(minHot) > 0){
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }

        });
        List<String> sortedTags = new ArrayList<>();
        while(priorityQueue.size() > 0){
            sortedTags.add(0, priorityQueue.poll().getName());
        }
        hots = sortedTags;
    }
}
