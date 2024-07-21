package AccessModifier.Private01;

// class는 public 아니면 default
public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p1 = new Person();
        // 자기 자신이므로 접근가능
        p1.name="동우";
    }

}
