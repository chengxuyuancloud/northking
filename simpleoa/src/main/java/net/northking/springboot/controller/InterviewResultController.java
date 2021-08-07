package net.northking.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import net.northking.springboot.dao.InterviewResultFeedbackDao;
import net.northking.springboot.easyexcel.UploadDataListener;
import net.northking.springboot.entities.InterviewResultFeedback;
import net.northking.springboot.service.InterviewResultFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manage")
public class InterviewResultController {
    @Autowired
    private InterviewResultFeedbackService interviewResultFeedbackService;
    @Autowired
    private InterviewResultFeedbackDao interviewResultFeedbackDao;

    @RequestMapping("find")
    @ResponseBody
    public PageInfo<InterviewResultFeedback> findResult(HttpSession session,
                                                        @RequestParam int pageNum,
                                                        @RequestParam int pageSize,
                                                        @RequestParam String startTime,
                                                        @RequestParam String endTime) {
        PageInfo<InterviewResultFeedback> resultByUserId = interviewResultFeedbackService.findResultByUserId(pageNum, pageSize, startTime, endTime);
//        String resultList = JSON.toJSONString(resultFeedbacks);
        return resultByUserId;
    }

    /**
     * 文件上传
     * <p>
     * 1. 创建excel对应的实体对象
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
     * <p>
     * 3. 直接读即可
     */
    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), InterviewResultFeedback.class, new UploadDataListener(interviewResultFeedbackDao)).sheet().headRowNumber(2).doRead();
        return "success";
    }
    /**
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     */
    @RequestMapping("download")
    public void downloadFailedUsingJson(HttpServletResponse response,@RequestParam String startTime, @RequestParam String endTime) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            // 这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), InterviewResultFeedback.class).autoCloseStream(Boolean.FALSE).sheet("模板")
                    .doWrite(data(startTime,endTime));
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }
    }

    private List<InterviewResultFeedback> data(String startTime, String endTime) {
        List<InterviewResultFeedback> data = interviewResultFeedbackService.findDownloadResult(startTime,endTime);
        return data;
    }
}
