package com.ssa.coding;

import java.util.Stack;

/**
 * 
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所 有路径。
 * 从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Coding23 {
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		root1.value = 8;
		node1.value = 1;
		node2.value = 7;
		node3.value = 9;
		node4.value = 2;
		node5.value = 4;
		node6.value = 7;

		root1.leftNode = node1;
		root1.rightNode = node2;
		node1.leftNode = node3;
		node1.rightNode = node4;
		node4.leftNode = node5;
		node4.rightNode = node6;

		findPath(root1, 15);
	}

	public static void findPath(BinaryTreeNode root, int expectedSum) {
		if (null == root) {
			return;
		}
		Stack<Integer> stackInts = new Stack<Integer>();
		int currentSum = 0;
		findPath(root, expectedSum, currentSum, stackInts);
	}

	public static void findPath(BinaryTreeNode root, int expectedSum,
			int currentSum, Stack<Integer> stackNum) {
		if (null == stackNum) {
			return;
		}
		currentSum += root.value;
		stackNum.push(root.value);
		boolean isLeaf = (null == root.leftNode) && (null == root.rightNode);
		if (isLeaf && currentSum == expectedSum) {
			for (Integer integer : stackNum) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
		if (null != root.leftNode) {
			findPath(root.leftNode, expectedSum, currentSum, stackNum);
		}
		if (null != root.rightNode) {
			findPath(root.rightNode, expectedSum, currentSum, stackNum);
		}
		stackNum.pop();
	}
}
