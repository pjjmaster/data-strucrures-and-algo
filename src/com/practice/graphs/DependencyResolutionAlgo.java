package com.practice.graphs;

import java.util.ArrayList;
import java.util.List;

public class DependencyResolutionAlgo {

	public static List<Node> nodes = new ArrayList<DependencyResolutionAlgo.Node>();

	static class Node {
		char name;
		List<Node> edges;

		public Node(char name) {
			this.name = name;
		}

		public void addEdge(Node toNode) {
			if (edges == null) {
				edges = new ArrayList<>();
			}
			edges.add(toNode);
		}
	}

	public static void printDependenctTree(Node node, List<Character> resolved) {
		System.out.println(node.name);

		if (null == node.edges) {
			resolved.add(node.name);
			return;
		}
		for (Node edge : node.edges) {
			if (!resolved.contains(edge.name)) {
				printDependenctTree(edge, resolved);
			}
		}
		resolved.add(node.name);

	}

	public static void main(String[] args) {
		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');

		a.addEdge(b);
		a.addEdge(d);

		b.addEdge(c);
		b.addEdge(e);

		c.addEdge(d);
		c.addEdge(e);

		DependencyResolutionAlgo.nodes.add(a);
		DependencyResolutionAlgo.nodes.add(b);
		DependencyResolutionAlgo.nodes.add(c);
		DependencyResolutionAlgo.nodes.add(d);
		DependencyResolutionAlgo.nodes.add(e);

		List<Character> resolved = new ArrayList<>();
		printDependenctTree(a, resolved);

		System.out.println("DependencyResolutionAlgo.main()");

		for (Character character : resolved) {
			System.out.println(character);
		}
	}

}
