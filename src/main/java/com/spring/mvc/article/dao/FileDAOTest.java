/*
 * FileDAOTest.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.spring.mvc.article.model.FileInfo;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "classpath:spring/applicationContext-datasource.xml" })
public class FileDAOTest {
    private FileDAO fileDAO;
    @Autowired
    private SqlMapClient sqlMapClient;

    @Before
    public void setUp() {
        fileDAO = new FileDAO();
        fileDAO.setSqlMapClient(sqlMapClient);
    }

    @Test
    public void testFile() {

        fileDAO.insertFile(getFile());
        assertNotNull(fileDAO.selectArticleFileList(getFile().getArticleId()));

        fileDAO.deleteArticleFile(getFile().getArticleId());
    }

    @Test
    public void testSelectFileInfo() {
        fileDAO.selectFileInfo(1);
    }

    @Test
    public void testDeleteFile() {
        fileDAO.deleteFile(1);
    }

    private FileInfo getFile() {
        FileInfo file = new FileInfo();
        file.setArticleId(1);
        file.setOriginFilename("테스트.txt");
        file.setSaveFilename("123456789.txt");
        file.setFileSize(1024000);
        file.setMimeType("text");
        file.setFilePath("/");
        return file;
    }
}