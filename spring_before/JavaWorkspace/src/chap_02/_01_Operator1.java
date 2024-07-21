package chap_02;

public class _01_Operator1 {
    public static void main(String[] args) {
        // 산술 연산자


        // 증감 연산자 ++ , --
        int val;
        val = 10;
        System.out.println(val); // 10
        System.out.println(++val); //11
        System.out.println(val); //11

        val = 10;
        System.out.println(val); // 100
        System.out.println(val++); //10
        System.out.println(val); // 11

        val = 10;
        System.out.println(val); // 10
        System.out.println(--val); //9
        System.out.println(val); // 9

        val = 10;
        System.out.println(val); // 10
        System.out.println(val--); //0
        System.out.println(val); // 9

        // 은행 대기번호표
        int waiting = 0;
        System.out.println("대기인원: " + waiting++); // 대기인원 0
        System.out.println("대기인원:" + waiting++); // 대기인원 1
        System.out.println("대기인원 : " + waiting++); // 대기인원2
        System.out.println("총 대기인원: " + waiting);

    }
}
