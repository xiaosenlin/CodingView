package com.ssa.coding;

import java.util.LinkedList;

/**
 * 
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 *
 */
public class Coding3 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, null);
		ListNode node2 = new ListNode(2, node1);
		ListNode node3 = new ListNode(3, node2);
		System.out.println("----非递归实现----");
		printListFromTailToHead(node3);
		System.out.println("----递归实现-----");
		printListFromTailToHeadRecursion(node3);
	}

	public static void printListFromTailToHead(ListNode nodeHead) {
		LinkedList<ListNode> stackNodes = new LinkedList<ListNode>();
		while (null != nodeHead) {
			stackNodes.push(nodeHead);
			nodeHead = nodeHead.getNextNode();
		}

		while (stackNodes.size() != 0) {
			System.out.println(stackNodes.pop().getValue());
		}
	}

	public static void printListFromTailToHeadRecursion(ListNode nodeHead) {
		if (null != nodeHead) {
			if (null != nodeHead.getNextNode()) {
				printListFromTailToHeadRecursion(nodeHead.getNextNode());
			}
			
			System.out.println(nodeHead.getValue());
		} 
	}
}

class ListNode {
	public int value;
	public ListNode nextNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public ListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}

	public ListNode(int value, ListNode nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}
}