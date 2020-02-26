package com.practice.stack;

import java.util.Stack;

public class MinBracketReversal {

	public static int minReversalsUsingStack(String expr) {

		int size = expr.length();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			char c = expr.charAt(i);
			if (c == '}' && !stack.isEmpty()) {
				if (stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push('}');
				}
			} else {
				stack.push('{');
			}
		}

		int open = 0;
		int closed = 0;

		while (!stack.isEmpty()) {
			char bracket = stack.pop();
			if (bracket == '{') {
				open++;
			} else {
				closed++;
			}
		}

		return (open / 2 + closed / 2);

	}

	public int reversals(String expr) {

		int n = expr.length();

		int open = 0;
		int closed = 0;

		for (int i = 0; i < n; i++) {

			if (expr.charAt(i) == '{') {
				open++;
			} else {
				if (open == 0) {
					closed++;
				} else {
					open--;
				}
			}
		}

		int answer = open / 2 + closed / 2;

		// For the case: "}{" or when one closing and
		// one opening bracket remains for pairing, then
		// both need to be reversed.

		closed = closed % 2;

		if (closed != 0) {
			answer = answer + 2;
		}

		return answer;
	}

	public static void main(String[] args) {

	}

}
