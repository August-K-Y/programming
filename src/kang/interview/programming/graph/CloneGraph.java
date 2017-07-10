package kang.interview.programming.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @see kang.interview.programming.zhe.ClonePostingsList
 * @author Yan Kang
 *
 */
public class CloneGraph {
	
	public GraphVertex clone(GraphVertex source) {
		
		// map original vertex to its cloned vertex
		Map<String, GraphVertex> track = new HashMap<>();
		
		GraphVertex clonedSource = new GraphVertex(source.getLabel());
		track.put(clonedSource.getLabel(), clonedSource);
		clone(clonedSource, source, track);
		return clonedSource;
	}

	private void clone(GraphVertex source, GraphVertex vertex, Map<String, GraphVertex> track) {
		for (GraphVertex v : vertex.getNeighbors()) {
			GraphVertex newVertex = null;
			if (track.containsKey(v.getLabel())) {
				newVertex = track.get(v);
				source.addNeighbor(newVertex);
			} else {
				newVertex = new GraphVertex(v.getLabel());
				track.put(newVertex.getLabel(), newVertex);
				source.addNeighbor(newVertex);
				clone(newVertex, v, track);
			}
		}
	}

	public static void main(String[] args) {
		GraphVertex source = createGraph();
		CloneGraph cg = new CloneGraph();
		GraphVertex clonedSource = cg.clone(source);
		
		GraphUtil.assertGraph(source, clonedSource);
	}
	
	private static GraphVertex createGraph() {
		GraphVertex A = new GraphVertex("A");
		GraphVertex B = new GraphVertex("B");
		GraphVertex C = new GraphVertex("C");
		GraphVertex D = new GraphVertex("D");
		GraphVertex E = new GraphVertex("E");
		A.addNeighbor(B);
		A.addNeighbor(C);
		B.addNeighbor(E);
		C.addNeighbor(D);
		D.addNeighbor(B);
		return A;
	}
	
}
