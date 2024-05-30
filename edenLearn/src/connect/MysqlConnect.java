package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnect {

	public static void main(String[] args) throws SQLException{
		// TODO 自動生成されたメソッド・スタブ
		
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eden?useSSL=false&serverTimezone=UTC","root", "1234");
		Statement statement = connection.createStatement();
		
		//String s="update employees set department='営業部' where employee_id=19";
		
		//String s1="update employees set department='AI2技術部' where department='AI技術部'";
		//String s2="update employees set address=substring(address,1,2) where true";
			String s3="select\n"
					+ "    employee_name,department,\n"
					+ "(case when age<=30 then'青年' when age>=31 and age<=35 then'中青年' else '老年' end) as '年齢'\n"
					+ "from employees;";
		//System.out.println(i);
		
		//String s="select * from employees";
		
		
		ResultSet resultSet = statement.executeQuery(s3);
		
//		employee_id INT PRIMARY KEY,
//		employee_name VARCHAR(20),
//		gender VARCHAR(10),
//		age INT,
//		department VARCHAR(20),
//		salary INT,
//		address VARCHAR(50),
//		id_card_number VARCHAR(20)
//		);
		
while(resultSet.next()) {
	//int id=resultSet.getInt("employee_id");
	String name=resultSet.getString("employee_name");
	//String gender=resultSet.getString("employee_name");
	//int age=resultSet.getInt("age");
	String department=resultSet.getString("department");
	String ageGroup=resultSet.getString("年齢");
	//int salary=resultSet.getInt("salary");
	//String address=resultSet.getString("address");
	//String idCardNumber=resultSet.getString("id_Card_Number");

	//System.out.println(id+""+name+""+gender+""+age+""+department+""+address+""+salary+""+idCardNumber+"");
//}*/
	System.out.println(name+""+department+""+ageGroup)	;
		
	}
connection.close();
}
}