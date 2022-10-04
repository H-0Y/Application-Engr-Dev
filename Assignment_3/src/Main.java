
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //create an instance of Calculator
        Calculator calculator = new Calculator();
        //create a Scanner class for inputting
        Scanner sc = new Scanner(System.in);
        //user input and set the values of the attributes in Calculator by mutator methods
        System.out.println("Please input max scores: ");
        for(int i = 0; i < calculator.getMaxScores().length; i++) {
            calculator.setMaxScore(i, sc.nextDouble());
        }
        System.out.println("Please input earned scores: ");
        for(int i = 0; i < calculator.getRowScores().length; i++) {
            calculator.setRowScore(i, sc.nextDouble());
        }
        System.out.println("Please input assignment percentages: ");
        for(int i = 0; i < calculator.getPercentages().length; i++) {
            calculator.setPercentage(i, sc.nextDouble());
        }
        //calculate process
        calculator.calculate();
        //access the result
        Double result = calculator.getResult();
//        System.out.println(Arrays.toString(calculator.getMaxScores()));
//        System.out.println(Arrays.toString(calculator.getRowScores()));
//        System.out.println(Arrays.toString(calculator.getPercentages()));
        System.out.printf("Your total score is: %.3f\n",result);
        char c;
        if(result >= 90) c = 'A';
        else if(result >= 80) c = 'B';
        else if(result >= 70) c = 'C';
        else if(result >= 60) c = 'D';
        else c = 'F';

        //output the result of grades
        System.out.printf("Your grade is: %c \n", c);
    }

}



























