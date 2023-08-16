package AccessModifier.Getter_Setter;

public class Person {
    // 접근자와 생성자를 만들자
    // 먼저 멤버 변수를 private로 선언
    private String name;
    private int age;
    private boolean hungry;

    // 위 멤버 변수에 접근할 수 있는 통로를
    // public한 메서드로 만들어줌
    // -값을 변경 -> 설정자(setter) : set+멤버변수 이름
    // -값을 조회 -> 접근자(getter) : get+멤버변수 이름

    // 마우스 우클릭 -> Generate -> Getter and Setter
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
