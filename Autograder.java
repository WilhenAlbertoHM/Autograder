import java.util.*;

// Program that calculates the final grade for Fundamentals of Physics I (Physics 113).
public class Autograder {

    // Prints letter grade.
    public static String letterGrade(double grade) {
        if (grade >= 93.33) return "A";
        else if (grade >= 90 && grade < 93.33) return "A-";
        else if (grade >= 86.66 && grade < 90) return "B+";
        else if (grade >= 83.33 && grade < 86.66) return "B";
        else if (grade >= 80 && grade < 83.33) return "B-";
        else if (grade >= 76.66 && grade < 80) return "C+";
        else if (grade >= 73.33 && grade < 76.66) return "C";
        else if (grade >= 70 && grade < 73.33) return "C-";
        else if (grade >= 66.66 && grade < 70) return "D+";
        else if (grade >= 63.33 && grade < 66.66) return "D";
        else if (grade >= 60 && grade < 63.33) return "D-";
        else return "F";        
    }

    // Calculates homework average grade without two of the worst scores.
    public static double average(ArrayList<Double> scores) {
        Collections.sort(scores);
        double avg = 0.0;
        for (int i = 2; i < scores.size(); i++) {
            avg += scores.get(i);
        }
        return avg / 150;
    }

    // Calculates 1st midterm grade after redo.
    public static double m1Grade(double m1, double redo) {
        return (m1 + redo) / 2;
    }

    // Calculates final grade for the class
    public static double finalGrade(double hw, double m1, double m2, double f) {
        // Scalings.
        hw *= 30.0;
        m1 /= 2.0;
        m2 /= 2.0;
        f /= 2.0;
        return hw + m1 + m2 + f;
    }

    // Main function.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> hw_scores = new ArrayList<>();

        // Obtain homework average grade.
        for (int i = 0; i < 7; i++) {
            System.out.printf("Homework %d Grade: ", i + 1);
            double hw_score = in.nextDouble();
            while (hw_score < 0.0 || hw_score > 30.0) {
                System.out.println("Please enter a number between 0.0 and 30.0");
                System.out.printf("Homework %d Grade: ", i + 1);
                hw_score = in.nextDouble();
            }
            hw_scores.add(hw_score);
        }
        
        // Obtain 1st midterm grade.
        System.out.print("Midterm 1 Grade: ");
        double m1_score = in.nextDouble();
        while (m1_score < 0.0 || m1_score > 40.0) {
            System.out.println("Please enter a number between 0.0 and 40.0");
            System.out.print("Midterm 1 Grade: ");
            m1_score = in.nextDouble();
        }

        // Obtain 1st midterm redo grade.
        System.out.print("Midterm 1 Redo Grade: ");
        double redo_score = in.nextDouble();
        while (redo_score < 0.0 || redo_score > 40.0) {
            System.out.println("Please enter a number between 0.0 and 40.0");
            System.out.print("Midterm 1 Redo Grade: ");
            redo_score = in.nextDouble();
        }
        
        // Obtain 2nd midterm grade.
        System.out.print("Midterm 2 Grade: ");
        double m2_score = in.nextDouble();
        while (m2_score < 0.0 || m2_score > 45.0) {
            System.out.println("Please enter a number between 0.0 and 45.0");
            System.out.print("Midterm 2 Grade: ");
            m2_score = in.nextDouble();
        }

        // Obtain final exam grade.
        System.out.print("Final Exam Grade: ");
        double final_score = in.nextDouble();
        while (final_score < 0.0 || final_score > 60.0) {
            System.out.println("Please enter a number between 0.0 and 60.0");
            System.out.print("Final Exam Grade: ");
            final_score = in.nextDouble();
        }

        // Print final grade
        double final_grade = finalGrade(average(hw_scores), m1Grade(m1_score, redo_score), m2_score, final_score);
        System.out.printf("Your final grade is %.2f out of 100, which is a %s.", final_grade, letterGrade(final_grade));
        in.close();
    }
}
