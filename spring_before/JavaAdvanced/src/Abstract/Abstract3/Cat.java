package Abstract.Abstract3;

public class Cat extends Animal {
    // 추상 클래스를 상속받은 클래스는
    // 추상 메서드를 모두 오버라이드 해야함

    @Override
    public void speak() {
        System.out.println("야옹");
    }

    // 자식 클래스에서 독단적으로 eat() 생성
    public void eat() {
        System.out.println("생선 냠냠");
    }
}
