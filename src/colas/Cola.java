package colas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Cola<E> implements Iterable<E>{
	private SimpleNode<E> head;
	private int size;

	public Cola() {
		this.head = null;
		this.size = 0;
	}

	private void setHead(SimpleNode<E> cabeza) {
		head = cabeza;
	}

	private void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	/**
	 * This method is used for adding a new {@link SimpleNode} to the list
	 * 
	 * @param node
	 */
	public void addToHead(SimpleNode<E> node) {
		if (head == null) {
			head = node;
			size++;
			return;
		}
		SimpleNode<E> auxiliar = head;
		head = node;
		head.setNext(auxiliar);
		size++;
	}

	/**
	 * This method is used for adding a new {@link SimpleNode} using its data (the
	 * correct way to be implemented) We should not use {@link SimpleNode} as
	 * parameter.
	 * 
	 * @param value
	 */
	public void addToHeadByValue(E value) {
		SimpleNode<E> nodoPara = new SimpleNode<E>(value);
		if (head == null) {
			head = nodoPara;
			return;
		}
		SimpleNode<E> aux = head;
		head = nodoPara;
		head.setNext(aux);
		size++;

	}

	/**
	 * This method is used for adding a new {@link SimpleNode} to as the last node
	 * of the {@link SimpleList}
	 * 
	 * @param value
	 */
	public void encolar(E value) {
		SimpleNode<E> node = new SimpleNode<E>(value);
		if (head == null) {
			head = node;
			return;
		}
		SimpleNode<E> nodeAux = head;
		while (nodeAux.getNext() != null) {
			nodeAux = nodeAux.getNext();
		}
		nodeAux.setNext(node);
		size++;

	}

	public void addByPosition(E value, int pos) {
		SimpleNode<E> nodeParam = new SimpleNode<E>(value);
		int cont = 0;
		SimpleNode<E> node = head;
		if (head == null) {
			head = nodeParam;
			return;
		}
		if (pos == 0) {
			nodeParam.setNext(head);
			head = nodeParam;
			return;
		}

		while (node.getNext() != null && cont < pos - 1) {
			node = node.getNext();
			cont++;
		}
		if (cont == pos - 1)
			nodeParam.setNext(node.getNext());
		node.setNext(nodeParam);
		size++;

	}

	public boolean isValidIndex(int index) {
		if (head == null) {
			return false;
		}
		SimpleNode<E> nodo = head;
		int cont = 0;
		while (nodo.getNext() != null) {
			if (cont == index) {
				return true;
			}
			nodo = nodo.getNext();
			cont++;

		}
		return false;
	}

	// Método para revertir la lista enlazada utilizando recursividad
	private SimpleNode<E> reverseRecursively(SimpleNode<E> current) {
		if (current == null || current.getNext() == null) {
			return current;
		}

		SimpleNode<E> newHead = reverseRecursively(current.getNext());
		current.getNext().setNext(current);
		current.setNext(null); // Corrección aquí
		return newHead;
	}

	// Método público para invertir la lista llamando al método recursivo
	public void reverse() {
		head = reverseRecursively(head);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterador(head);
	}

	@Override
	public String toString() {
		return String.format("[%s]", head);
	}

	private class Iterador implements Iterator<E> {

		private SimpleNode<E> head;

		public Iterador(SimpleNode<E> head) {
			this.head = head;
		}

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("");
			}
			E e = head.getValue();
			head = head.getNext();
			return e;
		}

	}

	public SimpleNode<E> obtenerValorNodo(int n) {
		int i = 0;
		SimpleNode<E> aux = head;
		while (aux != null && i < n) {
			aux = aux.getNext();
			i++;
		}
		return aux;
	}

	public SimpleNode<E> obtenerNodo(SimpleNode<E> nodoBuscar) {
		SimpleNode<E> aux = head;
		while (aux != null) {
			if (aux.equals(nodoBuscar))
				return aux;
			aux = aux.getNext();
		}
		return aux;
	}

	public int obtenerPosicionNodo(SimpleNode<E> nodoBuscar) {
		int i = 0;
		SimpleNode<E> aux = head;
		while (aux != null) {
			if (aux.equals(nodoBuscar))
				return i;
			i++;
			aux = aux.getNext();
		}
		return -1;
	}

	public boolean estaVacia() {
		return head == null;
	}

	public E desencolar() {
		if (estaVacia())
			return null;
		E elemento = head.getValue();
		head = head.getNext();
		size--;
		return elemento;
	}

	public void eliminarUltimo() {
		if (estaVacia())
			return;
		var aux = head;
		var previous = head;

		while (aux.getNext() != null) {
			previous = aux;
			aux = aux.getNext();
		}
		previous.setNext(null);
		size--;
	}

	public void eliminarElemento(E elemento) {
		if (estaVacia())
			return;

		var aux = head;
		var previous = head;

		while (aux.getNext() != null) {
			previous = aux;
			aux = aux.getNext();
			if (aux.getValue().equals(elemento)) {
				previous.setNext(aux.getNext());
				return;
			}
		}
		size--;

	}

	/**
	 * Method used to print a {@link SimpleList} using forwards movement
	 * 
	 * @return
	 */
	public void printListForwards() {
		StringBuilder sb = new StringBuilder("[");
		SimpleNode<E> aux = head;

		while (aux != null) {
			sb.append(aux.getValue());
			if (aux.getNext() == null) {
				sb.append("]");
			} else {
				sb.append(", ");
			}
			aux = aux.getNext();
		}

		System.out.println(sb.toString());
	}

	public void borrarLista() {
		head = null;
	}

	public Cola<E> copiar() {
		Cola<E> colita = new Cola<E>();
		colita.setHead(head);
		colita.setSize(size);
		return colita;
	}
	
	public boolean comparar(Cola<E> c2) {
		var node = head;
		var n2 = c2.head;
		while(node.getNext() != null) {
			if(!node.equals(n2)) return false;
			node = node.getNext();
			n2 = n2.getNext();
		}
		return true;
	}
	
	//Realizar un procedimiento que ingrese un elemento en la posición N de la cola.
	//Tener en cuenta que los demás elementos deben quedar en el mismo orden. 
	public E encolarEn(int index, E elemento) {
		if(elemento ==  null) return null;
		int tam = size;
		for(int i = 0; i <= tam; i++) {
			E aux = desencolar();
			if(i == index) encolar(elemento);
			encolar(aux);
		}
		return elemento;
	}
	
	


}