package com.yyw.community.mycommunity.controller;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import com.yyw.community.mycommunity.entity.User;
import com.yyw.community.mycommunity.service.ReportService;
import com.yyw.community.mycommunity.utils.commonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.controller
 * @className: ReportController
 * @author: Dantence
 * @description: 举报相关控制器
 * @date: 2022/11/7 0:06
 * @version: 1.0
 */
@Controller
@Slf4j
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping("/report")
    public String doReport(@RequestParam(name = "reportUserId")Long reportUserId,
                           @RequestParam(name = "reportPostId")Long reportPostId,
                           @RequestParam(name = "userId")Long userId,
                           @RequestParam(name = "reason")String reason,
                           HttpServletRequest request){
        User user = commonUtils.getUserFromSession(request);
        reportService.doReport(reportUserId, reportPostId, userId, reason);
        return "redirect:/post/" + reportPostId.toString();
    }

}
