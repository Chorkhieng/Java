// don't change this code
// this is for test only

public class TestDivisibleByN {

    public static void main(String[] args) {

        Integer[] collatz = { 27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214,
                107, 322, 161, 484, 242, 121, 364, 182, 91, 274, 137 };

        for (int i = 2; i < 10; i++) {
            System.out.printf("The follow numbers are divisible by %s\n", i);
            DivisibleByN divN = new DivisibleByN(i);
            for (int n : collatz)
                if (divN.test(n))
                    System.out.printf("%d ", n);
            System.out.println();
        }
    }
}
