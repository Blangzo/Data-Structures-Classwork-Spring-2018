import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<String,List<Edge>> graphData = new HashMap<String,List<Edge>>();
	private boolean isDirected;
	private boolean isWeighted;

	public Graph(boolean isDirected, boolean isWeighted) {
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}

	// this method will add edges to the graph based on a string.
	// this string is in the form "from,to"
	// each pair of adjacent nodes should be separated by a semicolon.
	public void addEdges(String edgeList) {
		for (String edgePair : edgeList.split(";")) {
			String[] edges = edgePair.split(",");
			if (edges.length == 2) {
				addEdge(edges[0], edges[1]);
			}
		}
	}

	// add an edge from one node to another; if this is a weighted graph this will throw an exception
	public void addEdge(String from, String to) {
		if (isWeighted) {
			throw new UnsupportedOperationException("Graph is weighted.");
		}
		addEdge(from, to, 1);
	}

	// add an edge from one node to another;
	// this method will handle reversing the edge for undirected graphs
	public void addEdge(String from, String to, int weight) {
		addOneWayConnection(from, to, weight);
		if (!isDirected) {
			addOneWayConnection(to, from, weight);
		}
	}

	private void addOneWayConnection(String origin, String destination, int weight) {
		List<Edge> connections = graphData.get(origin);
		if (connections == null) {
			connections = new LinkedList<Edge>();
			graphData.put(origin, connections);
		}
		connections.add(new Edge(destination, weight));
	}

	// determine if you can travel directly from "from" to "to"
	public boolean isAdjacent(String from, String to) {
		List<Edge> edges = graphData.get(from);
		if (edges != null) {
			for (Edge edge : edges) {
				if (edge.adjacentNode.equals(to)) {
					return true;
				}
			}
		}
		return false;
	}

	// return the weight between "from" and "to"
	// if nodes are not adjacent, return null
	public Integer getWeight(String from, String to) {
		List<Edge> edges = graphData.get(from);
		if (edges != null) {
			for (Edge edge : edges) {
				if (edge.adjacentNode.equals(to)) {
					return new Integer(edge.weight);
				}
			}
		}
		return null;
	}

	// represent the weight and an adjacent node
	private class Edge {
		private int weight = 1;
		private String adjacentNode;

		public Edge(String adjacentNode, int weight) {
			this.adjacentNode = adjacentNode;
		}
	}

	//tester
	public static void main(String[] args) {
		String nodes = "A,B;B,C;C,D;D,E;A,K;K,E;A,F;F,G;G,H;H,I;I,J;J,E";
		Graph graph = new Graph(false, false);
		graph.addEdges(nodes);
		System.out.println("testprint: " + graph.getShortestPath("A", "E")); // should print [A, K, E]
	}

	public List<String> getShortestPath(String from, String to) {
		LinkedList<String> q = new LinkedList<String>();
		Map<String,String> m = new HashMap<String,String>();
		String currentVertex, neighborVertex;
		q.add(from);
		m.put(from, null);
		while(q.size() != 0) {
			System.out.println(q);
			currentVertex = q.pop();
			if (currentVertex.equals(to)) {
				return calculatePath(from, to, m);
			} else {
				List<Edge> edges = graphData.get(currentVertex);
				if (edges != null) {
					for (Edge edge : edges) {
						System.out.println(edge.adjacentNode);
						neighborVertex = edge.adjacentNode;
						if (!m.containsKey(neighborVertex)) {
							q.addFirst(edge.adjacentNode);
							m.put(edge.adjacentNode, currentVertex);
						}
						System.out.println(m);
					}
				}
			}
		}
		return null; //if no path exists
	}

	private List<String> calculatePath(String from, String to, Map<String, String> m) {
		String curr = to;
		LinkedList<String> list = new LinkedList<String>();
		while (!curr.equals(from)) {
			list.addFirst(curr);
			curr = m.get(curr);
		}
		list.addFirst(from);
		return list;
	}
}
