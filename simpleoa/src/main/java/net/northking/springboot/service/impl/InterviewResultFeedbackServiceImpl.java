package net.northking.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.northking.springboot.dao.InterviewResultFeedbackDao;
import net.northking.springboot.entities.InterviewResultFeedback;
import net.northking.springboot.service.InterviewResultFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewResultFeedbackServiceImpl implements InterviewResultFeedbackService {
    @Autowired InterviewResultFeedbackDao interviewResultFeedbackDao;
    @Override
    public PageInfo<InterviewResultFeedback> findResultByUserId(int pageNum, int pageSize,String startTime, String endTime) {
        PageHelper.startPage(pageNum, pageSize);
        List<InterviewResultFeedback> lists = interviewResultFeedbackDao.selectByUserId(startTime, endTime);
        PageInfo<InterviewResultFeedback> pageInfo = new PageInfo<InterviewResultFeedback>(lists);
        return pageInfo;
    }

    @Override
    public List<InterviewResultFeedback> findDownloadResult(String startTime, String endTime) {
        List<InterviewResultFeedback> list = interviewResultFeedbackDao.selectByUserId(startTime, endTime);
        return list;
    }
}
