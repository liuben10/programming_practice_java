package graph;

import java.util.List;

/**
 * Created by liuben10 on 8/15/17.
 */
public class GraphNode<TYPE> {

	TYPE val;

	Integer cost;

	List<GraphNode> successors;

	public TYPE getVal() {
		return val;
	}

	public void setVal(TYPE val) {
		this.val = val;
	}

	public List<GraphNode> getSuccessors() {
		return successors;
	}

	public void setSuccessors(List<GraphNode> successors) {
		this.successors = successors;
	}

	public void addSuccessor(GraphNode successor) {
		this.successors.add(successor);
	}

	public GraphNode(TYPE val, List<GraphNode> successors) {
		this.val = val;
		this.successors = successors;
	}

	public GraphNode(TYPE val, Integer cost, List<GraphNode> successors) {
		this.val = val;
		this.cost = cost;
		this.successors = successors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GraphNode<?> graphNode = (GraphNode<?>) o;

		if (val != null ? !val.equals(graphNode.val) : graphNode.val != null) return false;
		if (cost != null ? !cost.equals(graphNode.cost) : graphNode.cost != null) return false;
		return successors != null ? successors.equals(graphNode.successors) : graphNode.successors == null;

	}

	@Override
	public int hashCode() {
		int result = val != null ? val.hashCode() : 0;
		result = 31 * result + (cost != null ? cost.hashCode() : 0);
		result = 31 * result + (successors != null ? successors.hashCode() : 0);
		return result;
	}
}
