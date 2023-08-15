package chap_03;

public class _06_While {
    public static void main(String[] args) {
        // 반복문 While
        // 수영장에서 수영을 하는 모습
        int distance = 25; // 전체거리 25m
        int move = 0; //현재 이동거리 0m

        while (move < distance) { // 현재 이동거리가 전체거리보다 작다는 조건이 참인동안 반복
            System.out.println("발차기를 한다");
            System.out.println("현재 이동거리:" + move);
            move += 3;
        }
        System.out.println("도착했다.");

        // 무한 루프
        while (move < distance) { // 현재 이동거리가 전체거리보다 작다는 조건이 참인동안 반복
            System.out.println("발차기를 한다");
            System.out.println("현재 이동거리:" + move);
        }
        System.out.println("도착");
    }
}
