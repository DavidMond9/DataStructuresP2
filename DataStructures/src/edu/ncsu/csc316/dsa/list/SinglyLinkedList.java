package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A singly-linked list is a linked-memory representation of the List abstract
 * data type. This list maintains a dummy/sentinel front node in the list to
 * help promote cleaner implementations of the list behaviors. This list also
 * maintains a reference to the tail/last node in the list at all times to
 * ensure O(1) worst-case cost for adding to the end of the list. Size is
 * maintained as a global field to allow for O(1) size() and isEmpty()
 * behaviors.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

    /** A reference to the dummy/sentinel node at the front of the list **/
    private LinkedListNode<E> front;
    
    /** A reference to the last/final node in the list **/
    private LinkedListNode<E> tail;
    
    /** The number of elements stored in the list **/
    private int size;
        
    /**
     * Constructs an empty singly-linked list
     */     
    public SinglyLinkedList() {
        front = new LinkedListNode<E>(null);
        tail = null;
        size = 0;
    }
    
    /**
     * Adds a node to the list.
     * @param index index to add
     * @param value value of the node
     */
    public void add(int index, E value) {
    	checkIndexForAdd(index);
    	if(index == size) {
    		addLast(value);
    	}
    	else {
    		LinkedListNode<E> curr = front;
    		for(int i = 0; i < index; i++) {
    			curr = curr.getNext();
    		}
    		curr.setNext(new LinkedListNode<>(value, curr.getNext()));
    		size++;
    	}
    	
    }
    /**
     * Adds a node to the end of the list.
     * @param element value of the node.
     */
    public void addLast(E element) {
    	LinkedListNode<E> newNode = new LinkedListNode<>(element, null);
    	newNode = new LinkedListNode<>(element);
    	if(size == 0) {
    		front.setNext(newNode);
    		tail = newNode;
    	}
    	else {
    		tail.setNext(newNode);
    		tail = newNode;
    	}
    	size++;
    	
    }
    /**
     * Gets the element of the node at a certain index.
     * @param index index to get value from.
     * @return returns the element of the node 
     */
    public E get(int index) {
    	checkIndex(index);
    	LinkedListNode<E> curr = front.getNext();
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	return curr.getElement();
    	
    }
    /**
     * Creates an iterator for the nodes.
     * @return returns an iterator of type ElementIterator.
     */
    public Iterator<E> iterator() {
    	return new ElementIterator();
    	
    }
    /**
     * Gets the last element in the list.
     * @return returns the element at the end of the list.
     */
    public E last() {
    	if (isEmpty()) {
    		throw new IndexOutOfBoundsException("The list is empty");
        }
    	return tail.getElement();
    	
    }
    /**
     * Removes a node from the list at a specific index.
     * @param index index to remove from.
     * @return returns the removed value.
     */
    public E remove(int index) {
    	checkIndex(index);
    	LinkedListNode<E> curr = front;
        
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	E removeEle = curr.getNext().getElement();
    	curr.setNext(curr.getNext().getNext());
    	if(index == size) {
    		tail = curr;
    	}
    	size--;
    	return removeEle;
    	
    }
    /**
     * Sets a value at a specific index for the node.
     * @param index index to set
     * @param value value of the node that is being set.
     * @return E returns the old value before it was set.
     */
    public E set(int index, E value) {
    	checkIndex(index);
    	LinkedListNode<E> curr = front.getNext();
    	for(int i = 0; i < index; i++) {
    		curr = curr.getNext();
    	}
    	E oldVal = curr.getElement();
    	curr.setElement(value);
    	return oldVal;
    }
    /**
     * Gets the size of the list.
     * @return returns the size of the list.
     */
    public int size() {
    	return size;
    }
    
    
    
    
    private static class LinkedListNode<E> {
        /** Value of the node */
        private E element;
        /** Next node */
        private LinkedListNode<E> next;
        
        public LinkedListNode(E ele) {
        	this(ele, null);
        	
        }
        public LinkedListNode(E ele, LinkedListNode<E> next) {
        	element = ele;
        	this.next = next;
        	
        }
        public E getElement() {
        	return element;
        }
        public void setElement(E element) {
        	this.element = element;
        }
        public LinkedListNode<E> getNext(){
        	return next;
        }
        
        public void setNext(LinkedListNode<E> next) {
        	this.next = next;
        }
        	
    }
    
    private class ElementIterator implements Iterator<E> {
        /**
         * Keep track of the next node that will be processed
         */
        private LinkedListNode<E> current;
        
        
        /**
         * Construct a new element iterator where the cursor is initialized 
         * to the beginning of the list.
         */
        public ElementIterator() {
            current = front.next;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
            	throw new NoSuchElementException();
            }
            E res = current.element;
            current = current.next;
            return res;
        }
         
        @Override    
        public void remove() {
    	    // DO NOT CHANGE THIS METHOD
            throw new UnsupportedOperationException(
                "This SinglyLinkedList implementation does not currently support removal of elements when using the iterator.");
        }
    }
}