package org.example.task2;

public class Task2 {
    private int number = 1;
    private final int numberOfTry;

    public Task2(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public synchronized void fizzbuzz(){
        while (true){
            if (number > numberOfTry) {
                break;
            }
            if (number % 15 == 0 ){
                System.out.println("fizzbuzz");
                number++;
                notifyAll();
            }
            else {
                waitOrCatch();
            }
        }

    }

    public synchronized  void fizz(){
        while (true){
            if (number > numberOfTry) {
                break;
            }
                if (number % 3 == 0 && number % 15 != 0 ){
                    System.out.println("fizz");
                    number++;
                    notifyAll();
                }
                else {
                  waitOrCatch();
                }
            }
    }

    public synchronized void buzz(){
        while (true){
            if (number > numberOfTry) {
                break;
            }
            if (number % 5 == 0 && number % 15 != 0 ){
                System.out.println("buzz");
                number++;
                notifyAll();
            }
            else {
               waitOrCatch();
            }
        }
        }

    public synchronized void numbers(){
        while (true){
            if (number > numberOfTry) {
                break;
            }
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.println(number);
                number++;
                notifyAll();
            }
            else {
                waitOrCatch();
            }
        }
    }

    public  void run() throws InterruptedException {
        Task2 task2 = new Task2(16);
        Thread C = new Thread(task2::fizzbuzz);
        Thread A = new Thread(task2::fizz);
        Thread B = new Thread(task2::buzz);
        Thread D = new Thread(task2::numbers);

        A.start();
        B.start();
        C.start();
        D.start();

        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

   private void waitOrCatch(){
       try {
           wait();
       } catch (InterruptedException e){
           throw new RuntimeException(e);
       }
   }
}
