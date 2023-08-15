package chap_05;

public class _02_Parameter {
    public  static void power(int x) {
        int result = x*x;
        System.out.println(result);
    }

    public static void powerByExp(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *=number;
        }
        System.out.println(number+"의"+exponent+"승은"+result);
    }

    public static void main(String[] args) {
        // 전달값, parameter
        power(3);
        power(2);

        powerByExp(3, 3);

    }
}
