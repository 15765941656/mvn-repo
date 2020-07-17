package com.mapper;

import com.entity.Notice;

import java.util.List;

public interface NoticeMapper {
    List<Notice> ListNotice();

    int deleteNoticeById(Integer id);

    void addNotice(Notice notice);

    Notice SelectNoticeById(Integer id);
}