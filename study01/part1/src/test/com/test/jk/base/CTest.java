package com.test.jk.base;


import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class CTest {

    private static PrintStream S_ = System.out;

    @Test
    void callFunc(){
        S_.println("++++++++++++++++++++");

        S_.println("=====================");
    }

    @Test
    void callTest(){
        S_.println("Call A () ----------------------------");
    }

}
