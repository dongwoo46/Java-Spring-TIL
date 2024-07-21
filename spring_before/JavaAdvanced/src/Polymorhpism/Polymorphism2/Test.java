package Polymorhpism.Polymorphism2;

public class Test {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("홍승길",23);
        persons[1] = new Person("정민우",20);
        persons[2] = new Student("오지헤", 23, "자바");
        // 부모 클래스로 참조할 수 있지만
        // 부모 클래스의 관점에서 보기때문에
        // 접근 가능한 범위가 달라짐

        for (Person p: persons){
            System.out.println(p);
        }

        Person st = new Student("시월", 23, "자바");


    }
}
