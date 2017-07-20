package kang.interview.programming.zhe;

import java.util.HashMap;
import java.util.Map;

/**
 * Consider a special family of Engineers and Doctors. This family has the following rules:

	Everybody has two children.
	The first child of an Engineer is an Engineer and the second child is a Doctor.
	The first child of a Doctor is a Doctor and the second child is an Engineer.
	All generations of Doctors and Engineers start with an Engineer.
	We can represent the situation using this diagram:
	
	                E
	           /         \
	          E           D
	        /   \        /  \
	       E     D      D    E
	      / \   / \    / \   / \
	     E   D D   E  D   E E   D
	Given the level and position of a person in the ancestor tree above, find the profession of the person.
	Note: in this tree first child is considered as left child, second - as right.
	
	Example
	
	For level = 3 and pos = 3, the output should be
	findProfession(level, pos) = "Doctor".

 * @author Yan Kang
 *
 */
public class FindProfesstion_H {

	String findProfession_bf(int level, int pos) {
		Map<Character, String> map = new HashMap<>(2);
		map.put('E', "Engineer");
		map.put('D', "Doctor");
		
		if (level == 1) {
			return "Engineer";
		}

		StringBuilder sb = new StringBuilder("E");
		for (int i = 2; i <= level; i++) {
			construct(sb);
		}

		String result = sb.toString();
		System.out.println(result);
		return map.get(result.charAt(pos - 1));

	}

	private void construct(StringBuilder sb) {
		sb.append(flip(sb.toString()));
	}

	private String flip(String input) {
		char[] chars = input.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == 'E') {
				chars[i] = 'D';
			} else {
				chars[i] = 'E';
			}
		}
		return new String(chars);
	}
	
	/**
	 * 
	 * @param level
	 * @param pos
	 * @return
	 */
	public String findProfession(int level, int pos) {
		if (level == 1) {
			return "Engineer";
		}
		
		int all = Double.valueOf(Math.pow(2, level-1)).intValue();
		
		int half = all/2;
		
		// 
//		if(pos > all) {
//			return find(level + 1, pos, true);
//		} else if(pos > half){
//			return find(level -1, pos-half, true);
//		} else {
//			return find(level-1, pos, false);
//		}
		
		// 
		if(pos > half){
			return find(level -1, pos-half, true);
		} else {
			return find(level-1, pos, false);
		}
		
	}
	
	private String find(int level, int pos, boolean flip) {

		if (level == 1) {
			if (flip)
				return "Doctor";
			else
				return "Engineer";
		}

		int all = Double.valueOf(Math.pow(2, level-1)).intValue();
		int half = all / 2;
		if (pos > half) {
			return find(level - 1, pos - half, !(flip == true));
		} else {
			return find(level - 1, pos, !(flip == false));
		}
	}
	
	// TODO: any other way that can do this better? Bit manipulation ??

	public static void main(String[] arg) {
		FindProfesstion_H f = new FindProfesstion_H();
//		System.out.println(f.findProfession_bf(9, 265));
		
		System.out.println(f.findProfession(13, 519));
	}
}
