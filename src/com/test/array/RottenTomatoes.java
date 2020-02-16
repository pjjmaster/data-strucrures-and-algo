package com.test.array;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottenTomatoes {

	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, -1, 0, 1 };

	public static int orangesRotting(int[][] grid) {
		int R = grid.length, C = grid[0].length;

		// queue : all starting cells with rotten oranges
		Queue<Integer> queue = new ArrayDeque();
		Map<Integer, Integer> depth = new HashMap();
		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c)
				if (grid[r][c] == 2) {
					int code = r * C + c;
					queue.add(code);
					depth.put(code, 0);
				}

		int ans = 0;
		while (!queue.isEmpty()) {
			int code = queue.remove();
			int r = code / C, c = code % C;
			for (int k = 0; k < 4; ++k) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
					grid[nr][nc] = 2;
					int ncode = nr * C + nc;
					queue.add(ncode);
					depth.put(ncode, depth.get(code) + 1);
					ans = depth.get(ncode);
				}
			}
		}

		for (int[] row : grid)
			for (int v : row)
				if (v == 1)
					return -1;
		return ans;

	}

	public static int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];
		int value = 1;
		int up = 0;
		int left = 0;
		int right = n - 1;
		int down = n - 1;

		while (true) {

			// left-up to right-up
			for (int i = left; i < right; i++) {
				result[left][right] = value++;
			}

			if (value == n * n) {
				break;
			}

			// right-up to right down

		}

		return null;
	}

	public static int orangesRotting2(int[][] grid) {

		int length = grid.length;
		int totalTime = 0;

		for (int x = 0; x < length; x++) {

			for (int y = x; y < length; y++) {
				if (grid[x][y] == 0 || grid[x][y] == 1) {
					continue;
				}
				if (grid[x][y] == 2) {
					if (x + 1 < length) {
						grid[x + 1][y] = 2;
					}
					if (y + 1 < length) {
						grid[x][y + 1] = 2;
					}
					totalTime++;
				}
			}
		}

		for (int x = 0; x < length; x++) {

			for (int y = x; y < length; y++) {
				if (grid[x][y] == 1) {
					return -1;
				}
			}
		}

		return totalTime;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("RottenTomatoes.main():" + orangesRotting(grid));
	}

}
