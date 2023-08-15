package chap_03;

public class _04_SwitchCase {
    public static void main(String[] args) {
        // switch case 이용
        int ranking = 1;
        switch (ranking) {
            case 1:
                System.out.println("전액장학금");
                break;
            case 2:
            case 3:
                System.out.println("반액장학금");
                break;
            default:
                System.out.println("장학금 안됨");
        }
        System.out.println("조회완료");

        // 중고 상품의 등급에 따른 가격을 책정 ( 1급: 최상, 4급: 최하)
        int grade = 1; // 등급
        int price = 7000; // 기본가격

        switch (grade) {
            case 1:
                price += 1000;
            case 2:
                price += 1000;
            case 3:
                price += 1000;
                break;
        }
        System.out.println(grade + "등급 제품의 가격 :" + price + "원");


        // if else 범위가 있는 경우
        // switch case 명확한 케이스가 있는 경우

    }
}
