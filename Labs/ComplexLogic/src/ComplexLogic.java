
import java.util.Scanner;

public class ComplexLogic {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);

        while(n.hasNextInt()){
            int value = n.nextInt();

            if(((value%2)!=0) && ((value<0) || (value>=100))){
                System.out.println("yes");
            } else if((value%3)==0 || (value>=0 && value<100)){
                System.out.println("maybe");
            } else {
                System.out.println("no");
            }
        }
    }
}

