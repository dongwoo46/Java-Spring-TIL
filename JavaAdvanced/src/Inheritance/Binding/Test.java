package Inheritance.Binding;

public class Test {
    public static void main(String[] args) {
        Student st = new Student("김동우",5,"산업공");
        st.eat(); // 자식클래스에서 부모의 메서드 재정의 가능

        //다형성
        Person st2 = new Student("양명균", 20, "자바");
        st2.eat();
    }
}
