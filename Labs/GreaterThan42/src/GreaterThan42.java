import java.util.Scanner;

public class GreaterThan42 {
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        int num = n.nextInt();
        if(num > 42){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}