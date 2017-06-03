package com.wuliangit.shopos.service;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.Date;

/**
 * Created by nilme on 2017/3/20.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml", "classpath:spring-shiro.xml"})
@TransactionConfiguration(defaultRollback = true)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void createUser() {

        Member member = new Member();
        member.setCreateTime(new Date());
        member.setUpdateTime(new Date());
        member.setUsername("18066265836");
        member.setMobile("18066265836");
        member.setType(POJOConstants.USER_TYPE_DEFAULT);
        member.setAuthState(POJOConstants.NOT_AUTH);
        member.setSalt(PasswordHelper.generateSalt());
        member.setPassword(PasswordHelper.generatePassword("11", member.getSalt()));

        System.out.println(member.getUsername() + "+" + member.getPassword() + "+" + member.getSalt());

    }


}
