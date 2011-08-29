/*
 * Emp.java 2011. 8. 27.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.model;

import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class Emp {

    @Min(1000)
    private int empno;
    private int mgr;
    private int sal;
    private int deptno;
    private String ename;
    private String job;

    /**
     * @return the empno
     */
    public int getEmpno() {
        return empno;
    }

    /**
     * @param empno
     *            the empno to set
     */
    public void setEmpno(int empno) {
        this.empno = empno;
    }

    /**
     * @return the mgr
     */
    public int getMgr() {
        return mgr;
    }

    /**
     * @param mgr
     *            the mgr to set
     */
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    /**
     * @return the sal
     */
    public int getSal() {
        return sal;
    }

    /**
     * @param sal
     *            the sal to set
     */
    public void setSal(int sal) {
        this.sal = sal;
    }

    /**
     * @return the deptno
     */
    public int getDeptno() {
        return deptno;
    }

    /**
     * @param deptno
     *            the deptno to set
     */
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    /**
     * @return the ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * @param ename
     *            the ename to set
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job
     *            the job to set
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
