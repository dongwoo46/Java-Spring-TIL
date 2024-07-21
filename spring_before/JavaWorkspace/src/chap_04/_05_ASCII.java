package chap_04;

public class _05_ASCII {
    public static void main(String[] args) {
        //아스키코드
        char c = 'a'; // 알파벳 대문자(A)는 65부터 시작, 소문자(a)는 97부터, 숫자(0)은 48부터
        System.out.println(c);
        System.out.println((int) c);

        c = '1';
        System.out.println(c);
        System.out.println((int) c);

        c++;
        System.out.println(c);
        System.out.println((int)c);
    }
}
