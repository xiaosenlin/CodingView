package com.ssa.coding;

public class Coding8 {
	public static void main(String[] args) {
		System.out.println(numberOf2(6));
		System.out.println(stepNumbers(13, 10));
		System.out.println(1/2);
	}

	public static int numberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if (0 != (n & flag)) {
				count++;
			}
			flag = flag << 1;

		}
		return count;
	}

	public static int numberOf2(int n) {
		int count = 0;
		while (0 != n) {
			n = (n - 1) & n;
			count++;
		}

		return count;
	}

	public static int stepNumbers(int m, int n) {
		int result = m^n;
		int count = 0;
		while(result!=0){
			result = (result-1)&result;
			count++;
		}
		return count;
	}
}
