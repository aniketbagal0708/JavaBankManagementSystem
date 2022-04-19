import java.sql.*;

public class DBConnection
{
	
	public static String url = "jdbc:postgresql://localhost:5432/revaturebank";
	public static String user="postgres";
	public static String password="aniket";
	
	

	public static Connection createDBConnection()
	{
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
