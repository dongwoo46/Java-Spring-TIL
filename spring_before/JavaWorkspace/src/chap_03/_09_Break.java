package chap_03;

public class _09_Break {
    public static void main(String[] args) {
        // Break
        // 치킨 집에서 매일 20마리만 판매 (1인당 1마리)
        // 손님 50명 대기

        // for 문
        int max = 20;
        for (int i = 1; i <=50 ; i++) {
            System.out.println(i+"번 손님, 치킨나옴");
            if (i==max) {
                System.out.println("재료소진");
                break;
            }
        }
        System.out.println("영업 종료");

    }
}
