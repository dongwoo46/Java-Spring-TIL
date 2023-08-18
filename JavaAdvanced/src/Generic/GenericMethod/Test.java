package Generic.GenericMethod;

public class Test {
    public static void main(String[] args) {
        // 제네릭 클래스의 변수 선언
        // 제네릭 클래스로 객체 만듦
        // 선언과 객체 생성시 타입 지정

        GenericBox<String> strBox = new GenericBox<String>();
        strBox.setData("Generic");
        System.out.println(strBox.getData());
        strBox.genericMethod(123);
    }
}
