package Interface.Interface02;

public class Monitor implements HdmiOutput {

    @Override
    public void output() {
        System.out.println("모니터 화면에 출력합니다");
    }


}
