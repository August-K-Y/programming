package kang.interview.programming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 133. Clone Graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * @see kang.interview.programming.linkedlist.ClonePostingsList
 * @author Yan Kang
 *
 */
public class CloneGraph {
	
	public class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
		 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label, cloned);
        clone(cloned, node, map);
        return cloned;
    }
    
    private void clone(UndirectedGraphNode cloned, UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        
        for(UndirectedGraphNode n : node.neighbors) {
            UndirectedGraphNode c = null;
            if(map.containsKey(n.label)) {
                c = map.get(n.label);
                cloned.neighbors.add(c);
            } else {
                c = new UndirectedGraphNode(n.label);
                map.put(n.label, c);
                cloned.neighbors.add(c);
                clone(c, n, map);
            }
        }
    }
	
//	public GraphVertex clone(GraphVertex source) {
//		
//		// map original vertex to its cloned vertex
//		Map<String, GraphVertex> track = new HashMap<>();
//		
//		GraphVertex clonedSource = new GraphVertex(source.getLabel());
//		track.put(clonedSource.getLabel(), clonedSource);
//		clone(clonedSource, source, track);
//		return clonedSource;
//	}
//
//	private void clone(GraphVertex source, GraphVertex vertex, Map<String, GraphVertex> track) {
//		for (GraphVertex v : vertex.getNeighbors()) {
//			GraphVertex newVertex = null;
//			if (track.containsKey(v.getLabel())) {
//				newVertex = track.get(v);
//				source.addNeighbor(newVertex);
//			} else {
//				newVertex = new GraphVertex(v.getLabel());
//				track.put(newVertex.getLabel(), newVertex);
//				source.addNeighbor(newVertex);
//				clone(newVertex, v, track);
//			}
//		}
//	}

//	public static void main(String[] args) {
//		GraphVertex source = createGraph();
//		CloneGraph cg = new CloneGraph();
//		GraphVertex clonedSource = cg.clone(source);
//		
//		GraphUtil.assertGraph(source, clonedSource);
//	}
//	
//	private static GraphVertex createGraph() {
//		GraphVertex A = new GraphVertex("A");
//		GraphVertex B = new GraphVertex("B");
//		GraphVertex C = new GraphVertex("C");
//		GraphVertex D = new GraphVertex("D");
//		GraphVertex E = new GraphVertex("E");
//		A.addNeighbor(B);
//		A.addNeighbor(C);
//		B.addNeighbor(E);
//		C.addNeighbor(D);
//		D.addNeighbor(B);
//		return A;
//	}
	
}
