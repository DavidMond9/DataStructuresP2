package edu.ncsu.csc316.dsa.list;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
	private List<String> list;

    /**
     * Create a new instance of an array-based list before each test case executes
     */
    @Before
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }
    @Test
    public void testAddLast() {
    	list = new SinglyLinkedList<String>();
    	assertEquals(0, list.size());
    	assertTrue(list.isEmpty());
    	list.add(0, "5");
    	list.addLast("hi");
    	list.addLast("3");
    	assertEquals(list.last(), "3");
    }
    @Test
    public void testAdd() {
    	list = new SinglyLinkedList<String>();
    	assertEquals(0, list.size());
    	assertTrue(list.isEmpty());
    	list.add(0, "7");
    	list.addLast("new");
    	list.add(0, "5");
    	assertEquals(list.get(0), "5");
    }
    @Test
    public void testRemove() {
    	list = new SinglyLinkedList<String>();
    	assertEquals(0, list.size());
    	assertTrue(list.isEmpty());
    	list.add(0, "7");
    	list.addLast("new");
    	assertEquals("new", list.remove(1));
    }
    @Test
    public void testSet() {
    	list = new SinglyLinkedList<String>();
    	assertEquals(0, list.size());
    	assertTrue(list.isEmpty());
    	list.add(0, "7");
    	list.addLast("new");
    	list.set(0, "set");
    	assertEquals("set", list.get(0));
    }
    @Test
    public void testIterator() {
    	list = new SinglyLinkedList<String>();
    	assertEquals(0, list.size());
    	assertTrue(list.isEmpty());
    	Iterator<String> iterate = list.iterator();
    	assertFalse(iterate.hasNext());
    	list.add(0, "hi");
    	iterate = list.iterator();
    	assertTrue(iterate.hasNext());
        assertEquals("hi", iterate.next());
    }
	
	
}
