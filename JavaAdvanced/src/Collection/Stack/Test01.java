package Collection.Stack;

import java.util.Stack;

public class Test01 {
    public static void main(String[] args) {
        // Stack
        // - LIFO
        // - Stack 클래스사용
        Stack<Integer> stack = new Stack<>();

        // stack 에다가 0~9까지 순서대로 값넣기
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        // 스택에서 순서대로 값빼내기
        // - 가장 나중에 들어간 값이 가장 먼저 나옴
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+"");
        }
    }
}
