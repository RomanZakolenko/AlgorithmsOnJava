package datastructure;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	private static MyArrayList<String> list;

	@Before
	public void setUp() {
		list = new MyArrayList<String>();
	}

	@Test
	public void testSizeEmpty() {
		assertEquals(0, list.size());
	}

	@Test
	public void testSizeBeforeAdd() {
		list.add("first");
		assertEquals(1, list.size());
	}

	@Test
	public void testSizeBeforeRemove() {
		list.add("first");
		list.add("second");
		list.remove(1);
		assertEquals(1, list.size());
		list.remove("first");
		assertEquals(0, list.size());
	}

	@Test
	public void testToArray() {
		String[] expResult = new String[5];
		for (int i = 0; i < 5; i++) {
			list.add(i, "" + i);
			expResult[i] = "" + i;
		}
		assertArrayEquals(expResult, list.toArray());
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 17; i++) {
			list.add(i, "" + i);
		}
		assertEquals("16", list.get(16));
		assertEquals(17, list.size());
	}

	@Test
	public void testAddByIndex() {
		for (int i = 0; i < 5; i++) {
			list.add(i, "" + i);
		}
		assertArrayEquals(new String[] { "0", "1", "2", "3", "4" }, list.toArray());
	}

	@Test
	public void testAddAll() {
		ArrayList<String> expResult = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			expResult.add(i, "" + i);
		}
		list.addAll(expResult);
		assertArrayEquals(expResult.toArray(), list.toArray());
	}

	@Test
	public void testAddAllIndex() {
		ArrayList<String> expResult = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			expResult.add(i, "" + i);
		}
		list.add("first");
		list.add("second");
		list.addAll(0, expResult);
		expResult.add("first");
		expResult.add("second");
		assertArrayEquals(expResult.toArray(), list.toArray());
	}

	@Test
	public void testClear() {
		for (int i = 0; i < 5; i++) {
			list.add(i, "" + i);
		}
		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testContains() {
		assertFalse(list.contains("0"));
		list.add("0");
		assertTrue(list.contains("0"));
	}

	@Test
	public void testContainsAll() {
		ArrayList<String> c = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			c.add("" + i);
			list.add("" + i);
		}
		assertTrue(list.containsAll(c));
		list.add("false");
		assertFalse(list.contains(c));
	}

	@Test
	public void testGet() {
		String expResult = "first";
		list.add(expResult);
		assertEquals(expResult, list.get(0));
	}

	@Test
	public void testIndexOf() {
		String first = "first";
		String second = "second";
		list.add(first);
		list.add(second);
		assertEquals(0, list.indexOf(first));
		assertEquals(1, list.indexOf(second));
		assertEquals(-1, list.indexOf("third"));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.add("first");
		assertFalse(list.isEmpty());
	}

	@Test
	public void testIteratorHasNext() {
		Iterator<String> iter = list.iterator();
		assertFalse(iter.hasNext());
		list.add("first");
		assertTrue(iter.hasNext());
		iter.next();
		iter.remove();
		assertFalse(iter.hasNext());
	}

	@Test
	public void testIteratorNext() {
		Iterator<String> iter = list.iterator();
		String expResult = "first";
		list.add(expResult);
		assertEquals(expResult, iter.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void testIteratorNextException() {
		Iterator<String> iter = list.iterator();
		iter.next();
	}

	@Test
	public void testLastIndexOf() {
		Iterator<String> iter = list.iterator();
	}
}
