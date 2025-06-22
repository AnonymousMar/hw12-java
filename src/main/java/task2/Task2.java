package task2;

public class Task2 {
    private int number = 1;

    public synchronized void fizzbuzz(){
        while (true){
            if (number > 16) break;
            if (number % 15 == 0 ){
                System.out.println("fizzbuzz");
                number++;
                notifyAll();
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }

    }
    public synchronized  void fizz(){
        while (true){
            if (number > 16) break;
                if (number % 3 == 0 && number % 15 != 0 ){
                    System.out.println("fizz");
                    number++;
                    notifyAll();
                }
                else {
                    try {
                      wait();
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
    }
    public synchronized void buzz(){
        while (true){
            if (number > 16) break;
            if (number % 5 == 0 && number % 15 != 0 ){
                System.out.println("buzz");
                number++;
                notifyAll();
            }
            else {
                try {
                  wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        }


    public synchronized void numbers(){
        while (true){
            if (number > 16) break;
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.println(number);
                number++;
                notifyAll();
            }
            else {
                try {
                   wait();
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public  void run(){
        Task2 task2 = new Task2();
        Thread C = new Thread(task2::fizzbuzz);
        Thread A = new Thread(task2::fizz);
        Thread B = new Thread(task2::buzz);
        Thread D = new Thread(task2::numbers);

        A.start();
        B.start();
        C.start();
        D.start();
    }
}
