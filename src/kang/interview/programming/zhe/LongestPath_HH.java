package kang.interview.programming.zhe;

/**
 * 
 * 
 * Suppose we represent our file system as a string. For example, the string
 * "user\n\tpictures\n\tdocuments\n\t\tnotes.txt" 
 * 
 * represents:
 * 
 * user pictures documents notes.txt The directory user contains an empty
 * sub-directory pictures and a sub-directory documents containing a file
 * notes.txt.
 * 
 * The string
 * "user\n\tpictures\n\t\tphoto.png\n\t\tcamera\n\tdocuments\n\t\tlectures\n\t\t\tnotes.txt"
 * 
 * represents:
 * 
 * user pictures photo.png camera documents lectures notes.txt The directory
 * user contains two sub-directories pictures and documents. pictures contains a
 * file photo.png and an empty second-level sub-directory camera. documents
 * contains a second-level sub-directory lectures containing a file notes.txt.
 * 
 * We want to find the longest (as determined by the number of characters)
 * absolute path to a file within our system. For example, in the second example
 * above, the longest absolute path is "user/documents/lectures/notes.txt", and
 * its length is 33 (not including the double quotes).
 * 
 * Given a string representing the file system in this format, return the length
 * of the longest absolute path to a file in the abstracted file system. If
 * there is not a file in the file system, return 0.
 * 
 * Example
 * 
 * For fileSystem = "user\n\tpictures\n\tdocuments\n\t\tnotes.txt", the output
 * should be
 * 
 * longestPath(fileSystem) = 24.
 * 
 * The longest path is "user/documents/notes.txt", and it consists of 24
 * characters.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] string fileSystem
 * 
 * File system in the format described above. It is guaranteed that:
 * 
 * the name of a file contains at least a . and an extension; the name of a
 * directory or sub-directory does not contain a .. Note: Due to system
 * limitations, newline characters are given as carriage returns ('\r') in our
 * test cases.
 * 
 * Guaranteed constraints:
 * 
 * 1 <= fileSystem.length <= 6500.
 * 
 * [output] integer
 * 
 * @author Yan Kang
 *
 */
public class LongestPath_HH {

	// TODO: using regular expression
	
	
	// 
	int longestPath(String input) {
		if (input == null || input.trim().isEmpty())
			return 0;

		input = input.replace("    ", "\t");
		int maxLength = 0;
//		String longestPath = null;
		int curr = 0;
		while (curr != -1) {
			String fullPath = null;
			curr = input.indexOf(".", curr);
			if (curr != -1) {
				int s = input.lastIndexOf("\t", curr - 1);
				int e = input.indexOf("\n", curr + 1);
				s = s == -1 ? 0 : s;
				e = e == -1 ? input.length() - 1 : e;

				if (s != 0) {
					int ss = input.lastIndexOf("\n", s - 1);

					String file = input.substring(s + 1, e + 1);
					String pat = s - ss >= 2 ? input.substring(ss, s) : null;
					String path = _searchPath(input, pat, ss - 1);
					fullPath = path + file;
				} else {
					String file = input.substring(s, e + 1);
					fullPath = file;
				}

				if (fullPath.length() > maxLength) {
					maxLength = fullPath.length();
//					longestPath = fullPath;
				}
				curr = e + 1;
			}
		}
		return maxLength;
	}
	
	String _searchPath(String input, String pat, int startIndex) {

		StringBuilder sb = new StringBuilder();
		int s = pat == null ? -1 : input.lastIndexOf(pat, startIndex);
		while (s != -1) {
			int e = input.indexOf("\n", s + 1);

			String str = input.substring(s + pat.length(), e);
			sb.append(str + "/");
			s = s - 1;

			if (pat.length() == 3) {
				pat = pat.substring(0, pat.length() - 1);
				s = input.lastIndexOf(pat, s);
			} else {
				s = -1;
			}
		}

		int e = input.indexOf("\n", s + 1);
		String str = input.substring(0, e);
		sb.insert(0, str + "/");

		return sb.toString();
	}

	public static void main(String[] args) {
		
		int maxLength = 0;
		String longestPath = null;
//		String input = "user\r\tpictures\r\tdocuments\r\t\tnotes.txt";
//		String input = "a\r\tb1\r\t\tf1.txt\r\taaaaa\r\t\tf2.txt";
//		String input = "dir\r    file.txt";
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//		String input = "file name with  space.txt";
//		String input = "user\r\tpictures\r\tdocuments\r\t\tnotes.txt";
		System.out.println(input);
		LongestPath_HH l = new LongestPath_HH();
		System.out.println(l.longestPath(input));
		
		
//		input = input.replace("    ", "\t");
//		int curr = 0;
//		while(curr != -1) {
//			String fullPath = null;
//			curr = input.indexOf(".", curr);
//			System.out.println("@@ curr: " + curr);
//			if (curr != -1) {
//				int s = input.lastIndexOf("\t", curr - 1);
//				int e = input.indexOf("\r", curr + 1);
//
//				System.out.println("s -> e: " + s + " -> " + e);
//				
//				s = s == -1 ? 0 : s;
//				e = e == -1 ? input.length() - 1: e;
//				
//				System.out.println("adjusted s -> e: " + s + " -> " + e);
//				
//				if(s != 0) {
//					int ss = input.lastIndexOf("\r", s - 1);
//					System.out.println("ss: " + ss);
//					
//					String file = input.substring(s + 1, e + 1);
//					String pat = s - ss >= 2 ? input.substring(ss, s) : null;
//					String path = searchPath(input, pat, ss - 1);
//					System.out.println("path: " + path);
//					System.out.println("file: " + file);
//					fullPath = path + file;
//					System.out.println("## fullPath: " + fullPath);
//				} else {
//					String file = input.substring(s, e + 1);
//					fullPath = file;
//				}
//				
//				if(fullPath.length() > maxLength) {
//					maxLength = fullPath.length();
//					longestPath = fullPath;
//				}
//
//				curr = e + 1;
//
//			}
//		}
//		System.out.println("longest path: " + longestPath);
//		System.out.println("len : " + maxLength);
		
//		System.out.println(searchPath(input, "\r\t", 24));

	}
	
	

	public static String searchPath(String input, String pat, int startIndex) {
		System.out.println("pat: " + pat);
		System.out.println("path search start at: " + startIndex);

		StringBuilder sb = new StringBuilder();
		int s = pat == null ? -1 : input.lastIndexOf(pat, startIndex);
		System.out.println("s: " + s);
		while (s != -1) {
			int e = input.indexOf("\r", s + 1);
			System.out.println("e: " + e);

			String str = input.substring(s + pat.length(), e);
			System.out.println("str: "+ str);
			sb.append(str + "/");
			s = s - 1;
			
			System.out.println("pat length: " + pat.length());
			if (pat.length() == 3) {
				pat = pat.substring(0, pat.length() - 1);
				s = input.lastIndexOf(pat, s);
			} else {
				s = -1;
			}
		}
		
		int e = input.indexOf("\r", s + 1);
		String str = input.substring(0, e);
		sb.insert(0, str + "/");
		
		return sb.toString();
	}
}
