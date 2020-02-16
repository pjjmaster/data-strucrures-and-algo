package com.practice.linkedlist;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class SnakesLadderPart1 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int ladders[][] = { { 4, 14 }, { 8, 22 }, { 9, 31 }, { 20, 38 }, { 28, 84 }, { 40, 59 }, { 51, 67 }, { 63, 81 },
				{ 71, 86 }, { 79, 100 } };
		
		

		int snakes[][] = { { 17, 7 }, { 54, 34 }, { 62, 19 }, { 64, 60 }, { 85, 24 }, { 90, 78 }, { 99, 70 } };

		HashMap<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();

		HashMap<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();

		HashMap<Integer, Integer> laddersonMyWay = new HashMap<Integer, Integer>();

		/*ladderMap.put(1, 38);
		ladderMap.put(4, 14);
		ladderMap.put(9, 31);
		ladderMap.put(21, 42);
		ladderMap.put(28, 84);
		ladderMap.put(51, 67);
		ladderMap.put(72, 91);
		ladderMap.put(80, 99);
		
		snakeMap.put(17, 7);
		snakeMap.put(54, 34);
		snakeMap.put(62, 19);
		snakeMap.put(64, 60);
		snakeMap.put(87, 36);
		snakeMap.put(93, 73);
		snakeMap.put(95, 75);
		snakeMap.put(98, 79);*/
		
		System.out.println(ladders[1][1]);

		int max = ladders.length > snakes.length ? ladders.length : snakes.length;

		int min = ladders.length < snakes.length ? ladders.length : snakes.length;

		for (int i = 0; i < max; ++i) {

			for (int j = 0; j < 1; ++j) {

				ladderMap.put(ladders[i][j], ladders[i][j + 1]);

				if (i < min)

					snakeMap.put(snakes[i][j], snakes[i][j + 1]);

			}

		}

		System.out.println(ladderMap);

		System.out.println(snakeMap);

		int i = 0;

		// int maxLengthofBoard = 100;

		// Problem 1

		int maxDiceVal = 6;

		int possibleMove = 0;

		int count = 0;

		while (i < 100) {

			for (int j = i; j <= i + maxDiceVal; ++j) {

				if (ladderMap.containsKey(j)) {

					laddersonMyWay.put(j, ladderMap.get(j));

				}

				else if (!snakeMap.containsKey(j)) {

					possibleMove = j;

				}

			}

			// Will try to find out of multiple ladders in one dice roll, which is the
			// longest ladder

			if (laddersonMyWay.size() > 0) {

				int value = 0;

		
				for (Integer key : laddersonMyWay.keySet()) {

					if (value < laddersonMyWay.get(key)) {

						value = laddersonMyWay.get(key);

					}

				}

				if (value > i && value > possibleMove)

					i = value;

			} else {

				i = possibleMove;

			}

			count++;

			System.out.println("Next stop: " + i);

			laddersonMyWay.clear();

		}

		System.out.println("Total Stops: " + count);

	}

	@SuppressWarnings("unused")
	private static void readInputFileSpaceSeparatedIntoMap(HashMap<Integer, Integer> map, String fileName) {
		List<String> allLines = null;
		Path path = Paths.get(fileName);
		try {
			allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String line : allLines) {
			String[] parts = line.split(" ");
			map.put(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		}
	}

	
}
