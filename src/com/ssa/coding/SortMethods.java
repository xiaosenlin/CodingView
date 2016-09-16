package com.ssa.coding;


public class SortMethods {
	public static void main(String[] args) {
		int[] arr = {3,4,2,1,6,5};
		insertSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}
			}
			if (flag == false) {
				return;// 若没有发生交换，说明是有序的
			}
		}
	}

	public static void selectSort(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[i]){
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	
	public static void insertSort(int[] a) {
		if (null == a || a.length < 2) {
			return;
		}
		for (int i = 1; i < a.length; i++) {
			// 暂存当前值
			int temp = a[i];
			int j = i - 1;
			while (j >= 0 && temp < a[j]) {
				// 后移
				a[j + 1] = a[j];
				j--;
			}
			// 当前值归位
			a[j + 1] = temp;
		}
	}

}
