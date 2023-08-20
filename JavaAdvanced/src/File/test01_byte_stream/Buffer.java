package File.test01_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Buffer {

	public static void main(String[] args) throws IOException {
		// byte stream
		// => 이미지
		
		
		// 여기서는 예외 처리는 따로 하지 x
		// try with resource
		// try 다음에 (), ()안에 필요한 리소스를 정의
		// 문장은 ; 구분
		// close를 따로 할 필요없이 알아서 close해줌! 
		
		try (FileInputStream in = new FileInputStream("newjeans.jpg");
				FileOutputStream out = new FileOutputStream("newjeans-copy3.jpg")){
			
			// 버퍼를 사용하기
			byte[] buffer = new byte[10];
			int read; // byte를 int형으로 저장해도 됨
			
			while ((read=in.read(buffer)) != -1) {
				// 매번 in.read(buffer)할 때마다 buffer에 바이트를 채워줌
				// read : 어디까지가 읽으면 되는지
				out.write(buffer, 0, read);
				System.out.println(Arrays.toString(buffer)+","+read);
			}
			
			while ((read=in.read()) != -1) {
				out.write(read);
			}
			System.out.println("복사완료");
			System.out.println("알아서 스트림 닫아줌");
		} 
	}

}
