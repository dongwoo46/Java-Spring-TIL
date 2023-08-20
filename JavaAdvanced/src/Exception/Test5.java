package Exception;

public class Test5 {

	public static void main(String[] args) {
		// try ~catch ~ catch
		// - 나열된 예외 클래스들이 상속관계에 있는 경우
		// - 순서 중요!
		// - catch문은 해당 클래스 또는 자식 클래스만 처리가능
		try {
			int num = Integer.parseInt("ssafy");
			
			// 해당하는 catch 블록을 만나지 못하면
			// 예외는 처리안됨
//		} catch (ArithmeticException e) {
//			System.out.println("나눌 수 없다.");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("인덱스 범위 넘어감");
//		} catch (NumberFormatException e) {
//			System.out.println("해당문자열은 숫자로 못바꿈");
//		}
			// | 연산자를 이용해서, 하나의 catch 블록에서
			// 다양한 종류의 예외를 동시에 처리 가능
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
		System.out.println("하나의 블록에서 세가지 예외를 처리");
	}
}
}
