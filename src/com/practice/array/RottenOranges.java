package com.practice.array;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	static int count;
	
	static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int orangesRotting(int[][] grid) {

		int length = grid.length;

		Queue<Coordinate> queue = new LinkedList<>();

		getRottenOranges(grid, length, queue);

		int time = 0;

		while (!queue.isEmpty()) {
			Coordinate coordinate = queue.poll();
			if(coordinate==null) {
				time++;
			} else {
				rotOrange(coordinate.x, coordinate.y + 1, length, grid, queue);
				rotOrange(coordinate.x, coordinate.y - 1, length, grid, queue);
				rotOrange(coordinate.x + 1, coordinate.y, length, grid, queue);
				rotOrange(coordinate.x - 1, coordinate.y, length, grid, queue);
				queue.add(null);
			}
		}

		if (freshTomatoExists(grid)) {
			return -1;
		}

		return time;
	}

	private static boolean freshTomatoExists(int[][] grid) {

		int length = grid.length;
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				if (grid[x][y] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private static void rotOrange(int x, int y, int length, int[][] grid, Queue<Coordinate> queue) {
		if (validCoordinates(x, y, length)) {
			grid[x][y] = 2;
			queue.offer(new Coordinate(x, y));
			//flag = true;
		}
	}

	private static boolean validCoordinates(int x, int y, int length) {
		return ((x >= 0 && x < length) && (y >= 0 && y < length)) ? true : false;
	}

	private static void getRottenOranges(int[][] grid, int length, Queue<Coordinate> queue) {
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				if (grid[x][y] == 2) {
					queue.add(new Coordinate(x, y));
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("RottenTomatoes.main():" + orangesRotting(grid));
	}

}
