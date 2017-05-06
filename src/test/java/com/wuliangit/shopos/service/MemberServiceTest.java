package com.wuliangit.shopos.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by nilme on 2017/3/20.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-shiro.xml"})
@TransactionConfiguration(defaultRollback = true)
public class MemberServiceTest {






}
