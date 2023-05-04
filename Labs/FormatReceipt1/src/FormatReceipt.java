import java.util.Scanner;

public class FormatReceipt {
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        int value = n.nextInt();
        n.nextLine();

        String[] stA = new String[value];
        int[] numA = new int[value];
        double[] dbA = new double[value];

        for (int i = 0; i < stA.length; i++){
            if (n.hasNext()){
                stA[i] = n.nextLine();
            } else {
                continue;
            }
        }

        for (int j = 0; j < numA.length; j++){
            if(n.hasNextInt()){
                numA[j] = n.nextInt();
            } else {
                continue;
            }
        }

        for (int k = 0; k < dbA.length; k++){
            if(n.hasNextDouble()){
                dbA[k] = n.nextDouble();
            } else {
                continue;
            }
        }

        double sum = 0.00;

        for (int a = 0; a < value; a++){
            sum += numA[a] * dbA[a];
            System.out.printf("%-15s %6.2f\n", stA[a], numA[a] * dbA[a]);
        }

        System.out.printf("%23s", "------\n");
        System.out.printf("%22.2f\n", sum);
    }
}
