package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairsWithSameSum {

	static class Indices {
		int index1;
		int index2;

		public Indices(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}
	}

	/*
	 * Find four elements a, b, c and d in an array such that a+b = c+d
	 */

	public static List<Indices> findElements(int[] array) {

		if (null == array || array.length == 0) {
			return Collections.emptyList();
		}

		List<Indices> list = new ArrayList<>();

		Map<Integer, Indices> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				int sum = array[i] + array[j];

				if (!map.containsKey(sum)) {
					map.put(sum, new Indices(i, j));
				} else {
					Indices indices = map.get(sum);
					list.add(indices);
					list.add(new Indices(i, j));
					System.out.println("Indexes with same sum: (" + array[i] + " , " + array[j] + ") & ("
							+ array[indices.index1] + " , " + array[indices.index2] + ")");
				}

			}
		}

		return list;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 4, 7, 1, 2, 9, 8 };
		findElements(arr);
	}

}
