package kang.interview.programming.design.trie;

import kang.interview.programming.util.DataPrinter;

public class Trie_recursive {

//	class TrieNode {
//
//		private TrieNode[] children;
//		private boolean hasWord;
//
//		public TrieNode() {
//			children = new TrieNode[26];
//			hasWord = false;
//		}
//
//		public void insert(char[] chars, int index) {
//			int i = chars[index] - 'a';
//			TrieNode node = children[i];
//			if (node == null) children[i] = new TrieNode();
//			if (index == chars.length - 1) {
//				children[i].hasWord = true;
//				return;
//			}
//			children[i].insert(chars, index + 1);
//		}
//
//		public boolean search(char[] chars, int index) {
//			int i = chars[index] - 'a';
//			if (children[i] == null) return false;
//			if (index == chars.length - 1) return children[i].hasWord;
//			return children[i].search(chars, index + 1);
//		}
//
//		public boolean startWith(char[] chars, int index) {
//			int i = chars[index] - 'a';
//			if (children[i] == null) return false;
//			if (index == chars.length - 1) return true;
//			return children[i].startWith(chars, index + 1);
//		}
//	}

	private TrieNode root;

	/** Initialize your data structure here. */
	public Trie_recursive() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		char[] chars = word.toCharArray();
		root.insert(chars, 0);
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		char[] chars = word.toCharArray();
		return root.search(chars, 0);
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		char[] chars = prefix.toCharArray();
		return root.startWith(chars, 0);
	}

	public static void main(String[] args) {
		// ["Trie","insert","search","search","search","startsWith","startsWith","startsWith"]
		// [[],["hello"],["hell"],["helloa"],["hello"],["hell"],["helloa"],["hello"]]
		// [null,null,false,false,true,true,false,true]
		Trie_recursive trie = new Trie_recursive();
		trie.insert("hello");
		DataPrinter.println(trie.search("hell")); // false
		DataPrinter.println(trie.search("helloa")); // false
		DataPrinter.println(trie.search("hello")); // true
		DataPrinter.println(trie.startsWith("hell")); // true
		DataPrinter.println(trie.startsWith("helloa")); // false
		DataPrinter.println(trie.startsWith("hello")); // true

	}
}
