
// StudentScores keeps track of the quiz/test/homework
// scores of a particular student.  The student is identified
// by their first and last name.

public class StudentScores {

    // Invariant:
    // firstName and lastName are not null
    // All arrays are allocated to the proper size.
    private String firstName;
    private String lastName;
    private double[] quizScores;

    public StudentScores(String firstName, String lastName, int numQuizScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        quizScores = new double[numQuizScores];
    }

    public void setQuizScore(int quizNumber, double quizScore) {
        assert 0 <= quizNumber && quizNumber < quizScores.length;
        quizScores[quizNumber] = quizScore;
    }

    public double getQuizScore(int quizNumber) {
        assert 0 <= quizNumber && quizNumber < quizScores.length;
        return quizScores[quizNumber];
    }

    public double getQuizAverage() {
        double totalScore = 0.0;
        for (int i = 0; i < quizScores.length; i++)
            totalScore += quizScores[i];
        return totalScore / quizScores.length;
    }

    // Returns the state of the object as
    //      firstName,lastName,score1,score2,...,scoreN
    @Override
    public String toString() {
        String result = firstName + "," + lastName;
        for (int i = 0; i < quizScores.length; i++)
            result += "," + quizScores[i];
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        StudentScores rhs = (StudentScores)other;
        return this.firstName == rhs.firstName
                && this.lastName == rhs.lastName;
    }

    public static void main(String[] args) {
        StudentScores ss = new StudentScores("John", "Doe", 3);
        ss.setQuizScore(0, 80);
        ss.setQuizScore(1, 82);
        ss.setQuizScore(2, 94);

        System.out.println(ss);
    }
}
