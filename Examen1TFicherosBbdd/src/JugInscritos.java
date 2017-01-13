
public class JugInscritos {

	public String nombreEquipo;
	public String nombre;
	public String apellido;
	public String puesto;
	public float altura;
	public int salario;

	public JugInscritos(String nombreEquipo, String nombre, String apellido,
			String puesto, float altura,int salario) {
		this.nombreEquipo=nombreEquipo;
		this.nombre=nombre;
		this.apellido=apellido;
		this.puesto=puesto;
		this.altura=altura;
		this.salario=salario;

	}
	
	public JugInscritos(){
		
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	

}
