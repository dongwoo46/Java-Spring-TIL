package chap_01;

public class _03_Varables {
    public static void main(String[] args) {
        String name = "나노코딩"; // 큰따옴표 써야함
        int hour = 15;

        System.out.println(name + "님아 배송시작된다" + hour + "시에 방문 예정이다");
        System.out.println(name + "님 배송완료됐어요");

        double score = 90.5; //실수값저장
        char grade = 'A'; //딱 한문자  char 작은따옴표 써도됨
        name = "강백호";
        System.out.println(name + "님의 평균 점수는 " + score + "점입니다.");
        System.out.println("학점은" + grade + "입니다.");

        boolean pass = true;
        System.out.println("이번 시험에 합격햇을까요?" + pass);

        double b = 3.14;
        float f = 3.14F; //float에 넣으려면 실수값뒤에 F넣어줘야함
        System.out.println(b);
        System.out.println(f);

//        int i = 10000000000; //int에는 값이 길어서 넣을 수 없음
        long l = 1000000000000000000L;//int대신 긴 값을 넣으려면 long써야함 21 억이상
        System.out.println(l);
    }
}
