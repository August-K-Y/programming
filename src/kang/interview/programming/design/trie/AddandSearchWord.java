package kang.interview.programming.design.trie;

/**
 * 211. Add and Search Word - Data structure design:
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) bool search(word) search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true search(".ad") -> true search("b..") -> true 
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author yankang
 *
 */
public class AddandSearchWord {
	
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
//			if (node == null) {
//				children[i] = new TrieNode();
//			}
//
//			if (index == chars.length - 1) {
//				children[i].hasWord = true;
//				return;
//			}
//			children[i].insert(chars, index + 1);
//		}
//
//		public boolean search(char[] chars, int index) {
//
//			if (chars[index] == '.') {
//				
//				for(TrieNode node : children) {
//					if (node == null)
//						continue;
//					
//					if (index == chars.length - 1) {
//						if(node.hasWord){
//							return true;
//						} 
//						continue;
//					}
//					boolean result = node.search(chars, index + 1);
//					if(result)
//						return true;
//				}
//				return false;
//
//			} else {
//				
//				int i = chars[index] - 'a';
//				if (children[i] == null)
//					return false;
//
//				if (index == chars.length - 1) {
//					return children[i].hasWord;
//				}
//
//				return children[i].search(chars, index + 1);
//			}
//		}
//	}

	private TrieNode root;

	/** Initialize your data structure here. */
	public AddandSearchWord() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		char[] chars = word.toCharArray();
		root.insert(chars, 0);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		char[] chars = word.toCharArray();
		return root.search(chars, 0);
	}
}
