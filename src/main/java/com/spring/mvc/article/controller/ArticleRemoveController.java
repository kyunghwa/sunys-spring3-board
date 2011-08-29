/*
 * ArticleRemoveController.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.MessageSourceAccessor;
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
public class ArticleRemoveController {
    @Autowired
    private ArticleBO articleBO;
    @Autowired
    private MessageSourceAccessor message;

    @RequestMapping(value = "/remove")
    public ModelAndView list(@ModelAttribute(value = "article") Article article) {

        articleBO.removeArticle(article.getArticleId());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("article/ArticleList");
        Search search = new Search();
        search.setCommunityId(article.getCommunityId());
        mv.addObject("articleList", articleBO.getArticleList(search));
        mv.addObject("communityId", article.getCommunityId());
        mv.addObject("msg", message.getMessage("article.remove.success"));

        return mv;
    }

}
