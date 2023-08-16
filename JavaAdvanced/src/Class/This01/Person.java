package Class.This01;

public class Person {
    // static 키워드 -> 클래스변수
    // 이 클래스로 생성되는 모든 인스턴스가 공유
    static String species = "호모 사피엔스 사피엔스";

    // static 키워드가 없으면 -> 인스턴스 변수
    String name;
    int age;

    public Person() {
        this("정민우",24);
    } //생성자 호출
    public Person(String name, int age) {
        this.name =name; // 자기 변수 호출
        this.age = age;
    }


    public double add(double a, double b) {
        return a+b;
    }
    public int add(int a, int b) { // int->반환값
        return a+b;
    }



    public void study(String subject) {
        double probability = Math.random();
        System.out.println(subject + "를 공부한다");
        System.out.println("문제푼다");
        if (probability<0.9999)
            return;

        System.out.println("게임을한다");
        System.out.println("영상을 본다.");
    }

    public void sleep() {
        System.out.println("잠을 잔다.");
    }

    public void eat() {
        // 지역변수
        String dish = "짜장면";
    }

    public void eat(String dish) {
        System.out.println(dish + "먹기");
        this.sleep(); // 자기자신 메서드 호출
    }
    
    public void eat(String dish,int times) {
        System.out.println(dish+"를" + times+"먹는다.");
    }

    public void eat(int times, String dish) {
        System.out.println( times+"먹는다." +dish+"를");
    }

    

}
