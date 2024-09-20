package com.wiki.web.service.impl;

import com.wiki.web.entity.Category;
import com.wiki.web.mapper.CategoryMapper;
import com.wiki.web.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
