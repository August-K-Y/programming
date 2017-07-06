package kang.interview.programming.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * P229 13.10
 * 
 * @author YK044346
 *
 */
public class FindLengthOfLongestContainedInterval {

	/**
	 * First sort the input list and then find the longest consecutive subarray.
	 * time complexity is Q(nlgn).
	 * 
	 * @param input
	 *            the input list
	 * @return
	 */
	public List<Integer> find_withSort(List<Integer> input) {

		input = new ArrayList<>(input);
		Collections.sort(input);

		int tempIndex = 0;
		int startIndex = 0;
		int maxLength = 0;

		int currentLength = 1;
		for (int i = 1; i < input.size(); i++) {
			if (input.get(i - 1) + 1 == input.get(i)) {
				currentLength++;
			} else {
				maxLength = Math.max(maxLength, currentLength);
				if (currentLength > maxLength) {
					maxLength = currentLength;
					startIndex = tempIndex;
				}
				tempIndex = i;
				currentLength = 1;
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = startIndex; i < startIndex + maxLength; i++) {
			result.add(input.get(i));
		}
		return result;
	}

	public List<Integer> find_byHashSet(List<Integer> input) {
		Set<Integer> track = new HashSet<>(input);
		List<Integer> result = null;
		int currentLength = 1;
		int maxLength = 0;
		while (!track.isEmpty()) {
			int value = track.iterator().next();
			List<Integer> temp = new ArrayList<>();
			temp.add(value);
			track.remove(value);
			int next = value + 1;
			while (track.contains(next)) {
				currentLength++;
				track.remove(next);
				temp.add(next);
				next++;
			}

			int prev = value - 1;
			while (track.contains(prev)) {
				currentLength++;
				track.remove(prev);
				temp.add(prev);
				prev--;
			}

			if (currentLength > maxLength) {
				maxLength = currentLength;
				result = temp;
				currentLength = 0;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(-2);
		list.add(7);
		list.add(9);
		list.add(8);
		list.add(1);
		list.add(2);
		list.add(0);
		list.add(-1);
		list.add(5);
		list.add(8);

		FindLengthOfLongestContainedInterval f = new FindLengthOfLongestContainedInterval();
		// print(f.find_withSort(list));
		print(f.find_byHashSet(list));
	}

	private static void print(List<Integer> find) {
		find.stream().forEach(a -> System.out.print(a + " "));
	}

}
