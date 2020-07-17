package com.service.impl;

import com.entity.Tag;
import com.mapper.TagMapper;
import com.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

}