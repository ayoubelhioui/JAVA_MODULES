package fr.test.Reflections_Annotations;

import fr.test.Reflections_Annotations.classes.Car;
import fr.test.Reflections_Annotations.classes.User;

import javax.annotation.processing.AbstractProcessor;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        User user = new User();
//        Car car = new Car();
        Class<?> userClass = user.getClass();
        System.out.println(userClass.getSimpleName());
        Method[] methods = userClass.getDeclaredMethods();
//        AbstractProcessor

//        for (Method method: methods)
//        {
//           Class<?>[] c = method.getExceptionTypes();
//            System.out.println("the method is : " + method.getName());
//           for (Class<?> c1: c)
//               System.out.println("-->" + c1.getSimpleName());
//        }
//        System.out.println( "Hello World!" );
    }

}
