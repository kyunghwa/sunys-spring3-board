/*
 * FileBO.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.article.dao.FileDAO;
import com.spring.mvc.article.model.FileInfo;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Service
public class FileBO {

    @Autowired
    private FileDAO fileDAO;

    /**
     * 게시글 첨부파일 목록반환
     * 
     * @param articleId
     * @return
     */
    public List<FileInfo> getArticleFileList(int articleId) {
        return fileDAO.selectArticleFileList(articleId);
    }

    /**
     * 파일정보 반환
     * 
     * @param fileId
     * @return
     */
    public FileInfo getArticleFileInfo(int fileId) {
        return fileDAO.selectFileInfo(fileId);
    }
}
