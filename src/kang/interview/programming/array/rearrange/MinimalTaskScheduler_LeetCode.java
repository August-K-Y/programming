package kang.interview.programming.array.rearrange;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/#/description
 * 
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks.Tasks could
 * be done without original order. Each task could be done in one interval. For
 * each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * Example 1: 
 * 
 * Input: tasks = ['A','A','A','B','B','B'], n = 2 
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B. 
 * 
 * Note: 
 * The number of tasks is in the range [1, 10000]. 
 * The integer n is in the range [0, 100].
 * 
 * @see https://leetcode.com/problems/task-scheduler/#/solution
 * @see https://leetcode.com/problems/task-scheduler/#/discuss
 * @author Yan Kang
 *
 */
public class MinimalTaskScheduler_LeetCode {
	
	
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0)
			return 0;

		int[] count = new int[26];
		int[] valid = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			count[tasks[i] - 'A']++;
		}

		int interval = 0;
		int num = tasks.length;
		for (int i = 0; i < num;) {
			int index = findValid(count, valid, i);
			if (index < 0) {
				num++;
			} else {
				count[index]--;
				valid[index] = i + n + 1;
			}
			interval++;
			i++;
		}
		return interval;
	}

	private int findValid(int[] count, int[] valid, int start) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0 && count[i] > max && start >= valid[i]) {
				max = count[i];
				index = i;
				
			}
		}
		return index;
	}

	public static void main(String[] args) {
		MinimalTaskScheduler_LeetCode alg = new MinimalTaskScheduler_LeetCode();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		char[] tasks1 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n = 2;
		
		DataPrinter.println(alg.leastInterval(tasks1, n));
	}
}
