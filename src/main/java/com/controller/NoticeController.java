package com.controller;


import com.entity.Notice;
import com.entity.User;
import com.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller @RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @RequestMapping("")
    public String notices(ModelMap m) {
        List<Notice> noticeList= noticeService.ListNotice();
        m.put("noticeList",noticeList);
        return "Notice/notice-list";
    }

    @RequestMapping("/delete")
    public String noticeDelete(HttpServletRequest request){
        noticeService.deleteNoticeById(Integer.parseInt(request.getParameter("delid")));
        return "forward:/notice";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String gotoAddPage(){
        return "Notice/notice-add";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String gotoEditPage(ModelMap m ,HttpServletRequest request){
        m.put("notice",noticeService.SelectNoticeById(Integer.parseInt(request.getParameter("editid"))));
        return "Notice/notice-edit";
    }

    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String add(Notice notice) throws IOException {
        notice.setNoticeId(noticeService.ListNotice().size()+1);
       notice.setNoticeCreateTime(new Date());
       notice.setNoticeStatus((Integer)1);
       notice.setNoticeOrder(noticeService.ListNotice().size()+1);
       noticeService.addNotice(notice);
       return "forward:/notice";   //添加完成以后.转到用望列表
    }
    @RequestMapping(value="/edit",method=RequestMethod.POST)
    public String edit(Notice notice, HttpServletRequest request) throws IOException {
        notice.setNoticeCreateTime(noticeService.SelectNoticeById(Integer.parseInt(request.getParameter("editid"))).getNoticeCreateTime());
        notice.setNoticeStatus((Integer)1);
        notice.setNoticeOrder(noticeService.SelectNoticeById(Integer.parseInt(request.getParameter("editid"))).getNoticeOrder());
        notice.setNoticeUpdateTime(new Date());
        notice.setNoticeId(Integer.parseInt(request.getParameter("editid")));
        noticeService.deleteNoticeById(Integer.parseInt(request.getParameter("editid")));
        noticeService.addNotice(notice);
        return "forward:/notice";   //添加完成以后.转到用望列表
    }
}
