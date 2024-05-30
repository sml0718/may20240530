package eden;

import java.util.Scanner;

public class RegexTest {
	public static void main(String[] args) {
		//String qq="123456788444";
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		System.out.println("qq番号を入力してください：");
		String QQ=scanner.next();
		
		
		
			
		
		/*char ch='a';
		int in=ch;*/
		
		
		//System.out.println(checkqq(qq));
		
		String regex="[1-9]\\d{5,19}";
		
		boolean match = QQ.matches(regex);
		
		if (match==true){
		System.out.println("qq番号は正しいです");
		}else {
			System.out.println("qq番号は間違いです");
		}
		
		
		
	}

	public static boolean checkqq(String qq) {
		
		int len=qq.length();
		
		if(len<6||len>20) {
			return false;
		}
		
		if(qq.startsWith("0")) {
			
			return false;
						
		}for(int i=0;i<qq.length();i++) {
			char c=qq.charAt(i);
			
			if(c<'0'||c>'9') {
				return false;
			}
		}
		/*if() {
			qq.charAt(0)
		}*/
			
		 return true;
	}
}
