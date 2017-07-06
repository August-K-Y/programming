package kang.interview.programming.hashtable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * You have a collection of coins, and you know the values of the coins and the
 * quantity of each type of coin in it. You want to know how many distinct sums
 * you can make from non-empty groupings of these coins.
 * 
 * Example
 * 
 * For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
 * possibleSums(coins, quantity) = 9.
 * 
 * Here are all the possible sums:
 * 
 * 50 = 50; 
 * 10 + 50 = 60; 
 * 50 + 100 = 150; 
 * 10 + 50 + 100 = 160; 
 * 50 + 50 = 100; 
 * 10 + 50 + 50 = 110;
 * 50 + 50 + 100 = 200; 
 * 10 + 50 + 50 + 100 = 210; 
 * 10 = 10; 
 * 100 = 100; 10 + 100 = 110. 
 * 
 * As you can see, there are 9 distinct sums that can be
 * created from non-empty groupings of your coins.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.integer coins
 * 
 * An array containing the values of the coins in your collection.
 * 
 * Guaranteed constraints:
 * 	 1 ≤ coins.length ≤ 20, 
 * 	 1 ≤ coins[i] ≤ 104.
 * 
 * [input] array.integer quantity
 * 
 * An array containing the quantity of each type of coin in your collection.
 * quantity[i] indicates the number of coins that have a value of coins[i].
 * 
 * Guaranteed constraints: quantity.length = coins.length, 1 ≤ quantity[i] ≤
 * 105.
 * 
 * It is guaranteed that:
 *  (quantity[0] + 1) * (quantity[1] + 1) * ... * (quantity[quantity.length - 1] + 1) <= 106.
 * 
 * [output] integer
 * 
 * The number of different possible sums that can be created from non-empty
 * groupings of your coins.
 * 
 * @author yankang
 *
 */
public class FindPossibleSums {
	
	/**
	 * Recursive version of the algorithm
	 * 
	 * @param coins
	 * @param quantity
	 * @return
	 */
	int possibleSums(int[] coins, int[] quantity) {
		Set<Integer> sums = new HashSet<>();
		compute(coins, quantity, 0, 0, sums);
		sums.remove(0);
		return sums.size();
	}
	
	private void compute(int[] coins, int[] quantity, int coinIndex, int prevSum, Set<Integer> sums){
		if(coinIndex >= coins.length)
			return;
		
		int count = quantity[coinIndex];
		int sum = 0;
		
		// When j is zero, this deals with situation when coin at position j in
		// coins array is not picked
		for (int j = 0; j <= count; j++) {
			sum = prevSum + coins[coinIndex] * j;
			sums.add(sum);
			compute(coins, quantity, coinIndex + 1, sum, sums);
		}
	}

	/**
	 * Iterative version of the algorithm
	 * 
	 * @param coins
	 * @param quantity
	 * @return
	 */
	int possibleSums_(int[] coins, int[] quantity) {
		Set<Integer> sums = new HashSet<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		for (int i = 0; i < coins.length; i++) {
			int count = quantity[i];
			
			// the queue2 tracks all possible sums from coin at position 0 to
			// coin at position i.
			Queue<Integer> queue2 = new LinkedList<>();
			while (!queue.isEmpty()) {
				int prevSum = queue.remove();
				int sum = 0;
				for (int j = 0; j <= count; j++) {
					sum = prevSum + coins[i] * j;
					queue2.add(sum);
					sums.add(sum);
				}
			}
			
			queue = queue2;
		}
		
		sums.remove(0);
		return sums.size();
	}

	public static void main(String[] args) {

		FindPossibleSums alg = new FindPossibleSums();
		
		int[] coins = { 10, 50, 100 };
		int[] quantity = { 1, 2, 1 };
		System.out.println("result: " + alg.possibleSums_(coins, quantity));
		
		int[] coins2 = { 10, 50, 100, 500 };
		int[] quantity2 = { 5, 3, 2, 2 };
		System.out.println("result: " + alg.possibleSums_(coins2, quantity2));
	}
}
