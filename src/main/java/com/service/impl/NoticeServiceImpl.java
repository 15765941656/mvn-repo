package com.service.impl;

import com.entity.Notice;
import com.mapper.NoticeMapper;
import com.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    NoticeMapper noticeMapper;
    @Override
    public List<Notice> ListNotice() {
        return noticeMapper.ListNotice();
    }

    @Override
    public int deleteNoticeById(Integer id) {
        return noticeMapper.deleteNoticeById(id);
    }

    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    @Override
    public Notice SelectNoticeById(Integer id) {
        return noticeMapper.SelectNoticeById(id);
    }
}