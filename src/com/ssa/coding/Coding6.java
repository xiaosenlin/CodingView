package com.ssa.coding;

/**
 * 旋转数组的最小数字
 *
 */
public class Coding6 {
	public static void main(String[] args) throws Exception {
		// int[] numbers = { 3, 4, 5, 6, 1, 2 };
		int[] numbers = { 1, 0, 1, 1, 1 };
		System.out.println(min(numbers));
	}

	public static int min(int[] numbers) throws Exception {
		if (null == numbers || numbers.length < 1) {
			throw new Exception("Invalid Parameters");
		}
		int index1 = 0;
		int index2 = numbers.length - 1;
		int indexMid = index1;
		while (numbers[index1] >= numbers[index2]) {
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}
			indexMid = (index1 + index2) / 2;
			if (numbers[index1] == numbers[index2]
					&& numbers[indexMid] == numbers[index1]) {
				return minInOrder(numbers);
			}
			if (numbers[indexMid] >= numbers[index1]) {
				index1 = indexMid;
			} else if (numbers[indexMid] <= numbers[index2]) {
				index2 = indexMid;
			}
		}

		return numbers[indexMid];
	}

	public static int minInOrder(int[] numbers) {
		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (result > numbers[i]) {
				result = numbers[i];
			}
		}

		return result;
	}
}
