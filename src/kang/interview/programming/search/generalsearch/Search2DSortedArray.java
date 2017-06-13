package kang.interview.programming.search.generalsearch;

public class Search2DSortedArray {
	
	public boolean isAvailable(int[][] board, int num) 
	{
		int rowNumber = board.length;
		int colNumber = board[0].length;
		
		int row = 0;
		int col = colNumber - 1;
		while (row < rowNumber && col >= 0) {
			if (num == board[row][col]) {
				return true;
			} else if (num > board[row][col]) {
				row++;
			} else {
				col--;
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		Search2DSortedArray s = new Search2DSortedArray();
		int[][] board = { { -1, 2, 4, 4, 6},
						  { 1, 5, 5, 9, 21},
						  { 3, 6, 6, 9, 22},
						  { 3, 6, 8, 10, 24},
						  { 6, 8, 9, 12, 25},
						  { 8, 10, 12, 13, 40} };
		System.out.println(s.isAvailable(board, 8));
		System.out.println(s.isAvailable(board, 7));
	}

}
