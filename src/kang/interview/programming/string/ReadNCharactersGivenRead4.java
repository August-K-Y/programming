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

		int batch = n / 4;
		char[] temp = new char[4];
		int cur = 0, total = 0;
		for (int i = 0; i < batch; i++) {
			int count = read4(temp);
			total += count;
			int j = 0;
			int end = cur + count;
			while (cur < end) {
				buf[cur++] = temp[j++];
			}

			if (count < 4)
				return total;

		}

		int res = n % 4;
		int count = read4(temp);
		int min = Math.min(res, count);
		int j = 0;
		total += min;
		int end = cur + min;
		while (cur < end) {
			buf[cur++] = temp[j++];
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
	
	
	public int read_(char[] buf, int n) {
		boolean eof = false; // end of file flag
		int total = 0; // total bytes have read
		char[] tmp = new char[4]; // temp buffer

		while (!eof && total < n) {
			int count = read4(tmp);

			// check if it's the end of the file
			eof = count < 4;

			// get the actual count
			count = Math.min(count, n - total);

			// copy from temp buffer to buf
			for (int i = 0; i < count; i++)
				buf[total++] = tmp[i];
		}

		return total;
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
