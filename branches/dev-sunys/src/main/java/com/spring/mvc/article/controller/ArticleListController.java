/*
 * ArticleListController.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.article.bo.ArticleBO;
import com.spring.mvc.article.model.Article;
import com.spring.mvc.article.model.Search;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */

@Controller
@Scope("prototype")
@RequestMapping("/article")
public class ArticleListController {
    @Autowired
    private ArticleBO articleBO;
    private List<Article> articleList;
    private static final int DEFAULT_COMMUNITY_ID = 1;

    @RequestMapping(value = "/list")
    public ModelAndView list(@ModelAttribute("search") Search search) {

        if (search.getCommunityId() == 0) {
            search.setCommunityId(DEFAULT_COMMUNITY_ID);
        }

        articleList = articleBO.getArticleList(search);
        ModelAndView mv = new ModelAndView();

        mv.setViewName("article/ArticleList");
        mv.addObject("articleList", articleList);
        mv.addObject("communityId", search);

        return mv;
    }

}
