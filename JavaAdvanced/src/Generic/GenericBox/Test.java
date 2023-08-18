package Generic.GenericBox;

public class Test {
    public static void main(String[] args) {
        // 제네릭 클래스의 변수 선언
        // 제네릭 클래스로 객체 만듦
        // 선언과 객체 생성시 타입 지정

        GenericBox<String> strBox = new GenericBox<String>();
        strBox.setData("Generic");
        System.out.println(strBox.getData());


        // new 키워드 다음에 생성자를 호출할 때 <>안에 타입 생략가능
        // 컴파일러가 문맥 유추가능
        GenericBox<Integer> intBox = new GenericBox<>();
        intBox.setData(123);
        Integer i = intBox.getData();

        // Integer : 래퍼클래스
        // 기본형으로 사용하는 int-> 값
        // 래퍼클래스를 사용하면 마치 객체처럼 사용가능

        //래퍼클래스
        // byte->Byte
        // short -> Short
        //int -> Integer
        // long-> Long
        // float -> Float
        // double -> Double
        // char -> Character
        // boolean -> Boolean
        // void -> Void

        int i1 = new Integer(123); // 그냥 기본형 값으로만 사용
        Integer i2 = new Integer(123); // 객체처럼 사용 가능

        //static method
        int num = Integer.parseInt("12341234");

    }
}
