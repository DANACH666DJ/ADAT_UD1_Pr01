import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        System.out.println("Inicio Ejecucion - Actividad 1.1");
		
		bbdda base=new bbdda();
		
		base.loadFichero("fichero.ini");
		
		
		Intermediario intermediario = new Intermediario();
		
		intermediario.ejecucion();
				
		System.out.println("Fin Ejecucion - Actividad 1.1");

	}

}
