package kang.interview.programming.zhe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 554. Brick Wall:
 * https://leetcode.com/problems/brick-wall/description/
 * 
 * There is a brick wall in front of you. The wall is rectangular and has
 * several rows of bricks. The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the
 * least bricks.
 * 
 * The brick wall is represented by a list of rows. Each row is a list of
 * integers representing the width of each brick in this row from left to right.
 * 
 * If your line go through the edge of a brick, then the brick is not considered
 * as crossed. You need to find out how to draw the line to cross the least
 * bricks and return the number of crossed bricks.
 * 
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * 
 * Example: 
 * 
 * Input: [[1,2,2,1], [3,1,2], [1,3,2], [2,4], [3,1,2], [1,3,1,1]]
 * Output: 2
 * 
 * 
 * @author Yan Kang
 *
 */
public class BrickWall_M {

	/**
	 * We want to cut from the edge of the most common location among all the
	 * levels, hence using a map to record the locations and their corresponding
	 * occurrence.
	 * 
	 * @param wall
	 * @return
	 */
	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null || wall.size() == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (List<Integer> row : wall) {

			int sum = 0;
			//
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				count = Math.max(count, map.get(sum));
			}
		}

		// if count is 0, it means that
		return wall.size() - count;
	}

	public static void main(String[] args) {
		BrickWall_M alg = new BrickWall_M();

		List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
		List<Integer> list2 = Arrays.asList(3, 1, 2);
		List<Integer> list3 = Arrays.asList(1, 3, 2);
		List<Integer> list4 = Arrays.asList(2, 4);
		List<Integer> list5 = Arrays.asList(3, 1, 2);
		List<Integer> list6 = Arrays.asList(1, 3, 1, 1);

		List<List<Integer>> lists = new LinkedList<>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		lists.add(list5);
		lists.add(list6);
		DataPrinter.println(alg.leastBricks(lists));
	}
}
