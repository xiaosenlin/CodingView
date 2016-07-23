package com.ssa.coding;

/**
 * 
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 *
 */
public class Coding14 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, null);
		ListNode node2 = new ListNode(2, node1);
		ListNode node3 = new ListNode(3, node2);
		ListNode node4 = new ListNode(4, node3);
		ListNode node5 = new ListNode(5, node4);
		ListNode head = node5;
		ListNode reverseHead = reverseList(head);
		while(null!=reverseHead) {
			System.out.println(reverseHead.getValue());
			reverseHead = reverseHead.getNextNode();
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode reverseHead = null;
		ListNode currentNode = head;
		ListNode preNode = null;
		while (null != currentNode) {
			ListNode node = currentNode.getNextNode();
			if (null == node) {
				reverseHead = currentNode;
			}
			currentNode.setNextNode(preNode);
			preNode = currentNode;
			currentNode = node;
		}
		
		return reverseHead;
	}
}
