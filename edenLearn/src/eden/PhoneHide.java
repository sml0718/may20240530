package eden;

public class PhoneHide {

	public static void main(String[] args) {
		
		String phN1 = "1234446  1234";
		
		String phN2 ="222";	
				
		String starMark="*";
		
		String numcheck = phoneNumcheck(phN1,starMark);
		
		System.out.println(numcheck);
	}
		
		
	


	static String phoneNumcheck(String p,String m) {
		// TODO 自動生成されたメソッド・スタブ
	
		p=p.trim();

		if(p.isEmpty()||p.isBlank()){
			return"電話番号は空してはいけません";
			
				}
		if(p.length()!=11) {
			return"番号の行数は間違いです、も一度入力してください";
			
				}
		if(!p.matches("\\d+")) {
			return"電話番号は数字のみ構成されます。";}
			
			String phnum = p.substring(0,3);
			
			String phend = p.substring(7);
			
			String ri = phnum + m+m+m+m+ phend;
			return ri;
			
		}
	}
		


		
		
	
