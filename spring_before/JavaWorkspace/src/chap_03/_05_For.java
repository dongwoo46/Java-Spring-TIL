package chap_03;

public class _05_For {
    public static void main(String[] args) {
        // 반복문 사용 For
        for (int i=0 ; i<10; i++) {
            System.out.println("어서오세요. 동우다" + i);
        }

        //짝수만 출력
        for (int i = 0; i<10; i+=2) {
            System.out.print(i);
        }

        System.out.println();
        // 홀수만 출력
        for (int i = 1; i <10 ; i+=2) {
            System.out.print(i);
        }

        // 거꾸로 출력 (fori만 적고 엔터)
        for (int i = 5 ; i>0; i--) {
            System.out.print(i);
        }

        // 1부터 10까지의 합
        int sum = 0;
        for (int i = 1; i<=10; i++) {
            sum+=i;
            System.out.println(sum);
        }
    }

}
