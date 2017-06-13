package kang.interview.programming.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BuildingsWithSunsetView {

	public static class Building {
		public int number;
		public int height;
	}

	public Deque<Building> getBuildingWithSunsetView(Iterator<Building> sequence) {
		Deque<Building> tracking = new LinkedList<>();
		while (sequence.hasNext()) {
			Building build = sequence.next();
			int height = build.height;
			// Removes all the buildings with weights that are not bigger than
			// current building. After this iteration, all buildings in the
			// tracking stack after current building should have bigger height.
			while (!tracking.isEmpty()) {
				Building top = tracking.peek();
				int topHeight = top.height;
				if (height >= topHeight) {
					tracking.pop();
				} else {
					break;
				}
			}
			tracking.push(build);
		}
		return tracking;
	}
}
