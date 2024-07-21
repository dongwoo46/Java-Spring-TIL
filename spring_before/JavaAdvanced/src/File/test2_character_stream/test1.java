package File.test2_character_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test1 {
	public static void main(String[] args) throws IOException {
		// character stream -> reader, writer
		try (FileReader reader = new FileReader("big_input.txt");
				FileWriter writer = new FileWriter("big_input-copy.txt")){
			int c; // character 를 int에 담아도
			while((c=reader.read()) != -1) {
				writer.write(c);
			}
			System.out.println("복사완료");
			System.out.println("try with resource구문을 사용해서 알아서 정리됨");
		}
	}
}
