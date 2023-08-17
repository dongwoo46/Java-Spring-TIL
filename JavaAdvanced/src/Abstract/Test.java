package Abstract;

public class Test {
    public static void main(String[] args) {
        // 추상 클래스로 객체를 만들수 잇는가? 없다
//        Animal a = new Animal()

        // 다형성
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        Animal a3 = new Person();

        // 부모 클래스 타입의 변수이지만.
        // 메서드의

    }
}
