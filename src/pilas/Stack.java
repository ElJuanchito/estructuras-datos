package pilas;

public interface Stack<T> {
	boolean isEmpty();
	T peek();
	void push(T value);
	T unstack();
	void clear();
}
