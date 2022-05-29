package com.test.jk.base.task;

import org.junit.jupiter.api.Test;

import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskTest {

    @Test
    void taskActTest(){

        ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();
        //

        Runnable push = ()->{
            //
            boolean bFlag = true;
            try {
                while (bFlag) {
                    long id = Thread.currentThread().getId();

                    queue.push("["+id+"]DATA ####");
                    System.out.println("Thread-" + id + ": push DATA" );
                    Thread.sleep(700);
                }
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        };


        Runnable poll = ()->{
            boolean bFlag = true;

            try {
                while (bFlag) {

                    if (!queue.isEmpty()) {
                        String data = queue.poll();
                        long id = Thread.currentThread().getId();
                        System.out.println("Thread-" + id + " peek() " + data + " queue size:" + queue.size());

                    }
                    Thread.sleep(600);
                }
                //
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        };

        //-------------------------
        //
        ExecutorService tPool = Executors.newFixedThreadPool(20);
        for(int i=0;i<5;i++) {
            tPool.execute(push);
        }
        //
        for(int i=0;i<10;i++){
            tPool.execute(poll);
        }

        //
        try {
            //main
            Thread.currentThread().join(30 * 1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

        //
        tPool.shutdown();

        System.out.println("####### END ########");


    }

    @Test
    void FutureTest(){

        //-------------------------------
        //
        Callable<String> task = ()->{
            try {
                for (int i = 0; i < 5; i++) {
                    long id = Thread.currentThread().getId();
                    System.out.println( "[Thread-"+id+"] excute @@@@@@@@@@" );
                    Thread.sleep(1000);
                }
                //
                long id = Thread.currentThread().getId();
                return "Result-" + id; //
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            return "Faild";
        };


        //
        ExecutorService s = Executors.newFixedThreadPool(10);

        // 종료 후 다음으로 실행
        List<Future<String>> fList = new ArrayList<Future<String>>();

        fList.add(s.submit(task)); // 종료시 ...
        fList.add(s.submit(task)); // 종료시 ...
        fList.add(s.submit(task)); // 종료시 ...
        fList.add(s.submit(task)); // 종료시 ...
        fList.add(s.submit(task)); // 종료시 ...

        //
        try {
            //
            for(Future<String> f: fList) {
                String r = f.get();
                System.out.println("### " + r);
            }
        }catch (Exception e){

        }

        s.shutdown();
        System.out.println("####### END #############");



    }



    @Test
    void taskTest(){

        // Task
        Thread t = new Thread(()->{
            long id = Thread.currentThread().getId();
            boolean b = true;
            while(b) {
                try {
                    //
                    Thread.sleep(500);
                    System.out.println("Thread-" + id);

                }catch (InterruptedException ie){
                    //
                    ie.printStackTrace();
                }
            }

        });

        t.start();
        try {
            t.join();

        }catch (Exception e){
            e.printStackTrace();
        }

        //
        System.out.println("@@@@@@@@@@@ End @@@@@@@@@@@@");

    }

}
