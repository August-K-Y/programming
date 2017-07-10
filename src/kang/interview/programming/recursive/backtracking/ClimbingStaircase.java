package kang.interview.programming.recursive.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * You need to climb a staircase that has n steps, and you decide to get some
 * extra exercise by jumping up the steps. You can cover at most k steps in a
 * single jump. Return all the possible sequences of jumps that you could take
 * to climb the staircase, sorted.
 * 
 * Example
 * 
 * For n = 4 and k = 2, the output should be
 * 
 * climbingStaircase(n, k) = 
 * [[1, 1, 1, 1], 
 * 	[1, 1, 2], 
 * 	[1, 2, 1], 
 * 	[2, 1, 1], 
 * 	[2, 2]] 
 * 
 * There are 4 steps in the staircase, and you can jump up 2 or fewer steps
 * at a time. There are 5 potential sequences in which you jump up the stairs
 * either 2 or 1 at a time.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] integer n
 * 
 * Guaranteed constraints: 0 <= n <= 10.
 * 
 * [input] integer k
 * 
 * Guaranteed constraints: 0 <= k <= n.
 * 
 * [output] array.array.integer
 * 
 * An array containing all of the possible sequences in which you could climb n
 * steps by taking them k or fewer at a time.
 * 
 * @author Yan Kang
 *
 */
public class ClimbingStaircase {

	int[][] climbingStaircase(int n, int k) {
		int[][] result = new int[][]{{}};
				
		if (n == 0 || k == 0)
			return result;

		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> buffer = new ArrayList<>();
		climb(n, k, buffer, lists);
		
		result = new int[lists.size()][];
		int i = 0;
		for(List<Integer> list : lists) {
			result[i] = new int[list.size()];
			for(int j = 0; j< list.size();j++) {
				result[i][j] = list.get(j);
			}
			i++;
		}
		return result;
	}

	private void climb(int n, int k, List<Integer> buffer, List<List<Integer>> result) {
		
		// base case
		if (n <= 0) {
			result.add(new ArrayList<>(buffer));
			return;
		}

		for (int i = 1; i <= k; i++) {
			// Rejection criterion
			if (n - i >= 0) {
				buffer.add(i);
				climb(n - i, k, buffer, result);
				buffer.remove(buffer.size() - 1);
			}
		}
	}
	
	/**
	 * From CodeFight: an interesting implementation
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	int[][] climbingStaircase_(int n, int k) {
		// base case, only one way to climb a staircase of height 0, take no
		// steps
		if (n == 0) {
			return new int[1][0];
		}

		if (ht.containsKey(n)) {
			return ht.get(n);
		}

		ArrayList<int[]> al = new ArrayList<int[]>();
		// for every possible way next step you can take, recurse
		for (int i = 1; i <= Math.min(k, n); i++) {
			int[][] prev = climbingStaircase(n - i, k);
			for (int j = 0; j < prev.length; j++) {
				int[] toAdd = new int[prev[j].length + 1];
				toAdd[0] = i;
				for (int l = 1; l < toAdd.length; l++) {
					toAdd[l] = prev[j][l - 1];
				}
				al.add(toAdd);
			}
		}

		int[][] output = new int[al.size()][];
		for (int i = 0; i < al.size(); i++) {
			output[i] = al.get(i);
		}
		ht.put(n, output);
		return output;
	}

	HashMap<Integer, int[][]> ht = new HashMap<Integer, int[][]>();


	
	public static void main(String[] args) {
		ClimbingStaircase c = new ClimbingStaircase();
		DataPrinter.print2DArray(c.climbingStaircase(4, 2));
	}

}
