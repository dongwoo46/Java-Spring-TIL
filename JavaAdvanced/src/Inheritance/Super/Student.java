package Inheritance.Super;

public class Student extends Person {
    String major;
    public Student(String name, int age, String major) {
        super(name,age); // 부모클래스의 생성자 호출
        this.major = major;
    }
    public void study() {
        System.out.println("공부함");
    }
}
