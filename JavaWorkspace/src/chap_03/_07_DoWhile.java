package chap_03;

public class _07_DoWhile {
    public static void main(String[] args) {
        // 반복문 DoWhile
        int distance =25; // 전체거리 25m
        int move = 0; //현재 이동거리 0m
        int height = 2; // 키 2m
        while (move +height < distance) {
            System.out.println("발차기를 계속한다");
            System.out.println("현재 이동거리: " + move);
            move+=3;
        }
        System.out.println("도착");

        // 키가 엄청큼
        move = 0;
        height =25;
        while (move +height < distance) {
            System.out.println("발차기를 계속한다");
            System.out.println("현재 이동거리: " + move);
            move+=3;
        }
        System.out.println("도착");

        System.out.println("----반복문2----");

        // Do While 반복문 do가 먼저 실행됨
        do {
            System.out.println("발차기한다");
            System.out.println("현재이동거리:" + move);
            move+=3;
        } while (move+height<distance );
        System.out.println(("도착했다."));

    }
}
