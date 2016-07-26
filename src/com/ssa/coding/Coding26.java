package com.ssa.coding;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *
 */
public class Coding26 {
	public static void main(String[] args) {
		char[] str = { 'a', 'b', 'c', 'd' };
		// permutation(str);
		/*
		 * ArrayList<String> permutation2 = permutation2("abcd"); for (String
		 * temp : permutation2) { System.out.println(temp); }
		 */
		permutationNo("abc");
	}

	public static void permutation(char[] str) {
		if (null == str || str.length < 1) {
			return;
		}
		permutation(str, 0);
	}

	// 递归
	public static void permutation(char[] str, int startIndex) {
		if (startIndex == str.length) {
			System.out.println(str);
		} else {
			for (int i = startIndex; i < str.length; i++) {
				char temp = str[i];
				str[i] = str[startIndex];
				str[startIndex] = temp;

				permutation(str, startIndex + 1);

				temp = str[i];
				str[i] = str[startIndex];
				str[startIndex] = temp;
			}
		}
	}

	// 非递归//错误,这个用栈模拟的还未实现
	public static void permutationNo(String str) {
		Stack<Integer> stackIntIndexs = new Stack<Integer>();
		char[] charArrays = str.toCharArray();
		for (int i = 0; i <= charArrays.length; i++) {
			stackIntIndexs.push(i);
		}
		System.out.println(str);
		do {
			boolean isFlag = false;
			int j = stackIntIndexs.pop();
			/*
			 * if (j == charArrays.length) { System.out.println(charArrays); }
			 */
			for (; j < charArrays.length; j++) {

				if (j + 1 < charArrays.length) {
					swap(charArrays, j);
					isFlag = true;
					stackIntIndexs.push(j + 1);
				}
			}

			if (j == charArrays.length && isFlag) {
				System.out.println(charArrays);
			}

		} while (!stackIntIndexs.isEmpty());

	}

	private static void swap(char[] charArrays, int j) {
		char temp = charArrays[j];
		charArrays[j] = charArrays[j + 1];
		charArrays[j + 1] = temp;
	}

	// 非递归
	public static ArrayList<String> permutation2(String str) {
		// 使用TressSet是因为它是有序的
		TreeSet<String> tree = new TreeSet<String>();
		// 创建一个栈保存每次排列的字符组合
		Stack<String[]> stack = new Stack<String[]>();
		// 存放最终的排列结果
		ArrayList<String> results = new ArrayList<String>();
		stack.push(new String[] { str, "" });
		do {
			// 这里的popStrs就是str输入的字符串
			String[] popStrs = stack.pop();
			// 空串
			String oldStr = popStrs[1];
			// str
			String statckStr = popStrs[0];
			for (int i = statckStr.length() - 1; i >= 0; i--) {
				String[] strs = new String[] {
						statckStr.substring(0, i) + statckStr.substring(i + 1),
						oldStr + statckStr.substring(i, i + 1) };
				if (strs[0].length() == 0) {
					tree.add(strs[1]);
				} else {
					stack.push(strs);
				}
			}
		} while (!stack.isEmpty());
		for (String s : tree)
			results.add(s);
		return results;
	}
}
