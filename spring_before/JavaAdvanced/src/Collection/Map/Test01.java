package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test01 {
    public static void main(String[] args) {

        // Map
        // - 사전과 같은 자료구조
        // - 키 & 값의 쌍으로 저장
        // - 키로 구별
        // - 키는 중복되면 안되고 , 값은 중복될 수 있음

//        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new TreeMap<>();


        //맵에 값 저장
        map.put("hong", "13130232-2442");
        map.put("yang", "341023-2342");
        map.put("sdfds", "f2320-2424");

        // 중복된 키로 값을 넣으면 새로운 값으로 대체
        map.put("hong", "23423-242");

        System.out.println(map);

        // 값가지고 오려면
        System.out.println(map.get("hong"));

        // 없는 거로 값 가져오면?=> null
        System.out.println(map.get("kim"));

        // 키가 있느지 미리 확인
        System.out.println(map.containsKey("KIM"));

        // 값이 있는지확인
        System.out.println(map.containsValue("2323-4242"));

        // 반복문 돌리기
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

        Iterator<String> e = map.keySet().iterator();
        while(e.hasNext()) {
            String key = e.next();
            System.out.printf("키: %s, 값:%s \n",key ,map.get(key));

        }

        for (String key : map.keySet()) {
            System.out.printf("키 : %s, 값:%s \n", key, map.get(key));

        }
    }
}
