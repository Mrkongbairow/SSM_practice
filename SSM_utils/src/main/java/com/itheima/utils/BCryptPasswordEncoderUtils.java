package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private  static BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();

    public static String encodingPassword(String password){

        return bpe.encode(password);
    }

    public static void main(String[] args) {
        String  s = "123";

        String s1 = encodingPassword(s);
        System.out.println(s1);
    }
}
