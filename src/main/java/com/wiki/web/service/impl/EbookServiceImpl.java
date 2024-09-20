package com.wiki.web.service.impl;

import com.wiki.web.entity.Ebook;
import com.wiki.web.mapper.EbookMapper;
import com.wiki.web.service.IEbookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author 袁锦鹏
 * @since 2024-09-07
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {

}
