package singletonpattern;

public class TestBrowser {
    public static void main(String[] args) {
//        Browser.getInstance().displayMsg();
        //call the run method of Runnale interface using lamba expression ()->

        Runnable task1 = () -> {
            Browser.getInstance().displayMsg();
        };

        Runnable task2 = () -> {
            Browser.getInstance().displayHealth();
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task1);
        Thread thread4 = new Thread(task2);

        //start the thread execution
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        //wait for all threads to complete their process
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
