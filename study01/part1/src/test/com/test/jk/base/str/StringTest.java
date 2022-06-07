package com.test.jk.base.str;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void strTest(){
        String r = String.format("%02d", 9);
        System.out.println(r);
        String tmp = String.format("% 2d", 9);
        System.out.println(tmp);
    }

}
