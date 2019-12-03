package com.cybertek.tests.day7_testNg;

import org.testng.annotations.*;

public class BeforeAndAftertest {

    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before meth. runs");
        System.out.println("Opening the browser");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Close the browser");
    }
    @BeforeClass
    public void BeforeClassMethod() {
        System.out.println("Before CLASS CODE");
    }
        @AfterClass
        public void AfterClassMethod() {
            System.out.println("AFTER CLASS CODE : REPORTING");
        }
    }
