import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //create an instance of Calculator and initialize three private LinkedLists
        Calculator calculator = new Calculator();

        //create a Scanner class for inputting
        Scanner sc = new Scanner(System.in);

        //creat a bool value for while loop
        boolean flag = false;

        while(!flag) {
            //reset three LinkedLists
            calculator.clearMaxScores();
            calculator.clearRowScores();
            calculator.clearPercentages();

            //user input and add the values to the attributes in Calculator by mutator methods
            System.out.println("Please input max scores, enter -1 to end: ");
            Double input = sc.nextDouble();
            while(!input.equals(-1.0)){
                calculator.addMaxScores(input);
                input = sc.nextDouble();
            }

            System.out.println("Please input earned scores, enter -1 to end: ");
            //reset input
            input = sc.nextDouble();
            while(input != -1.0) {
                calculator.addRowScores(input);
                input = sc.nextDouble();
            }

            //check the consistency of numbers of scores
            if(calculator.sizeOfMaxScores() != calculator.sizeOfRowScores()) {
                System.out.println("The number of scores for maxScores is: " + calculator.sizeOfMaxScores());
                System.out.println("The number of scores for rowScores is: " + calculator.sizeOfRowScores());
                System.out.println("The numbers are not consistent\nEnter 0 to input again or any other number to end");
                if(sc.nextDouble() != 0) return ;
                else continue;
            }

            System.out.println("Please input assignment percentages, enter -1 to end: ");
            //sum is used to check if sum of percentages equals to 100
            Double sum = 0.0;
            //reset input
            input = sc.nextDouble();
            while(input != -1.0) {
                sum += input;
                calculator.addPercentages(input);
                input = sc.nextDouble();
            }
            if(sum != 100) {
                System.out.println("The sum of percentages you just entered is " + sum + ", which doesn't equal to 100 percent");
                System.out.println("Enter 0 to enter again or any other number to end");
                if(sc.nextDouble() != 0) return ;
                else continue;
            }
            //check the consistency of numbers of scores
            if(calculator.sizeOfRowScores()!= calculator.sizeOfPercentages()) {
                System.out.println("The number of scores for maxScores is: " + calculator.sizeOfMaxScores());
                System.out.println("The number of scores for rowScores is: " + calculator.sizeOfRowScores());
                System.out.println("The number of scores for percentages is: " + calculator.sizeOfPercentages());
                System.out.println("The numbers are not consistent\nEnter 0 to input again or any other number to end");
                if(sc.nextDouble() != 0) return ;
                else continue;
            }

            else if(calculator.sizeOfMaxScores() == 0) {
                System.out.println("There is no score, enter 0 to input again or any other number to end");
                if(sc.nextDouble() != 0) return ;
            }
            //end while loop
            else flag = true;
        }

        System.out.println("The number of scores you have input is： " + calculator.sizeOfMaxScores());

        //calculate process
        calculator.calculate();
        //access the result
        Double result = calculator.getResult();
        System.out.println("This is the distribution of your scores: ");
        System.out.println("MaxScore: " + calculator.getMaxScores());
        System.out.println("RowScore: " + calculator.getRowScores());
        System.out.println("Percentages: " + calculator.getPercentages());
        System.out.printf("Your final score is: %.3f\n",result);
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