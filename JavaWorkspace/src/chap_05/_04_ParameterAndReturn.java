package chap_05;

public class _04_ParameterAndReturn {

    public static int getPower(int number) {
        int result = number * number;
        return result;
    }

    public static int getPowerByExp(int number, int exponent){
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        // 전달값과 바환값이 이슨 메소드
        int retval = getPower(2);
        System.out.println(retval);

        retval = getPower(3);
        System.out.println(retval);

        retval = getPowerByExp(3, 3);
        System.out.println(retval);
    }
}
