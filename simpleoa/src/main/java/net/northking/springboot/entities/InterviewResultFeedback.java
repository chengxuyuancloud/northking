package net.northking.springboot.entities;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * interview_result_feedback
 * @author 
 */
@Data
public class InterviewResultFeedback implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    @ExcelProperty(index = 0,value = {"基础信息","姓名"})
    private String name;

    /**
     * 学历
     */
    @ExcelProperty(index = 1,value = {"基础信息","学历"})
    private String education;

    /**
     * 电话
     */
    @ExcelProperty(index = 2,value = {"基础信息","电话"})
    private String phone;

    /**
     * 期望薪资
     */
    @ExcelProperty(index = 3,value = {"基础信息","期望薪资"})
    private String expectedSalary;

    /**
     * 推荐时间
     */
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 4,value = {"基础信息","推荐时间"})
    private String recommendedTime;

    /**
     * 初筛面试时间
     */
    @ExcelProperty(index = 5,value = "面试时间")
    private String preliminaryScreeningInterviewTime;

    /**
     * 初筛反馈
     */
    @ExcelProperty(index = 6,value = {"初筛反馈","初筛反馈"})
    private String primaryScreeningFeedback;

    /**
     * 初步评价薪资
     */
    @ExcelProperty(index = 7,value = {"初筛反馈","初步评价薪资"})
    private String preliminaryEvaluationSalary;

    /**
     * 是否直录
     */
    @ExcelProperty(index = 8,value = {"初筛反馈","是否直录"})
    private String directEmployment;

    /**
     * 客户名称
     */
    @ExcelProperty(index = 9,value = {"客户反馈","客户名称"})
    private String customerName;

    /**
     * 推荐岗位
     */
    @ExcelProperty(index = 10,value = {"客户反馈","推荐岗位"})
    private String pecommendedPosition;

    /**
     * 客户面试时间
     */
    @ExcelProperty(index = 11,value = {"客户反馈","面试时间"})
    private String customerInterviewTime;

    /**
     * 是否到场面试
     */
    @ExcelProperty(index = 12,value = {"客户反馈","是否到场面试"})
    private String onSiteInterview;

    /**
     * 客户反馈
     */
    @ExcelProperty(index = 13,value = {"客户反馈","客户反馈"})
    private String customeFeedback;

    /**
     * 是否录用
     */
    @ExcelProperty(index = 14,value = {"入职跟踪","是否录用"})
    private String hire;

    /**
     * 录用薪资
     */
    @ExcelProperty(index = 15,value = {"入职跟踪","录用薪资"})
    private String employmentSalary;

    /**
     * 预计入职时间
     */
    @ExcelProperty(index = 16,value = {"入职跟踪","预计入职时间"})
    private String estimatedEntryTime;

    /**
     * 是否入职
     */
    @ExcelProperty(index = 17,value = {"入职跟踪","是否入职"})
    private String employment;

    /**
     * 实际入职时间
     */
    @ExcelProperty(index = 18,value = {"入职跟踪","实际入职时间"})
    private String actualEntryTime;

    /**
     * 薪资偏差
     */
    @ExcelProperty(index = 19,value = {"归档信息","薪资偏差"})
    private String salaryDeviation;

    /**
     * 是否归档
     */
    @ExcelProperty(index = 20,value = {"归档信息","是否归档"})
    private String archive;

    /**
     * 推荐HR
     */
    @ExcelProperty(index = 21,value = {"","推荐HR"})
    private String recommendedHr;

    /**
     * 备注
     */
    @ExcelProperty(index = 22,value = {"","备注"})
    private String remarks;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}