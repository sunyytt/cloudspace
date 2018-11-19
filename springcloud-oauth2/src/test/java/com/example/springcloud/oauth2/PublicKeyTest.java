package com.example.springcloud.oauth2;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

public class PublicKeyTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("cnsesan-jwt.jks");
		KeyPair keyPair = new KeyStoreKeyFactory(resource, "cnsesan123".toCharArray()).getKeyPair("cnsesan-jwt");
		RSAPublicKey key = (RSAPublicKey)keyPair.getPublic();
		System.out.println(key);
		//vertify key 是对publicKey进行Base64编码后得到的一个字符串：
		String verifierKey = "-----BEGIN PUBLIC KEY-----\n" + new String(Base64.encode(key.getEncoded()))
				+ "\n-----END PUBLIC KEY-----";
		System.out.println(verifierKey);
	}
}
