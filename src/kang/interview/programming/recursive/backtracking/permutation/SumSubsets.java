package kang.interview.programming.recursive.backtracking.permutation;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * Given a sorted array of integers arr and an integer num, find all possible
 * unique subsets of arr that add up to num. Both the array of subsets and the
 * subsets themselves should be sorted in lexicographical order.
 * 
 * Example
 * 
 * For arr = [1, 2, 3, 4, 5] and num = 5, 
 * the output should be sumSubsets(arr, num) = [[1, 4], [2, 3], [5]].
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.integer arr
 * 
 * A sorted array of integers.
 * 
 * Guaranteed constraints: 
 * 		0 <= arr.length <= 50, 
 * 		1 <= arr[i] <= num.
 * 
 * [input] integer num
 * 
 * A non-negative integer.
 * 
 * Guaranteed constraints: 0 <= num <= 1000.
 * 
 * [output] array.array.integer
 * 
 * A sorted array containing sorted subsets composed of elements from arr that
 * have a sum of num. It is guaranteed that there are no more than 1000 subsets
 * in the answer.
 * 
 * @see {@link CombinationSum)
 * @author Yan Kang
 *
 */
public class SumSubsets {
	
	int[][] sumSubsets(int[] arr, int num) {

		LinkedList<Integer> bus = new LinkedList<>();
		Map<String, int[]> map = new LinkedHashMap<>();

		findSolution(arr, 0, num, bus, map);

		int[][] result = new int[map.size()][];
		int j = 0;
		for (int[] r : map.values()) {
			result[j++] = r;
		}
		return result;
	}

	private void findSolution(int[] arr, int index, int num, LinkedList<Integer> bus, Map<String, int[]> map) {
		if (num == 0) {
			String key = bus.toString();
			if (!map.containsKey(key)) {
				int[] r = new int[bus.size()];
				int i = 0;
				for (int e : bus) {
					r[i++] = e;
				}
				map.put(key, r);
			}
		}

		for (int i = index; i < arr.length; i++) {
			// NOTE: num - arr[i] >= 0 is very important for improving the
			// performance. It is the the rejection criterion the rejects all
			// the subsequent solution searching if the criteron is not
			// satisfied
			if (num - arr[i] >= 0) {
				bus.add(arr[i]);
				findSolution(arr, i + 1, num - arr[i], bus, map);
				bus.removeLast();
			}
		}
	}
	
	/**
	 * 
	 * C++ implementation
	 * @param args
	 */
	
//	void dfs(const std::vector<int>& arr, int num, int i, int sum, vector<int>& now, vector<vector<int>>& result) {
//        if (sum == num) {
//            if (result.empty() || result.back() != now) {
//                result.emplace_back(now);
//            }
//            return;
//        }
//        if (sum > num) {
//            return;
//        }
//        if (i == arr.size()) {
//            return;
//        }
//        now.push_back(arr[i]);
//        dfs(arr, num, i + 1, sum + arr[i], now, result);
//        now.pop_back();
//        dfs(arr, num, i + 1, sum, now, result);
// }
//
//
// std::vector<std::vector<int>> sumSubsets(std::vector<int> arr, int num) {
//    vector<vector<int>> result;
//    vector<int> now;
//    dfs(arr, num, 0, 0, now, result);
//    sort(result.begin(), result.end());
//    result.erase(unique(result.begin(), result.end()), result.end());
//    return result;
// }

	/**
	 * 
	 * Python implementation
	 * @param args
	 */

//	def sumSubsets(arr, num):
//	    ans = [set() for _ in xrange(num+1)]
//	    ans[0].add(())
//	    for n in arr:
//	        for m in xrange(num, n-1, -1):
//	            if ans[m-n]:
//	                for x in ans[m-n]:
//	                    ans[m].add(x+(n, ))
//	    ans = sorted(list(ans[num]))
//	    return ans

	public static void main(String[] args) {
		SumSubsets c = new SumSubsets();

		int[] arr = { 1, 2, 2, 3, 4, 5 };
		int num = 5;
		DataPrinter.print2DArray(c.sumSubsets(arr, num));
	}
}
