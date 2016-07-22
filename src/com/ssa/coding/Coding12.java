package com.ssa.coding;

/**
 * 输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得
 * 所有奇数位于数组的前半部分，所有的数组位于数组的后半部分。
 *
 */
public class Coding12 {
	public static void main(String[] args) {
		Test test = new Test();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		reOrder(array, test);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void reOrder(int[] array, ITest test) {
		if (null == array || array.length < 1 || null == test) {
			return;
		}
		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			while (start < end && !test.isEven(array[start])) {
				start++;
			}
			while (start < end && test.isEven(array[end])) {
				end--;
			}
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}

	}
}

class Test implements ITest {
	@Override
	public boolean isEven(int n) {
		return ((n & 1) == 0) ? true : false;
	}
}

interface ITest {
	boolean isEven(int n);
}
