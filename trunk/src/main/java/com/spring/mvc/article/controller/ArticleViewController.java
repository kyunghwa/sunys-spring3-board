/*
 * ArticleViewController.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.article.bo.ArticleBO;
import com.spring.mvc.article.bo.FileBO;
import com.spring.mvc.article.model.Article;
import com.spring.mvc.article.model.FileInfo;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Controller
@Scope("prototype")
@RequestMapping("/article")
public class ArticleViewController {
    @Autowired
    private ArticleBO articleBO;

    @Autowired
    private FileBO fileBO;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "articleId", required = true, defaultValue = "1") int articleId) {

        Article article = articleBO.getArticleInfo(articleId);
        List<FileInfo> fileList = fileBO.getArticleFileList(articleId);

        ModelAndView mv = new ModelAndView();

        mv.setViewName("article/ArticleViewForm");
        mv.addObject("article", article);
        mv.addObject("fileList", fileList);

        return mv;
    }

}
