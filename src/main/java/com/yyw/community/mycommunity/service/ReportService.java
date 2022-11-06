package com.yyw.community.mycommunity.service;/**
 * @author Dantence
 * @description:
 * @date 2022/11/7
 */

import com.yyw.community.mycommunity.entity.Report;
import com.yyw.community.mycommunity.enums.ReportStatusEnum;
import com.yyw.community.mycommunity.exception.CustomizeErrorCodeImpl;
import com.yyw.community.mycommunity.exception.CustomizeException;
import com.yyw.community.mycommunity.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: MyCommunity
 * @package: com.yyw.community.mycommunity.service
 * @className: ReportService
 * @author: Dantence
 * @description: 举报服务类
 * @date: 2022/11/7 0:07
 * @version: 1.0
 */
@Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;

    /**
     * @author Dantence
     * @description 插入举报信息
     * @date 2022/11/7 0:43
     */
    public void doReport(Long reportUserId, Long reportPostId, Long userId, String reason){
        Report report = new Report();
        report.setReportUserId(reportUserId);
        report.setReportPostId(reportPostId);
        report.setUserId(userId);
        report.setReason(reason);
        report.setStatus(ReportStatusEnum.NOT_HANDLED.getStatus());
        report.setGmtCreate(System.currentTimeMillis());
        report.setGmtModified(System.currentTimeMillis());
        int rows = reportMapper.insert(report);
        if (rows != 1) {
            throw new CustomizeException(CustomizeErrorCodeImpl.SYSTEM_ERROR);
        }
    }
}
