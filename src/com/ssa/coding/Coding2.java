package com.ssa.coding;

/**
 * 
 * 题目：请实现一个函数，把字符串中的每个空格替换成“ %20”。
 *
 */
public class Coding2 {
	public static void main(String[] args) {
		String str = "We are happy!";
		System.out.println(replaceBlank(str));
	}

	public static String replaceBlank(String inputStr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputStr.length(); i++) {
			if (inputStr.charAt(i)==' ') {
				sb.append("%20");
			} else {
				sb.append(inputStr.charAt(i));
			}
		}
		
		return sb.toString();
	}
}
