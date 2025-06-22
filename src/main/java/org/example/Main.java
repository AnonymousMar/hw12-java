package org.example;

import task1.Task1;
import task2.Task2;

public class Main {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.run();
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

