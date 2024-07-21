package AccessModifier.Getter_Setter;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
//        pl.name = "이승재" ; //private 멤버 변수이므로 접근불가
        p1.setName("이승재"); // public 메서드 이므로 접근 가능
        p1.setAge(-19); // setter를 이용해 멤버 변수 값 수정
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
    }
}
