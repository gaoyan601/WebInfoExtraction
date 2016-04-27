package hust.kevin.db;

public class DB {
	protected String ip;
	protected int port;
	protected String user;
	protected String passwd;
	protected String database;

	/**
	 * @param ip
	 * @param port
	 * @param user
	 * @param passwd
	 * @param database
	 */
	public DB(String ip, int port, String user, String passwd, String database) {
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
		this.database = database;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}
