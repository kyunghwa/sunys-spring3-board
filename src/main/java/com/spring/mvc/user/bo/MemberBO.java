/*
 * MemberBO.java 2011. 9. 26.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.article.model.Article;
import com.spring.mvc.article.model.FileInfo;
import com.spring.mvc.article.model.Search;
import com.spring.mvc.user.dao.MemberDAO;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Service
public class MemberBO {
    @Autowired
    private MemberDAO memberDAO;

    /**
     * 게시글 목록반환
     * 
     * @param search
     * @return
     */
    public List<Article> getArticleList(Search search) {
        return memberDAO.selectArticleList(search);
    }

    /**
     * 게시글 정보반환
     * 
     * @param articleId
     * @return
     */
    public Member getArticleInfo(String id) {
        return memberDAO.selectJoinMember(id);
    }

    /**
     * 게시글 정보등록
     * 
     * @param article
     * @param uploadPath
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    // @Transactional(rollbackFor = java.sql.SQLException.class)
    public int writeArticle(Article article, Resource uploadPath) {

        // 게시글 정보 등록
        int articleId = memberDAO.insertArticle(article);

        // 첨부파일 업로드
        fileUpload.writeFile(article.getFilename(), uploadPath, articleId);

        // 첨부파일 정보
        List<FileInfo> fileList = fileUpload.getFileList();

        // 첨부파일 정보 등록
        for (FileInfo fileInfo : fileList) {
            fileDAO.insertFile(fileInfo);
        }
        return articleId;
    }

    /**
     * 게시글 정보 삭제
     * 
     * @param articleId
     */
    public void removeArticle(int articleId) {
        memberDAO.deleteArticle(articleId);
    }

}
