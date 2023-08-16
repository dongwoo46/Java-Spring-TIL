package pkg1;

import pkg1.pkg2.pkg3.Person; //패키지명을 생략하고 쓰겟다.
public class PackageTest {
    public static void main(String[] args) {
        // 서로 다른 패키지에 있는 클래스 중에서
        // 하남를 골라서 쓸때 이렇게 씀
//        Person p1 = new Person();
//        System.out.println(p1.pkg);

        // 만약 서로 다른 패키지에 있는 이름이 같은 클래스를
        // 두개 이상 쓰려고하면 -> 패키지 생략 안됨
        // 패키지명.클래스명 => 풀패키지이름
        pkg1.Person p1 = new pkg1.Person();
        pkg1.pkg2.Person p2 = new pkg1.pkg2.Person();
        pkg1.pkg2.pkg3.Person p3 = new pkg1.pkg2.pkg3.Person();
        Person p4 = new Person();

        System.out.println(p1.pkg);
        System.out.println(p2.pkg);
        System.out.println(p3.pkg);
        System.out.println(p4.pkg);

    }
}
