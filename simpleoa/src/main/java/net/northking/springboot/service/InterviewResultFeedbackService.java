package net.northking.springboot.service;

import com.github.pagehelper.PageInfo;
import net.northking.springboot.entities.InterviewResultFeedback;

import java.util.List;

public interface InterviewResultFeedbackService {
    /**
     * 根据用户id查询访谈结果详情
     * @param userIdList
     * @return
     */
    PageInfo<InterviewResultFeedback> findResultByUserId(int pageNum, int pageSize,String startTime, String endTime);

    List<InterviewResultFeedback> findDownloadResult(String startTime, String endTime);
}
