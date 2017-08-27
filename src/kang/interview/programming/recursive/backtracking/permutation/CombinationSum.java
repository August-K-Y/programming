package kang.interview.programming.recursive.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 39. Combination Sum:
 * https://leetcode.com/problems/combination-sum/description/
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [2, 3, 6, 7] and target 7, 
	A solution set is: 
	[
	  [7],
	  [2, 2, 3]
	]

 * @author Yan Kang
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if(candidates == null || candidates.length ==0)
            return result;
        
//        Arrays.sort(candidates);
        find(candidates, 0, new LinkedList<Integer>(), result, target);
        return result;
    }
    
    private void find(int[] can, int index, LinkedList<Integer> list, List<List<Integer>> result, int target){
        if(target <= 0){
            if(target == 0){
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = index; i < can.length; i++) {
            list.add(can[i]);
            find(can, i, list, result, target - can[i]);
            list.removeLast();
        }
    }
}
