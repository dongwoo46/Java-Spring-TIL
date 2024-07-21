package chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
        System.out.println(s);

        //문자열의 길이
        System.out.println(s.length());


        // 대소문자 변환
        System.out.println(s.toUpperCase());
        // 소문자변환
        System.out.println(s.toLowerCase());

        // 포함관계
        System.out.println(s.contains("Java")); // 포함되면 true / 포함 안되면 false
        System.out.println(s.contains("c#"));

        // 몇번째 위치에 잇는지
        System.out.println(s.indexOf("Java")); // 위치되면 시작위치 알려주고 없으면 -1
        System.out.println(s.indexOf("and")); // 처음 일치하는 위치정보
        System.out.println(s.lastIndexOf("and")); // 마지막 일치하는 위치정보
        System.out.println(s.startsWith("I like")); // 이문자열로 시작하면 true
        System.out.println(s.endsWith(".")); // 이 문자열로 끝나면 true


    }
}
