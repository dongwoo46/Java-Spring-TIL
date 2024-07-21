package Abstract.Abstract3;
public class Test {
    public static void main(String[] args) {
       // 자식 클래스에서 추상클래스에서 없는 메서드를 만들어보자
        // eat
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        Animal a3 = new Person();

        a1.eat(); // 왜 안될까?
        // 부모클래스에 추상메서드 혹은 일반메서드를 정의해놔야
        // 부모클래스 타입으로 참조 시 메서드 사용가능
        a1.speak();

        // 조상 클래스에서 일반 메서드로 상속받는 것 vs 추상 메서드
        // 일반 메서드 -> 상속
        // 추상 메서드 -> 상속

        //(부모클래스에서) 일반 메서드를 사용하는 경우
        // -> 자식클래스에서 재정의 안하고 넘어갈 수 있음

        // 부모 클래스에서 일반 메서드, 추상 메서드 둘다 안만들고
        // 자식 클래스에서 독립적으로 만들어서 사용하는 경우
        // -> 다형성 사용 불가
    }
}
