package com.example.springclouduser.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: sunyy
 * @Date: 2018/11/13 17:36
 * @Description:
 */
public class BPwdEncoderUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String BCryptPassword(String password){

        return encoder.encode(password);
    }
    public static boolean matches (CharSequence rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
