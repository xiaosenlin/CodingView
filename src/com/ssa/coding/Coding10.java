package com.ssa.coding;

public class Coding10 {
	public static void main(String[] args) {
		/*
		 * char a = '3'; int b = a - '0'; System.out.println(b); int c = 4; char
		 * d = (char) (c+'0'); System.out.println(d);
		 */
		// printToMaxOfNDigits(3);
		printToMaxOfNDigits2(3);
	}

	public static void printToMaxOfNDigits(int n) {
		if (n < 0) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		while (!increment(number)) {
			printNumber(number);
		}

	}

	public static boolean increment(char[] number) {
		boolean isOverflow = false;// 是否溢出
		int nTakeOver = 0;// 进位

		for (int i = number.length - 1; i >= 0; i--) {
			// 第n位的值 = 先-'0'转化为对应的数字,然后+第(n+1)位的进位
			int nSum = number[i] - '0' + nTakeOver;
			if (i == number.length - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) (nSum + '0');
				}
			} else {
				number[i] = (char) (nSum + '0');
				break;
			}
		}

		return isOverflow;
	}

	public static void printNumber(char[] number) {
		if (null == number || number.length < 1) {
			return;
		}
		boolean isBegin0 = true;
		for (int i = 0; i < number.length; i++) {
			if (isBegin0 && number[i] != '0') {
				isBegin0 = false;
			}
			if (!isBegin0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}

	// 全排列方式,递归
	public static void printToMaxOfNDigits2(int n) {
		if (n < 0) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}

		printToMaxOfNDigitsRecusively(number, 0);
	}

	public static void printToMaxOfNDigitsRecusively(char[] number, int index) {

		for (int i = 0; i < 10; i++) {
			if (index != number.length) {
				number[index] = (char) (i + '0');
				printToMaxOfNDigitsRecusively(number, index + 1);
			} else {
				printNumber(number);
				return;
			}
		}

	}
}
