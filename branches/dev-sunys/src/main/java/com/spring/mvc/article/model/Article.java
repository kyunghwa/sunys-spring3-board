/*
 * Article.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class Article {

    private int articleId;
    private int communityId;
    private int empno;
    private int groupId;
    private int reLevel;
    private int reDepth;

    @NotEmpty
    private String title;

    @NotEmpty
    private String name;

    @NotEmpty
    private String content;
    private String useYn;
    private Date registYmdt;
    private Date updateYmdt;

    private CommonsMultipartFile[] filename;

    public CommonsMultipartFile[] getFilename() {
        return filename;
    }

    public void setFilename(CommonsMultipartFile[] filename) {
        this.filename = filename;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getReLevel() {
        return reLevel;
    }

    public void setReLevel(int reLevel) {
        this.reLevel = reLevel;
    }

    public int getReDepth() {
        return reDepth;
    }

    public void setReDepth(int reDepth) {
        this.reDepth = reDepth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public Date getRegistYmdt() {
        return registYmdt;
    }

    public void setRegistYmdt(Date registYmdt) {
        this.registYmdt = registYmdt;
    }

    public Date getUpdateYmdt() {
        return updateYmdt;
    }

    public void setUpdateYmdt(Date updateYmdt) {
        this.updateYmdt = updateYmdt;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}