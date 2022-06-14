package com.test.jk.base.str;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    @Test
    void strTest(){
        String r = String.format("%02d", 9);
        System.out.println(r);
        String tmp = String.format("% 2d", 9);
        System.out.println(tmp);
    }

    @Test
    void compNumberTest(){
        System.out.println("===============================");
        Pattern p = Pattern.compile("[\\d-\\d]");

        String str = "[A100-200B]";
        Matcher m = p.matcher(str);
        if(m.find()){
            System.out.println(" find!! ");
            System.out.println( m.groupCount() + " " + m.group(0) + " " + m.toString() );
        }else{
            System.out.println(" not find!! ");
        }
    }

    //정규식 확인
    @Test
    void compTest(){
        System.out.println("===============================");

        Pattern p = Pattern.compile("^\\[.*]$"); //<--처리함

        String str = "[100-200]";
        Matcher m = p.matcher(str);
        if(m.find()){
            System.out.println(" find !!!");
            System.out.println( m.group() );
        }else{
            System.out.println(" not find !!!");
        }

    }

}
