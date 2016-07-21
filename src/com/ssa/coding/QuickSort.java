package com.ssa.coding;

import java.util.LinkedList;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		// quickSort1(a, 0, 9);
		quickSort2(a, 0, 9);
		for (int i : a) {
			System.out.println(i);
		}
	}

	// 递归
	public static void quickSort1(int[] a, int low, int high) {
		if (null == a || a.length < 2) {
			return;
		}

		if (low < high) {
			int mid = partition(a, low, high);
			quickSort1(a, low, mid - 1);
			quickSort1(a, mid + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		int left = low;
		int pivot = a[low];
		while (low < high) {
			while (a[high] >= pivot && low < high) {
				high--;
			}
			while (a[low] <= pivot && low < high) {
				low++;
			}
			if (low < high) {
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
			}
		}

		a[left] = a[low];
		a[low] = pivot;

		return low;
	}

	// 非递归
	public static void quickSort2(int[] a, int low, int high) {
		if (null == a || a.length < 2) {
			return;
		}
		LinkedList<Integer> stackIndexs;

		if (low < high) {
			stackIndexs = new LinkedList<Integer>();
			stackIndexs.push(low);
			stackIndexs.push(high);
			while (!stackIndexs.isEmpty()) {
				int right = stackIndexs.pop();
				int left = stackIndexs.pop();
				//因为后面判断了left<mid-1 right>mid+1
				//所以此处right是不可能<=left，其实这三行代码可以省去，
				//防御性编程
				if (right <= left) {
					break;
				}
				int mid = partition(a, left, right);
				if (left < mid - 1) {
					stackIndexs.push(left);
					stackIndexs.push(mid - 1);
				}
				if (right > mid + 1) {
					stackIndexs.push(mid + 1);
					stackIndexs.push(right);
				}
			}
		}
	}
}
