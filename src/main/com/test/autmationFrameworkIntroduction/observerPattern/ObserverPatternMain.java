package main.com.test.autmationFrameworkIntroduction.observerPattern;

public class ObserverPatternMain {
    public static void main(String[] args) {
        TestSubject subject = new TestSubject();

        Observer observer1 = new ConcreteObserver("Observer1");
        Observer observer2 = new ConcreteObserver("Observer2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState("State 1");
        subject.setState("State 2");
    }
}
