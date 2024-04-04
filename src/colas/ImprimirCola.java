package colas;

import java.util.Iterator;

public class ImprimirCola {

	public static void main(String[] args) {
//		Cola<Persona> cola = new Cola<Persona>();
//		cola.encolar(new Persona("Pepe", "1"));
//		cola.encolar(new Persona("Josue", "2"));
//		cola.encolar(new Persona("Juan", "3"));
//		cola.encolar(new Persona("Pepa", "4"));
//		
//		cola.encolarEn(2, new Persona("Popo", "5"));
//		
//		imprimirCola(cola);
//		//System.out.println("HOlaaa");
//		//eliminarPersona(cola, "P");
//		//imprimirCola(cola);

		Cola<Oveja> establo1 = new Cola<Oveja>();
		establo1.encolar(new Oveja("Ovejita1", 15));
		establo1.encolar(new Oveja("Ovejita2", 13));
		establo1.encolar(new Oveja("Ovejita3", 30));
		establo1.encolar(new Oveja("Ovejita4", 20));
		establo1.encolar(new Oveja("Ovejita5", 10));

		Cola<Oveja> establo2 = new Cola<Oveja>();
		establo2.encolar(new Oveja("Ovejota1", 43));
		establo2.encolar(new Oveja("Ovejota2", 112));
		establo2.encolar(new Oveja("Ovejota3", 12));
		establo2.encolar(new Oveja("Ovejota4", 13));

	}

	public static <E> void imprimirCola(Cola<E> cola) {
		Iterator<E> iterador = cola.iterator();
		while (iterador.hasNext())
			System.out.println(iterador.next());
	}

	public static void eliminarPersona(Cola<Persona> cola, String inicial) {
		int tamano = cola.getSize();
		if (cola.estaVacia())
			return;
		for (int i = 0; i <= tamano; i++) {
			Persona persona = cola.desencolar();
			if (!persona.getNombre().startsWith(inicial))
				cola.encolar(persona);
		}
	}

	public static Cola<Oveja> ordenarOvejas(Cola<Oveja> establo) {
		Cola<Oveja> aux1 = new Cola<Oveja>();
		Cola<Oveja> aux2 = new Cola<Oveja>();

		return ordernarOvejasAux(establo, aux1, aux2);
	}

	private static Cola<Oveja> ordernarOvejasAux(Cola<Oveja> establo, Cola<Oveja> aux1, Cola<Oveja> aux2) {
		return null;
		
	}
}
