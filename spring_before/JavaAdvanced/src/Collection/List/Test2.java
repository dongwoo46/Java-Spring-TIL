package Collection.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test2 {
    public static void main(String[] args) {
        List<Object> al = new ArrayList<>();
        List<Object> ll = new LinkedList<>();
        List<Object> v = new Vector<>();

        test1("순차적추가-ArrayList-", al);
        test1("순차적추가-LinkedList-", ll);
        test1("순차적추가-Vector-", v);

        test2("중간에추가-ArrayList-", al);
        test2("중간에추가-LinkedList-", ll);
        test2("중간에추가-Vector-", v);

        test3("데이터조회-ArrayList-", al);
        test3("데이터조회-LinkedList-", ll);
        test3("데이터조회-Vector-", v);





    }

    public static void test1(String testname, List<Object> list) {
        long start = System.nanoTime();//시작시간
        for (int i=0; i<50000; i++){
            list.add(new String("Hello")); // 뒤에다 추가
        }
        long end = System.nanoTime(); //끝시간
        System.out.printf("%s \t 소요시간:%15d ns. \n", testname, end - start);

    }
    public static void test2(String testname, List<Object> list) {
        long start = System.nanoTime();//시작시간
        for (int i=0; i<50000; i++){
            list.add(0, new String("Hello")); // 맹 앞에다가 추가(중간에 추가)
        }
        long end = System.nanoTime(); //끝시간
        System.out.printf("%s \t 소요시간:%15d ns. \n", testname, end - start);
    }
    public static void test3(String testname, List<Object> list) {
        long start = System.nanoTime();//시작시간
        // 리스트 모든 원소 조회
        for (int i=0; i<list.size(); i++){
            list.get(i);
        }
        long end = System.nanoTime(); //끝시간
        System.out.printf("%s \t 소요시간:%15d ns. \n", testname, end - start);
    }
}
