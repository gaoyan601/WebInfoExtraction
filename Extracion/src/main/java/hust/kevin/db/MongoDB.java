package hust.kevin.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDB extends DB {
	private String host;
	private int port;
	private String dataBase;
	private MongoClient mc;
	public static MongoDatabase mdb;

	/**
	 * 
	 */
	public MongoDB() {
		super();
	}

	/**
	 * @param host
	 * @param dataBase
	 */
	public MongoDB(String host, String dataBase) {
		this(host, 27017, dataBase);
	}

	/**
	 * @param host
	 * @param port
	 * @param dataBase
	 */
	public MongoDB(String host, int port, String dataBase) {
		this.host = host;
		this.port = port;
		this.dataBase = dataBase;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	private MongoClient getMongoClient() {
		if (mc == null) {
			mc = new MongoClient(host, port);
		}
		return mc;
	}

	public MongoDatabase getMongoDatabase() {
		mc = getMongoClient();
		if (mdb == null) {
			mdb = mc.getDatabase(dataBase);
		}
		return mdb;
	}
	
	public void close(){
		if(mc!=null){
			mc.close();
		}
	}
}
