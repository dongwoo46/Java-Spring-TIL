package AccessModifier.SingleTon;

public class Person {

    //싱글턴으로 바꾸기
    // 1. private로 자기자신을 만들기
    //   - static : 객체를 생성하지 않고 클래스 이름으로 접근하기 위함
    private static Person instance = new Person();

    // 2. 생성자를 private로 막기
    private Person() {
        this.name="유일한사람";
        this.age=123123;
    }

    // 3. 유일한 객체에 접근할 수 잇는 통로만들기
    public static Person getInstance() {
        return instance;
    }

    private String name;
    private int age;
    private boolean hungry;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        if (age<0){
            System.out.println("나이가 음수 안됨");
            return;
        }
        if (age>100) {
            System.out.println("오래못살아");
            return;
        }
        this.age = age;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}
