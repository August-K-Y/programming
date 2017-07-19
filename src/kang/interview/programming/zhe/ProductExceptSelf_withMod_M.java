package kang.interview.programming.zhe;

/**
 * 
 * You have an array nums. We determine two functions to perform on nums. In
 * both cases, n is the length of nums:
 * 
 * fi(nums) = nums[0] · nums[1] · ... · nums[i - 1] · nums[i + 1] · ... · nums[n
 * - 1]. (In other words, fi(nums) is the product of all array elements except
 * the ithf.)
 * 
 * g(nums) = f0(nums) + f1(nums) + ... + fn-1(nums).
 * 
 * Using these two functions, calculate all values of f modulo the given m. Take
 * these new values and add them together to get g. You should return the value
 * of g modulo the given m.
 * 
 * Example
 * 
 * For nums = [1, 2, 3, 4] and m = 12, the output should be
 * productExceptSelf(nums, m) = 2.
 * 
 * The array of the values of f is: [24, 12, 8, 6]. If we take all the elements
 * modulo m, we get: [0, 0, 8, 6]. The sum of those values is 8 + 6 = 14, making
 * the answer 14 % 12 = 2.
 * 
 * @see {@link ProductExceptSelf_M}
 * @see http://blog.codefights.com/productexceptself-solution/
 * @author Yan Kang
 *
 */
public class ProductExceptSelf_withMod_M {

	int productExceptSelf(int[] nums, int m) {

		int g = 0;
		for (int i = 0; i < nums.length; i++) {
			g += f(nums, m, i);
		}
		System.out.println("g: " + g);
		return g % m;
	}

	private int f(int[] nums, int m, int i) {
		int r = 1;
		for (int j = 0; j < nums.length; j++) {
			if (i != j)
				r *= nums[j] % m;
		}
		r %= m;
		System.out.println("r: " + r);
		return r;
	}
	
	public static void main(String[] arg) {
//		int[] nums = {1,2,3,4};
		int[] nums = { 27, 37, 47, 30, 17, 6, 20, 17, 21, 43, 5, 49, 49, 50, 20, 42, 45, 1, 22, 44 };
		ProductExceptSelf_withMod_M f = new ProductExceptSelf_withMod_M();
		System.out.println("res: " + f.productExceptSelf(nums, 40));
		
	}

}
