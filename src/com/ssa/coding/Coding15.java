package com.ssa.coding;

/**
 * 
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按 照递增排序的。
 *
 */
public class Coding15 {
	public static void main(String[] args) {
		ListNode node9 = new ListNode(9, null);
		ListNode node7 = new ListNode(7, node9);
		ListNode node5 = new ListNode(5, node7);
		ListNode node3 = new ListNode(3, node5);
		ListNode node1 = new ListNode(1, node3);
		ListNode head1 = node1;
		ListNode node8 = new ListNode(8, null);
		ListNode node6 = new ListNode(6, node8);
		ListNode node4 = new ListNode(4, node6);
		ListNode node2 = new ListNode(2, node4);
		ListNode head2 = node2;

		ListNode mergeHead = mergeList(head1, head2);

		while (null != mergeHead) {
			System.out.println(mergeHead.value);
			mergeHead = mergeHead.nextNode;
		}
	}

	public static ListNode mergeList(ListNode head1, ListNode head2) {
		if (null == head1) {
			return head2;
		} else if (null == head2) {
			return head1;
		} else {
			// TODO: no logic to do;
		}

		ListNode mergeHead = null;
		if (head1.value < head2.value) {
			mergeHead = head1;
			head1 = head1.nextNode;
			mergeHead.nextNode = mergeList(head1, head2);
		} else {
			mergeHead = head2;
			head2 = head2.nextNode;
			mergeHead.nextNode = mergeList(head1, head2);
		}

		return mergeHead;
	}

}
