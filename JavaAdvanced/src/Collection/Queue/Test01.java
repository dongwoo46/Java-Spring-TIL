package Collection.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test01 {
    public static void main(String[] args) {
        // 큐(queue)
        // - FIFO
        // - Queue 인터페이스
        // - 구현체(클래스)는 LInkedList사용
        Queue<Integer> queue = new LinkedList<>();

        // queue에다가 0부터 9까지 순차적 값넣기
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        //큐에서 순차적으로 값꺼내기
        // - 가장 먼저 들어간 값이 먼저나옴
        while(!queue.isEmpty()) {
            System.out.println(queue.poll()+"");
        }
    }
}
