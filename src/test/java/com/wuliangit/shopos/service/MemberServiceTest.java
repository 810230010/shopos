package com.wuliangit.shopos.service;

import com.wuliangit.shopos.core.sms.YXSMSSender;
import com.wuliangit.shopos.core.util.PasswordHelper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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


    @Test
    @Transactional
    public void addMember() {
        Member member = new Member();
        member.setUsername("jjjjj");
        member.setEmail("taoshanchang1@foxmail.com");
        member.setSalt(PasswordHelper.generateSalt());
        member.setPasswd(PasswordHelper.generatePassword("123456",member.getSalt()));
        member.setNikename("Nilme2");
        member.setCreateTime(new Date());
        member.setLoginTime(new Date());
        member.setMemberId(1);

        memberMapper.updateByPrimaryKeySelective(member);

        int a = 1/0;

        Member member1 = new Member();
        member1.setUsername("bbbb");
        member1.setMemberId(5);
        member1.setEmail("taoshanchang3@foxmail.com");
        member1.setSalt(PasswordHelper.generateSalt());
        member1.setPasswd(PasswordHelper.generatePassword("123456",member1.getSalt()));
        member1.setNikename("Nilme3");
        member1.setCreateTime(new Date());
        member1.setLoginTime(new Date());

        memberMapper.updateByPrimaryKeySelective(member1);

    }


    @Test
    public void getByUsername() {
        memberService.getByUsername("test");
    }


    @Test
    public void getPlaceholder () {
        smsService.sendRegisterCode("18066265836");
    }


}
