package Class.MethodOverLoading01;
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        int sum = p1.add(4, 5);
        double sum2 = p1.add(2.4,4.5);
        System.out.println(sum2);
        p1.eat("탕수육");
        p1.eat();
        p1.eat("햄버거", 3);
        p1.eat(5,"사과"); // 파라미터 순서 바뀌어도 가능
    }
}
