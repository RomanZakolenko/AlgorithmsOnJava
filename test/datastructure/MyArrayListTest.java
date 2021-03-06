package datastructure;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	private static MyArrayList<String> list;
	private static Iterator<String> iter;
	private static ListIterator<String> listIter;

	@Before
	public void setUp() {
		list = new MyArrayList<String>();
		iter = list.iterator();
		listIter = list.listIterator();
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
		assertFalse(iter.hasNext());
		list.add("first");
		assertTrue(iter.hasNext());
		iter.next();
		iter.remove();
		assertFalse(iter.hasNext());
	}

	@Test
	public void testIteratorNext() {
		String expResult = "first";
		list.add(expResult);
		assertEquals(expResult, iter.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void testIteratorNextException() {
		iter.next();
	}

	@Test
	public void testLastIndexOf() {
		assertEquals(-1, list.lastIndexOf("false"));
		list.add("java");
		list.add("scala");
		list.add("java");
		assertEquals(2, list.lastIndexOf("java"));
	}

	@Test
	public void testListIteratorAdd() {
		listIter.add("first");
		assertEquals("first", list.get(0));
		listIter.add("second");
		assertEquals("second", list.get(0));
	}

	@Test
	public void testListIteratorRemove() {
		listIter.add("first");
		listIter.next();
		listIter.remove();
		assertTrue(list.isEmpty());
	}

	@Test(expected = IllegalStateException.class)
	public void testListIteratorRemoveException() {
		listIter.remove();
	}

	@Test
	public void testListIteratorHasPrevious() {
		assertFalse(listIter.hasPrevious());
		listIter.add("first");
		listIter.add("second");
		listIter.next();
		listIter.next();
		assertTrue(listIter.hasPrevious());
	}

	@Test
	public void testNextIndex() {
		assertEquals(0, listIter.nextIndex());
		list.add("first");
		listIter.next();
		assertEquals(1, listIter.nextIndex());
	}

	@Test
	public void testListIteratorPrevious() {
		list.add("first");
		list.add("second");
		listIter.next();
		listIter.next();
		assertEquals("first", listIter.previous());
	}

	@Test(expected = NoSuchElementException.class)
	public void testListIteratorException() {
		listIter.previous();
	}

	@Test
	public void testListIteratorPreviousIndex() {
		assertEquals(-1, listIter.previousIndex());
		list.add("first");
		list.add("second");
		listIter.next();
		listIter.next();
		assertEquals(0, listIter.previousIndex());
	}

	@Test
	public void testListIteratorSet() {
		listIter.add("first");
		listIter.next();
		listIter.set("FIRST");
		assertEquals("FIRST", list.get(0));
	}

	@Test(expected = IllegalStateException.class)
	public void testListIteratorSetException() {
		listIter.set("fail");
	}

	@Test
	public void testRemove() {
		assertFalse(list.remove("fail"));
		list.add("first");
		assertTrue(list.remove("first"));
		assertTrue(list.isEmpty());
		assertFalse(list.contains("first"));
	}

	@Test
	public void testRemoveIndex() {
		list.add("first");
		list.add("second");
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals("second", list.get(0));
	}

	@Test
	public void testRemoveAllTrue() {
		List<String> c = new ArrayList(Arrays.asList("2", "1", "3"));
		list.addAll(Arrays.asList("1", "1", "2", "4", "3"));
		assertTrue(list.removeAll(c));
	}

	@Test
	public void testRemoveAllFalse() {
		List<String> c = new ArrayList(Arrays.asList("2", "1", "3"));
		assertFalse(list.removeAll(c));
	}

	@Test
	public void testRetainAllTrue() {
		List<String> c = new ArrayList(Arrays.asList("2", "1", "3"));
		list.addAll(Arrays.asList("1", "1", "2", "4", "3"));
		assertTrue(list.retainAll(c));
	}

	@Test
	public void testRetainAllFalse() {
		List<String> c = new ArrayList(Arrays.asList("2", "1", "3"));
		assertFalse(list.retainAll(c));
	}

	@Test
	public void testSet() {
		list.addAll(Arrays.asList("1", "2"));
		String expResult = list.set(0, "first");
		assertEquals(expResult, "1");
		assertEquals("first", list.get(0));
	}

	@Test
	public void testSubList() {
		list.addAll(Arrays.asList("1", "2", "3", "4", "5"));
		List<String> res = list.subList(0, 5);
		assertArrayEquals(res.toArray(), list.toArray());
		res = list.subList(1, 4);
		assertArrayEquals(new String[] { "2", "3", "4" }, res.toArray());
	}

}
