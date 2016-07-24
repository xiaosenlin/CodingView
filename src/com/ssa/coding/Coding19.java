package com.ssa.coding;

import java.util.LinkedList;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min 函数。
 * 在该栈中，调用min、 push及pop的时间复杂度都是O(1)
 */
public class Coding19 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(3);
		minStack.push(0);
		minStack.push(4);
		minStack.push(1);
		minStack.push(-1);
		minStack.push(5);
		System.out.println(minStack.min());
	}
}

abstract class MyStack<T> {
	protected LinkedList<T> stack1;
	protected LinkedList<T> stack2;

	public MyStack() {
		stack1 = new LinkedList<T>();
		stack2 = new LinkedList<T>();
	}

	public abstract void push(T t);

	public abstract T pop();

	public abstract T min();
}

class MinStack extends MyStack<Integer> {

	@Override
	public void push(Integer t) {

		if (null != stack1 && null != stack2) {
			stack1.push(t);
			if (stack2.isEmpty() || t < stack2.getFirst()) {
				stack2.push(t);
			} else {
				stack2.push(stack2.getFirst());
			}
		}

	}

	@Override
	public Integer pop() {
		Integer t = null;
		if (null != stack1 && null != stack2 && !stack1.isEmpty()
				&& !stack2.isEmpty()) {
			t = stack1.pop();
			stack2.pop();
		}

		return t;
	}

	@Override
	public Integer min() {
		Integer t = null;
		if (null != stack2 && !stack2.isEmpty()) {
			t = stack2.getFirst();
		}
		return t;
	}

}
