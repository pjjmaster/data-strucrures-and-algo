package com.practice.stack;

import java.util.Stack;

public class QueueFromOneStack {

	private Stack<Integer> stack = new Stack<>();

	public void enQueue(int item) {
		stack.push(item);
	}

	public Integer deQueue() {

		if (stack.empty()) {
			System.out.println("Queue is empty!");
			System.exit(0);
		} else if (stack.size() == 1) {
			return stack.pop();
		} else {

			// pop an item from the stack
			int x = stack.pop();

			int result = deQueue();

			// push back the popped element
			stack.push(x);

			return result;
		}

		return null;
	}

	public static void main(String[] args) {

		QueueFromOneStack queue = new QueueFromOneStack();

		queue.enQueue(1);

		queue.enQueue(2);

		queue.enQueue(3);

		System.out.println("Queue.get: " + queue.deQueue());

		queue.enQueue(4);

		System.out.println("Queue.get: " + queue.deQueue());

		System.out.println("Queue.get: " + queue.deQueue());

		System.out.println("Queue.get: " + queue.deQueue());

	}

}
