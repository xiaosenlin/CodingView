package com.ssa.coding;

//对公司几万名员工的年龄进行排序,时间复杂度O(n);
public class BirthdaySort {
	public static void main(String[] args) throws Exception {
		int[] ages = { 1, 23, 45, 2, 3, 32, 67, 98,67 };
		sortAges(ages,8);
		for (int i : ages) {
			System.out.println(i);
		}
	}

	public static void sortAges(int[] ages, int length) throws Exception {
		if (null == ages || length < 2) {
			return;
		}
		final int oldestAge = 99;

		int[] timesOfAge = new int[oldestAge+1];
		for (int i = 0; i < ages.length; i++) {
			if (ages[i] < 0 || ages[i] > oldestAge) {
				throw new Exception("Out Of Range");
			}
			timesOfAge[ages[i]]++;
		}
		int index = 0;
		for (int i = 0; i <= oldestAge; i++) {
			for (int j = 0; j < timesOfAge[i]; j++) {
				ages[index] = i;
				index++;
			}
		}
	}
}
