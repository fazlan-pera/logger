package com.logger.hash;



public class HashComparator {
	
	private String hash1;
	private String hash2;
	
	public HashComparator(String hash1,String hash2) {
		this.hash1 = hash1;
		this.hash2 = hash2;
	}
	
	

	public String getHash1() {
		return hash1;
	}



	public void setHash1(String hash1) {
		this.hash1 = hash1;
	}



	public String getHash2() {
		return hash2;
	}



	public void setHash2(String hash2) {
		this.hash2 = hash2;
	}



	public boolean compareHash(){
		if(hash1.equals(hash2))
			return true;
		else
			return false;
	}
}
