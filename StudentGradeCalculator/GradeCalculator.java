package StudentGradeCalculator;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many subjects you have: ");
        int n = sc.nextInt();
        sc.nextLine();

        String subjects[] = new String[n];
        int marks[] = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjects[i] = sc.nextLine();

            System.out.print("Enter marks for " + subjects[i] + " (out of 100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            total = total + marks[i];
            System.out.println();
        }

        double average = total / (double) n;
        char grade;

        if (average >= 90) {
            grade = 'A';
            System.out.println("Congratulations! Excellent performance!");
        } else if (average >= 80) {
            grade = 'B';
            System.out.println("Great job! Keep it up!");
        } else if (average >= 70) {
            grade = 'C';
            System.out.println("Good effort! You can do even better.");
        } else if (average >= 60) {
            grade = 'D';
            System.out.println("You passed, but try to improve.");
        } else {
            grade = 'F';
            System.out.println("Better luck next time.");
        }

        System.out.println("\n------ Result ------");
        for (int i = 0; i < n; i++) {
            System.out.println(subjects[i] + " : " + marks[i]);
        }
        System.out.println("--------------------");
        System.out.println("Total Marks = " + total);
        System.out.println("Average = " + String.format("%.2f", average) + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }
}
