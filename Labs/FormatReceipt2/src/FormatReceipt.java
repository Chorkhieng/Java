import java.util.Scanner;

public class FormatReceipt {
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        int value = n.nextInt();

        String[] stA = new String[value];
        int[] numA = new int[value];
        double[] dbA = new double[value];

        for (int i = 0; i < value; i++){
            String st = n.nextLine();
            stA[i] = n.nextLine();
            int num = n.nextInt();
            Double db = n.nextDouble();
            numA[i] = num;
            dbA[i] = db;
        }


        double sum = 0.00;

        for (int a = 0; a < value; a++){
            sum += numA[a] * dbA[a];
            System.out.printf("%-15s %5.2f\n", stA[a], numA[a] * dbA[a]);
        }

        System.out.printf("%22s", "------\n");
        System.out.printf("%21.2f\n", sum);
    }
}