package main.com.test.lamdaAndStreams;

public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + '}';
    }

    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("John", 30);
        System.out.println(person);

        // The following lines would cause compile-time errors if uncommented
//         person.name = "Jane";
//         person.age = 25;
    }
}