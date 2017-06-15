package kang.interview.programming.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

public class GraphUtil {
	
	public static void assertGraph(GraphVertex v1, GraphVertex v2) {
		Set<GraphVertex> track = new HashSet<>();
		assertGraph(v1, v2, track);
	}

	private static void assertGraph(GraphVertex v1, GraphVertex v2, Set<GraphVertex> track) {
		if (track.contains(v1))
			return;

		Assert.assertSame(v1.getLabel(), v2.getLabel());
		List<GraphVertex> neighbors1 = v1.getSortedNeighbors();
		List<GraphVertex> neighbors2 = v2.getSortedNeighbors();
		Assert.assertSame(neighbors1.size(), neighbors2.size());
		track.add(v1);
		for (int i = 0; i < neighbors1.size(); i++) {
			assertGraph(neighbors1.get(i), neighbors2.get(i), track);
		}
	}
}
