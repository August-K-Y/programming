package kang.interview.programming.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a program to find intersection of two sorted array in Java?
 * 
 * Another interesting array interview question, where you need to treat array
 * as Set. Your task is to write a function in your favorite language e.g. Java,
 * Python, C or C++ to return intersection of two sorted array. For example, if
 * the two sorted arrays as input are {21, 22, 34, 61, 73} and {11, 21, 34, 45,
 * 61}, it should return an intersection array with numbers {34, 21, 61}, For
 * the sake of this problem you can assume that numbers in each integer array
 * are unique.
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gd1BvBat
 * 
 */
public class FindIntersectionOfTwoSortedArrays {
	
	/**
	 * 
	 * @param array1 an array sorted 
	 * @param array2 an array sorted
	 * @return
	 */
	public List<Integer> findIntersection(int[] array1, int[] array2) 
	{
		List<Integer> set = new ArrayList<>();
		int idx1 = 0;
		int idx2 = 0;
		while (idx1 < array1.length && idx2 < array2.length) {
			if (array1[idx1] == array2[idx2]) {
				set.add(array1[idx1]);
				idx1++;
				idx2++;
			} else if (array1[idx1] > array2[idx2]) {
				idx2++;
			} else {
				idx1++;
			}
		}
		return set;
	}
	
	public static void main(String[] args) 
	{
		FindIntersectionOfTwoSortedArrays s = new FindIntersectionOfTwoSortedArrays();
		int[] array1 = { 21, 22, 34, 61, 73 };
		int[] array2 = { 11, 21, 34, 45, 61 };
		System.out.println(s.findIntersection(array1, array2));
	}

}
