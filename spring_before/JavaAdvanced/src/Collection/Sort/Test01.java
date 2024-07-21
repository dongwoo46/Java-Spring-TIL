package Collection.Sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        String[] arr = {"samsung", "software", "academy", "for", "youth"};
        System.out.println(arr);
        List<String> list = Arrays.asList(arr); //리스트로 바꿔줌
        System.out.println(list);

        // cf. Arrays.sort
        // Collection을 정렬할 때는?
        // Collections.sort()
        Collections.sort(list);
        System.out.println(list);
    }
}
