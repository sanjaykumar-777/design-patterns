package singletonpattern;

import java.io.Serial;
import java.io.Serializable;

public class Browser implements Serializable {
    //1. private static instance of the class
    // Volatile ensures visibility of changes to the instance variable across threads
    //Best practice
    private volatile static Browser browser;

    //2. private constructor to prevent/avoid object instantiation
    /*
    steps to handle reflections attack
     */
    private Browser() {
        if(browser!= null){
                throw new IllegalArgumentException("object already exists");
        }
    }

    //3.public static getInstance method of to provide access to the instance/object
    /*
    Using a synchronized block to support thread safety in
    multi-threading scenario
     */
    public static Browser getInstance() {
        if (browser == null) {

            synchronized (Browser.class) {
                if (browser == null) {
                    browser = new Browser();
                }
            }
        }
        return browser;
    }

    /*
    Not thread safety
     */
//    private static Browser getInstance(){
//        if(browser == null){
//            browser = new Browser();
//        }
//        return browser;
//    }

    /*
    Declaring the method as synchronized.
    t1 - resource consumtion(locked)
    t2 - waiting
    t3 - waiting
    once t1 completes it's task, then only t2 can access the instance
    but other threads needs to wait until the first thread release it's lock
     */
//    private synchronized static Browser getInstance(){
//        if(browser == null){
//            browser = new Browser();
//        }
//        return browser;
//    }

    //4. Individual public method of the class(optional)
    public void displayMsg() {
        System.out.println("browser info");
    }

    public void displayHealth() {
        System.out.println("browser health");
    }

    //Add readResolve() - Which will be called during De-serialization process
    //this will return class instance
   protected Object readResolve(){
        return getInstance();
    }

}
