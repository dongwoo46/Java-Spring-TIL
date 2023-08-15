package chap_05;

public class _08_MainMethod {
    public static void main(String[] args) {
        for (String s:args
                ) {
            System.out.println(s);
        }

        // 1.도서조회
        // 2. 도서대출
        // 3. 도서반납
        if (args.length == 1) {
            switch (args[0]){
                case "1":
                    System.out.println("도서조회 메뉴");
                    break;
                case "2":
                    System.out.println("도서 조회메뉴");
                    break;
                case "3":
                    System.out.println("도서 반납");
                    break;
                default:
                    System.out.println("끝");

            }
        }else {
            System.out.println("잘못 선택했다.");
        }
    }
}
