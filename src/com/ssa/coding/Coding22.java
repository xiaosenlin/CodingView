package com.ssa.coding;

import java.util.Arrays;

/**
 * 
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 是则返回true，否则返回false。
 *
 */
public class Coding22 {
	public static void main(String[] args) {
		int[] sequence = { 5, 7, 6, 9, 11, 10, 8 };
		int[] sequence1 = { 7, 4, 6, 5 };
		int[] sequence2 = { 5, 7, 6, 8 };
		int[] sequence3 = { 9, 11, 10, 8 };
		System.out.println(verifySquenceOfBST(sequence3));
	}

	public static boolean verifySquenceOfBST(int[] sequence) {
		if (null == sequence || sequence.length < 1) {
			return false;
		}

		int root = sequence[sequence.length - 1];
		int splitIndex = 0;
		for (int i = 0; i < sequence.length - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
			splitIndex = i + 1;
		}
		for (int j = splitIndex; j < sequence.length - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		boolean left = true;
		if (splitIndex > 0) {
			left = verifySquenceOfBST(Arrays.copyOfRange(sequence, 0,
					splitIndex));
		}
		boolean right = true;
		if (splitIndex < sequence.length - 1) {
			right = verifySquenceOfBST(Arrays.copyOfRange(sequence, splitIndex,
					sequence.length - 1));
		}

		return (right && left);
	}
}
