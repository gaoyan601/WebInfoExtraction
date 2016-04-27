package hust.kevin.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MySql extends DB {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MySql.class);
	private static Connection conn;

	/**
	 * @param ip
	 * @param port
	 * @param user
	 * @param passwd
	 * @param database
	 */
	public MySql(String ip, int port, String user, String passwd,
			String database) {
		super(ip, port, user, passwd, database);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ip
	 * @param user
	 * @param passwd
	 * @param database
	 */
	public MySql(String ip, String user, String passwd, String database) {
		this(ip, 3306, user, passwd, database);
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		String dirver = "com.mysql.jdbc.Driver";
		Class.forName(dirver);
		String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
		if (conn == null || conn.isClosed()) {
			conn = DriverManager
					.getConnection(
							url
									+ "?rewriteBatchedStatements = true&useServerPrepStmts=false",
							user, passwd);
		}
		return conn;

	}

	public void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			logger.info("数据库连接关闭失败");
		}
	}
}
