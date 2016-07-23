package com.ssa.coding;

/**
 * 题目：输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构。
 *
 */
public class Coding16 {
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

		BinaryTreeNode root2 = new BinaryTreeNode();
		BinaryTreeNode node7 = new BinaryTreeNode();
		BinaryTreeNode node8 = new BinaryTreeNode();
		root2.value = 8;
		node7.value = 9;
		node8.value = 2;

		root2.leftNode = node7;
		root2.rightNode = node8;

		System.out.println(hasSubTree(root1, root2));
	}

	public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		boolean result = false;
		if (null != root1 && null != root2) {
			if (root1.value == root2.value) {
				result = doesTree1HasTree2(root1, root2);
			}
			if (!result) {
				result = hasSubTree(root1.leftNode, root2);
			}
			if (!result) {
				result = hasSubTree(root1.rightNode, root2);
			}
		}

		return result;
	}

	public static boolean doesTree1HasTree2(BinaryTreeNode root1,
			BinaryTreeNode root2) {
		if (null == root2) {
			return true;
		}
		if (null == root1) {
			return false;
		}
		if (root1.value != root2.value) {
			return false;
		}

		return doesTree1HasTree2(root1.leftNode, root2.leftNode)
				&& doesTree1HasTree2(root1.rightNode, root2.rightNode);
	}
}
