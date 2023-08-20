package Exception;

public class Test03 {

	public static void main(String[] args) {
		// try ~catch ~ catch
		try {
			int num = Integer.parseInt("ssafy");
			
			// 다중 예외 처리를 할때는 순서가 중요!
			// 자식 예외를 먼저 검사하고, 나중에 큰 예외를 검사
		} catch (NumberFormatException e) {
			System.out.println("해당 문자열은 정수로 못바꿈");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 넘어감");
		} catch (Exception e) { // 모든 예외르 ㄹ처리할 수 있는 블록
			// 다형성이 적용
			System.out.println("모든 예외 처리 실행");
		}
	}

}
