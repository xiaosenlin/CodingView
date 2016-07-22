package com.ssa.coding;

/**
 * 
 * 题目：输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯， 本题从 1 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6
 * 个结点的 链表，从头结点依次是 1,2,3,4， 5,6。倒数第三个结点就是值为 4 的结点。
 *
 */
public class Coding13 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, null);
		ListNode node2 = new ListNode(2, node1);
		ListNode node3 = new ListNode(3, node2);
		ListNode node4 = new ListNode(4, node3);
		ListNode node5 = new ListNode(5, node4);
		ListNode head = node5;
		ListNode resultNode = findKthToTail(head, 1);
		if (null != resultNode) {
			System.out.println(resultNode.getValue());
		}
	}

	public static ListNode findKthToTail(ListNode head, int k) {
		if (null == head || k <= 0) {
			return null;
		}
		ListNode firstNode = head;
		ListNode secondNode = null;
		for (int i = 0; i < k - 1; i++) {
			if (null != firstNode.getNextNode()) {
				firstNode = firstNode.getNextNode();
			} else {
				return null;
			}
		}
		secondNode = firstNode;
		firstNode = head;
		while (null != secondNode.getNextNode()) {
			secondNode = secondNode.getNextNode();
			firstNode = firstNode.getNextNode();
		}

		return firstNode;
	}
}
