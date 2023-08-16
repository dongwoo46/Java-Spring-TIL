package AccessModifier.Import01;

//import java.util.Arrays;
//import java.util.Date;
//import java.util.Scanner;
import java.util.*;
import java.util.logging.Logger;
// 하위 패키지에 있는 클래스까지 임포트 되는 건 아님
// 하위 패키지도 다른 패키지다.

public class ImportTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date d = new Date();
        int[] arr = {1,2,3,4,5};
        Arrays.toString(arr);

        Logger l = Logger.getGlobal();
    }
}
