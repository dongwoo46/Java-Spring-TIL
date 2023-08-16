package Class.Class01;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(); // 객체의 생성 : new 키워드 + 생성자 호출
        p1.name = "김동우";
        p1.age = 23;
        p1.eat();

        Person p2 = new Person();
        p2.name= "김시원";
        p2.age = 24;
        p2.eat();
    }
}
