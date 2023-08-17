package Polymorhpism.Polymorphism1;

public class Test {
    public static void main(String[] args) {
        Student st = new Student("동우", 23, "자바");

        Person p = st;

        Student st3 = (Student) p;
        st3.study();

        Person p2 = new Person("동우", 23);

        Student st2 = (Student) p2;
//        st2.study();



    }
}
