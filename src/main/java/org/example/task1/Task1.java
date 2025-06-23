package org.example.task1;

public class Task1  implements  Runnable {
    @Override

    public void run() {
        for (int i = 1; ; i++) {
            System.out.println(i + " seconds have passed");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
