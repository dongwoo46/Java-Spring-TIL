package Interface.Multiple_Interface03;

public class Test {
    public static void main(String[] args) {
        Duck d = new Duck();
        Eagle e = new Eagle();

        // d. => fly, swim, hunt 셋 다 보임

        //다형성
        AbleToFly f = d;
        // f. =>fly만보임
    }
}
