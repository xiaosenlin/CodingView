package com.ssa.coding;

import java.util.Stack;

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
