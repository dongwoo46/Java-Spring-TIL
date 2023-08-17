package Polymorhpism.Polymorphism2;

public class Person extends Object{
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age){ // 파라미터가 있는 생성자
        this.name=name;
        this.age=age;
    }
    public void eat() {
        System.out.println("음식 먹음");
    }
}
