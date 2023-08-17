package Polymorhpism.Polymorphism2;

public class Student extends Person {
    String major;
    public Student(String name, int age, String major) {
        super(name,age); // 부모클래스의 생성자 호출
        this.major = major;
    }
    public void study() {
        System.out.println("공부함");
    }
    @Override
    public void eat() {
        System.out.println("지식 냠냠");
    }

    @Override
    public String toString() {
        return "Student [name="+super.name+",age="+super.age+",major="+this.major+"]";
    }

    @Override // generate -> override methods
    public boolean equals(Object obj) {
        return name.equals(((Student) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
