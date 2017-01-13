import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Intermediario {
	private LeerEscribirFichero encargadoFicheros;
	private bbdda base;
	private Scanner teclado;
	
	public Intermediario(){
		teclado = new Scanner(System.in); // Para leer las opciones de teclado
		encargadoFicheros = new LeerEscribirFichero();
		base=new bbdda();
	}
	
	public void ejecucion(){
		int op = 0; // Opcion
		boolean salir = false;
		
		while (!salir) { // Estructura que repite el algoritmo del menu principal hasta que se la condicion sea falsa
			// Se muestra el menu principal
			System.out.println(".......................... \n" 
							+  ".  1 Clasificación de equipos  \n"
							+  ".  2 Jugadores inscritos \n" 
							+  ".  3 Jugadores de un determinado equipo \n" 
							+  ".  4 Salarios \n"  
							+  ".  5 Salir \n" 
							+  "..........................");
			try{
				op = teclado.nextInt(); // Se le da a la variable op el valor del teclado
				System.out.println("OPCION SELECCIONADA:" + op);
				switch (op) {
					case 1:// 
						Clasificaciónequipos();
						break;
					case 2:// Retornar Monedas
						base.leerJugIns();
						break;
					case 3:
						base.LeerJugEquipo();
						break;
					case 4:
						base.Salarios();
						break;
					case 5:
						salir = true;
						break;
					default:// No valido
						System.out.println("Opcion invalida: marque un numero de 1 a 5");
						break;
				}
			}catch (Exception e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 1 a 7");
	            // flushing scanner
				//e.printStackTrace();
				teclado.next();
			}
		}
		
		//teclado.close();

	}

	private void salarios() {
		// TODO Auto-generated method stub
		
	}

	private void JugadoresEquipo() {
		// TODO Auto-generated method stub
		
	}

	private void JugadoresInscritos() {
		// TODO Auto-generated method stub
		System.out.println("Pasamos los datos base de datos a fichero");
		//ArrayList<JugInscritos> ed=base.leerJugIns();
		//encargadoFicheros.escribirFicheroJugInscritos(ed);
		
	}

	private void Clasificaciónequipos() {
		// TODO Auto-generated method stub
		System.out.println("Pasamos los datos base de datos a fichero");
		HashMap<String,Integer> ed =base.ClasCompet();
		encargadoFicheros.escribirFicheroClasEquipo(ed);
		
		
	}
	
	
	

}
