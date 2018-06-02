import java.io.*;
import java.util.*;

public class GraphTraversal {
	public static void main (String[] args) {
		try {
			String[] data = new Scanner(new File("graphsearch.text")).useDelimiter("//Z").next().split("\n");
			Node[] graph = getGraph(data);
			//depthFirst(graph);
			//breadthFirst(graph);
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	/* Read and store the graph's data, from the text file.
		Graph stored as a list of Nodes. Each Node is a list of it's neighbouring Nodes.
	*/
	private static Node[] getGraph(String[] data) 
	{
		ArrayList <Nodes> node_list = new ArrayList <Nodes> ();
		String line;
		Char chr;
		int num_edges;
		// Run through text line by line:
		for (int line_num = 0; line_num < data.length; line_num ++) {
			line = data [line_num];
			// Check if line has Node data or unimportant data:
			if (line.length() < 2 || line.chartAt(1) != ':') { continue; }
			else {
				num_edges = StringUtils.countMatch(line, ";") + 1;	// Check how many edges the specific node has.
				double[][][] edges = new double [num_edges][num_edges][num_edges];
				// Run through line char by char:
				for (int chr_num = 2; chr < line.length(); chr ++) {
					chr = line.charAt(chr_num);
					if (chr == '$') { break; }
					else if ((int) chr >)

				}
			}
		}

		return null;
	}
	
	/*private static void depthFirst(Node[] graph, int start) {
		Stack dftraverse = new Stack();
	}

	private static void BreadthFirst(Node[] graph, int start) {
		Queue bftraverse = new Queue
	}*/

}
