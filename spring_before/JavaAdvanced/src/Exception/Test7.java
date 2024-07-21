package Exception;

public class Test7 {

	public static void main(String[] args) {
		// try ~ catch ~ finally
		
		try {
			String str = "ssafy";
			System.out.println("code 1 - before parse : "+str);
			int num = Integer.parseInt(str);
			System.out.println("code 2 - after parase : "+str);
			// return;
		} catch (Exception e) {
			System.out.println("code 3 - exception handling을 완료!");
		} finally {
			System.out.println("code 4 - 언제나 실행?");
		}
		// 언제나 실행되지 않는다.
		// try 블록안에 , 혹은 catch 블록 안에 , finally 블록안에 return이 있다면
		// 메인 메서드는 그 순간 종료되므로
		System.out.println(" code 5 - 언제나 실행");
		System.out.println("프로그램의 끝");
		
		// 왜 finally가 필요할까?
		// db 연결하는 상황
		// - 연결 종료시 관련된 리소스들을 정리할 필요
	}

}
