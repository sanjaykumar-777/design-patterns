package singletonpattern;

import java.io.*;

public class ReadResolveTest {
    public static void main(String[] args) {


        try {
            Browser instance1 = Browser.getInstance();

            //serialize the Browser instance
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
            out.writeObject(instance1);
            out.close();

            //deserialize the Browser instance
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("browser.json"));
            Browser instance2 = (Browser) in.readObject();
            in.close();

            System.out.println("hashcode of instance1 : "+instance1.hashCode());
            System.out.println("hashcode of instance2 : "+instance2.hashCode());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
