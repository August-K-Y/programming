package kang.interview.programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000]. 
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments).
 * 
 * @author yankang
 *
 */
public class SmallestPositiveIntegerNotInArray {
	public int solution(int[] A) {

		// TODO: more efficient algorithm ???
		
        Set<Integer> set = new HashSet<>();
        for(int a : A) {
            if(a > 0)
                set.add(a);
        }
        
        for(int i = 1; i <= 1000000; i++){
            if(i > 0 && !set.contains(i)) {
                return i;
            }
        }
        
        return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		SmallestPositiveIntegerNotInArray solution = new SmallestPositiveIntegerNotInArray();
		
		int[] array1 = {1, 3, 6, 4, 1, 2} ;
		int[] array2 = {1, 2, 3} ;
		int[] array3 = {-1, -3};
		int[] array4 = {-1000000, 3, 6456, 32, 45, 1000000} ;
		
		System.out.println(solution.solution(array1)); // 5
		System.out.println(solution.solution(array2)); // 4
		System.out.println(solution.solution(array3)); // 1
		System.out.println(solution.solution(array4)); // 1
	}
}
