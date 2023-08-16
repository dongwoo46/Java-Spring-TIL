package AccessModifier.Protected02;


import AccessModifier.Protected01.Person;
public class Student extends Person {
    public static void main(String[] args) {
        Student s1 = new Student();
        // 상속을 받앗으므로
        // 다른패키지에 잇더라도
        // protected 속성에 접근가능

    }
}
