package Exception;

public class Test01 {
    public static void main(String[] args) {
        int[] nums = {10}; //
//        System.out.println(nums[1]);
        System.out.println(nums[-1]); // 오버플로우 발생시 음수가 들어감 => long

        // java.lang.ArithemticException
        int num = 5/0;

        // java.lang.NumberFormatException
//        int num = Integer.parseInt("ssafy");

        // 예외는 언제 발생? throw  키워드를 사용해서
        // new 예외생성자() => 예외객체
        // 예외 객체를 던질때 발생
        // 예외가 발생? 내부적으로는 예외 객체가 생서되서 던져진것


        throw new ArrayIndexOutOfBoundsException(); // nums[20]


    }
}
