package Collection.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // Set
        // - 집합을 나타내는 자료구조
        // - 중복 허용 x
        // - 순서도 없음

//        Set<String> set = new HashSet<>();
        Set<String> set = new TreeSet<>();

        set.add("홍승길");
        set.add("홍승길");
        set.add("정민우");
        set.add("이승재");

        System.out.println(set);

        System.out.println("홍승길".hashCode());
        System.out.println("홍".hashCode());
        System.out.println(new String("홍승길").hashCode());
        System.out.println("홍승길".equals("홍승길"));

        // 반복자
        Iterator<String> e = set.iterator();
        while (e.hasNext()) {
            System.out.println(e.next());
        }

        // HashSet
        // - 해시 테이블에 원소 저장
        // - 성능면에서 우수
        // - 원소 순서가 일정 X

        // TreeSet
        // - red-black tree에 원소저장
        // - 값에 따라서 순서 결정
        // - 값을 순서대로 정렬할 필요가 있다면 고려해볼만한 선택지
    }
}
