package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * The Positional Linked List is implemented as a doubly-linked list data
 * structure to support efficient, O(1) worst-case Positional List abstract data
 * type behaviors.
 * 
 * Size is maintained as a global field to ensure O(1) worst-case runtime of
 * size() and isEmpty().
 * 
 * The PositionalLinkedList class is based on the implementation developed for
 * use with the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements stored in the positional list
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	/** A dummy/sentinel node representing at the front of the list **/
	private PositionalNode<E> front;

	/** A dummy/sentinel node representing at the end/tail of the list **/
	private PositionalNode<E> tail;

	/** The number of elements in the list **/
	private int size;

	/**
	 * Constructs an empty positional linked list
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	private static class PositionalNode<E> implements Position<E> {
		/** Element of the current position. */
		private E element;
		/** Position of the node that comes after */
		private PositionalNode<E> next;
		/** Position of the node that came before */
		private PositionalNode<E> previous;

		public PositionalNode(E value) {
			this(value, null);
		}

		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		public PositionalNode<E> getPrevious() {
			return previous;
		}

		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		public PositionalNode<E> getNext() {
			return next;
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	 /**
     * Safely casts a Position, p, to be a PositionalNode.
     * 
     * @param p the position to cast to a PositionalNode
     * @return a reference to the PositionalNode
     * @throws IllegalArgumentException if p is null, or if p is not a valid PositionalNode
     */
    private PositionalNode<E> validate(Position<E> p) {
        if (p instanceof PositionalNode) {
            return (PositionalNode<E>) p;
        }
        throw new IllegalArgumentException("Position is not a valid positional list node.");
    }


	/** Returns the number of elements in the linked list. 
	 * @return returns the size of the list.
	 * */
	public int size() {
		return size;
	}

	/** Tests whether the linked list is empty. 
	 * @return returns a boolean if the list is empty or not.
	 * */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the first Position in the linked list (or null, if empty). 
	 * @return returns the first element in the list.
	 * */
	public Position<E> first() {
		if(front.next == tail) {
			return null;
		}
		return front.getNext();
	}

	/** Returns the last Position in the linked list (or null, if empty). 
	 * @return returns the last element in the list.
	 * */
	public Position<E> last() {
		if(tail.previous == front) {
			return null;
		}
		return tail.getPrevious();
	}

	/**
	 * Returns the Position immediately before Position p (or null, if p is first).
	 * @param p position of current node, validated.
	 * @return returns the node that is before p
	 */
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		if(node.previous == front) {
			return null;
		}
		return node.getPrevious();

	}

	/**
	 * Returns the Position immediately after Position p (or null, if p is last).
	 * @param p position of current node, validated.
	 * @return returns the node that is after p 
	 */
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		if(node.next == tail) {
			return null;
		}
		return node.getNext();
	}

	private Position<E> addBetween(E element, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> newest = new PositionalNode<>(element);
		PositionalNode<E> myP = validate(prev);
		PositionalNode<E> myN = validate(next);
		myP.next = newest;
		newest.next = myN;
		myN.previous = newest;
		newest.previous = myP;
		size++;
		return newest;
	}

	/**
	 * Inserts element e at the front of the linked list and returns its new
	 * Position.
	 * @param e Element that is being added
	 * @return Returns position of element being added first.
	 */
	public Position<E> addFirst(E e) {
		return addBetween(e, front.next, front); 
	}

	/**
	 * Inserts element e at the back of the linked list and returns its new
	 * Position.
	 * @param e Element that is being added
	 * @return Returns position of element being added last.
	 */
	public Position<E> addLast(E e) {
		return addBetween(e, tail, tail.previous); 
	}

	/**
	 * Inserts element e immediately before Position p, and returns its new
	 * Position.
	 * @param p Position of element being added
	 * @param e Value of element being added
	 * @return returns the position of the node after being validated
	 */
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		return addBetween(e, node, node.previous);
	}

	/**
	 * Inserts element e immediately after Position p, and returns its new Position.
	 * @param p Position of element being added
	 * @param e Value of element being added
	 * @return returns the position of the node after being validated
	 */
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		return addBetween(e, node.next, node);
	}

	/**
	 * Replaces the element stored at Position p and returns the replaced element.
	 * @param p Position of element being set
	 * @param e Value of element being set
	 * @return returns the element of the old node that was set
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	/** Removes the element stored at Position p and returns it (invalidating p). 
	 * @param p Position of element being removed
	 * @return returns the element of the node removed.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		PositionalNode<E> node = validate(p);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
		return node.getElement();
	}

	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	private class ElementIterator implements Iterator<E> {
		/**
		 * Iterator that works with the ElementIterator class.
		 */
		private Iterator<Position<E>> it;

		public ElementIterator() {
			it = new PositionIterator();
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next().getElement();
		}

		@Override
		public void remove() {
			it.remove();
		}
	}

	private class PositionIterator implements Iterator<Position<E>> {

		/**
		 * Represents the current position for the PositionIterator.
		 */
		private Position<E> current;
		/**
		 * Represents the previous position for the PositionIterator.
		 */
		private Position<E> previous;
		/**
		 * Represents if you can remove something from the iterator.
		 */
		private boolean removeOK;

		public PositionIterator() {
			current = front.next;
			removeOK = false;
		}

		@Override
		public boolean hasNext() {
			PositionalNode<E> var = validate(current);
			return var != tail;
		}

		@Override
		public Position<E> next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Position<E> var = current;
			PositionalNode<E> x = validate(current);
			x = x.next;
			removeOK = true;
			current = x;
			return var;
		}

		@Override
		public void remove() {
			// TODO your code here
			// You should consider delegating to
			// the outer class's remove(position) method,
			// similar to:
			// PositionalLinkedList.this.remove(position);
			PositionalNode<E> x = validate(current);
			if (removeOK) {
				PositionalLinkedList.this.remove(x.previous);
			} else {
				throw new IllegalStateException();
			}
			removeOK = false;
		}
	}

	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator();
		}
	}
}