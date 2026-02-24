package com.string;

public class StringBufferClass {

	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer("Java");
		StringBuffer sb2 = new StringBuffer("Java");
		
		System.out.println(sb1);
		
		sb1.append("Lang");
		
		System.out.println(sb1);
		
		System.out.println(sb1 == sb2);
		
		System.out.println(sb1.equals(sb2));
		
		System.out.println(sb1.reverse().toString());
	}

}
