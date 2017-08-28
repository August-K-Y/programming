package kang.interview.programming.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LeetCode 71. Simplify Path:
 * https://leetcode.com/problems/simplify-path/description/
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * 
 * path = "/home/", => "/home"
 * 
 * path = "/a/./b/../../c/", => "/c"
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * 
 * Did you consider the case where path = "/../"? In this case, you should
 * return "/".
 * 
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/". In this case, you should ignore redundant slashes and
 * return "/home/foo".
 * 
 * @author Yan Kang
 *
 */
public class SimplifyPath_H {

	/**
	 * The main idea is to push to the stack every valid file name (not in
	 * {"",".",".."}), popping only if there's smth to pop and we met "..". I
	 * don't feel like the code below needs any additional comments.
	 * 
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
		if (path == null)
			return null;

		// the stack only tracks the directories
		Stack<String> stack = new Stack<>();
		Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));

		for (String dir : path.split("/")) {
			// If run into "..", it means pop out from the current dir to the
			// parent dir. If the stack is empty, we are not in only directory
			if (dir.equals("..") && !stack.isEmpty()) stack.pop();
			// If the dir is one of the skip token, not push it into the stack
			else if (!skip.contains(dir))
				stack.push(dir);
		}

		String ret = "";

		// construct the final simplied path
		while (!stack.isEmpty())
			ret = "/" + stack.pop() + ret;

		// handle corner case that when ret is empty, "/" should be returned
		return ret.isEmpty() ? "/" : ret;

	}
}
