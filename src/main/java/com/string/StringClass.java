package com.string;

public class StringClass {

	public static void main(String[] args) {
		
		String str1 = new String("Java");
		
		System.out.println(str1);
		
		str1.concat("Lang");
		
		System.out.println(str1);
		
		String str2 = "Java";
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.charAt(0));
		
		System.out.println(str1.compareTo(str2));
		
		System.out.println(str1.repeat(2));
		
	}

}
