package Abstract.Abstract3;

// 일반 클래스인데 추상 클래스를 상속받음
public class Person extends Animal {

    @Override
    public void speak() {
        System.out.println("안녕하세요");
    }
    
    public void eat() {
        System.out.println("밥 냠냠");
    }
}
