package lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	private List<Record> dataStore;
	
	private LinkedList<Record> buffer;

	private Map<String, Record> indexes;
	
	private int maxSize;
	
	private int size;
	
	private int hitCount;
	
	private int missCount;
	
	public LRUCache(final int maxSize) {
		super();
		this.buffer = new LinkedList<Record>();
		this.indexes = new HashMap<String, Record>();
		this.size = 0;
		this.hitCount = 0;
		this.missCount = 0;
		this.maxSize = maxSize;
	}
	
	public void initializeDataStoreForTest() {
		dataStore = new LinkedList<Record>();
		for (char alph = 'A'; alph <= 'Z'; alph++) {
			String alphString = new String(new char[]{alph});
			dataStore.add(new Record(alphString, Character.getNumericValue(alph) + 26));
		}
	}
	
	public Record evict() {
		return buffer.removeFirst();
	}

	public Integer get(final String id) {
		if (indexes.containsKey(id)) { //hit
			this.hitCount += 1;
			final Record hit = indexes.get(id);
			buffer.remove(hit);
			buffer.add(hit);
			return hit.getData();
		} else { //miss
			this.missCount += 1;
			for (Record record : dataStore) {
				if (record.getId().equals(id)) {
					buffer.add(record);
					if (size == maxSize) {
						final Record evicted = evict();
						indexes.remove(evicted.getId());
						indexes.put(record.getId(), record);
					} else {
						indexes.put(record.getId(), record);
						size += 1;
					}
					return record.getData();
				}
			}
			throw new RuntimeException("Could not find data with id={" + id + "} in dataStore");
		}
	}
	
	private static class Record {
		private String id;
		private Integer data;

		public Record(String id, Integer data) {
			super();
			this.id = id;
			this.data = data;
		}
		
		@Override
		public String toString() {
			return id;
		}
		
		private String getId() {
			return id;
		}
		
		private Integer getData() {
			return data;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public int getMissCount() {
		return missCount;
	}

	public int getHitCount() {
		return hitCount;
	}
}
