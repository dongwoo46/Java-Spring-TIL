package Exception;

public class Test1 {

	public static void main(String[] args) {
		int[] nums = {10}; //0밖에 업슴
		//System.out.println(nums[1]);
		//System.out.println(nums[-1]); //오버 플로우가 발생시 음수가..=> long을 쓰자
		
		// java.lang.ArithmeticException ->0으로 못나눔
		// int num = 5/0;
		
		// java.lang.NumberFomatiException
		// int num = Integer.parseInt("ssafy");
		
		// 예외는 언제 발생? throw 키워드를 사용해ㅓㅅ,
		// new 예외생성자() => 예외객체
		// 예외 객체를 던질때 발생
		// 예외가 발생? 내부적으로는 예외 객체가 생성되서 던져진 것임
		// throw new ArrayIndexOutOfBoundsException(); // nums[20]
		// throw new ArithmeticException();
		// throw new NumberFomatiException();
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("예외 처리");
		}
		System.out.println("프로그램 끝");
		
	}

}
