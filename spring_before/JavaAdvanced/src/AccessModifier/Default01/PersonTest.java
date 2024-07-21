package AccessModifier.Default01;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        // 다른 클래스에 있지만
        // 같은 패키지이므로 deafult속성에 접근가능
        p1.name = "동우";
    }
}
