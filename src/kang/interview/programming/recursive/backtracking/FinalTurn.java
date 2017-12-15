package kang.interview.programming.recursive.backtracking;

public class FinalTurn {

	private int[][] shifts = new int[][] { { -1, -1 }, { -1, 1 } };

	private static int numOfBeats = 0;

	public int solution(String[] B) {
		// write your code in Java SE 8
		numOfBeats = 0;
		
		int row = B.length;
		int col = B[0].length();

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				String r = B[i];
				char[] chars = r.toCharArray();
				if (chars[j] == 'O') {
					startBeat(B, i, j);
					break;
				}
			}
		}
		return numOfBeats;
	}
	
	private void startBeat(String[] B, int i, int j) {
		// System.out.println("pos: " + i + ", " + j);
		for (int[] shift : shifts) {
			if (isBeatable(B, i, j, shift)) {
				numOfBeats++;

				// clear current position
				char[] charNew1 = B[i].toCharArray();
				charNew1[j] = '.';

				// clear one step up position
				int newX = i + shift[0];
				int newY = j + shift[1];
				char[] charNew2 = B[newX].toCharArray();
				charNew2[newY] = '.';

				// move forward Jafar two steps
				i = newX + shift[0];
				j = newY + shift[1];
				char[] charNew3 = B[i].toCharArray();
				charNew3[j] = 'O';

				startBeat(B, i, j);
			}
		}
	}

	private boolean isBeatable(String[] b, int i, int j, int[] shift) {

		int oneStepUp = i + shift[0];
		int oneStepHorizontal = j + shift[1];

		int twoStepUp = oneStepUp + shift[0];
		int twoStepHorizontal = oneStepHorizontal + shift[1];

		if (oneStepUp < 0 || oneStepHorizontal < 0 || oneStepHorizontal >= b[0].length())
			return false;

		if (twoStepUp < 0 || twoStepHorizontal < 0 || twoStepHorizontal >= b[0].length())
			return false;

		if (b[oneStepUp].charAt(oneStepHorizontal) == 'X' && b[twoStepUp].charAt(twoStepHorizontal) == '.')
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		String[] input = new String[]{ 
				"..X...", 
				"......", 
				"....X.", 
				".X....", 
				"..X.X.", 
				"...O.."};
		
		FinalTurn checker = new FinalTurn();
		System.out.println("result: " + checker.solution(input));
	}

}
