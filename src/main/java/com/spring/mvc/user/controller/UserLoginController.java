/*
 * UserLoginController.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.common.util.CookieUtil;
import com.spring.mvc.user.model.Emp;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserLoginController {
    private static final Log LOG = LogFactory.getLog(UserLoginController.class);

    @RequestMapping(value = "/loginform")
    public String loginForm() {
        return "user/LoginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletResponse response, @Valid Emp emp, BindingResult result) {

        // 사원번호와 비밀번호로 인증하는 비지니스 로직을 추가하면 되겠죠

        // Validation 오류 발생시 게시글 정보 등록화면으로 이동
        if (result.hasErrors()) {
            // 에러 출력
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
                LOG.error(" ObjectError : " + e);
            }

            return "user/LoginForm";
        } else {
            CookieUtil.setCookie(response, "LOGIN_KEY", String.valueOf(emp.getEmpno()),
                    CookieUtil.COOKIE_DEFAULT_MAX_AGE, CookieUtil.COOKIE_DEFAULT_DOMAIN);

        }
        return "redirect:/article/list.ok";
    }

}
