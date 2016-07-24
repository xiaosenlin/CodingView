package com.ssa.coding;

import java.util.LinkedList;

/**
 * 
 *
 */
public class Coding17 {
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

		mirrorNoRecursively(root1);

		System.out.println(root1.value);

	}

	// 递归
	public static void mirrorRecursively(BinaryTreeNode root) {
		if (null == root) {
			return;
		}
		if (null == root.leftNode && null == root.rightNode) {
			return;
		}
		BinaryTreeNode temp = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = temp;

		if (null != root.leftNode) {
			mirrorRecursively(root.leftNode);
		}
		if (null != root.rightNode) {
			mirrorRecursively(root.rightNode);
		}
	}

	// 非递归
	public static void mirrorNoRecursively(BinaryTreeNode root) {

		if (null == root) {
			return;
		}
		if (null == root.leftNode && null == root.rightNode) {
			return;
		}

		LinkedList<BinaryTreeNode> stackTreeNodes = new LinkedList<BinaryTreeNode>();
		while (null != root || !stackTreeNodes.isEmpty()) {
			if (null != root) {
				stackTreeNodes.push(root);
				BinaryTreeNode temp = root.leftNode;
				root.leftNode = root.rightNode;
				root.rightNode = temp;
				root = root.leftNode;
			} else {
				BinaryTreeNode popNode = stackTreeNodes.pop();
				root = popNode.rightNode;
			}
		}
	}
}
