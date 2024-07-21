package hello.core.singleton;

public class SingleTonService {

    // static 영역에 하나 만들어져서 올라감
    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

    private SingleTonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
