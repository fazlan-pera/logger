package com.logger.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

	private String password;
	private String hashAlgo;
	private String charSet;
	
	public HashGenerator(String password,String hashAlgo,String charSet) {
		this.password = password;
		this.hashAlgo = hashAlgo;
		this.charSet = charSet;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHashAlgo() {
		return hashAlgo;
	}
	public void setHashAlgo(String hashAlgo) {
		this.hashAlgo = hashAlgo;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	
	/*
	 * hash a password
	 */
	
	public byte[] getHash() throws UnsupportedEncodingException,NoSuchAlgorithmException{
		MessageDigest dig = MessageDigest.getInstance(this.hashAlgo);
	    return dig.digest(this.password.getBytes(this.charSet));
	}
	
	/*
	 * hash a password with salt
	 */
	public byte[] getHash(byte[] salt) throws UnsupportedEncodingException,NoSuchAlgorithmException{
		MessageDigest dig = MessageDigest.getInstance(this.hashAlgo);
	    dig.reset();
	    dig.update(salt);
	    return dig.digest(this.password.getBytes(this.charSet));
	}
}
