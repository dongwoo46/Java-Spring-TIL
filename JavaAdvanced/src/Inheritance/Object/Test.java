package Inheritance.Object;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Student st = new Student("김동우",5,"산업공");
        st.eat(); // 자식클래스에서 부모의 메서드 재정의 가능
        st.toString();
        System.out.println(st.toString()); //Object의 메서드를 상속받고 잇음

        Student st2 = new Student("김동우", 20, "자바");
        System.out.println(st == st2); // 다른객체
        System.out.println(st.equals(st2)); // 다르게 나옴, 주소값 비교
        // == 와 equals는 같은 뜻 주소값 비교
        // 객체의 내용을 비교하고 싶으면 equals 재정의 필요

        Object o = new Object();
        o.equals(st);

        //집합
        Set<Student> set = new HashSet<>();
        set.add(st);
        set.add(st2);
        System.out.println(set.size());
        // set에서는 도일성을 판단하기 위해서 equals와 hashcode를 사용
        // 해시코드를 재정의해야 같은것으로 봄

    }
}
