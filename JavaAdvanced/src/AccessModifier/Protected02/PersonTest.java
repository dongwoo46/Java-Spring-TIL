package AccessModifier.Protected02;

import AccessModifier.Protected01.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        // 다른 패키지에 있으므로 protected속성 접근 불가
//        p1.name = "동우";
    }
}
