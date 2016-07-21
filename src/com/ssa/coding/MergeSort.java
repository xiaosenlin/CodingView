package com.ssa.coding;


public class MergeSort {
	public static void main(String[] args) {
		//int[] a = { 9, 1, 5, 5, 3, 4, 2, 6, 8, 7 };
		// mergeSort1(a, 0, 9);
		int[]a = {0,1,2,3,4,5,6,7,8};
		mergeSort2(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	// 递归
	public static void mergeSort1(int[] a, int low, int high) {
		if (null == a || low < 0 || high < 0) {
			return;
		}
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			mergeSort1(a, low, mid);
			// 右边
			mergeSort1(a, mid + 1, high);
			// 合并
			merge(a, low, mid, high);
		}
	}

	// 合并
	public static void merge(int[] a, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		int[] temp = new int[high - low + 1];

		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		// 左边的补齐
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		// 右边的补齐
		while (j <= high) {
			temp[k++] = a[j++];
		}

		for (int l = 0; l < temp.length; l++) {
			a[low + l] = temp[l];
		}
	}

	public static void mergeSort2(int[] a) {
		if (null == a || a.length < 1) {
			return;
		}

		int len = 1;
		while (len <= a.length) {
			for (int i = 0; i + len < a.length; i += len * 2) {
				int low = i;
				int mid = i + len - 1;
				int high = i + len * 2 - 1;
				if (high > a.length - 1) {
					high = a.length - 1;
				}
				merge(a, low, mid, high);
			}

			len *= 2;
		}

	}
}
