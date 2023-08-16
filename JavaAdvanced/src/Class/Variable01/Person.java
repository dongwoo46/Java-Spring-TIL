package Class.Variable01;

public class Person {
    // static 키워드 -> 클래스변수
    // 이 클래스로 생성되는 모든 인스턴스가 공유
    static String species = "호모 사피엔스 사피엔스";

    // static 키워드가 없으면 -> 인스턴스 변수
    String name;
    int age;

    // 생성자를 만들지 않고
    // 만약에 설계도에 생성자가 하나도 없다면
    // JM이 기본생성자를 만들어줌
    // Person() {}
    public void eat() {
        // 지역변수
        String dish = "짜장면";
    }


}
