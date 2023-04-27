package com.kpmg.util;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;

@Component
public class RSAKeyProperties {

	private RSAPublicKey publickey;
	private RSAPrivateKey privatekey;
	
	public RSAKeyProperties() {
		
		KeyPair pair = KeyGeneratorUtility.generateRsaKey();
		
		this.publickey = (RSAPublicKey) pair.getPublic();
		this.privatekey = (RSAPrivateKey) pair.getPrivate();
		
		

	}

	public RSAPublicKey getPublickey() {
		return publickey;
	}

	public void setPublickey(RSAPublicKey publickey) {
		this.publickey = publickey;
	}

	public RSAPrivateKey getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(RSAPrivateKey privatekey) {
		this.privatekey = privatekey;
	}
}
