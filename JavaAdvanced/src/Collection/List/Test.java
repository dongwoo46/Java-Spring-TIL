package Collection.List;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // List
        // - 순서가 있는 자료구조
        // - 중복 허용
//        List<String> names = new ArrayList<>();
//        List<String> names = new LinkedList<>();
        List<String> names = new Vector<>();

        // 원소 추가
        names.add("안중근");
        names.add("이순신");
        names.add("김동우");
        names.add(0, "신"); // 0번 인덱스에 넣기

        System.out.println(names);

        //비었는지 체크
        System.out.println(names.isEmpty());

        // 원소의 개수
        System.out.println(names.size());

        // 수정
        names.set(2, "세종대왕");
        System.out.println(names);

        //조회
        for (String name: names) {
            System.out.println(name);
        }

        //반복자 사용
        Iterator<String> e = names.iterator();
        while (e.hasNext()) {
            System.out.println(e.next());
        }

        //반복자 사용을 좀더 간편히 한것이 foreach

        // 삭제
        names.remove(2);
        System.out.println(names);

        // 값삭제
        names.remove("이순신");
        System.out.println(names);

        // 전부삭제
        names.clear();

        names.add("홍승길");
        names.add("강낼자");
        names.add("수재랑");
        for (int i=0; i<names.size(); i++) {
            System.out.println(names.get(i));
        }

        // "홍승길" 삭제하고싶다
        for (int i=0; i<names.size(); i++) { // 크기가 동적으로 변하므로 names.size() 변함!
            if (names.get(i).equals("홍승길")) {
                names.remove(i);
            }
        }
        for (int i=names.size()-1; i>=0; i--){
            if(names.get(i).equals("홍승길")){
                names.remove(i);
            }
        }

        System.out.println(names);
    }
}
