package com.ssa.coding;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 */
public class Coding18 {
	public static void main(String[] args) {
		/*int[][] matrix = { { 1, 2, 3, 4,17 }, { 5, 6, 7, 8,18 },
				{ 9, 10, 11, 12,19 }, { 13, 14, 15, 16,20 } };*/
		// int[][] matrix1 = new int[4][5];
		//System.out.println(matrix.length);
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8},
				{ 9, 10, 11, 12}, { 13, 14, 15, 16 },{17,18,19,20} };
		printMatrixClockwisely(matrix);
	}

	public static void printMatrixClockwisely(int[][] matrix) {
		if (null == matrix || matrix[0].length <= 0 || matrix.length <= 0) {
			return;
		}
		int start = 0;
		while (matrix[0].length > start * 2 && matrix.length > start * 2) {
			printMatrixInCircle(matrix, start);
			start++;
		}
	}

	public static void printMatrixInCircle(int[][] matrix, int start) {
		int endX = matrix.length - start - 1;
		int endY = matrix[0].length - start - 1;
		//第一步
		for (int i = start; i <= endY; i++) {
			System.out.println(matrix[start][i]);
		}
		//第二步
		if(endX>start) {
			for (int i = start+1; i <=endX; i++) {
				System.out.println(matrix[i][endY]);
			}
		}
		//第三步
		if(endY>start && endX>start) {
			for (int i = endY-1; i >= start; i--) {
				System.out.println(matrix[endX][i]);
			}
		}

		//第四步
		if(endY > start && (endX-start>=2)) {
			for (int i = endX-1; i >= start+1; i--) {
				System.out.println(matrix[i][start]);
			}
		}
		
	}
}
