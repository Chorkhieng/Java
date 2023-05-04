import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSort2 {

    private static void getData(ArrayList<String> names, ArrayList<Integer> values) {
        ArrayList<String[]> rawData = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            names.add(sc.next());
            if (!sc.hasNextInt())
                throw new RuntimeException("Invalid data format");
            values.add(sc.nextInt());
        }
    }

    private static String stripQuotes(String s) {
        int len = s.length();
        return s.substring(1, len-1);
    }

    private static void getStateData(String fileName, ArrayList<String> names, ArrayList<Integer> populations) {
        try {
            FileInputStream inFile = new FileInputStream(fileName);
            Scanner sc = new Scanner(inFile);
            sc.nextLine();  // ignore header
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] fields = line.split(",");
                names.add(stripQuotes(fields[1]));
                populations.add(Integer.parseInt(stripQuotes(fields[2])));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        ArrayList<String> alNames = new ArrayList<>();
        ArrayList<Integer> alValues = new ArrayList<>();
        String sortOrder = "is";

        if (args.length == 0) {
            getData(alNames, alValues);
        }
        else if (args.length == 2) {
            getStateData(args[0], alNames, alValues);
            sortOrder = args[1];
        }
        else
            throw new RuntimeException("Invalid command line");

        if (alNames.size() != alValues.size())
            throw new RuntimeException("Data read error");

        int numEntries = alNames.size();
        String[] names = new String[numEntries];
        Integer[] values = new Integer[numEntries];
        for (int i = 0; i < numEntries; i++) {
            names[i] = alNames.get(i);
            values[i] = alValues.get(i);
        }

        if (sortOrder.charAt(0) == 'i')
            Sort2.insertionSort(names, values);
        else
            Sort2.selectionSort(names, values);
        System.out.println("After sorting by names:");
        for (int i = 0; i < numEntries; i++)
            System.out.printf("%20s %8d\n", names[i], values[i]);

        if (sortOrder.charAt(1) == 'i')
            Sort2.insertionSort(values, names);
        else
            Sort2.selectionSort(values, names);
        System.out.println("After sorting by values:");
        for (int i = 0; i < numEntries; i++)
            System.out.printf("%20s %8d\n", names[i], values[i]);
    }
}
