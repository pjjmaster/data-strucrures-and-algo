package com.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class TeamOfCoders {

	static int getCountOfPossibleTeams(List<Integer> coders) {

		if (null == coders || coders.isEmpty()) {
			return 0;
		}

		int[] array = coders.stream().mapToInt(i -> i).toArray();

		int length = array.length;

		int count = 0;

		for (int i = 0; i < length; i++) {

			for (int j = i + 1; j < length; j++) {

				if (array[j] > array[i]) {
					continue;
				}

				for (int k = j + 1; k < length; k++) {

					if (array[k] > array[j]) {
						continue;
					}
					
					if (array[i] > array[j] && array[j] > array[k]) {
						count++;
					}
				}
			}
		}

		for (int i = 0; i < length; i++) {

			for (int j = i + 1; j < length; j++) {

				if (array[j] < array[i]) {
					continue;
				}

				for (int k = j + 1; k < length; k++) {

					if (array[k] < array[j]) {
						continue;
					}
					
					if (array[i] < array[j] && array[j] < array[k]) {
						count++;
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(4);

		
		System.out.println("TeamOfCoders.main()" + getCountOfPossibleTeams(list));
	}

}
