package com.practice.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchicalText {

	public static List<String> extractDataAtLevel(String hierarchicalData, int level) {

		String[] lines = hierarchicalData.split(System.getProperty("line.separator"));

		int localLevel = 0;

		Map<Integer, List<String>> levelData = new HashMap<>();

		for (String line : lines) {

			String trimmedLine = line.trim();
			if (trimmedLine.equals("{")) {
				localLevel++;
				continue;
			} else if (trimmedLine.equals("}")) {
				localLevel--;
				continue;
			} else {
				if (null != line) {
					List<String> list = levelData.getOrDefault(localLevel, new ArrayList<String>());
					list.add(trimmedLine);
					levelData.put(localLevel, list);
				}
			}

		}
		
		return levelData.get(level);
	}

	public static void main(String[] args) {

		String data = "{\r\n" + "    Money Heist Info\r\n" + "    {\r\n"
				+ "        The most important character is the Professor\r\n" + "    }\r\n" + "    {\r\n"
				+ "        Another character is that of Berlin\r\n" + "        {\r\n"
				+ "            Berlin is in charge of the money heist\r\n" + "        }\r\n" + "    }\r\n" + "    {\r\n"
				+ "        Another character is that of Moscow\r\n" + "        {\r\n"
				+ "            Moscow is Denver's dad\r\n" + "        }\r\n" + "    }\r\n" + "    {\r\n"
				+ "        Another character is that of Rio\r\n" + "        {\r\n"
				+ "            Rio is a programmer\r\n" + "            {\r\n"
				+ "                Rio is also a decent hacker\r\n" + "                {\r\n"
				+ "                    Rio is quite happy to be a part of the heist\r\n" + "                }\r\n"
				+ "            }\r\n" + "        }\r\n" + "    }\r\n" + "    {\r\n"
				+ "        Another character is that of Denver\r\n" + "    }\r\n" + "}";

		System.out.println("HierarchicalText:1 -> " + extractDataAtLevel(data, 1));

		System.out.println("HierarchicalText:2 -> " + extractDataAtLevel(data, 2));

		System.out.println("HierarchicalText:3 -> " + extractDataAtLevel(data, 3));

		System.out.println("HierarchicalText:4 -> " + extractDataAtLevel(data, 4));

		System.out.println("HierarchicalText:5 -> " + extractDataAtLevel(data, 5));


		
	}

}
