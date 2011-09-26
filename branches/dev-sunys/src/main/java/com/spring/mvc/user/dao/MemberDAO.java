/*
 * MemberDAO.java 2011. 9. 26.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.spring.mvc.user.model.Member;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
public class MemberDAO extends SqlMapClientDaoSupport {

    @Resource(name = "sqlMapClient")
    public void init(SqlMapClient sqlMapClient) {
        setSqlMapClient(sqlMapClient);
    }

    private static final String NAMESPACE = "member.";

    @SuppressWarnings("unchecked")
    public List<Member> selectJoinMember(String id) {
        return (List<Member>) getSqlMapClientTemplate().queryForObject(NAMESPACE + "selectJoinMember", id);
    }
}
