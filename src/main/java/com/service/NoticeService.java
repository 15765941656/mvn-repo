package com.service;

import com.entity.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> ListNotice();

    int deleteNoticeById(Integer id);

    void addNotice(Notice notice);

    Notice SelectNoticeById(Integer id);
}
