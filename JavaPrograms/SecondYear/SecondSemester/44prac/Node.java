public class Node {
	int vertNum;	// Assigned number to the node.
	double[][][] edges;	// Holds the connecting nodes, the distance to the node and each one's respective distance from the goal.

	public Node(int vertice, double[][][] connections) {
		vertNum = vertice;
		edges = connections;
	}

	public int getVertNum() { return vertNum; }
	public double[][][] getEdges() { return edges; }
}