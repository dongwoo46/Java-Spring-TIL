package chap_04;

public class _04_MultiArrayLoop {
    public static void main(String[] args) {
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4", "A5"},
                {"B1", "B2", "B3", "B4", "B5"},
                {"C1", "C2", "C3", "C4", "C5"}
        };

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.println(seats[i][j]);
            }
        }

        System.out.println("--------------------------");
        //세로크기 10 가로크기 15 영화관 좌석
        String[][] seats3 = new String[10][15];
        String[] eng = {"A", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        for (int i = 0; i < seats3.length; i++) {
            for (int j = 0; j < seats3[i].length; j++) {
                seats3[i][j] = eng[i] + (j + 1);
            }
        }
    }
}
