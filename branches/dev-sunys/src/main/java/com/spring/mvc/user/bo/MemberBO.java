/*
 * MemberBO.java 2011. 9. 26.
 *
 * Copyright oracleclub.com All rights Reserved.
 */
package com.spring.mvc.user.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.user.dao.MemberDAO;
import com.spring.mvc.user.model.Member;

/**
 * Class 내용 기술
 * 
 * @author : Sunys
 * 
 */
@Service
public class MemberBO {

    // @autowired 미적용
    private MemberDAO memberDAO;

    /**
     * 멤버 정보반환
     * 
     * @param id
     * @return
     */
    public List<Member> getJoinMember(String id) {
        return memberDAO.selectJoinMember(id);
    }

}
