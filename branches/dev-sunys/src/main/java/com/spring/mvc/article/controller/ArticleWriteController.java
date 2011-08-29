/*
 * ArticleWriteController.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.article.bo.ArticleBO;
import com.spring.mvc.article.model.Article;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping("/article")
public class ArticleWriteController implements InitializingBean {
    private static final Log LOG = LogFactory.getLog(ArticleWriteController.class);

    @Autowired
    private ArticleBO articleBO;
    private Resource uploadPath;

    @RequestMapping(value = "/form")
    public ModelAndView writeForm(
            @RequestParam(value = "communityId", required = true, defaultValue = "1") int communityId) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("article/ArticleWriteForm");
        mv.addObject("communityId", communityId);

        return mv;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public ModelAndView write(@Valid Article article, BindingResult result,
            @CookieValue(value = "LOGIN_KEY", required = false) int empno) {

        ModelAndView mv = new ModelAndView();

        // Validation 오류 발생시 게시글 정보 등록화면으로 이동
        if (result.hasErrors()) {
            // 에러 출력
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError e : list) {
                LOG.error(" ObjectError : " + e);
            }

            mv.setViewName("article/ArticleWriteForm");
            mv.addObject("article", article);
            mv.addObject("communityId", article.getCommunityId());
            return mv;
        }

        article.setEmpno(empno);
        article.setReLevel(0);
        article.setReDepth(0);

        // 게시글 정보 등록
        int articleId = articleBO.writeArticle(article, uploadPath);
        mv.setViewName("redirect:/article/view.ok?articleId=" + articleId);

        return mv;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // tomcat start 할 때 uploadPath가 설정되었는지 체크한다.
        Assert.notNull(uploadPath, "FileUpload Path must be defined!");
        LOG.debug(" ######### uploadPath : " + uploadPath.getFile().getAbsolutePath());

        // 디렉토리가 존재하지 않는다면, 디렉토리를 만든다.
        if (!uploadPath.getFile().exists()) {
            uploadPath.getFile().mkdirs();
        }
    }

    public void setUploadPath(Resource uploadPath) {
        this.uploadPath = uploadPath;
    }
}