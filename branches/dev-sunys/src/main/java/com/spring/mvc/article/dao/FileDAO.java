/*
 * FileDAO.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.spring.mvc.article.model.FileInfo;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Repository
public class FileDAO extends SqlMapClientDaoSupport {

    @Resource(name = "sqlMapClient")
    public void init(SqlMapClient sqlMapClient) {
        setSqlMapClient(sqlMapClient);
    }

    private static final String NAMESPACE = "file.";

    public void insertFile(FileInfo fileInfo) {
        getSqlMapClientTemplate().insert(NAMESPACE + "insertFile", fileInfo);
    }

    public void deleteFile(int fileId) {
        getSqlMapClientTemplate().delete(NAMESPACE + "deleteFile", fileId);
    }

    public void deleteArticleFile(int articleId) {
        getSqlMapClientTemplate().delete(NAMESPACE + "deleteArticleFile", articleId);
    }

    @SuppressWarnings("unchecked")
    public List<FileInfo> selectArticleFileList(int articleId) {
        return (List<FileInfo>) getSqlMapClientTemplate().queryForList(NAMESPACE + "selectArticleFileList", articleId);
    }

    public FileInfo selectFileInfo(int fileId) {
        return (FileInfo) getSqlMapClientTemplate().queryForObject(NAMESPACE + "selectFileInfo", fileId);
    }
}