package listas;

import java.util.Comparator;

public interface LinkedList<E> extends Iterable<E>{
	void addFirst(E element);
	void addEnd(E element);
	boolean add(int index, E element);
	E getValue(int index);
	Node<E> getNode(int index);
	int findIndex(Node<E> node);
	boolean validIndex(int index);
	boolean isEmpty();
	boolean removeFirst();
	boolean removeEnd();
	boolean remove(E element);
	void updateNode(int index, E element);
	void sort();
	void sort(Comparator<E> comparator);
	String toString();
	void clean();
}
