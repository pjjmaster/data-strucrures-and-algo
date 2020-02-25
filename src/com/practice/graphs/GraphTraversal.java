package com.practice.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphTraversal {

	private int v;

	private LinkedList<Integer> adj[];

	public GraphTraversal(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void printBFS(int s) {
		boolean visited[] = new boolean[this.v];

		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {

			int element = queue.poll();
			System.out.println(element);

			Iterator<Integer> iterator = adj[element].listIterator();

			while (iterator.hasNext()) {
				int n = iterator.next();

				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}

		}

	}

	public void printDFS() {

		boolean visited[] = new boolean[this.v];

		for (int i = 0; i < this.v; ++i) {
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		}

	}

	private void DFSUtil(int i, boolean[] visited) {

		visited[i] = true;
		System.out.println(i);

		Iterator<Integer> iterator = adj[i].listIterator();

		while (iterator.hasNext()) {
			int n = iterator.next();

			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}

	}

	public static void main(String[] args) {

		GraphTraversal g = new GraphTraversal(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.printBFS(2);
		g.printDFS();
	}

}
