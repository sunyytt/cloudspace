package com.example.springclouduser;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Test {
    /**
     * 解码
     * @param bytes
     * @return
     */
    public static String decode(final byte[] bytes) {
        return new String(Base64.decodeBase64(bytes));
    }

    /**
     * 编码
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    public static void main(String[] args) {
        String str="whuang123哈哈";
        System.out.println("编码=="+encode(str.getBytes()));
        System.out.println("解码=="+decode(encode(str.getBytes()).getBytes()));

        String a = "dXNlci1zZXJ2aWNlOjEyMzQ1Ng==";
        System.out.println("解码=="+decode(a.getBytes()));
        String b = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NDI1MzE3MzMsInVzZXJfbmFtZSI6InN1bnl5IiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiI5ZmFhNzc0NC01ZmE3LTRjZmMtYmQzZC02MjAxNDE0NjdjMjAiLCJjbGllbnRfaWQiOiJ1c2VyLXNlcnZpY2UiLCJzY29wZSI6WyJzZXJ2aWNlIl19.d9ZFZoLbJY1aznHiuv1jYrnrNq6kR3imCEXPv-AhihjV7MaIGfbcubVrKWhlRLBWY7HXKKn3tFOM9R9UzLNj-tDJjMt7bMh3v-EVW91bgjvE0KU4OrGqWrxVIPyQHOgKOnj-3r58p2fEvw0xxZEpTxk5OeNqkBdp4qQTo9tDH37TpxDu7VpbJyJ1ysK666rO7DWbxefcEwEtdFhOKM9CJdD9fU9Q7Ah5CLDnRYr9DpZkrrjyzOArXSkfdUh7xeTzEwofqcGWyHWRi2dBtigYwQAhvzBUrW3sXZEVdlxz6fUIdSKkFTdwp4jk92VaYXuG1aLJzvmO943XT1FU05U-nQ";
        System.out.println("解码=="+decode(b.getBytes()));




    }
}
