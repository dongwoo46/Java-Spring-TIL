package Exception;

public class Test6 {

	public static void main(String[] args) {
		// try ~catch ~ catch
		try {
			int num = Integer.parseInt("ssafy");
			
			// 해당하는 catch 블록을 만나지 못하면
			// 예외는 처리안됨
		} catch (ArithmeticException e) {
			System.out.println("해당 문자열은 정수로 못바꿈");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 넘어감");
		}
	}

}
