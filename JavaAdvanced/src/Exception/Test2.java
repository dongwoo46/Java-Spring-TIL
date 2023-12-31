package Exception;

public class Test2 {

	public static void main(String[] args) {
		// try ~ catch 문 사용하기
		int[] nums = {10};
		try {
			System.out.println(nums[1]);
			// 발생한 예외 : ArrayIndexOutOfBoundsException
		} //catch(ArrayIndexOutOfBoundsException e) {
			// catch가 잡을 수 있는 예외 객체
			// ArrayIndexOutOfBoundsException이거나, 이클래스의 자식개체만
		catch(Exception e) { // 어떤 예외든 처리 가능

			// catch가 잡을수 있는 예외 객체
			// catch()안에 오는 예외클래스는
			// 그 예외 클래스이거나, 그 클래스의 자식 클래스인 경우
			System.out.println("배열의 크기가 넘어갔을 때 대처코드");\
			System.out.println("에러메시지: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상종료");
	}

}
