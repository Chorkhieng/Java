import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordPath {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream wordsStream = new FileInputStream("words4.txt");
		Scanner wordsScan = new Scanner(wordsStream);
		// Read the word list into an appropriate data structure.
		String[] list = ScannerUtils.readAllStrings(wordsScan);
		// Keep it simple!  Check out what's available in ScannerUtils.
		wordsScan.close();
	
		IntGraph g = IntGraph.createIntGraph("wordgraph.txt");

		Scanner inScan = new Scanner(System.in);
		while (inScan.hasNext()) {
			String from = inScan.next();
			String to = inScan.next();

			int idxFrom = ArrayUtils.find(list,from); // find the vertex number of the "from" word
			int idxTo = ArrayUtils.find(list, to);// find the vertex number of the "to" word
			
			// Compute the shortest paths from idxFrom to every other vertex
			IntBreadthFirstPaths path = new IntBreadthFirstPaths(g, idxFrom);

			if (!path.hasPathTo(idxTo)/* there is no path to idxTo */)
				System.out.println("No path!");
			else {
				System.out.println(from + " -> " + to);
				// get the path from idxFrom to idxTo
				Iterable<Integer> paths = path.pathTo(idxTo);
				// and print the word for each vertex in the path
				for (int s : paths)
					System.out.print(list[s] + " ");
				System.out.println();
			}
		}
		inScan.close();
	}
}
