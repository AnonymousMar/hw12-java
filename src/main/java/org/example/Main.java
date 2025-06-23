package org.example;

import org.example.task1.Task1;
import org.example.task2.Task2;

public class Main {
    public static void main(String[] args) {
        Task2 task2 = new Task2(16);
        try {
            task2.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread thread = new Thread( new Task1());
        thread.start();

       for (int i = 1; ; i++ ){
           try{
               Thread.sleep(5000);
               System.out.println("Пройшло 5 секунд");

           } catch (InterruptedException e){
               System.out.println(e.getMessage());
           }
       }


    }
    }

