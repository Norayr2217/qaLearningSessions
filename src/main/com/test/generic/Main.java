package main.com.test.generic;

class TestData<T> {
    private T data;

    public TestData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        TestData<String> stringData = new TestData<>("Sample Test");
        System.out.println("Data: " + stringData.getData());
        TestData<Integer> integerData = new TestData<>(42);
        System.out.println("Data: " + integerData.getData());
        TestData<Double> doubleData = new TestData<>(3.14);
        System.out.println("Data: " + doubleData.getData());
    }
}