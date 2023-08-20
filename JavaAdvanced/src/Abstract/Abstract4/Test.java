package Abstract.Abstract4;

public class Test {
    public static void main(String[] args) {
       // 자식 클래스에서 추상클래스에서 없는 메서드를 만들어보자
        // eat
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        Animal a3 = new Person();

//        a1.eat(); // 왜 안될까?
        // 안되는 것을 해결하는 방법 2. instanceof를 이용해 형변환
        a1.speak();

        // instanceof 연산자
        // 객체가 해당 클래스로 만든 객체이거나
        // 객체가 해당 클래스의 조상 클래스로 만든 객체인 경우 true
        // 자식 클래스, 젼혀 상관없는 클래스로 만든 객체인 경우 false

        System.out.println(a1 instanceof Animal);
        System.out.println(a1 instanceof Cat);
        System.out.println(a1 instanceof Dog);

        if (a1 instanceof Cat) {
            Cat c = (Cat) a1;
            c.eat();
        }

        if (a2 instanceof Dog) {
            Dog d = (Dog) a2;
            d.eat();
        }

        if (a3 instanceof Person) {
            Person p = (Person) a3;
            p.eat();
        }
    }
}
