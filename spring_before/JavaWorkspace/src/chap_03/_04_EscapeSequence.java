package chap_03;

public class _04_EscapeSequence {
    public static void main(String[] args) {
        // 특수문자, 이스케이프 문자
        // \n, \t \\ \" \'

        System.out.println("자바가");
        System.out.println("너무");
        System.out.println("재밋어요");

        // \n : 줄바꿈
        System.out.println("자바가\n너무\n재밋어요");

        // \t : 탭
        // 해물파전
        // 김치전
        // 부추전
        System.out.println("해물파전\t\t9000원");

        // \\ : 역슬래시
        System.out.println("C:\\program file\\java");

        // \" : 큰따옴표
        // \' : 작은따옴표
        // 단비가 "냐옹"이라고 햇어요
        System.out.println("단비가 \"냐옹\"이라고 했다.");

    }
}
