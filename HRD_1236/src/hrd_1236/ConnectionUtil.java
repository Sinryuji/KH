package hrd_1236;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static ConnectionUtil instance;
	
	public static ConnectionUtil getInstance(){
		
		if(instance == null) {
			try{
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				instance = new ConnectionUtil();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return instance;
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "silgi", "1234");
	}
}
