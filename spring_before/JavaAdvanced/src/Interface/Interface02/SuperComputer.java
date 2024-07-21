package Interface.Interface02;

public class SuperComputer implements HdmiInput {
    private HdmiOutput device;
    @Override
    public void setOutput(HdmiOutput device) {
        this.device = device;
    }

    @Override
    public void show() {
        System.out.print("슈퍼컴의 화면을");
        device.output();

    }
}
