import java.util.Scanner;

public class QuizScores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numQuizzes = sc.nextInt();
        int[] scores = new int[numQuizzes];
        for (int i = 0; i < numQuizzes; i++)
            scores[i] = sc.nextInt();

        sc.close();

        // Don't change anything above this line.

        // Your code starts here.

        //find the first student with 100% score
        if(ArrayUtils.find(scores, 0, scores.length, 100)==-1){
            System.out.println("No one scored 100%.");
        } else {
            System.out.println("Student " + ArrayUtils.find(scores, 0, scores.length, 100) + " was the first 100% score.");
        }

        //phase2: minimum and maximum scores
        if(scores.length<2){
            System.out.println("Too few items to split into two non-empty ranges.");
        } else {
            // print maximum part
            System.out.print("The maximum scores in the first and second halves were ");
            System.out.print(scores[ArrayUtils.maxElement(scores, 0, (scores.length/2))]);
            System.out.print(" (student " + ArrayUtils.maxElement(scores, 0, scores.length/2));
            System.out.print(") and " + scores[ArrayUtils.maxElement(scores, scores.length/2, scores.length)]);
            System.out.println(" (student " + ArrayUtils.maxElement(scores, scores.length/2, scores.length) + ").");

            //print the minimum part
            System.out.print("The minimum scores in the first and second halves were ");
            System.out.print(scores[ArrayUtils.minElement(scores, 0, (scores.length/2))]);
            System.out.print(" (student " + ArrayUtils.minElement(scores, 0, scores.length/2));
            System.out.print(") and " + scores[ArrayUtils.minElement(scores, scores.length/2, scores.length)]);
            System.out.println(" (student " + ArrayUtils.minElement(scores, scores.length/2, scores.length) + ").");
        }

        // phase3: number of 100% in each third

        if(scores==null){
            ;
        } else {
            System.out.print("The numbers of 100%s in the 3 thirds were ");
            System.out.print(ArrayUtils.count(scores, 0, scores.length/3, 100) + ", ");
            System.out.print(ArrayUtils.count(scores, scores.length/3, 2*scores.length/3, 100) + ", and ");
            System.out.println(ArrayUtils.count(scores, 2*scores.length/3, scores.length, 100) + ".");
        }
    }
}
