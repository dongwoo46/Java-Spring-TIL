package AccessModifier.Protected01;

// class는 public 아니면 default
public class Person {
    // 다른 패키지에서는 안되지만
    // 다른패키지에 있어도 상속받은 클래스면 접근 가능
    protected String name; 
    protected int age;

    public static void main(String[] args) {
        Person p1 = new Person();
        // 자기 자신이므로 접근가능
        p1.name="동우";
    }

}
