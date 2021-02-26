package gradle_study.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection conn = null;
		String propertiesPath = "db.properties";
		try (InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath)) {
			Properties props = new Properties();
			props.load(is);
//			System.out.println(props);
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String password = props.getProperty("password");

//			System.out.println(url);

			conn = DriverManager.getConnection(url, user, password);
			Connection conn1 = DriverManager.getConnection(url, props);

//			System.out.println(conn1);
//			System.out.println(conn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
