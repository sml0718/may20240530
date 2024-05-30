package eden;

import java.util.Scanner;

public class DirtyTalk {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("入力してください：");
		String word=sc1.next();
		String[]DirtyTalk= {"tmd","nmd","qsb","sc"};
		word=word.toLowerCase();
		
		for(int i=0;i<DirtyTalk.length;i++) {
			word=word.replace(DirtyTalk[i], "***");
			
		}
		System.out.println(word);
		
	

	}

}
