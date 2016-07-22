package com.ssa.coding;

import java.util.Stack;

/**
 * 
 * 题目描述：用两个栈实现一个队列，实现对了的两个函数 appendTail 和
 * deleteHead，分别完成在队列尾插入结点和在队列头部删除结点的功能。
 *
 */
public class Coding5 {
	public static void main(String[] args) throws Exception {
		Queue<Integer> queue = new Queue<Integer>();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		while(!queue.isEmpty()){
			System.out.println(queue.deleteHead());
		}
	}
}

class Queue<T> {
	Stack<T> stack1 = new Stack<T>();
	Stack<T> stack2 = new Stack<T>();

	public void appendTail(T t) {
		stack1.push(t);
	}
	
	public T deleteHead() throws Exception {
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				T t1= stack1.pop();
				stack2.push(t1);
			}
		} 
		if(stack2.isEmpty()){
			throw new Exception("队列为空,不能删除");
		}
		
		return stack2.pop();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
