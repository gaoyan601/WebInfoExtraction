package hust.kevin.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql extends DB {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MySql.class);

	private String User;
	private String Passwd;
	private int Port;
	private String IP;
	private String DataBase;
	private static Connection conn;

	/**
	 * 
	 */
	public MySql() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param user
	 * @param passwd
	 * @param dataBase
	 */
	public MySql(String user, String passwd, String dataBase) {
		this(user, passwd, 3306, "localhost", dataBase);
	}

	/**
	 * @param user
	 * @param passwd
	 * @param iP
	 * @param dataBase
	 */
	public MySql(String user, String passwd, String iP, String dataBase) {
		this(user, passwd, 3306, iP, dataBase);
	}

	/**
	 * @param user
	 * @param passwd
	 * @param port
	 * @param iP
	 * @param dataBase
	 */
	public MySql(String user, String passwd, int port, String iP,
			String dataBase) {
		super();
		User = user;
		Passwd = passwd;
		Port = port;
		IP = iP;
		DataBase = dataBase;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPasswd() {
		return Passwd;
	}

	public void setPasswd(String passwd) {
		Passwd = passwd;
	}

	public int getPort() {
		return Port;
	}

	public void setPort(int port) {
		Port = port;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getDataBase() {
		return DataBase;
	}

	public void setDataBase(String dataBase) {
		DataBase = dataBase;
	}

	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		String dirver = "com.mysql.jdbc.Driver";
		Class.forName(dirver);
		String url = "jdbc:mysql://" + IP + ":" + Port + "/" + DataBase;
		if (conn == null||conn.isClosed()) {
			conn = DriverManager
					.getConnection(
							url
									+ "?rewriteBatchedStatements = true&useServerPrepStmts=false",
							User, Passwd);
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
