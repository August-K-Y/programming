package kang.interview.programming.array;

import kang.interview.programming.util.DataPrinter;
import kang.interview.programming.zhe.RearrangeStringKDistanceApart_H;

/**
 * 
 * 
 * Given a task sequence tasks such as ABBABBC, and an integer k, which is the
 * cool down time between two same tasks. Assume the execution for each
 * individual task is 1 unit.
 * 
 * For example, if k = 3, then tasks BB takes a total of 5 unit time to finish,
 * because B takes 1 unit of time to execute, then wait for 3 unit, and execute
 * the second B again for another unit of time. So 1 + 3 + 1 = 5.
 * 
 * Given a task sequence and the cool down time, return the total execution
 * time.
 * 
 * Follow up: Given a task sequence and the cool down time, rearrange the task
 * sequence such that the execution time is minimal.
 * 
 * @see {@link RearrangeArrayInAlternatingPosNegNumber_M}
 * @see {@link RearrangeStringKDistanceApart_H}
 * @see https://discuss.leetcode.com/topic/112/minimal-run-time-scheduler
 * @author Yan Kang
 *
 */
public class MinimalTimeScheduler_M {

	public int compute(char[] tasks, int k) {

		if(tasks == null | tasks.length == 0)
			return 0;
		
		int time = 1;
		for(int i = 1; i< tasks.length; i++) {
			if (tasks[i] == tasks[i - 1]) {
				time += k;
			}
			time += 1;
		}

		return time;
	}
	
	public int minTime(char[] tasks, int k) {
		if (tasks == null | tasks.length == 0)
			return 0;

		int time = 1;
		int p = -1;
		for (int i = 1; i < tasks.length; i++) {
			if (tasks[i] == tasks[i - 1]) {
				int index = find(tasks, tasks[i], i + 1);
				if (index >= 0) {
					swap(tasks, i, index);
				} else {
					p = i;
					break;
				}
			}
			time += 1;
		}

		while (p >= 1 && p < tasks.length) {
			time += (1 + k);
			p++;
		}

		DataPrinter.printArray(tasks);

		return time;
	}

	private int find(char[] chars, char c, int start) {
		int index = -1;
		for (int i = start; i < chars.length; i++) {
			if (chars[i] != c) {
				return i;
			}
		}
		return index;
	}

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	public static void main(String[] args) {
		MinimalTimeScheduler_M alg = new MinimalTimeScheduler_M();
		String str = "AAABBBCC";
//		DataPrinter.println(alg.compute(str.toCharArray(), 3));
		String str2 = "AAABC";
		DataPrinter.println(alg.minTime(str2.toCharArray(), 3));
	}
}
