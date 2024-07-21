package File.test01_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_byte_with_finally {

	public static void main(String[] args) throws IOException {
		// byte stream
		// => 이미지
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		// 여기서는 예외 처리는 따로 하지 x
		// try ~ finally 왜 쓰는가?
		try {
			in = new FileInputStream("newjeans.jpg");
			out = new FileOutputStream("newjeans-copy.jpg");
			
			int b; // byte를 int형으로 저장해도 됨
			
			while ((b=in.read()) != -1) {
				out.write(b);
			}
			System.out.println("복사완료");
			
		} finally {
			// 입출력 스트림 닫아줌
			if (in!= null)
				in.close();
			if (out!=null)
				out.close();
				
			System.out.println("모든 리소스를 닫고 종료");
		}
	}

}
