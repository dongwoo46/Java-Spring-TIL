package chap_01;

public class _05_VariableNaming {
    public static void main(String[] args) {
        // 변수 이름 짓는법
        // 1. 저장할 값에 어울리는 이름
        // 2. 밑줄(_) 문자(abc, 숫자(123) 사용가능(공백사용불가)
        // 3. 밑줄 또는 문자로 시작 가능 (숫자로 시작x)
        // 4. 한단어 또는 2개 이상 단어의 연속
        // 5. 소문자로 시작, 각 단어의 시작 글자는 대문자(첫 단어 제외)
        // 6. 예약어 사용 불가(public, static , void , int , double, float...)

        // 입국 신고서 (여행)
        String nationality = "대한민국";//국적
        String firstName = "현성";
        String lastName = "김";
        String dateOfBirth = "2001-12-31";//생년월일
        String residentialAddress = "무슨 호텔"; // 체류지
        String purposeOFVisit = "관광"; // 입국목적
        String flightNo = "ke657"; // 항공 편명
        String flight_no_2 = "ke657"; // 민줄 시작
        String _flightNo = "ke657"; // 밑줄과 숫자포함
        // String -flightNo = "ke524";

        int accompany = 2; // 동반 가족수
        int lenghtOfStay = 5; // 체류기간
        // String 3item = "전자제품"

        int i = 0;
        String s = "";
        String str = "";

        //절대 변하지 않는 상수는 대문자로
        final String CODE = "KR";



    }
}
