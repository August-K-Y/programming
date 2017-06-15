package kang.interview.programming.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphVertex implements Comparable<GraphVertex> {

	private List<GraphVertex> neigbors = new ArrayList<>();
	private String label;

	public GraphVertex(String label) {
		this.label = label;
	}

	public List<GraphVertex> getNeighbors() {
		return this.neigbors;
	}

	public void addNeighbor(GraphVertex vertex) {
		this.neigbors.add(vertex);
	}

	public String getLabel() {
		return this.label;
	}
	
	public List<GraphVertex> getSortedNeighbors(){
		List<GraphVertex> list = new ArrayList<>(this.neigbors);
		Collections.sort(list);
		return list;
	}

	@Override
	public int hashCode() {
		return this.label.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;

		if (this == object)
			return true;

		if (!(object instanceof GraphVertex))
			return false;

		GraphVertex vertex = (GraphVertex) object;
		return this.label.equals(vertex.getLabel());
	}

	@Override
	public int compareTo(GraphVertex object) {
		return this.label.compareTo(object.getLabel());
	}
}
