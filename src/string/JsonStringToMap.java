package string;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by benjaminliu on 8/2/17.
 */
public class JsonStringToMap {

	public static Map<String, Object> convertJsonStringToMap(final String json) {
		if (!json.contains("{")) {
			return ImmutableMap.of(json, 1);
		}
		Map<String, Object> results = new HashMap();
		final String jsonStripped = json.substring(1, json.length() - 1);
		boolean addingKey = true;
		StringBuilder keyBuilder = new StringBuilder();
		StringBuilder exprBuilder = new StringBuilder();
		String key = null;
		boolean addingNested = false;
		int openBraceCount = 0;
		for (int i = 0; i < jsonStripped.length(); i++) {
			if (addingKey) {
				if (jsonStripped.charAt(i) == ':') {
					addingKey = false;
					key = keyBuilder.toString();
					keyBuilder = new StringBuilder();
				} else {
					keyBuilder.append(jsonStripped.charAt(i));
				}
			} else {
				if (jsonStripped.charAt(i) == '{') {
					openBraceCount += 1;
					addingNested = true;
				} else if (jsonStripped.charAt(i) == '}') {
					openBraceCount -= 1;
				}
				if (addingNested || jsonStripped.charAt(i) != ',') {
					exprBuilder.append(jsonStripped.charAt(i));
				}
				if (openBraceCount == 0 && addingNested) {
					results.put(key, convertJsonStringToMap(exprBuilder.toString()));
					addingKey = true;
					addingNested = false;
					exprBuilder = new StringBuilder();
					key = null;
				} else if (!addingNested && jsonStripped.charAt(i) == ',') {
					results.put(key, exprBuilder.toString());
					addingKey = true;
					addingNested = false;
					key = null;
					exprBuilder = new StringBuilder();
				}
			}
		}
		if (key != null) {
			results.put(key, exprBuilder.toString());
		}
		return results;
	}

	public static void main(String...args) {
		final String input = "{foo:" +
				"{baz:a," +
				"bar:k}" +
				"}";
//		final String input = "{baz:a,bar:k}";
		final Map<String, Object> map = convertJsonStringToMap(input);
//		System.out.println(map.get("baz"));
//		System.out.println(((Map)map.get("foo")).get("baz"));
		System.out.println(map);
	}
}
