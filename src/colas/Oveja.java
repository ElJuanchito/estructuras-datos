package colas;

public class Oveja implements Comparable<Oveja>{
	
	private String nombre;
	private Integer peso;
	
	
	public Oveja(String nombre, Integer peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getPeso() {
		return peso;
	}


	public void setPeso(Integer peso) {
		this.peso = peso;
	}


	@Override
	public int compareTo(Oveja o) {
		return this.peso.compareTo(o.getPeso());
	}


	@Override
	public String toString() {
		return "Oveja [nombre=" + nombre + ", peso=" + peso + "]";
	}
	
	

}
