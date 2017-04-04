package com.wuliangit.shopos.service;

import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.dao.AdminLogMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;
import java.util.List;

/**
 * Created by nilme on 2017/3/20.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@TransactionConfiguration(defaultRollback = true)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private SMSService smsService;

    @Autowired
    private AdminLogMapper adminLogMapper;


    @Test
//    @Transactional
    public void addMember() {
        Member member = new Member();
        member.setUsername("nilme");
        member.setEmail("taoshanchang1@foxmail.com");
        member.setSalt(PasswordHelper.generateSalt());
        member.setPasswd(PasswordHelper.generatePassword("11",member.getSalt()));
        member.setNikename("Nilme");
        member.setCreateTime(new Date());
        member.setLoginTime(new Date());
        member.setMemberId(1);
        member.setUpdateTime(new Date());

        memberMapper.insertSelective(member);

    }


    @Test
    public void getByUsername() {
        memberService.getByUsername("test");
    }


    @Test
    public void getPlaceholder () {
        smsService.sendRegisterCode("18066265836");
    }

    @Test
    public void test(){



    }


}
