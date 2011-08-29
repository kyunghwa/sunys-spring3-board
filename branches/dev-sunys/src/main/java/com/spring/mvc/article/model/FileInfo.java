/*
 * FileInfo.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.model;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class FileInfo {

    private int fileId;
    private int articleId;
    private long fileSize; // 파일 사이즈

    private String originFilename; // 원본 파일명
    private String saveFilename; // 저장된 파일명
    private String mimeType; // 컨텐츠 타입
    private String filePath; // 저장된 파일 경로

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getOriginFilename() {
        return originFilename;
    }

    public void setOriginFilename(String originFilename) {
        this.originFilename = originFilename;
    }

    public String getSaveFilename() {
        return saveFilename;
    }

    public void setSaveFilename(String saveFilename) {
        this.saveFilename = saveFilename;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}