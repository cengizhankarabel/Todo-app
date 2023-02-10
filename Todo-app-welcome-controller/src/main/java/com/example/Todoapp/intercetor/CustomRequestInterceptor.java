package com.example.Todoapp.intercetor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomRequestInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(CustomRequestInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle invoked..."+request.getRequestURI()+","+request.getMethod());

        return HandlerInterceptor.super.preHandle(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle invoked..."+request.getRequestURI()+","+request.getMethod());

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

        if(ex!=null){
            log.info("exception inside afterCompletion"+ex.getMessage());
        }

        log.info("afterCompletion invoked..."+request.getRequestURI()+","+request.getMethod());


    }
}

