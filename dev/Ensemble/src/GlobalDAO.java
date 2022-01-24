
abstract public class GlobalDAO {
	/**
	 * Database connection parameters
	 */
	final static String PORT1 = "8889";
	final static String PORT2 = "3306";
	static String URL = "jdbc:mysql://localhost:" + PORT2 + "/ensemble";
	final static String LOGIN="root";
	final static String PASS="root";
	
	static void setPORT(String PORT) {
		URL = "jdbc:mysql://localhost:" + PORT + "/ensemble";
	}
}
