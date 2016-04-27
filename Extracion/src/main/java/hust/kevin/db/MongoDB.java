package hust.kevin.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDB extends DB {
	private MongoClient mc;
	public static MongoDatabase mdb;

	/**
	 * @param ip
	 * @param port
	 * @param user
	 * @param passwd
	 * @param database
	 */
	public MongoDB(String ip, int port, String database) {
		super(ip, port, "", "", database);
		// TODO Auto-generated constructor stub
	}

	private MongoClient getMongoClient() {
		if (mc == null) {
			mc = new MongoClient(ip, port);
		}
		return mc;
	}

	public MongoDatabase getMongoDatabase() {
		mc = getMongoClient();
		if (mdb == null) {
			mdb = mc.getDatabase(database);
		}
		return mdb;
	}

	public void close() {
		if (mc != null) {
			mc.close();
		}
	}
}
