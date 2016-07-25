package com.ssa.coding;

import java.util.LinkedList;

/**
 * 题目：从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class Coding21 {
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		root1.value = 8;
		node1.value = 8;
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
		printFromTopToBottom(root1);
	}

	public static void printFromTopToBottom(BinaryTreeNode root) {
		if (null == root) {
			return;
		}
		java.util.Queue<BinaryTreeNode> queueTreeNode = new LinkedList<BinaryTreeNode>();
		queueTreeNode.add(root);
		while(!queueTreeNode.isEmpty()) {
			BinaryTreeNode pollNode = queueTreeNode.poll();
			System.out.println(pollNode.value);
			if(null!=pollNode.leftNode) {
				queueTreeNode.add(pollNode.leftNode);
			}
			if(null!=pollNode.rightNode) {
				queueTreeNode.add(pollNode.rightNode);
			}
		}
	}
}
