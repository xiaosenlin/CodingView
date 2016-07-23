package com.ssa.coding;

/**
 * 
 * 堆排序
 *
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] a = {10,8,2,3,4,5,6,7,9};
		heapSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static void heapSort(int[] a) {
		if (null == a || a.length < 1) {
			return;
		}
		buildMaxHeap(a);
		for (int i = a.length-1; i >=0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			adjustMaxHeap2(a, i, 0);
		}
	}

	public static void buildMaxHeap(int[] a) {
		int mid = a.length / 2;
		for (int i = mid; i >= 0; i--) {
			adjustMaxHeap2(a, a.length, i);
		}
	}

	//递归
	public static void adjustMaxHeap(int[] a, int size, int parent) {
		int left = 2 * parent + 1;
		int right = 2 * parent + 2;
		int largest = parent;
		if (left < size && a[left] > a[parent]) {
			largest = left;
		}
		if (right < size && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != parent) {
			int temp = a[parent];
			a[parent] = a[largest];
			a[largest] = temp;
			adjustMaxHeap(a, size, largest);
		}
	}
	
	//非递归
	public static void adjustMaxHeap2(int[] a, int size, int parent) {
		int largest = parent;
		int count = 0;
		while(true) {
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;
			if (left < size && a[left] > a[parent]) {
				largest = left;
			}
			if (right < size && a[right] > a[largest]) {
				largest = right;
			}
			if (largest != parent) {
				int temp = a[parent];
				a[parent] = a[largest];
				a[largest] = temp;
				parent = largest;
			} else {
				break;
			}
			count++;
		}
		
		System.out.println("-----"+count);
	}
}
