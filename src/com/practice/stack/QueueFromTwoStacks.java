package com.practice.stack;

import java.util.Stack;

public class QueueFromTwoStacks {

	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();

	public void enQueue(int item) {

		while (!s1.isEmpty()) {
				s2.push(s1.pop());
		}

		s1.push(item);

		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	public Integer deQueue() {
		if (s1.empty()) {
			System.out.println("QueueFromStack.deQueue() : Stack is empty");
		}

		return s1.pop();
	}

	public static void main(String[] args) {

		QueueFromTwoStacks queue = new QueueFromTwoStacks();

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
