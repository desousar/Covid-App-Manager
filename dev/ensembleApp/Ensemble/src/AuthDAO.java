import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDAO {

	/**
	 * Database connection parameters
	 */
	final static String PORT1 = "8889";
	final static String PORT2 = "3306";
	final static String URL = "jdbc:mysql://localhost:" + PORT2 + "/ensemble";
	final static String LOGIN="root";
	final static String PASS="root";

	
	/**
	 * Class Constructor
	 * 
	 */
	public AuthDAO()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.err.println("Error while loading jdbc driver into the project");
		}

	}
	
	public boolean findUser(String user, String pw) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		boolean res = false;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM `auth` WHERE user = ? AND password = ?");
			ps.setString(1,user);
			ps.setString(2,pw);

			rs=ps.executeQuery();
		
			if(rs.next())
				res = true;

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return res;
	}
}
