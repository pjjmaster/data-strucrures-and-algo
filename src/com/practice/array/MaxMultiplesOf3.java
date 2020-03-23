package com.practice.array;

import java.util.HashMap;
import java.util.Map;

public class MaxMultiplesOf3 {

	public int solution(int[] A) {
		if (null == A || A.length == 0) {
			return 0;
		}

		int max = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 3 == 0) {
				if (A[i] > max) {
					max = A[i];
				}
			}
		}

		return max;
	}

	public static String solution(String[] A) {
		if (null == A || A.length == 0) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < A.length; i++) {
			String element = A[i];

			if (element.length() > 0) {

				if (element.length() == 1) {
					if (element.equals("k")) {
						builder.append(map.size() + " ");
						continue;
					}
				}

				String[] ops = element.split(":");
				if (ops.length == 2) {
					Integer key = Integer.parseInt(ops[1]);
					if (ops[0].equals("j")) {
						if (map.containsKey(key)) {
							builder.append(map.get(key) + " ");
						} else {
							builder.append(-1 + " ");
						}
					} else if (ops[0].equals("l")) {
						map.remove(key);
					}
				} else if (ops.length == 3) {
					if (ops[0].equals("i")) {
						Integer key = Integer.parseInt(ops[1]);
						Integer value = Integer.parseInt(ops[2]);
						map.put(key, value);
					}
				} else {
					continue;
				}
			}
		}

		return builder.toString();
	}


	static int count;

	static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int solutioncoulour(int[][] A) {
		// write your code in Java SE 8

		if (null == A || A.length <= 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < A[i].length; j++) {

				// leftcheck
				if ((j - 1 > 0) && A[i][j - 1] != A[i][j]) {
					count++;
				}
				// rightcheck
				if (((j + 1) < A[i].length) && A[i][j + 1] != A[i][j]) {
					count++;
				}
				// Up
				if ((i - 1) > 0 && A[i - 1][j] != A[i][j]) {
					count++;
				}
				// Bottom
				if ((i + 1) < A[i].length && A[i + 1][j] != A[i][j]) {
					count++;
				}
			}
		}

		return count;
	}

	

	private static boolean validCoordinates(int x, int y, int xlength, int ylength) {
		return ((x >= 0 && x < xlength) && (y >= 0 && y < ylength)) ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] array = { "i:1:2", "i:66:3", "j:66", "l:1", "k" };

		System.out.println("MaxMultiplesOf3.main(): " + solution(array));

	}

}
