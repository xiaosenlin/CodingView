package com.ssa.coding;

import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是 否为该栈的弹出序列。假设压入栈的所有数字均不相等。例如压栈序列为 1、 2、3、
 * 4、 5. 序列 4、 5、 3、 2、 1 是压栈序列对应的一个弹出序列，但 4、 3、 5、 1、2 却不是。
 *
 */
public class Coding20 {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 4, 5, 3, 1, 2 };
		System.out.println(isPopOrder(array1, array2));

	}

	public static boolean isPopOrder(int[] array, int[] array2) {
		if (null == array || null == array2 || array.length < 1
				|| array2.length < 1 || (array.length != array2.length)) {
			return false;
		}

		boolean bPossible = false;

		int index2 = 0;
		Stack<Integer> stackInts = new Stack<Integer>();
		for (int i = 0; i < array2.length; i++) {
			while (stackInts.isEmpty() || array2[i] != stackInts.peek()) {
				if (index2 >= array.length) {
					return false;
				}
				stackInts.push(array[index2]);
				index2++;
			}

			stackInts.pop();
		}

		if (stackInts.isEmpty() && index2 == array2.length) {
			bPossible = true;
		}

		return bPossible;
	}
}
