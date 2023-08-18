package Generic.WildCard;

// 클래스를 제네릭으로 만들려면?
// 다양한 타입을 처리할 수 있또록
// 타입 파라미터 필요
public class GenericBox<T> {
    // T는 타입처럼 사용가능
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
