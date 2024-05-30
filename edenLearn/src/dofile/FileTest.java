package dofile;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		File file=new File("C:\\edenlearn");
		file.mkdir();
		File file1=new File("C:\\edenlearn\\1.text");
		//file.mkdir();
		//file.delete();
		file1.createNewFile();
		
	}

}
