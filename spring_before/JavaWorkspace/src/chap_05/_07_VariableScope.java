package chap_05;

public class _07_VariableScope {
    // 중괄호 안에 있는 곳에서만 변수를 사용가능하고 다른 곳에서 쓰려고 한다면 파라미터로 전달해야함!!
    public static void  methodA() {
//        System.out.println(number);
    }

    public static void methodB(){
        int result = 3; //지역변수
    }

    public static void main(String[] args) {
        // main에 써진건 메인에서만 사용 가능
//        System.out.println(result);

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

//        System.out.println(i);


    }


}
