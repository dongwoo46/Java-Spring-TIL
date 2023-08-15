package chap_05;

public class _03_Return {
    // 호텔 전화번호
    public static String getPhoneNumber() {
        String phoneNumber = "02-1234-1235";
        return phoneNumber;
    }
    // 호텔 주소
    public  static String getAddress() {
        return "서울시";
    }

    // 호텔 엑티비티
    public static String getActivities() {
        return "볼링장,당구장";
    }

    public static void main(String[] args) {
        // 반환값, Return
        String contactNumber = getPhoneNumber();
        System.out.println(contactNumber);
        System.out.println(getAddress());
        System.out.println(getActivities());
    }
}
