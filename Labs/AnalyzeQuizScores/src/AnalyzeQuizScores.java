import java.util.Scanner;

public class AnalyzeQuizScores {

    public static void main(String[] args) {

        /////////////////////////////////////////////////////////
        //
        // Do not modify the code between this and the other line of //s
        //

        Scanner sc = new Scanner(System.in);

        int numStudents = sc.nextInt();

        String[] firstNames = new String[numStudents];
        String[] lastNames = new String[numStudents];
        int[] scores = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            firstNames[i] = sc.next();
            lastNames[i] = sc.next();
            scores[i] = sc.nextInt();
        }

        sc.close();

        //
        // Do not modify anything about this line!
        //
        //////////////////////

        // Your code starts here.
        // phase1:

        if(BinarySearch.exists(scores, 87)){
            System.out.println("Someone did score 87.");
        } else {
            System.out.println("No one scored 87.");
        }

        if(BinarySearch.exists(scores, 80)){
            System.out.println("Someone did score 80.");
        } else {
            System.out.println("No one scored 80.");
        }

        // phase2:
        System.out.print(BinarySearch.upperBound(scores, 93)-BinarySearch.lowerBound(scores,93));
        System.out.println(" students scored 93.");

        // phase3:
        System.out.println("The following students received Bs:");
        for(int i=BinarySearch.lowerBound(scores, 80); i<BinarySearch.lowerBound(scores, 90); i++){
            System.out.println(firstNames[i] + " " + lastNames[i]);
        }

        // phase4:
        System.out.println("The following students scored 79:");
        for(int i=BinarySearch.lowerBound(scores, 79); i<BinarySearch.upperBound(scores, 79); i++){
            System.out.println(firstNames[i] + " " + lastNames[i]);
        }
    }
}
