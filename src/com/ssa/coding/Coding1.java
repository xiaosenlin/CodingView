package com.ssa.coding;

/**
 * 
 * 题目描述： 一个二维数组，每一行从左到右递增，每一列从上到下递增．输
 * 入一个二维数组和一个整数，判断数组中是否含有整数。
 *
 */
public class Coding1 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(find(matrix, 4, 4, 7));
	}

	public static boolean find(int[][] matrix, int rows, int columns, int number) {
		boolean found = false;
		if (null != matrix && rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while (row < rows && column >= 0) {
				if (number == matrix[row][column]) {
					found = true;
					break;
				} else if (number < matrix[row][column]) {
					column--;
				} else {
					row++;
				}
			}
		}

		return found;
	}
}
