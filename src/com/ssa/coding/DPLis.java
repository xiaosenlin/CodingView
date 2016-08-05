package com.ssa.coding;

/**
 * 
 * 给定数组arr，返回arr的最长递增子序列的长度，
 * 比如arr=[2,1,5,3,6,4,8,9,7]，最长递增子序列为[1,3,4,8,9]返回其长度为5.
 *
 */
public class DPLis {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int[] dp = new int[arr.length];
		dp[0] = 1;
		int[] path = new int[arr.length];
		int maxLength = findLIS(arr, dp);
		System.out.println(maxLength);
	}

	public static int findLIS(int[] arr, int[] dp) {
		if (null == arr || null == dp ) {
			return 0;
		}
		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (dp[j] > max && arr[i] > arr[j]) {
					max = dp[j];
				}
				dp[i] = max + 1;
			}
		}
		int maxLength = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > maxLength) {
				maxLength = dp[i];
			}
		}

		return maxLength;
	}
}
