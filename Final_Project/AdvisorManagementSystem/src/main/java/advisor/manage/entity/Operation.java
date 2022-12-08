package advisor.manage.entity;

import advisor.manage.sql.SqlUtil;
import lombok.extern.java.Log;


import java.util.Scanner;
@Log
public class Operation {
    public void login(Scanner scanner) throws NullPointerException{
        SqlUtil.doSqlWork(mapper -> {
            java.lang.System.out.println("Please enter your username: ");
            String userName = scanner.nextLine();
            java.lang.System.out.println("Please enter password: ");
            String password = scanner.nextLine();

            User user = mapper.loginCheck(userName, password);

            java.lang.System.out.println("User: " + user.getUserName()+" logins successfully!");
            log.info("User: " + user.getUserName() + " logins successfully.");
        });
    }

    public void showStudent(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getStudentList().forEach(student -> {
                java.lang.System.out.println(student.getSid()+"."+student.getName()+" "+student.getSex()+" "+student.getGrade()+"");
            });
        });
    }

    public void showAdvisor(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAdvisorList().forEach(advisor -> {
                java.lang.System.out.println(advisor.getAid()+"."+ advisor.getName() + " "+ advisor.getSex());
            });
        });
    }
    public void showAdvised(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAdvisedList().forEach(advised -> {
                java.lang.System.out.println("sid: "+ advised.getSid() + " is advised by " + "aid: "+ advised.getAid());
            });
        });
    }
    public void addAdvised(Scanner scanner){

        java.lang.System.out.println("Please enter aid: ");
        String temp = scanner.nextLine();
        int bid = Integer.parseInt(temp);
        java.lang.System.out.println("Please enter sid: ");
        temp = scanner.nextLine();
        int sid = Integer.parseInt(temp);

        SqlUtil.doSqlWork(mapper -> {

            // check whether this advisor and student existed
            try {
                Advisor advisor = mapper.getAdvisorByAid(bid);
                Student student = mapper.getStudentBySid(sid);
                if(student.getName() != null && advisor.getName() != null) {
                    int i = mapper.addAdvised(sid, bid);
                    if(i>0) {
                        java.lang.System.out.println("Successful!");
                        log.info("add a new advised info: "+ "sid: "+ student.getSid() + " is advised by " + "aid: "+ advisor.getAid());
                    }
                    else java.lang.System.out.println("Failure, please try again");
                }
            } catch (Exception e) {
                java.lang.System.out.println("No such advisor or student was found, please try again");
            }
        });
    }
    public void addAdvisor(Scanner scanner){
        java.lang.System.out.println("Please enter aid: ");
        String id = scanner.nextLine();
        int aid = Integer.parseInt(id);
        java.lang.System.out.print("Please enter the name of the advisor: ");
        String name = scanner.nextLine();
        java.lang.System.out.print("Please enter the sex of the advisor: ");
        String sex = scanner.nextLine();

        Advisor advisor = new Advisor(aid, name, sex);
        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addAdvisor(advisor);
                if(i>0) {
                    java.lang.System.out.println("Successful!");
                    log.info("add a new advisor info: "+ advisor);
                }
                else java.lang.System.out.println("Failure, please try again");
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failure, please check and try again.");
        }

    }
    public void addStudent(Scanner scanner){
        java.lang.System.out.println("Please enter sid: ");
        String id = scanner.nextLine();
        int sid = Integer.parseInt(id);
        java.lang.System.out.print("Please enter the name of the student: ");
        String name = scanner.nextLine();
        java.lang.System.out.print("Please enter the sex of the student (male/female): ");
        String sex = scanner.nextLine();
        java.lang.System.out.print("Please enter the grade of the student: ");
        String grade = scanner.nextLine();
        int g = Integer.parseInt(grade);
        Student student = new Student(sid, name,sex, g);
        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addStudent(student);
                if(i>0) {
                    java.lang.System.out.println("Successful!");
                    log.info("add a new student info: "+ student);
                }
                else java.lang.System.out.println("Failure, please try again");
            });
        } catch (Exception e) {
            System.out.println("Failure, please check and try again.");
        }

    }


    public void deleteStudent(Scanner scanner){
        java.lang.System.out.print("Please enter the id of the student: ");
        Integer sid = scanner.nextInt();

        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.deleteStudentBySid(sid);
            if(i>0) {
                java.lang.System.out.println("Successful!");
                log.info("delete a student info of sid: "+ sid);
            }
            else java.lang.System.out.println("Failure, please try again");
        });
    }

    public void deleteAdvised(Scanner scanner){
        java.lang.System.out.println("Please enter id: ");
        Integer id = scanner.nextInt();
        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.deleteAdvisedById(id);
                if(i>0) {
                    java.lang.System.out.println("Successful!");
                    log.info("delete an advised info of id: "+ id);
                }
                else java.lang.System.out.println("Failure, please try again");
            });
        } catch (Exception e) {
            System.out.println("Failure, please try again");
        }

    }
    public void deleteAdvisor(Scanner scanner) {
        java.lang.System.out.print("Please enter the aid of the advisor: ");
        Integer aid = scanner.nextInt();

        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.deleteAdvisorByAid(aid);
            if (i > 0) {
                java.lang.System.out.println("Successful!");
                log.info("delete a book info of bid: " + aid);
            } else java.lang.System.out.println("Failure, please try again");
        });
    }


    public void getStudentBySid(Scanner scanner){
        SqlUtil.doSqlWork(mapper -> {
            java.lang.System.out.println("Please enter the sid of the student: ");
            Integer sid = scanner.nextInt() ;

            try {
                Student student = mapper.getStudentBySid(sid);

                java.lang.System.out.println(student.getSid()+"."+student.getName()+" "+student.getSex()+" "+student.getGrade());
            } catch (NullPointerException e) {
                java.lang.System.out.println("No such student was found, please try again");
            }

        });
    }

    public void getAdvisorByAid(Scanner scanner){
        SqlUtil.doSqlWork(mapper -> {
            java.lang.System.out.println("Please enter the aid of the advisor: ");
            Integer aid = scanner.nextInt();
            try {
                Advisor advisor = mapper.getAdvisorByAid(aid);
                java.lang.System.out.println(advisor.getAid()+"."+ advisor.getName() +" "+advisor.getSex());
            } catch (NullPointerException e) {
                java.lang.System.out.println("No such advisor was found, please try again");
            }

        });
    }
    public void getAdvisedById(Scanner scanner){
        SqlUtil.doSqlWork(mapper -> {
            java.lang.System.out.println("Please enter id: ");
            Integer id = scanner.nextInt() ;
            try {
                Advised advised = mapper.getAdvisedById(id);

                java.lang.System.out.println("sid: "+ advised.getSid() + " is advised by " + "aid: "+ advised.getAid());
            } catch (NullPointerException e) {
                java.lang.System.out.println("No such advised info was found, please try again");
            }

        });
    }

    public void addUser(Scanner scanner){
        java.lang.System.out.println("Please enter the new username: ");
        String userName = scanner.nextLine();


        java.lang.System.out.print("Please enter the new password: ");
        String password = scanner.nextLine();

        User user = new User(userName, password);
        try {
            SqlUtil.doSqlWork(mapper -> {
                int i = mapper.addUser(user);
                if(i>0) {
                    java.lang.System.out.println("Successful!");
                    log.info("add a new user: "+ user.getUserName());
                }
                else java.lang.System.out.println("Failure, please try again");
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failure, please check and try again.");
        }

    }

    public void deleteUser(Scanner scanner) {
        java.lang.System.out.print("Please enter the username of the advisor: ");
        String username = scanner.nextLine();

        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.deleteUser(username);
            if (i > 0) {
                java.lang.System.out.println("Successful!");
                log.info("delete the user: " + username);
            } else java.lang.System.out.println("Failure, please try again");
        });
    }
}
