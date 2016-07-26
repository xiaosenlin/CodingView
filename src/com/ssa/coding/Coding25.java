package com.ssa.coding;


/**
 * 
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Coding25 {
	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode();
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		root1.value = 10;
		node1.value = 6;
		node2.value = 14;
		node3.value = 4;
		node4.value = 8;
		node5.value = 12;
		node6.value = 16;

		root1.leftNode = node1;
		root1.rightNode = node2;
		node1.leftNode = node3;
		node1.rightNode = node4;
		node2.leftNode = node5;
		node2.rightNode = node6;

		BinaryTreeNode head = convert(root1);
		while (null!=head) {
			System.out.println(head.value);
			head = head.rightNode;
		}

	}

	public static BinaryTreeNode convert(BinaryTreeNode root) {
		if (null == root) {
			return null;
		}

		BinaryTreeNode lastNodeList = null;

		BinaryTreeNode headOfList = convertNode(root, lastNodeList);

		while (null != headOfList && null != headOfList.leftNode) {
			headOfList = headOfList.leftNode;
		}

		return headOfList;
	}

	public static BinaryTreeNode convertNode(BinaryTreeNode node,
			BinaryTreeNode lastNodeList) {
		if (null == node) {
			return null;
		}
		BinaryTreeNode currentNode = node;
		if (null != currentNode.leftNode) {
			//这里需要返回值,原书上用的是C++,C++有引用传递,而java中只有值传递,要注意区分
			lastNodeList = convertNode(currentNode.leftNode, lastNodeList);
		}
		currentNode.leftNode = lastNodeList;
		if (null != lastNodeList) {
			lastNodeList.rightNode = currentNode;
		}
		lastNodeList = currentNode;

		if (null != currentNode.rightNode) {
			lastNodeList = convertNode(currentNode.rightNode, lastNodeList);
		}

		return lastNodeList;
	}
}
