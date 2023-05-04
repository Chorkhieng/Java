import java.util.Scanner;

public class KeepSmallestN {

    public static void main(String[] args) {

        // nToKeep is what the assignment description calls N.
        int nToKeep = Integer.parseInt(args[0]);

        // Create a min or max priority queue.  You'll need
        // to figure out which.

        // Create a scanner object reading from System.in.

        // For each integer read from the input...
        //    ...figure out how to use a priority queue to
        //    keep the nToKeep smallest ones.

        // Write out the final nToKeep smallest items
        // to System.out, one per line.

        Scanner getN = new Scanner(System.in);
        int[] smallestN = new int[nToKeep];
        HeapMinPQ<Integer> minElement = new HeapMinPQ<>(nToKeep);

        // store input in the priority queue minElement
        while(getN.hasNextInt())
            minElement.insert(getN.nextInt());

        // keep the smallest element in the array smallestN
        for (int i = 0; i < nToKeep; i++) {
            smallestN[i] = minElement.delMin();
            if (minElement.isEmpty())
                nToKeep = i + 1;
        }

        // print out the array elements from largest to smallest
        for (int j = nToKeep - 1; j >= 0; j--)
            System.out.println(smallestN[j]);

    }
}

