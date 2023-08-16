package Inheritance.Overiding;

public class Test {
    public static void main(String[] args) {
        Student st = new Student("김동우",5,"산업공");
        st.eat(); // 자식클래스에서 부모의 메서드 재정의 가능
    }
}
