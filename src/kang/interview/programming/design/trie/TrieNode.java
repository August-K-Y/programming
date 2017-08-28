package kang.interview.programming.design.trie;

public class TrieNode {
	
	private TrieNode[] children;
	private boolean hasWord;

	public TrieNode() {
		children = new TrieNode[26];
		hasWord = false;
	}

	public void insert(char[] chars, int index) {
		int i = chars[index] - 'a';
		TrieNode node = children[i];
		if (node == null) children[i] = new TrieNode();
		if (index == chars.length - 1) {
			children[i].hasWord = true;
			return;
		}
		children[i].insert(chars, index + 1);
	}

	public boolean search(char[] chars, int index) {

		if (chars[index] == '.') {
			for (TrieNode node : children) {
				if (node == null) continue;
				if (index == chars.length - 1) {
					if (node.hasWord) return true;
					continue;
				}
				boolean result = node.search(chars, index + 1);
				if (result) return true;
			}
			return false;
		} else {
			int i = chars[index] - 'a';
			if (children[i] == null) return false;
			if (index == chars.length - 1) return children[i].hasWord;
			return children[i].search(chars, index + 1);
		}
	}
	
	public boolean startWith(char[] chars, int index) {
		int i = chars[index] - 'a';
		if (children[i] == null) return false;
		if (index == chars.length - 1) return true;
		return children[i].startWith(chars, index + 1);
	}
}
