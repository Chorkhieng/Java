import java.util.HashSet;

public class TwoSum {

    public static int countSlow(int[] a) {

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] + a[j] == 0)
                    count += 1;
            }
        }

        return count;
    }

    public static int countFast(int[] a) {

        // Your code goes here.
        HashSet<Integer> num = new HashSet<>();
        int count = 0;

        for (int k = 0; k < a.length - 1; k++){
            num.add(a[k]);
            if (num.contains(-(a[k+1])))
                count++;
        }
        return count;
    }
}
