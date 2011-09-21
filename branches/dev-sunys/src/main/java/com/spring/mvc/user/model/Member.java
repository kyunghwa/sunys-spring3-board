/*
 * Emp.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class Member {

    @NotEmpty
    private String id;
    @NotEmpty
    private String passwd;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String hp;
    private Date reg_date;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd
     *            the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the hp
     */
    public String getHp() {
        return hp;
    }

    /**
     * @param hp
     *            the hp to set
     */
    public void setHp(String hp) {
        this.hp = hp;
    }

    /**
     * @return the reg_date
     */
    public Date getReg_date() {
        return reg_date;
    }

    /**
     * @param reg_date
     *            the reg_date to set
     */
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
