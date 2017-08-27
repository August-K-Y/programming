package kang.interview.programming.recursive.backtracking;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 286. Walls and Gates:
 * https://leetcode.com/problems/walls-and-gates/description/
 * 
 * You are given a m x n 2D grid initialized with these three possible values.

	-1  - A wall or an obstacle.
	0   - A gate.
	INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
	
	Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
	
	For example, given the 2D grid:
	
	INF  -1  0  INF
	INF INF INF  -1
	INF  -1 INF  -1
	  0  -1 INF INF
	  
	After running your function, the 2D grid should be:
	  3  -1   0   1
	  2   2   1  -1
	  1  -1   2  -1
	  0  -1   3   4
  
 * @author YK044346
 *
 */
public class WallsAndGates_H {
	private int[][] shifts = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private final static int EMPTY = 2147483647;

	public void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0)
			return;

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0)
					search(rooms, i, j, 0);
			}
		}
	}

	private void search(int[][] rooms, int r, int c, int d) {
		// IMPORTANT: d > rooms[r][c] which means either current room is a wall
		// or current room is an empty room but its nearest gate was found and
		// is closer than current solution
		if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || d > rooms[r][c])
			return;

		rooms[r][c] = d;
		for (int[] s : shifts) {
			int nr = r + s[0];
			int nc = c + s[1];
			search(rooms, nr, nc, d + 1);
		}
	}

	/**
	 * 
	 * @param rooms
	 */
	public void wallsAndGates_(int[][] rooms) {
		if (rooms == null || rooms.length == 0)
			return;

		int[][] track = new int[rooms.length][rooms[0].length];

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				search_(rooms, i, j, track);
			}
		}
	}

	private int search_(int[][] rooms, int r, int c, int[][] track) {

		if (track[r][c] == 0 && rooms[r][c] == EMPTY) {
			track[r][c] = 1;
			int min = EMPTY;
			for (int[] s : shifts) {
				int nr = r + s[0];
				int nc = c + s[1];
				if (nr >= 0 && nr < rooms.length && nc >= 0 && nc < rooms[0].length) {
					min = Math.min(min, search_(rooms, nr, nc, track));
				}
			}
			track[r][c] = 0;
			rooms[r][c] = min == EMPTY ? min : min + 1;
			return min == EMPTY ? min : min + 1;

		} else if (rooms[r][c] == 0) {
			return 0;
		} else if (rooms[r][c] == -1) {
			return EMPTY;
		}
		return rooms[r][c];
	}

	public static void main(String[] args) {
		WallsAndGates_H alg = new WallsAndGates_H();
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		alg.wallsAndGates(rooms);
		DataPrinter.print2DArray(rooms);

	}
}
