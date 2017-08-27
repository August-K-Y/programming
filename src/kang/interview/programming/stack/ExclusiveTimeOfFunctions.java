package kang.interview.programming.stack;

import java.util.List;
import java.util.Stack;

/**
 * LeetCode: 636. Exclusive Time of Functions:
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 * 
 * Given the running logs of n functions that are executed in a nonpreemptive
 * single threaded CPU, find the exclusive time of these functions.
 * 
 * Each function has a unique id, start from 0 to n-1. A function may be called
 * recursively or by another function.
 * 
 * A log is a string has this format : function_id:start_or_end:timestamp. For
 * example, "0:start:0" means function 0 starts from the very beginning of time
 * 0. "0:end:0" means function 0 ends to the very end of time 0.
 * 
 * Exclusive time of a function is defined as the time spent within this
 * function, the time spent by calling other functions should not be considered
 * as this function's exclusive time. You should return the exclusive time of
 * each function sorted by their function id.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * n = 2
 * 
 * logs = ["0:start:0", 
 * 		   "1:start:2", 
 * 		   "1:end:5", 
 *         "0:end:6"] 
 *         
 * Output:[3, 4]
 * 
 * Explanation:
 * 
 * Function 0 starts at time 0, then it executes 2 units of time and reaches the
 * end of time 1. Now function 0 calls function 1, function 1 starts at time 2,
 * executes 4 units of time and end at time 5. Function 0 is running again at
 * time 6, and also end at the time 6, thus executes 1 unit of time. So function
 * 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4
 * units of time.
 * 
 * Note: 
 * 
 * Input logs will be sorted by timestamp, NOT log id.<br/>
 * Your output should be sorted by function id, which means the 0th element of
 * your output corresponds to the exclusive time of function 0.<br/>
 * Two functions won't start or end at the same time.<br/>
 * Functions could be called recursively, and will always end.<br/>
 * 1 <= n <= 100
 * 
 * @author Yan Kang
 *
 */
public class ExclusiveTimeOfFunctions {
	
	public int[] exclusiveTime(int n, List<String> logs) {
		
		// It is obvious that the function calling process is handled by a
		// stack.
		// the stack tracks each function's start log, from where the exclusive
		// time for each function is executed.
		Stack<Integer> stack = new Stack<>();
		// record exclusive time for each function
		int[] ret = new int[n];
		int prevTime = 0;
		for (int i = 0; i < logs.size(); i++) {
			
			String log[] = logs.get(i).split(":");
			int currTime = Integer.parseInt(log[2]);
			
			// If the stack is empty, it means that current log is the start of
			// a function that is not called by or (nested in) other functions.
			// Otherwise, this log is either start of a called/nested function
			// or end of a called/nested function. Either case, we need to
			// calculate the time gap between current log and previous log and
			// add it to currently executing function.
			if (!stack.isEmpty())
				ret[stack.peek()] += currTime - prevTime;
			
			// update the recorded time of previous log
			prevTime = currTime;

			if (log[1].equals("start")) {
				// push the newly called function represented by the function id
				// into the stack
				stack.push(Integer.valueOf(log[0]));
			} else {
				// if current log is the end of a function, pop out the top log
				// which must be the start log of the same function.

				// The ++ is little bit tricky. Since the current log is about
				// end time of certain function and the function ends by the end
				// of the recorded end time (not the start of the recorded time
				// as in the start log), we need to add it by 1 to make it
				// consistent with the start time.
				ret[stack.pop()]++;
				prevTime++;
			}
		}
		return ret;

	}
}
