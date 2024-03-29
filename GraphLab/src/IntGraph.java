
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// IntGraph is a simple graph data structure with a fixed
// number of vertices identified by integers by integers
// in the half-open range [0..V), where V is the number
// of vertices.  This handles both undirected and
// directed graphs; the constructor has a parameter
// to determine which type it is.

// This simple data structure is useful for most cases.
// Even if you need non-integer vertex type T, it can be
// implemented using an array of T and a HashMap<T> to
// map back from T to the corresponding array index.

// However, you may want to use the more general Graph<T>
// type if:
//		(1) You want to use non-integer vertex types
//		    without resorting to the work-around noted
//		    above.
//		(2) You have a dynamic graph or one in which
//		    all the vertices are not known up front
//		    (e.g. a web crawler).

public class IntGraph {

	// The graph is fully described by its adjacency
	// list and whether it is directed or not.
	private ArrayList<Integer>[] adjList;
	private boolean directed;

	@SuppressWarnings("unchecked")
	public IntGraph(int numVertices, boolean directed) {

		adjList = new ArrayList[numVertices];
		for (int i = 0; i < numVertices; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		this.directed = directed;
	}
	
	// Add an edge.  If the graph is undirected, an
	// the edge in both directions.
	public void addEdge(int v, int w) {
		adjList[v].add(w);
		if (!directed) {
			adjList[w].add(v);
		}
	}

	// Return the number of vertices.
	public int numVertices() {
		return adjList.length;
	}

	// Return the list of vertices adjacent to
	// vertex v.
	public Iterable<Integer> adjacent(int v) {
		return adjList[v];
	}

	// createIntGraph is a convenience function that
	// creates an IntGraph from a file.  The file must
	// have the following format:
	//		numVertices
	//		numEdges
	//		fromVertex toVertex
	//		fromVertex to Vertex
	// where the last two lines are repeated for
	// each edge.
	public static IntGraph createIntGraph(String filename) throws FileNotFoundException {

		FileInputStream inFile = new FileInputStream(filename);

		try (Scanner scan = new Scanner(inFile)) {
		
			int numVertices = scan.nextInt();
			int numEdges    = scan.nextInt();
			
			IntGraph g = new IntGraph(numVertices, false);
			for (int i = 0; i < numEdges; i++) {
				int v = scan.nextInt();
				int w = scan.nextInt();
				g.addEdge(v, w);
			}
			
			return g;
		}
	}
}
