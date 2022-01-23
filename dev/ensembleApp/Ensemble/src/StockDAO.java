import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockDAO {

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
	public StockDAO()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.err.println("Error while loading jdbc driver into the project");
		}

	}
	
	public int getStockOf(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		int res = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT stock FROM `materiel` WHERE name = ?");
			ps.setString(1,name);

			rs=ps.executeQuery();
		
			if(rs.next())
				res = rs.getInt("stock");

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return res;
	}
	
	//UPDATE `materiel` SET stock = stock + 10 WHERE name = "vaccine"
	public void setStockOf(String name, int amount) {
		Connection con = null;
		PreparedStatement ps = null;
		int rs= 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE `materiel` SET stock = stock + ? WHERE name = ?");
			ps.setInt(1,amount);
			ps.setString(2,name);

			rs=ps.executeUpdate();
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
	}
	
	public static void TestGetStockOfVaccine() {
		StockDAO StockDAO=new StockDAO();	
		int stock = StockDAO.getStockOf("vaccine");
		System.out.println("stock : " + stock);
	}
	public static void TestSetStockOfVaccine() {
		StockDAO StockDAO=new StockDAO();	
		StockDAO.setStockOf("vaccine",-5);
		System.out.println("stock : " + StockDAO.getStockOf("vaccine"));
	}
	
	
	public static void main(String[] args)  throws SQLException {
		//TestGetStockOfVaccine();
		//TestSetStockOfVaccine();
	}
}
