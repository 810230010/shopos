package com.wuliangit.shopos.core.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;

public class PasswordHelper {

    @Value("${password.algorithmName}")
    private static String algorithmName = "md5";
    @Value("${password.hashIterations}")
    private static int hashIterations = 2;

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }


    /**
     * 生成密码盐
     *
     * @return
     */
    public static String generateSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    /**
     * 生成密码
     *
     * @param password 明文密码
     * @param salt     盐
     * @return
     */
    public static String generatePassword(String password, String salt) {
        String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(salt), hashIterations).toHex();
        return newPassword;
    }

}
