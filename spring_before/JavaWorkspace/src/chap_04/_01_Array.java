package chap_04;

public class _01_Array {
    public static void main(String[] args) {
        // 배열 : 같은 자료형의 값 여러개를 저장하는 것

        // 배열 선언 첫 번재 방법
        String[] coffees = new String[4];

        //배열 선언 두번째 방법
        //String coffees[] = new String[4];
        coffees[0]="아메리카노"; // 0부터 시작
        coffees[1]="카페모카";
        coffees[2]="라떼";
        coffees[3]="카푸치노";

        // 세번재 방법
        //String[] coffees = new String[] {"아메리카노","카페모카","라떼","카푸치노"};

        // 네번재 방법
        //String[] coffees =  {"아메리카노","라떼","사탕","감자"};

        // 커피 주문
        System.out.println(coffees[0] + "하나");
        System.out.println(coffees[1] + "하나");

        coffees[2] = "에스프레소";
        System.out.println(coffees[2] + "하나");
        System.out.println(coffees[3] + "하나");


        int[] i = new int[3];
        i[0] = 1;
        i[1] = 2;
        i[2] = 3;
        double[] d = new double[] { 10.0,11.2,13.5};
    }
}
