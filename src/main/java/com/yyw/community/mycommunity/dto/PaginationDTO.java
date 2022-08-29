package com.yyw.community.mycommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dantence
 * @date 2022/7/7
 */

/**
 * 原本是JS处理这些数据，thymeleaf弱化了JS
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private List<Integer> pageList = new ArrayList<>();
    private Integer currentPage;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = totalCount / size;
        if(totalCount % size != 0){
            totalPage++;
        }
        Integer start = page - 1;
        Integer end = page + 1;
        Integer listSize = 0;
        Integer maxListSize = 7;
        this.pageList.add(page);
        while(start >= 1 && listSize < maxListSize / 2){
            this.pageList.add(0, start);
            listSize++;
            start--;
        }
        listSize = 0;
        while(end <= totalPage && listSize < maxListSize / 2){
            pageList.add(end);
            listSize++;
            end++;
        }
        this.currentPage = page;
        this.totalPage = totalPage;

    }
}
