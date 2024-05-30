package eden;

public class CharStringtest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		/*char ch1='a';
		char ch2='b';
		char ch3='c';
		char ch4='d';
		char ch5='e';
		
		String chaString=""+ch1+ch2+ch3+ch4+ch5;
		
		System.out.println(chaString);
		*/
		
		/*String chaString="abcdef";
		
		//int 代表整数
		
		for(int i=0;i<chaString.length();i++) {
			char cha=chaString.charAt(i);//char 代表单个字符
		
			System.out.println(cha);
		}
		char[] charArray = chaString.toCharArray();//chaArray
		
		System.out.print(charArray);*/
		//じゃバスクリブト
		char cha1='じ';
		char cha2='ゃ';
		char cha3='バ';
		char cha4='す';
		char cha5='く';
		char cha6='リ';
		char cha7='ブ';
		char cha8='ト';
		//
		String ch=""+cha1+cha2+cha3+cha4+cha5+cha6+cha7+cha8;
		
		//System.out.println(ch);
		
		//String chaString="じゃバスクリブト";
				
		/*for(int i=0;i<chaString.length();i++) {
			char cha=chaString.charAt(i);
		}*/
		char[] charArray = ch.toCharArray();
		String s="";
		for(char c:charArray) {
			System.out.println(c);
			
			
			 s+=c+"$";
			 
		}
		System.out.println(s);
		
		String a="";
				String b ="";
		
		String m =PhoneHide.phoneNumcheck(a,b);
		System.out.println(m);
	}

}
