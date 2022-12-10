package advisor.manage;


import advisor.manage.entity.Operation;


import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;


public class Main {
    public static void main(String[] args) {
        // create an instance of Operation Class
        Operation operation = new Operation();
        // capture exception
        try(Scanner scanner = new Scanner(System.in)) {
            // used for log system
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

            // User login: there are two users in the cloud database now.
            // one is {username: Test, password: 123456}
            // another is {username: root, password: 123}

            boolean flag = true;
            while (flag) {
                try {
                    operation.login(scanner);
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Failure, your username or password is incorrect.");
                }
            }

            // Main interface:
            // Level 1: First choose an operation
            while(true) {
                System.out.println("========================");
                System.out.println("1. Add info");
                System.out.println("2. Delete info by id");
                System.out.println("3. Query info by id");
                System.out.println("4. Show info");
                System.out.println("5. Modify user info");
                System.out.print("Enter a operation you want (enter any other number to quit) : ");

                int input;
                // check whether the input is legal
                try {
                    input = scanner.nextInt();
                }catch (Exception e){
                    System.out.println("Sorry, you entered an illegal character");
                    return;
                }
                scanner.nextLine();
                // Level 2: Decide the object you want to manipulate
                switch (input){
                    // ADD
                    case 1:
                        System.out.println("========================");
                        System.out.println("1. Add student info");
                        System.out.println("2. Add advisor info");
                        System.out.println("3. Add advised info");
                        System.out.println("4. Back to last level");
                        System.out.print("Enter a operation you want (enter any other number to quit) : ");

                        // check whether the input is legal
                        try {
                            input = scanner.nextInt();
                        }catch (Exception e){
                            System.out.println("Sorry, you entered an illegal character");
                            return;
                        }
                        scanner.nextLine();
                        switch (input){
                            case 1:
                                operation.addStudent(scanner);
                                break;
                            case 2:
                                operation.addAdvisor(scanner);
                                break;
                            case 3:
                                operation.addAdvised(scanner);
                                break;
                            case 4:
                                break;
                            default:
                                return;
                        }
                        break;
                    // DELETE
                    case 2:
                        System.out.println("========================");
                        System.out.println("1. Delete student info");
                        System.out.println("2. Delete advisor info");
                        System.out.println("3. Delete advised info");
                        System.out.println("4. Back to last level");
                        System.out.print("Enter a operation you want (enter any other number to quit) : ");
                        try {
                            input = scanner.nextInt();
                        }catch (Exception e){
                            System.out.println("Sorry, you entered an illegal character");
                            return;
                        }
                        scanner.nextLine();
                        switch (input){
                            case 1:
                                operation.deleteStudent(scanner);
                                break;
                            case 2:
                                operation.deleteAdvisor(scanner);
                                break;
                            case 3:
                                operation.deleteAdvised(scanner);
                                break;
                            case 4:
                                break;
                            default:
                                return;
                        }
                        break;
                    // Query
                    case 3:
                        System.out.println("========================");
                        System.out.println("1. Query student info");
                        System.out.println("2. Query advisor info");
                        System.out.println("3. Query advised info");
                        System.out.println("4. Back to last level");
                        System.out.print("Enter a operation you want (enter any other number to quit) : ");
                        try {
                            input = scanner.nextInt();
                        }catch (Exception e){
                            System.out.println("Sorry, you entered an illegal character");
                            return;
                        }
                        scanner.nextLine();
                        switch (input){
                            case 1:
                                operation.getStudentBySid(scanner);
                                break;
                            case 2:
                                operation.getAdvisorByAid(scanner);
                                break;
                            case 3:
                                operation.getAdvisedById(scanner);
                                break;
                            case 4:
                                break;
                            default:
                                return;
                        }
                        break;
                    // Show
                    case 4:
                        System.out.println("========================");
                        System.out.println("1. Show all student info");
                        System.out.println("2. Show all advisor info");
                        System.out.println("3. Show all advised info");
                        System.out.println("4. Back to last level");
                        System.out.print("Enter a operation you want (enter any other number to quit) : ");
                        try {
                            input = scanner.nextInt();
                        }catch (Exception e){
                            System.out.println("Sorry, you entered an illegal character");
                            return;
                        }
                        scanner.nextLine();
                        switch (input){
                            case 1:
                                operation.showStudent();
                                break;
                            case 2:
                                operation.showAdvisor();
                                break;
                            case 3:
                                operation.showAdvised();
                                break;
                            case 4:
                                break;
                            default:
                                return;
                        }
                        break;
                    // Modify user info
                    case 5:
                        System.out.println("========================");
                        System.out.println("1. Add a new user");
                        System.out.println("2. Delete a user");
                        try {
                            input = scanner.nextInt();
                        }catch (Exception e){
                            System.out.println("Sorry, you entered an illegal character");
                            return;
                        }
                        scanner.nextLine();
                        switch (input) {
                            case 1:
                                operation.addUser(scanner);
                                break;
                            case 2:
                                operation.deleteUser(scanner);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        return;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}