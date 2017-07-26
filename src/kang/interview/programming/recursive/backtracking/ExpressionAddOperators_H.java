package kang.interview.programming.recursive.backtracking;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import kang.interview.programming.util.DataPrinter;

public class ExpressionAddOperators_H {
	
 	private final char[] ops = {'+', '-', '*'};
    public List<String> addOperators(String num, int target) {
    	
    	List<String> result = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	char[] nums = num.toCharArray();
    	find(nums, 0, sb, result, target);
    	return result;
        
    }
    
    private void find(char[] nums, int index, StringBuilder sb, List<String> list, int target) {
    	if(index == nums.length - 1) {
    		sb.append(nums[index]);
    		if(calculate(sb.toString()) == target) {
    			list.add(sb.toString());
    		}
    		sb.setLength(sb.length() - 1);
    		return;
    	}
    	
    	for(char op : ops) {
    		sb.append(nums[index]).append(op);
    		find(nums, index + 1, sb, list, target);
    		sb.setLength(sb.length() - 2);
    	}
    }
    
    public int calculate(String formula) {
    	
    	Deque<Character> d = new LinkedList<>();
    	
    	char[] chars = formula.toCharArray();
    	for(int i =0; i< chars.length;i++) {
    		if(chars[i] == '*'){
				int num1 = d.removeLast() - '0';
				int num2 = chars[++i] - '0';
				int val = num1 * num2;
				d.add((char) (val + '0'));
    		} else {
    			d.add(chars[i]);
    		}
    	}
    	
    	for(char c : d) {
    		System.out.print(c+ " ");
    	}
		System.out.println();
		
    	int sum = d.removeFirst() - '0';
		while (!d.isEmpty()) {
			char c = d.removeFirst();
			if (c == '+') {
				sum = sum + (d.removeFirst() - '0');
			} else if (c == '-') {
				sum = sum - (d.removeFirst() - '0');
			}

		}
		return sum;
    }
    
    public static void main(String[] args) {
//    	ExpressionAddOperators_H alg = new ExpressionAddOperators_H();
//    	String s1 = "1+2+3";
//    	String s2 = "2*3+2";
//     	String s3 = "1*0+5";
//    	String s4 = "1*2*3";
//     	String s5 = "2+3*2";
    	String s6 = "10-51*1";
//    	
//    	DataPrinter.println(alg.calculate(s1)); //6
//    	DataPrinter.println(alg.calculate(s2)); //8
//    	DataPrinter.println(alg.calculate(s3)); //5
//    	DataPrinter.println(alg.calculate(s4)); //6
//    	DataPrinter.println(alg.calculate(s5)); //8
//    	DataPrinter.println(alg.calculate(s6)); //10
//    	
    	DataPrinter.printArray(s6.split("\\d+"));
    	DataPrinter.printArray(s6.split("[*|-]"));
    }
}
