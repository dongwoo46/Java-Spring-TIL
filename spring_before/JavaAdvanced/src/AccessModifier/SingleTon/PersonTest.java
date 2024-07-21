package AccessModifier.SingleTon;

public class PersonTest {
    public static void main(String[] args) {
//        Person p1 = new Person(); // 싱글턴에서는 객체를 추가로 생성할수 없음
        Person p1 = Person.getInstance();
//        pl.name = "이승재" ; //private 멤버 변수이므로 접근불가
        System.out.println(p1.getName());
        System.out.println(p1.getAge());

        Person p2 = Person.getInstance();
        System.out.println(p2.getAge());
        System.out.println(p2.getName());
    }
}
