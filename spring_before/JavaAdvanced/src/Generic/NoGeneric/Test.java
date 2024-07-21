package Generic.NoGeneric;

public class Test {
    public static void main(String[] args) {
        NormalBox b = new NormalBox();

        b.setData("hello");
//        String s = b.getData(); // 안됨 object-> string이기때문
        // instanceof를 써서 형변환하는 작업이 필요
        String s = (String) b.getData();
    }
}
