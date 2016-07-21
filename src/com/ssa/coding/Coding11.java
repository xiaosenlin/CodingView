package com.ssa.coding;
/**
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除
该结点。
 */
public class Coding11 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, null);
		ListNode node2 = new ListNode(2, node1);
		ListNode node3 = new ListNode(3, node2);
		ListNode node4 = new ListNode(4, node3);
		ListNode node5 = new ListNode(5, node4);
		ListNode head = node5;
		printListNodeValue(head);
		deleteNode(head, node4);
		System.out.println("-------删除后-------");
		printListNodeValue(head);
	}

	private static void printListNodeValue(ListNode head) {
		while (null != head) {
			System.out.println(head.getValue());
			head = head.getNextNode();
		}
	}

	public static void deleteNode(ListNode head, ListNode deletedNode) {
		if (null == head || null == deletedNode) {
			return;
		}
		if (null != deletedNode.getNextNode()) {
			ListNode node = deletedNode.getNextNode();
			deletedNode.setValue(node.getValue());
			deletedNode.setNextNode(node.getNextNode());
			node = null;

		} else if (head == deletedNode) {
			head = null;
		} else {
			while (deletedNode != head.getNextNode()) {
				head = head.getNextNode();
			}
			head.setNextNode(null);
		}
	}

}
