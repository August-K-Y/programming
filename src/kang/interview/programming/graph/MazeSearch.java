package kang.interview.programming.graph;

import java.util.ArrayList;
import java.util.List;

public class MazeSearch {

	/**
	 * 
	 * @param maze
	 */
	public void search(int[][] maze) {
		maze[0][0] = 1;
		List<String> path = new ArrayList<>();
		path.add("0-0");
		if(DFS(maze, 0, 0, path)){
			path.stream().forEach(a -> System.out.print(a + " -> ")); 
		} else {
			System.out.println("No path from start to end");
		}
	}
	private boolean DFS(int[][] maze, int x, int y, List<String> path) {

		int height = maze.length;
		int weigth = maze[0].length;
		if (x == weigth - 1 && y == height - 1) {
			return true;
		} else {
			final int[][] shift = { { 1, 0 }, { 0, 1 }, { -1, 0 } };
			for (int[] s : shift) {
				x = x + s[0];
				y = y + s[1];
				if (isFeasible(maze, x, y)) {
					maze[x][y] = 1;
					path.add(x + "-" + y);
					if (DFS(maze, x, y, path)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isFeasible(int[][] maze, int x, int y) {
		if (x < maze.length && y < maze[0].length && maze[x][y] == 0)
			return true;
		return false;
	}

	public static void main(String[] arg) {
		MazeSearch ms = new MazeSearch();
		int[][] maze = { { 0, 1, 1, 1 }, 
						 { 0, 1, 1, 1 }, 
						 { 0, 1, 1, 1 }, 
						 { 0, 0, 0, 0 } };
		ms.search(maze);
		
		int[][] maze2 = { { 0, 1, 1, 1 }, 
				 { 0, 1, 1, 1 }, 
				 { 1, 1, 1, 1 }, 
				 { 0, 0, 0, 0 } };
		ms.search(maze2);
	}
}
