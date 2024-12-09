package main.com.test;

public class Test {
    public static void main(String[] args) {
        System.out.println(m1());
    }

    public static int m1() {
        int a = 10;
        try {
            return a++;
        } finally {
            return ++a;
        }
    }
}