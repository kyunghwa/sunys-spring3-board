/*
 * ArticleDAOTest.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.spring.mvc.article.model.Article;
import com.spring.mvc.article.model.Search;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "classpath:spring/applicationContext-datasource.xml" })
public class ArticleDAOTest {
    private ArticleDAO articleDAO;
    @Autowired
    private SqlMapClient sqlMapClient;

    @Before
    public void setUp() {
        articleDAO = new ArticleDAO();
        articleDAO.setSqlMapClient(sqlMapClient);
    }

    @Test
    public void testSelectArticleList() {
        Search search = new Search();
        search.setSearchKey("TITLE");
        search.setSearchValue("111");
        search.setCommunityId(1);

        articleDAO.selectArticleList(search);
    }

    @Test
    public void testInsertArticle() {
        Article article = getArticle();
        int articleId = articleDAO.insertArticle(article);
        article.setArticleId(articleId);
        assertNotNull(articleDAO.selectArticleInfo(articleId));

        articleDAO.deleteArticle(articleId);
    }

    private Article getArticle() {
        Article article = new Article();

        article.setCommunityId(1);
        article.setEmpno(7839);
        article.setGroupId(1);
        article.setReDepth(1);
        article.setReLevel(1);
        article.setTitle("게시글 제목");
        article.setContent("게시글 내용");
        article.setUseYn("Y");
        article.setRegistYmdt(new Date());

        return article;
    }

}
