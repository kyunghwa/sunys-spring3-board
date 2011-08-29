/*
 * ArticleFileDownloadController.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.article.bo.FileBO;
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
public class ArticleFileDownloadController {
    private static final Log LOG = LogFactory.getLog(ArticleFileDownloadController.class);
    @Autowired
    private FileBO fileBO;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "fileId", required = true, defaultValue = "0") int fileId,
            HttpServletResponse response) throws Exception {

        FileInfo fileInfo = fileBO.getArticleFileInfo(fileId);
        response.setContentType(fileInfo.getMimeType());
        response.setContentLength((int) fileInfo.getFileSize());
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + URLEncoder.encode(fileInfo.getOriginFilename(), "UTF-8") + "\"");

        FileInputStream fis = null;

        try {

            File file = new File(fileInfo.getFilePath() + fileInfo.getSaveFilename());
            fis = new FileInputStream(file);

            IOUtils.copy(fis, response.getOutputStream());

        } catch (IOException ioe) {
            LOG.error("[FILE_DOWNLOAD_IOEXCEPTION]", ioe);
        } finally {
            IOUtils.closeQuietly(fis);
        }
        return null;
    }
}