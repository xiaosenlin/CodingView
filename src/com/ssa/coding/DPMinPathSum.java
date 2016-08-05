package com.ssa.coding;

/**
 * 题目：给定一个矩阵，从左上角开始每次只能向右或者向下移动，最后到达右下角的位置，
 * 路径上的所有的数字累加起来作为这条路径的路劲和。要求返回所有路径和中的最小路径和。
 *
 **/

public class DPMinPathSum {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 9 }, { 8, 1, 3, 4 },
				{ 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		int[][] dp = new int[4][4];
		int[][] path = new int[4][4];
		int sum = minPathSum(matrix, dp, path);
		System.out.println("最小路径和是：");
		System.out.println(sum);
	}

	public static int minPathSum(int matrix[][], int dp[][], int path[][]) {
		if (null == matrix) {
			return 0;
		}
		dp[0][0] = matrix[0][0];
		// 初始化第一列的数据
		for (int i = 1; i < matrix.length; i++) {
			dp[i][0] = dp[i - 1][0] + matrix[i][0];
		}
		// 初始化第一行的数据
		for (int j = 1; j < matrix[0].length; j++) {
			dp[0][j] = dp[0][j - 1] + matrix[0][j];
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				int driection = dp[i - 1][j] < dp[i][j - 1] ? 1 : 0;
				if(1==driection){
					dp[i][j] = dp[i-1][j]+matrix[i][j];
				} else {
					dp[i][j] = dp[i][j-1]+matrix[i][j];
				}
			    path[i][j] = driection;
			}
		}
		
		System.out.println("最短路径是：");
		//输出最短路径
		System.out.print(matrix[0][0]+" ");
		for (int i = 1; i < path.length; i++) {
			for (int j = 1; j < path[0].length; j++) {
				if(1 == path[i][j]){
					System.out.print(matrix[i-1][j]+" ");
				}
			}
		}
		System.out.print(matrix[matrix.length-1][matrix[0].length-1]+" ");
		System.out.println();
		return dp[matrix.length - 1][matrix[0].length - 1];
	}
}
