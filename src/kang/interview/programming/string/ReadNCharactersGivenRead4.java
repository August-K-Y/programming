package kang.interview.programming.string;

import kang.interview.programming.util.DataPrinter;

public class ReadNCharactersGivenRead4 {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {

		char[] temp = new char[4];
		int total = 0;
		boolean eof = false;

		// either reach the end of file or complete the total number of
		// character reading, the while loop end;
		while (!eof && total < n) {
			int count = read4(temp);

			// if the number of characters read from file is smaller than 4,
			// it's the end of the file
			eof = count < 4;

			// the number of characters left to be read may be smaller than the
			// number of character read from file. Chose the smaller one.
			count = Math.min(count, n - total);

			// copy from temp buffer to buf
			for (int i = 0; i < count; i++) {
				buf[total++] = temp[i];
			}
		}
		return total;
	}

	private int count = 0;
	private int read4(char[] buf) {
		if (count == 0) {
			buf[0] = 'A';
			buf[1] = 'B';
			buf[2] = 'C';
			buf[3] = 'D';
			count++;
			return 4;
		} else if (count == 1) {
			buf[0] = 'A';
			buf[1] = 'B';
			buf[2] = 'C';
			count++;
			return 3;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		ReadNCharactersGivenRead4 alg = new ReadNCharactersGivenRead4();
//		int n1 = 8;
//		char[] chars1 = new char[n1];
		int n2 = 6;
		char[] chars2 = new char[n2];
//		int n3 = 9;
//		char[] chars3 = new char[n3];
		
//		alg.read(chars1, n1);
		alg.read(chars2, n2);
//		alg.read(chars3, n3);
		
//		DataPrinter.printArray(chars1);
		DataPrinter.printArray(chars2);
//		DataPrinter.printArray(chars3);
	}
	
	
	
	public static void testString() {
		long start = System.currentTimeMillis();
		String resultStr = "";
		int i = 0;
		for (int a = 0; a < 10000; a++) {
			resultStr += "abc" + "def" + "g" + i++;
		}
		System.out.println("using String:" + (System.currentTimeMillis() - start));
	}

	public static void testStringBuilder() {
		StringBuilder stringBuilder = new StringBuilder();
		long start = System.currentTimeMillis();
		int i = 0;
		for (int a = 0; a < 10000; a++) {
			stringBuilder.append("abc").append("def").append("g").append(i++);
		}
		System.out.println("using StringBuilder:" + (System.currentTimeMillis() - start));
	}
}
