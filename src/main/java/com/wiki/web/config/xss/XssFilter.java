package com.gec.obwiki.config.xss;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")//过滤所有请求
public class XssFilter  implements Filter {

    String noFilterUrls[] = new String[] { "/doc/save" };
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        boolean isFilter = true;
        for (String noFilterUrl : noFilterUrls) {
            if (noFilterUrl.equals(uri)) {
                //如果匹配到 则变为false 则是进行doc新增或修改
                isFilter = false;
            }
        }
        if(!isFilter){
            filterChain.doFilter(servletRequest,servletResponse);
        }else { //进行html标签过滤
            XssHttpServletRequestWrapper wrapper=new XssHttpServletRequestWrapper(request);
            filterChain.doFilter(wrapper,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}