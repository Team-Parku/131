import java.sql.*;
import javax.swing.JOptionPane;

public class sqlConnection {
	Connection conn = null;
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:Parku.sqlite");
		   //JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
