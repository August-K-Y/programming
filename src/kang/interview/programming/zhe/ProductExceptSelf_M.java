package kang.interview.programming.zhe;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * 
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 * 
 * @see {@link ProductExceptSelf_withMod_M}
 * @author Yan Kang
 *
 */
public class ProductExceptSelf_M {

	/**
	 * This algorithm takes O(n) time and O(n) space without division.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {

		if (nums == null || nums.length == 0)
			return new int[0];

		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			f[i] = nums[i] * ((i - 1) >= 0 ? f[i - 1] : 1);
		}

		int[] d = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			d[i] = nums[i] * ((i + 1) < nums.length ? d[i + 1] : 1);
		}
		int[] o = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int l = (i - 1) >= 0 ? f[i - 1] : 1;
			int r = (i + 1) < nums.length ? d[i + 1] : 1;
			o[i] = l * r;
		}
		return o;
	}
	
	/**
	 * LeetCode: Brilliant idea. This algorithm takes O(n) time and O(1) space
	 * without division.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf_(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];

		// In the first iteration, res[i] is the product from nums[0]
		// to nums[i-1]. Written it as mathematical equation:
		// res[i] = res[i - 1] * nums[i - 1];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		// In the second iteration, each res[i] is multiplied by product of
		// numbers on the right of res[i].
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0 };
		ProductExceptSelf_M alg = new ProductExceptSelf_M();
		DataPrinter.printArray(alg.productExceptSelf(nums));
	}
}
