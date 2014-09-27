package com.xorio.mongodb.test;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Set;

import static com.xorio.mongodb.test.util.JsonUtils.$;

/**
 * User: radu
 * Date: 9/27/14
 * Time: 12:11 PM
 */
public class MongoDbTest {

	public static void main(String[] args) {
		MongoDbTest mongoDbTest = new MongoDbTest();
		try {
			mongoDbTest.boot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void boot() throws UnknownHostException {
		// To directly connect to a single MongoDB server (note that this will not auto-discover the primary even
		// if it's a member of a replica set:
		MongoClient mongoClient = new MongoClient();

		try {
			DB db = mongoClient.getDB("mydb");

			Set<String> colls = db.getCollectionNames();

			for (String s : colls) {
				System.out.println(s);
			}

			DBCollection coll = db.getCollection("testData");

//			BasicDBObject doc = new BasicDBObject("name", "MongoDB")
//					.append("x", 1);
//			coll.insert(doc);

			DBObject myDoc = coll.findOne();
			System.out.println(myDoc);

			System.out.println(coll.getCount());

			DBCursor cursor = coll.find();
			printConsume(cursor);

			BasicDBObject query = $("x", $("$ne", 3));
			cursor = coll.find(query);
			printConsume(cursor);

		} finally {
			mongoClient.close();
		}
	}

	private void printConsume(DBCursor cursor) {
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}
	}
}
