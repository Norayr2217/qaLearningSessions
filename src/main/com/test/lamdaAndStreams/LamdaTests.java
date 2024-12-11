package main.com.test.lamdaAndStreams;

import main.com.main.lamda.GreetingService;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LamdaTests {

    public static void main(String[] args) {
        GreetingService service = new GreetingService() {
            @Override
            public void greet(String name) {
                System.out.println("Hello... " + name);
            }
        };

        service.greet("Poxos");

//        int a1 = 5;
//        Consumer<String> service1 = a -> System.out.println("Hi... " + a);
//        service1.andThen(a -> System.out.println("Hi... " + a.length())).accept("Poxos");


        GreetingService service1 = name -> System.out.println("Hi... " + name);
        service1.greet("Poxos");

        GreetingService service2 = name -> {
            System.out.println("Hi... " + name.toUpperCase());
            System.out.println("Hi... " + name.length());
        };

        service2.greet("Anna");
        service2.greet("PODCASTLE");
    }
}
