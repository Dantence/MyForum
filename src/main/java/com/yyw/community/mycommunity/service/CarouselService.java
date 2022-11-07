package com.yyw.community.mycommunity.service;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import com.yyw.community.mycommunity.entity.Carousel;
import com.yyw.community.mycommunity.entity.CarouselExample;
import com.yyw.community.mycommunity.enums.CarouselStatusEnum;
import com.yyw.community.mycommunity.mapper.CarouselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.service
 * @className: CarouselService
 * @author: Dantence
 * @description: 轮播图服务类
 * @date: 2022/11/7 15:55
 * @version: 1.0
 */
@Service
public class CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    public List<Carousel> list(){
        CarouselExample carouselExample = new CarouselExample();
        carouselExample.createCriteria().andStatusEqualTo(CarouselStatusEnum.IN_USE.getStatus());
        return carouselMapper.selectByExample(carouselExample);
    }
}
