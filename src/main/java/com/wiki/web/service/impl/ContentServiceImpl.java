package com.wiki.web.service.impl;

import com.wiki.web.entity.Content;
import com.wiki.web.mapper.ContentMapper;
import com.wiki.web.service.IContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 袁锦鹏
 * @since 2024-09-07
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
