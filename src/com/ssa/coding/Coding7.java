package com.ssa.coding;

/**
 * 
 * 题目：写一个函数，输入 n，求斐波那契数列的第 n 项。
 *
 */
public class Coding7 {
	public static void main(String[] args) {
		System.out.println(fibonacci2(10));
		// System.out.println(Integer.MIN_VALUE);
	}

	// 递归
	public static int fibonacci(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// 循环
	public static int fibonacci2(int n) {
		int fibOne = 0;
		int fibTwo = 1;
		int fibN = fibOne;
		if (n <= 0) {
			return fibOne;
		}
		if (n == 1) {
			return fibTwo;
		}
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			fibOne = fibTwo;
			fibTwo = fibN;
		}

		return fibN;
	}
}
