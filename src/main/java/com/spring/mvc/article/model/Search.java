/*
 * Search.java 2011. 8. 28.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.article.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class Search {
    private int communityId;

    private String searchKey;
    private String searchValue;

    /**
     * @return the communityId
     */
    public int getCommunityId() {
        return communityId;
    }

    /**
     * @param communityId
     *            the communityId to set
     */
    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    /**
     * @return the searchKey
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * @param searchKey
     *            the searchKey to set
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue
     *            the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
