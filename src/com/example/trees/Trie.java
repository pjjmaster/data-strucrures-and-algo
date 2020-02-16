package com.example.trees;

public class Trie {

	public static int alphabetSize = 26;

	static TrieNode root;

	static class TrieNode {

		TrieNode[] children = new TrieNode[alphabetSize];

		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < alphabetSize; i++) {
				children[i] = null;
			}
		}

	}

	static void insert(String key) {

		int index;
		TrieNode crawl = root;

		for (int level = 0; level < key.length(); level++) {
			// Get the index of the character in children array
			index = key.charAt(level) - 'a';

			if (crawl.children[index] == null) {
				crawl.children[index] = new TrieNode();
			}

			crawl.isEndOfWord = true;

		}

	}

	static boolean search(String key) {

		int index;
		TrieNode crawl = root;

		for (int level = 0; level < key.length(); level++) {

			index = key.charAt(level) - 'a';

			if (crawl.children[index] == null) {
				return false;
			}

		}
		return (crawl != null && crawl.isEndOfWord);

	}

	public static void main(String[] args) {

	}

}
