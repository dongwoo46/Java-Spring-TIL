package Interface.Interface02;

public class Computer implements HdmiInput{
    
    // 컴퓨터는 hdmi 출력 장치에 의존
    private HdmiOutput outputDevice;
    @Override
    public void setOutput(HdmiOutput device) {
        outputDevice = device;
    }

    @Override
    public void show() {
        System.out.println("컴퓨터화면을");
        outputDevice.output();
    }
}
