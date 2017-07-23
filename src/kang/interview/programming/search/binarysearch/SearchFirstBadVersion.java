package kang.interview.programming.search.binarysearch;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 278. First Bad Version:
 * https://leetcode.com/problems/first-bad-version/#/description
 * 
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * @author Yan Kang
 *
 */
public class SearchFirstBadVersion {

	public int firstBadVersion(int n) {
		if (n <= 0)
			return 0;

		int left = 1;
		int right = n;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;

	}

	/**
	 * For test purpose only
	 * 
	 * @param version
	 * @return
	 */
	private boolean isBadVersion(int version) {
		if (version == 5 || version == 6)
			return true;
		return false;
	}

	public static void main(String[] args) {
		SearchFirstBadVersion alg = new SearchFirstBadVersion();
		DataPrinter.println(alg.firstBadVersion(9));
	}
}
