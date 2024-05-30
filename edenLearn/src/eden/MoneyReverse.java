package eden;

import java.util.Scanner;

public class MoneyReverse {
	//1.0~9999999の範囲内判断する。
//壹,贰,叁,肆，伍，陆，柒，捌，玖
	public static void main(String[] args) {
	//1.
	int money=checkMoney();
	//2.大
	int money1=235;
	String moneyStr="";
	while(true) {
		int remain=money1%10;
		String capital=getCapital(remain);
		moneyStr=capital+moneyStr;
		 
		money1=money1/10;
		if(money1==0) {
			break;
		}
	}
	
		System.out.println(moneyStr);
		//3.单位插入零
		int count=7-moneyStr.length();
		for(int i=0;i<count;i++) {
			moneyStr="零"+moneyStr;
		}
		System.out.println(moneyStr);
		String[] unit= {"佰","拾","万","仟","佰","拾","元"};
		String result="";
		for(int i=0;i<moneyStr.length();i++) {
			char cha=moneyStr.charAt(i);
			result=result+cha;
			result=result+unit[i];
		}
		
	//4.変更された金額を出力する
		System.out.println(result);
		
		
	}
	static int checkMoney() {


		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in) ;
		
		
		System.out.println("金額を入力してください");
		
		while(!scanner.hasNextInt()) {
			System.out.println("金額は数字だけです、もう一度入力してください。");
		scanner.next();
		}
		while(true) {
		int num=scanner.nextInt();
		
		if(num>=0 && num<9999999) {
			//System.out.println("入力した金額が正しい");
			return (int)num;
		
		}else {
			System.out.println("金額は0から9999999までの数字です、もう一度入力してください。");
			scanner.nextInt();
		}
				
		}
			
	}
	
	
	static String getCapital(int n) {
		String[]arrString= {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		return arrString[n];
	}
}
		

	


