package com.cainiao.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class SystemInterceptor implements HandlerInterceptor {

//	@Autowired
//	private AuthUtil authUtil;
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截之前");
//        if(!authUtil.isLogin(request)) {
//        	//重定向登录
//        	String returnUrl = UrlUtils.getBaseUrl(request)+"login/index";
//        	response.sendRedirect(returnUrl);
//        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
