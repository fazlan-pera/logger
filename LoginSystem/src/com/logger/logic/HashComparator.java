package com.logger.logic;

import java.util.Arrays;

public class HashComparator {
	
	private byte[] hash1;
	private byte[] hash2;
	
	public HashComparator(byte[] hash1,byte[] hash2) {
		this.hash1 = hash1;
		this.hash2 = hash2;
	}
	
	public byte[] getHash1() {
		return hash1;
	}

	public void setHash1(byte[] hash1) {
		this.hash1 = hash1;
	}

	public byte[] getHash2() {
		return hash2;
	}

	public void setHash2(byte[] hash2) {
		this.hash2 = hash2;
	}

	public boolean compareHash(){
		if(Arrays.equals(this.hash1, this.hash2))
			return true;
		else
			return false;
	}
}
