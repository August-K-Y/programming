package kang.interview.programming.combperm;

public class CombinationSum_IV {
	int count;

	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;

		count = 0;
		find(nums, target);
		return count;
	}

	private void find(int[] nums, int remain) {
		if (remain <= 0) {
			if (remain == 0)
				count++;
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			find(nums, remain - nums[i]);
		}
	}
}
