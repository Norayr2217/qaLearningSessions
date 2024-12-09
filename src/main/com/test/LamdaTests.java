package main.com.test;

import main.com.main.lamda.GreetingService;

public class LamdaTests {

    public static void main(String[] args) {
//        GreetingService service = new GreetingService() {
//            @Override
//            public void greet(String name) {
//                System.out.println("Hello... " + name);
//            }
//        };

//        GreetingService service1 = name -> System.out.println("Hi... " + name);
//        service1.greet("Poxos");

        GreetingService service2 = name -> {
            System.out.println("Hi... " + name.toUpperCase());
            System.out.println("Hi... " + name.length());
        };

        service2.greet("Anna");
    }
}
