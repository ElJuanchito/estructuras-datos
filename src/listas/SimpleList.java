package listas;

import java.util.Comparator;
import java.util.Iterator;

public class SimpleList<E> implements LinkedList<E> {

	private Node<E> head;
	private int size;

	public SimpleList() {
		head = null;
		size = 0;
	}
	
	private class SimpleListIterator<E> implements Iterator<E>{
		
		private Node<E> actual;
		private int i;
		
		public SimpleListIterator(Node<E> head) {
			this.actual = head;
		}

		@Override
		public boolean hasNext() {
			return (i < size) ? true : false;
		}

		@Override
		public E next() {
			if(!hasNext()) return null;
			E element = actual.getElement();
			actual = actual.getNext();
			return element;
		}
		
	}

	@Override
	public void addFirst(E element) {
		if (head == null)
			head = new Node<E>(element);
		else {
			var newHead = new Node<E>(element);
			newHead.setNext(head);
			head = newHead;
		}
		size++;
	}

	@Override
	public void addEnd(E element) {
		var node = head;
		while (node.getNext() != null)
			node = node.getNext();
		node.setNext(new Node<E>(element));
	}

	@Override
	public boolean add(int index, E element) {
//		if(! validIndex(index)) return false;
//		if(index == 0) addFirst(element);
//		var node = head;
//		var newNode = new Node<E>(element, getNode(index));
//		var n = Node<E>();
//		while(Node<E> n; n != node) {
//			
//		}
		return true;
		
	}

	@Override
	public E getValue(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<E> getNode(int index) {
		if(!validIndex(index)) return null;
		var node = head;
		int pos = 0;
		while(index != pos) node = node.getNext();
		return node;
	}

	@Override
	public int findIndex(Node<E> node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validIndex(int index) {
		return index < size ? true : false;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	@Override
	public boolean removeFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateNode(int index, E element) {
		var node = head;
		int i = 0;
		while(i != index) {
			node = node.getNext();
			i++;
		} node.setElement(element);
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sort(Comparator<E> comparator) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		String msg = "{ ";
		Iterator<E> iterador = iterator();
		while(iterador.hasNext()) {
			msg += iterador.next() + ", ";
		} return msg + "}";
	}

	@Override
	public void clean() {
		head = null;
	}

	@Override
	public Iterator<E> iterator() {
		return new SimpleListIterator<E>(head);
	}
}
