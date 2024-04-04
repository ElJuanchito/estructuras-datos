package pilas;

public class PruebaPila {
	public static void main(String[] args) {
		Stack<Integer> pila = new SimpleStack<Integer>();
		pila.push(5);
		pila.push(4);
		pila.push(3);
		pila.push(2);
		pila.push(1);
		System.out.println(pila);
		System.out.println(pila.unstack());
		System.out.println(pila);
	}
}
