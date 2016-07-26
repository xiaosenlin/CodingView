package com.ssa.coding;

/**
 * 
 * 题目：实现函数复制一个复杂链表。在复杂链表中，每个结点除了有一个 next 指针指向下一个结点外，还有一个指向链表中任意结点或 null。
 *
 */
public class Coding24 {
	public static void main(String[] args) {
		ComplexListNode root = new ComplexListNode();
		ComplexListNode node1 = new ComplexListNode();
		ComplexListNode node2 = new ComplexListNode();
		ComplexListNode node3 = new ComplexListNode();
		ComplexListNode node4 = new ComplexListNode();
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		root.data = 1;
		node1.data = 2;
		node2.data = 3;
		node3.data = 4;
		node4.data = 5;
		root.sibling = node1;
		node1.sibling = root;
		node3.sibling = node1;
		
		cloneNodes(root);
		connectSiblingNodes(root);
		ComplexListNode head = reconnectNodes(root);
		System.out.println(head);
	}

	public static void cloneNodes(ComplexListNode head) {
		if (null == head) {
			return;
		}
		ComplexListNode node = head;

		while (null != node) {
			ComplexListNode clonedNode = new ComplexListNode();
			clonedNode.data = node.data;
			clonedNode.next = node.next;
			clonedNode.sibling = null;
			node.next = clonedNode;
			node = clonedNode.next;
		}
	}

	public static void connectSiblingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (null != node) {
			ComplexListNode clonedNode = node.next;
			if (null != node.sibling) {
				clonedNode.sibling = node.sibling.next;
			}
			node = clonedNode.next;
		}
	}

	public static ComplexListNode reconnectNodes(ComplexListNode head) {
		ComplexListNode node = head;
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		if (null != node) {
			clonedHead = clonedNode = node.next;
			node.next = clonedNode.next;
			node = node.next;
		}
		while (null != node) {
			clonedNode = node.next;
			node.next =clonedNode.next;
			node = node.next;
		}
		
		return clonedHead;
	}
}

class ComplexListNode {
	int data;
	ComplexListNode next;
	ComplexListNode sibling;
}