package com.test.jk.base.link;

import com.data.draw.NDrawDataManager;
import org.junit.jupiter.api.Test;

public class LinkFuncTest {

    @Test
    void drawCallTest(){
        //
        NDrawDataManager nd = new NDrawDataManager(800,800);

        try {
            //
            int[] arr = {1,2,3,4,5,6,7};
            nd.addData(arr).drawData((d,g)->{
                System.out.println(" step001 ");

                return d;
            }, nd).drawData((d,g)->{
                System.out.println(" step002 ");

                return d;
            }, nd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void callTest(){
        //
        NDrawDataManager nd = new NDrawDataManager(800,800);

        //
        nd.callAdd((d, g)->{
            System.out.println("::: step01 ::::");
            System.out.println("01 d:" + d);
            System.out.println("01 g:" + g);
            System.out.println("::: step01 END ::::");
            return d;
        }, nd).callAdd((d, g)->{
            System.out.println("::: step02 ::::");
            System.out.println("02 d:" + d);
            System.out.println("02 g:" + g);
            System.out.println("::: step02 END ::::");
            return d;

        }, nd);

    }
}
