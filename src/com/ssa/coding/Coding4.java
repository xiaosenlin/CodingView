package com.ssa.coding;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 
 * 题目描述：输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。 假设前 序遍历和中序遍历结果中都不包含重复的数字，例如输入的前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出二叉树
 *
 */
public class Coding4 {
	public static void main(String[] args) throws Exception {
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = constructCore(preOrder, inOrder);
		System.out.println("----后续遍历输出----");
		// postOrderBinaryTree(root);
		postOrderBT(root);
	}

	public static BinaryTreeNode constructCore(int[] preOrder, int[] inOrder)
			throws Exception {
		if (null == preOrder || null == inOrder) {
			return null;
		}
		if (preOrder.length != inOrder.length) {
			throw new Exception("长度不一致,非法输入");
		}

		// (preOrder.length==0 && inOrder.length==0)
		BinaryTreeNode root = null;
		if (preOrder.length > 0 && inOrder.length > 0) {
			root = new BinaryTreeNode();
		}

		for (int i = 0; i < inOrder.length; i++) {
			if (preOrder[0] == inOrder[i]) {
				root.value = inOrder[i];
				System.out.println(root.value);

				root.leftNode = constructCore(
						Arrays.copyOfRange(preOrder, 1, i + 1),
						Arrays.copyOfRange(inOrder, 0, i));
				root.rightNode = constructCore(
						Arrays.copyOfRange(preOrder, i + 1, preOrder.length),
						Arrays.copyOfRange(inOrder, i + 1, inOrder.length));
			}
		}

		return root;
	}

	public static void postOrderBinaryTree(BinaryTreeNode root)
			throws Exception {
		if (null == root) {
			throw new Exception("输入非法");
		}
		if (null != root.leftNode) {
			postOrderBinaryTree(root.leftNode);
		}
		if (null != root.rightNode) {
			postOrderBinaryTree(root.rightNode);
		}
		System.out.println(root.value);
	}

	public static void postOrderBT(BinaryTreeNode root) throws Exception {
		if (null == root) {
			throw new Exception("输入非法");
		}
		LinkedList<BinaryTreeNode> stackNodes = new LinkedList<BinaryTreeNode>();
		stackNodes.push(root);

		while (!stackNodes.isEmpty()) {
			BinaryTreeNode node = stackNodes.pop();
			while (null != node) {
				stackNodes.push(node);
				node = node.leftNode;
			}
			boolean continue1 = true;
			while (continue1 && !stackNodes.isEmpty()) {
				BinaryTreeNode node1 = stackNodes.pop();
				switch (node1.tag) {
				case 0:
					node1.tag = 1;
					stackNodes.push(node1);
					continue1 = false;
					node1 = node1.rightNode;
					stackNodes.push(node1);
					break;
				case 1:
					System.out.println(node1.value);
					break;
				default:
					break;
				}

			}

		}

	}
}

class BinaryTreeNode {
	public int tag;
	public int value;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;
}