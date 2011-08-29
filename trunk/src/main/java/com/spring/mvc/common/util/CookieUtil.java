/*
 * CookieUtil.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.common.util;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class CookieUtil {
    protected static Log log = LogFactory.getLog(CookieUtil.class);
    public static final String COOKIE_DEFAULT_DOMAIN = "spring3.com";
    public static final String COOKIE_DEFAULT_PATH = "/";
    public static final int COOKIE_DEFAULT_MAX_AGE = -1;
    public static final int COOKIE_DEFAULT_MIN_AGE = 0;

    /**
     * creat cookie object <br>
     * 
     * @param name
     * @param value
     * @param maxAge
     * @param domain
     * @param path
     * @return
     */
    public static Cookie createCookie(String name, String value, int maxAge, String domain, String path) {
        Cookie cookie = new Cookie(name, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        return cookie;
    }

    /**
     * creat cookie object <br>
     * 
     * @param name
     * @param value
     * @param maxAge
     * @param domain
     * @return
     */
    public static Cookie createCookie(String name, String value, int maxAge, String domain) {
        return createCookie(name, value, maxAge, domain, COOKIE_DEFAULT_PATH);
    }

    /**
     * create cookie object and set it to Reponse <Br>
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @param domain
     * @param path
     * @return
     */
    public static Cookie setCookie(HttpServletResponse response, String name, String value, int maxAge, String domain,
            String path) {
        Cookie cookie = createCookie(name, value, maxAge, domain, path);
        response.addCookie(cookie);

        if (log.isDebugEnabled()) {
            log.debug("CookieUtils.setCookie " + name + ":" + value + " maxAge=" + maxAge + ",domain=" + domain
                    + ",path=" + path);
        }
        return cookie;
    }

    /**
     * Cooking Cookie value with the specified Cookie name (Domain is Base Domain) <Br>
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @param domain
     * @return
     */
    public static Cookie setCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
        return setCookie(response, name, value, maxAge, domain, COOKIE_DEFAULT_PATH);
    }

    /**
     * add cookie object to Reponse <br>
     * 
     * @param response
     * @param cookie
     * @return
     */
    public static Cookie setCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);

        return cookie;
    }

    /**
     * Getting Cookie value with is matched to the specified Cookie name <br>
     * 
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }

        Cookie cookies[] = request.getCookies();

        if (cookies == null) {
            return null;
        }
        // linear scan for the cookie.
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

    /**
     * get value of cookie <br>
     * 
     * @param request
     * @param name
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null)
            return cookie.getValue();
        return null;
    }

    /**
     * Getting all names of Cookie <br>
     * 
     * @param request
     * @return
     */
    public static String[] getCookieNames(HttpServletRequest request) {

        ArrayList<String> cookieNames = new ArrayList<String>();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.debug(" ################## cookie.getName() : " + cookie.getName());
                cookieNames.add(cookie.getName());
            }
        }

        return cookieNames.toArray(new String[cookieNames.size()]);
    }

    /**
     * Getting all names of Cookie which includes the specified word <br>
     * 
     * @param request
     * @param filter
     * @return
     */
    public static String[] getCookieNames(HttpServletRequest request, String filter) {

        ArrayList<String> cookieNames = new ArrayList<String>();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();

                if (cookieName.indexOf(filter) != -1) {
                    cookieNames.add(cookieName);
                }
            }
        }

        return cookieNames.toArray(new String[cookieNames.size()]);
    }

    /**
     * Checking whether or not Cookie of the specified name exists <br>
     * 
     * @param request
     * @param cookieName
     * @return
     */
    public static boolean isExistCookie(HttpServletRequest request, String cookieName) {
        boolean isExist = false;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(cookieName)) {
                    isExist = true;
                    break;
                }
            }
        }

        return isExist;
    }

    /**
     * invalidate Cookie with the specified Cookie name, domain, and path <br>
     * 
     * @param response
     * @param cookieName
     * @param domain
     * @param path
     */
    public static void invalidateCookie(HttpServletResponse response, String cookieName, String domain, String path) {
        setCookie(response, cookieName, null, COOKIE_DEFAULT_MIN_AGE, domain, path);
    }

    /**
     * invalidate Cookie with the specified Cookie name, domain <br>
     * 
     * @param response
     * @param cookieName
     * @param domain
     */
    public static void invalidateCookie(HttpServletResponse response, String cookieName, String domain) {
        invalidateCookie(response, cookieName, domain, COOKIE_DEFAULT_PATH);
    }

    /**
     * invalidate Cookie with the specified Cookie name, domain <br>
     * 
     * @param response
     * @param cookieName
     */
    public static void invalidateCookie(HttpServletResponse response, String cookieName) {
        invalidateCookie(response, cookieName, null, COOKIE_DEFAULT_PATH);
    }

    /**
     * invlidate all cookies in domain <br>
     * 
     * @param request
     * @param response
     * @param cookieDomain
     */
    public static void invalidateAllCookies(HttpServletRequest request, HttpServletResponse response,
            String cookieDomain) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (int idx = 0; idx < cookies.length; idx++) {
                invalidateCookie(response, cookies[idx].getName(), cookieDomain);
            }
        }
    }
}