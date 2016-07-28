package lru;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
	
	private LRUCache cache;
	
	@Before
	public void setup() {
		cache = new LRUCache(4);
		cache.initializeDataStoreForTest();
	}
	
	@Test
	public void canInitializeSizeTest() {
		assertEquals(cache.getMaxSize(), 4);
	}
	
	@Test
	public void simpleTest() {
		int asciiValue = Character.getNumericValue('A');
		for (char letter = 'A'; letter <= 'Z'; letter++, asciiValue++) {
			assertEquals(asciiValue + 26, cache.get(Character.toString(letter)).intValue());
			assertTrue(cache.getSize() <= cache.getMaxSize());
		}
		assertEquals(26, cache.getMissCount());
	}
	
	@Test
	public void partialFilledBufferWithSingleHit() {
		cache.get("A");
		cache.get("A");
		assertEquals(1, cache.getMissCount());
		assertEquals(1, cache.getHitCount());
	}
	
	@Test
	public void lruEvictionAtMaxCacheCapacity() {
		cache.get("A");
		cache.get("B");
		cache.get("C");
		cache.get("D");
		cache.get("E");
		cache.get("A");
		assertEquals(6, cache.getMissCount());
	}
	
	@Test
	public void noLruEvictionWhenHitFoundAtMaxCapacity() {
		cache.get("A");
		cache.get("B");
		cache.get("C");
		cache.get("D");
		cache.get("A");
		assertEquals(4, cache.getMissCount());
		assertEquals(1, cache.getHitCount());
	}
	
	@Test
	public void hitWillAdjustPriorityOfEviction() {
		cache.get("A");
		cache.get("B");
		cache.get("C");
		cache.get("D");
		cache.get("A");
		cache.get("E");
		cache.get("B");
		assertEquals(6, cache.getMissCount());
		assertEquals(1, cache.getHitCount());
	}
	
	@Test
	public void hitWhileNotFullWorks() {
		cache.get("A");
		cache.get("B");
		cache.get("A");
		cache.get("B");
		assertEquals(2, cache.getSize());
	}
}
