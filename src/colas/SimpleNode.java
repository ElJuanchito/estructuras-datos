package colas;

public class SimpleNode<T> {
	private T value;
	private SimpleNode<T> next;

	public SimpleNode() {
		// TODO Auto-generated constructor stub
	}

	public SimpleNode(T value) {
		super();
		this.value = value;
	}

	public SimpleNode(T value, SimpleNode<T> next) {
		super();
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SimpleNode<T> getNext() {
		return next;
	}

	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}

}
