package Interface.Interface02;

public class Television implements HdmiOutput {


    @Override
    public void output() {
        System.out.println("tv화면에 출력");
    }

}
