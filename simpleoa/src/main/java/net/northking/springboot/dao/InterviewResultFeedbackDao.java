package net.northking.springboot.dao;

import net.northking.springboot.entities.InterviewResultFeedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InterviewResultFeedbackDao {
    void insertResult(@Param("emps") List<InterviewResultFeedback> emps);

    List<InterviewResultFeedback> selectByUserId(String startTime, String endTime);
}
