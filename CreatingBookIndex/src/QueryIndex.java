// This is one of the labs from Maps and Sets section
// Creating a book index
// The time complexity is no greater than O(N)

import java.io.*;
import java.util.*;

public class QueryIndex {

    private static Set<String> readExcludeList(String fileName) throws FileNotFoundException {

        Set<String> excludeList = new HashSet<>();

        Scanner excludeFile = new Scanner(new FileInputStream(fileName));
        while (excludeFile.hasNext()) {
            String s = excludeFile.next();
            excludeList.add(s);
        }

        excludeFile.close();
        return excludeList;
    }

    private static Map<String, HashSet<Integer>> createIndex(String fileName, String excludeList) throws FileNotFoundException {

        Map<String, HashSet<Integer>> st = new TreeMap<>();

        Scanner text = new Scanner(new FileInputStream(fileName));
        int page = 1;
        while (text.hasNext()) {
            String word = text.next();
            /* your code here */
            // if the word is "-----", increment the page count
            // if the word is in the exclude list, ignore it
            // if the word not in the symbol table, create a new entry for it
            // if the word is in the symbol table, add this page to its list of pages

            if (word.equals("-----"))
                page++;
            if (!st.containsKey(word)) {
                HashSet<Integer> pages = new HashSet<>();
                st.put(word, pages);
            }
            if (st.containsKey(word)) {
                HashSet<Integer> pages = st.get(word);
                pages.add(page);
                st.put(word, pages);
            }


        }

        text.close();

        return st;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scnr = new Scanner(System.in);

        Set<String> excludeList = readExcludeList("exclude.txt");
        Map<String, HashSet<Integer>> st = createIndex("paginatedtale.txt", String.valueOf(excludeList));

//		System.out.println("Index created - enter query word");

        while (scnr.hasNext()) {
            String word = scnr.next();
            /* your code here */
            // if the word is in the exclusion list
            //		print "Excluded from search."
            // else if the word is not in the text
            //		print "Not in text."
            // else
            //		print the list of page numbers
            //		use System.out.print(pageNumber + " ")
            //		followed by System.out.println() when done

            if (excludeList.contains(word))
                System.out.print(word + ": Excluded from search.");
            else if (!st.containsKey(word))
                System.out.print(word + ": Not in text.");
            else {
                TreeSet<Integer> pageList = new TreeSet<>(st.get(word));
                System.out.print(word + ": ");
                for (int page : pageList)
                System.out.print(page + " ");
            }
                System.out.println();
        }
        scnr.close();
    }
}
	