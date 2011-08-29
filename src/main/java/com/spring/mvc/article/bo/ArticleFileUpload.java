/*
 * ArticleFileUpload.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.bo;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.spring.mvc.article.model.FileInfo;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Service
public class ArticleFileUpload {
    private static final Log LOG = LogFactory.getLog(ArticleFileUpload.class);
    private List<FileInfo> fileList;

    /**
     * 첨부파일 서버 저장 및 첨부파일 정보 생성
     * 
     * @param multipartFiles
     *            첨부파일정보
     * @param uploadPath
     *            파일저장경로
     * @param articleId
     *            게시글아이디
     */
    public void writeFile(CommonsMultipartFile[] multipartFiles, Resource uploadPath, int articleId) {
        OutputStream out = null;

        try {

            fileList = new ArrayList<FileInfo>();

            for (CommonsMultipartFile multipartFile : multipartFiles) {

                if (multipartFile.getSize() > 0) {

                    FileInfo fileInfo = new FileInfo();
                    fileInfo.setFilePath(uploadPath.getFile().getAbsolutePath() + "/");
                    fileInfo.setOriginFilename(multipartFile.getOriginalFilename());
                    fileInfo.setSaveFilename(getUniqueFileName(multipartFile.getOriginalFilename()));
                    fileInfo.setFileSize(multipartFile.getSize());
                    fileInfo.setMimeType(multipartFile.getContentType());
                    fileInfo.setArticleId(articleId);

                    // 저장경로 및 파일명 지정
                    out = new FileOutputStream(fileInfo.getFilePath() + fileInfo.getSaveFilename());
                    BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
                    byte[] buffer = new byte[8106];
                    int read;

                    while ((read = bis.read(buffer)) > 0) {
                        out.write(buffer, 0, read);
                    }

                    // 첨부파일 정보 추가
                    fileList.add(fileInfo);
                }
            }

        } catch (IOException ioe) {
            LOG.error(ioe);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * Unique Filename 생성
     * 
     * @param fileName
     * @return UniqueFileName
     */
    private String getUniqueFileName(String fileName) {

        String uniqueFilename = "";
        String uuid = StringUtils.remove(UUID.randomUUID().toString(), '-').toUpperCase();

        int fileIndex = StringUtils.lastIndexOf(fileName, '.');

        // 파일명과 확장자를 분리
        if (fileIndex != -1) {
            String extension = StringUtils.substring(fileName, fileIndex + 1);
            uniqueFilename = uuid + "." + extension;
        } else {
            uniqueFilename = uuid;
        }

        return uniqueFilename;
    }

    public List<FileInfo> getFileList() {
        return fileList;
    }
}