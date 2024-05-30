package dofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTest {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		
		String filePath="C:"+File.separator+"edenlearn\\aa\\1.txt";
		File fwrite=new File(filePath);
		
		FileInputStream fis=new FileInputStream(fwrite);
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		while(br.ready()) {
			System.out.println(br.readLine());
		}
		br.close();

	}

}
