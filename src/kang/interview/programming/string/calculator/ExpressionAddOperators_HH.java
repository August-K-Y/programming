package kang.interview.programming.string.calculator;

import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 282. Expression Add Operators:
 * https://leetcode.com/problems/expression-add-operators/#/description
 * 
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"] 
 * "00", 0 -> ["0+0", "0-0", "0*0"] 
 * "3456237490", 9191 -> [] Solution:
 * https://discuss.leetcode.com/topic/35942/java-ac-solution-19ms-beat-100-00
 * 
 * @author Yan Kang
 *
 */
public class ExpressionAddOperators_HH {
	
    public List<String> addOperators(String num, int target) {
    	
    	LinkedList<String> result = new LinkedList<>();
        if (num.length() == 0) return result;
        
		char[] path = new char[2 * num.length()];
		char[] nums = num.toCharArray();
		
		int n = 0;
	
		for (int i = 0; i < nums.length; i++) {
			n = n * 10 + (nums[i] - '0');
			if(n < 0)
				break;
			path[i] = nums[i];
			find(nums, i + 1, path, i + 1, 0, n, target, result);
			if(n == 0) break;
		}
		return result;
        
    }

    /**
     * 
     * @param nums
     * @param index
     * @param path
     * @param pathIndex
     * @param ac
     * @param hold
     * @param target
     * @param result
     */
	private void find(char[] nums, int index, char[] path, int pathIndex, int ac, int hold, int target,
			LinkedList<String> result) {
		if (index == nums.length) {
			int val = ac + hold;
			if (val == target) {
				result.add(new String(path, 0, pathIndex));
			}
			return;
		}

		int j = pathIndex + 1;
		int n = 0;
		for (int i = index; i < nums.length; i++) {
			n = n * 10 + (nums[i] - '0');
			path[j++] = nums[i];
			path[pathIndex] = '+' ;
			find(nums, i + 1, path, j, ac + hold, n, target, result);
			if (n >= 0) {
				path[pathIndex] = '-';
				find(nums, i + 1, path, j, ac + hold, -n, target, result);
			}
			path[pathIndex] = '*' ;
			find(nums, i + 1, path, j, ac, hold * n, target, result);
			
			if(n == 0) break;
		}
	}
	
    public List<String> addOperators_(String num, int target) {
    	
    	LinkedList<String> result = new LinkedList<>();
        if (num.length() == 0) return result;
        
		char[] path = new char[2 * num.length() - 1];
		char[] nums = num.toCharArray();
		
		int n = 0;
	
		for (int i = 0; i < nums.length; i++) {
			n = n * 10 + (nums[i] - '0');
			path[i] = nums[i];
			find(nums, i + 1, path, i + 1, 0, n, target, result);
			if (n == 0)
				break;
		}
		return result;
    }
    
    public static void main(String[] args) {
    	ExpressionAddOperators_HH alg = new ExpressionAddOperators_HH();
    	String s1 = "123";
    	String s2 = "2147483648";
    	String s3 = "02147483648";
//     	String s3 = "1*0+5";
//    	String s4 = "1*2*3";
//     	String s5 = "2+3*2";
//    	String s6 = "10-51*1";
//    	
//    	DataPrinter.println(alg.addOperators(s1, 6)); //["1*2*3","1+2+3"]
    	DataPrinter.println(alg.addOperators(s2, -2147483648)); //["2147483648"]
    	DataPrinter.println(alg.addOperators(s3, -2147483648)); //5
//    	DataPrinter.println(alg.calculate(s4)); //6
//    	DataPrinter.println(alg.calculate(s5)); //8
//    	DataPrinter.println(alg.calculate(s6)); //10
    	
//    	System.out.println(Integer.MIN_VALUE);
//    	System.out.println(Integer.MAX_VALUE);
//    	
//    	int n = 214748364 * 10 + 8;
//    	System.out.println(n);
    	
//    	
//    	DataPrinter.printArray(s6.split("\\d+"));
//    	DataPrinter.printArray(s6.split("[*|-]"));
    }
}
