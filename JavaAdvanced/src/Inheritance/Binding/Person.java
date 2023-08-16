package Inheritance.Binding;

public class Person {
    String name;
    int age;

    public Person(String name, int age){ // 파라미터가 있는 생성자
        this.name=name;
        this.age=age;
    }
    public void eat() {
        System.out.println("음식 먹음");
    }
}
