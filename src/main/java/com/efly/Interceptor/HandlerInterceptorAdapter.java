package com.efly.Interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nic on 2017/1/23.
 * 拦截器
 */
public class HandlerInterceptorAdapter implements AsyncHandlerInterceptor{
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.contains("login")){
            if(request.getSession().getAttribute("username") != null){
                response.sendRedirect(request.getContextPath());
            }else{
                return true;                //继续请求登录
            }
        }
        //判断session中是否有key，不为空继续用户的操作
        if(request.getSession().getAttribute("username") != null){
            return true;
        }

        //进入登录页面
        response.sendRedirect(request.getContextPath() + "/");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
