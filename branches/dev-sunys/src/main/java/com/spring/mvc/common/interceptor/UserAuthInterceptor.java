/*
 * UserAuthInterceptor.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.mvc.common.util.CookieUtil;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class UserAuthInterceptor extends HandlerInterceptorAdapter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 로그인 사용자 정보를 쿠키에서 가져옴
        int empno = NumberUtils.toInt(CookieUtil.getCookieValue(request, "LOGIN_KEY"), 0);

        // 사원번호 7839 KING 사용자만 인증에 성공함
        if (empno == 7839) {
            return true;
        } else {
            // 인증에 실패하거나 권한이 없는 사용자일 경우
            response.sendRedirect("/user/loginform.ok");
            return false;
        }
    }

}
