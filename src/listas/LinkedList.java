package listas;

import java.util.Comparator;

public interface LinkedList<T> extends Iterable<T>{

	void addHead(T element);
	void addTail(T element);
	void add(int index, T element);
	boolean validIndex(int index);
	boolean isEmpty();
	void removeHead();
	void removeTail();
	void remove(int index);
	void remove(T element);
	void sort();
	void print();
	void clean();

//obtenerValorNodo
//obtenerNodo
//obtenerPosicionNodo
//modificarNodo


}
