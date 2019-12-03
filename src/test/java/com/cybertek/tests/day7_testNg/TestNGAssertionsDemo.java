package com.cybertek.tests.day7_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals(1, 23);
    }
    @Test
    public void test2() {
        System.out.println("Second Assertion");
        Assert.assertEquals("title","title");
    }

    @Test
    public void testEmail(){
        String email = "mrtdh.com";
        Assert.assertTrue(email.contains("@"),"Verify @ in the email");
    }

    @Test
    public void test3(){

        Assert.assertNotEquals("one","two");
    }

    @Test
    public void test4(){
        Assert.assertFalse(1<0);

    }
}
