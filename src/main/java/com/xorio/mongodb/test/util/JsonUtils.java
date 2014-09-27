package com.xorio.mongodb.test.util;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Map;

/**
 * User: radu
 * Date: 9/27/14
 * Time: 1:20 PM
 */
public class JsonUtils {

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	public static BasicDBObject $(String key, Object value) {
		return new BasicDBObject(key, value);
	}

	/**
	 * @param key
	 * @param values
	 * @return
	 */
	public static BasicDBObject $arr(String key, Object... values) {
		BasicDBList list = new BasicDBList();
		list.addAll(Arrays.asList(values));

		return new BasicDBObject(key, list);
	}

	/**
	 * @param fields
	 * @return
	 */
	public static BasicDBObject $(BasicDBObject... fields) {
		BasicDBObject o = new BasicDBObject();

		for (BasicDBObject field : fields) {
			for (Map.Entry<String, Object> fieldEntry : field.entrySet()) {
				o.append(fieldEntry.getKey(), fieldEntry.getValue());
			}
		}

		return o;
	}
}
