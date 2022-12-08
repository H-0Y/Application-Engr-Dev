package com.test;

import advisor.manage.sql.SqlUtil;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void test1(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAdvisedList().forEach(System.out::println);
        });
    }

    @Test
    public void test2() {
        SqlUtil.doSqlWork(mapper -> {
            mapper.getStudentList().forEach(System.out::println);
        });
    }
    @Test
    public void test3(){
        SqlUtil.doSqlWork(mapper -> {
            mapper.getAdvisorList().forEach(System.out::println);
        });
    }
}
