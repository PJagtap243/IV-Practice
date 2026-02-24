package com.string;

public class CoversionOfString {

	public static void main(String[] args) {
		
		String str1 = "Java";
		StringBuffer sb1 = new StringBuffer(str1);
		str1 = sb1.reverse().toString();
		System.out.println(str1);
	}

}
