import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int N = scnr.nextInt();

        int[] arr = new int[N];
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            arr[i] = scnr.nextInt();
        }

        int target = scnr.nextInt();

        for (int j = 0; j < arr.length; j++){
            for (int k = j+1; k < arr.length; k++){
                if((arr[j]+arr[k]) == target){
                    count += 1;
                } else {
                    continue;
                }
            }
        }

        System.out.println(count);

        scnr.close();
    }
}
