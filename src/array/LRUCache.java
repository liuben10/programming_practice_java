package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 */
public class LRUCache {

	Map<String, String> indexes = new HashMap<>();
	List<String> disk;
	int capacity;
	List<String> cache;

	public LRUCache(final int capacity, final List<String> disk) {
		this.indexes = new HashMap<>();
		this.disk = disk;
		this.capacity = capacity;
		this.cache = new LinkedList<>();
	}

	public static void main(String...args) {
		LRUCache cache = new LRUCache(4, Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
		cache.get("A");
		cache.get("B");
		cache.get("C");
		cache.get("D");
		cache.get("F");
		cache.get("C");

		System.out.println(cache.getCache());
	}

	public String get(String s) {
		if (indexes.containsKey(s)) {
			cache.remove(s);
			cache.add(s);
		} else {
			if (cache.size() == capacity) {
				final String first = cache.remove(0);
				indexes.remove(first);
				cache.add(s);
			} else {
				cache.add(s);
			}
			indexes.put(s, s);
		}
		return s;
	}

	public List<String> getCache() {
		return cache;
	}
}
