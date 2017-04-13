package com.wuliangit.shopos.service;

import com.alibaba.druid.filter.config.ConfigTools;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.PasswordHelper;
import com.wuliangit.shopos.dao.AdminLogMapper;
import com.wuliangit.shopos.dao.MemberMapper;
import com.wuliangit.shopos.dto.ApiCollectGoodsDTO;
import com.wuliangit.shopos.entity.AdminLog;
import com.wuliangit.shopos.entity.FavoritesGoods;
import com.wuliangit.shopos.entity.Member;
import org.dozer.Mapper;
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
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-shiro.xml"})
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


    @Autowired
    private Mapper mapper;


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
    public void getToken(){
        System.out.println(QiNiuUtils.getToken());
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

    @Test
    public void dozeTest(){
        ApiCollectGoodsDTO apiCollectGoodsDTO = new ApiCollectGoodsDTO();

        apiCollectGoodsDTO.setFavoritesGoodId(1);
        apiCollectGoodsDTO.setFavTime(new Date());
        apiCollectGoodsDTO.setLogMsg("xxxxxx");


        FavoritesGoods favoritesGoods = new FavoritesGoods();

        ApiCollectGoodsDTO map = mapper.map(apiCollectGoodsDTO, ApiCollectGoodsDTO.class);

        System.out.println(map.getLogMsg());

//        System.out.println(favoritesGoods.getLogMsg());

    }



    public static void main(String[] args) throws Exception {
        //密码明文
        String password = "Kr^##lg*bX8Vt4";
        System.out.println("密码[ "+password+" ]的加密信息如下：\n");
        String [] keyPair = ConfigTools.genKeyPair(512);
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        //用私钥加密后的密文
        String password2 = ConfigTools.encrypt(privateKey, password);
        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("password:"+password2);

        String decrypt = ConfigTools.decrypt(publicKey,password2);
        System.out.println(decrypt);
    }



}
