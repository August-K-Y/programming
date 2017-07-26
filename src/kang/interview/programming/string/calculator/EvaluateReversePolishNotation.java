package kang.interview.programming.string.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 150. Evaluate Reverse Polish Notation:
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 */
public class EvaluateReversePolishNotation {
	
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length ==0)
			return 0;
		
		Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
		map.put("+", (x, y) -> {return x + y;});
		map.put("-", (x, y) -> {return x - y;});
		map.put("*", (x, y) -> {return x * y;});
		map.put("/", (x, y) -> {return x / y;});
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			BiFunction<Integer, Integer, Integer> func = map.get(tokens[i]);
			if (func != null) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.add(func.apply(num1, num2));
			} else {
				stack.add(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		String[] tokens2 = { "4", "13", "5", "/", "+" };
		String[] tokens3 = { "18" };
		EvaluateReversePolishNotation alg = new EvaluateReversePolishNotation();
		DataPrinter.println(alg.evalRPN(tokens)); // 9
		DataPrinter.println(alg.evalRPN(tokens2)); // 6
		DataPrinter.println(alg.evalRPN(tokens3)); // 18
	}
}
