package singletonpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionAttackTest {
    public static void main(String[] args) {
        Browser instance1 = Browser.getInstance();
        Browser instance2 = null;

        /*
        Reflections attack - accessing the private constructor
        of a class and trying to create a new object
         */
        try {
            Constructor<Browser> constructor = Browser.class.getDeclaredConstructor();
            //modifying the accessability to true
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();

            //print the hash of each object
            //if same - singleton pattern working fine - same object
            //if different - singleton pattern is not workingn as expected (more than one object got created)
            System.out.println("hashcode of instance1 : "+instance1.hashCode());
            System.out.println("hashcode of instance2 : "+instance2.hashCode());

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
