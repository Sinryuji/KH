package hrd_1234;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static ConnectionUtil instance;
	
	private ConnectionUtil(){
		
	}
	
	public static ConnectionUtil getInstance(){
		if(instance == null) {
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				instance = new ConnectionUtil();
			}catch(Exception e) {
				
			}
		}
		return instance;
	}
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "silgi", "1234");
	}
}
