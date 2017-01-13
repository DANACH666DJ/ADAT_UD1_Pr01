import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeerEscribirFichero {

	private String sFichero;
	private String element; 
	private String cadena;
	private ArrayList<String> al1; 
	
	public LeerEscribirFichero(){
		sFichero="";
		element="";
		cadena="";
		al1=new ArrayList<String>();
	}
	
	public void escribirFicheroClasEquipo(HashMap<String,Integer> equipos) {
		String nombre="";
		int puntos=0;
		sFichero = "fichero.txt";
		try {
			File fichero = new File(sFichero);
			FileWriter fi=new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fi);
			
			Iterator<Map.Entry<String,Integer>> entries = equipos.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<String,Integer> entry = entries.next();
		        nombre=entry.getKey();
		        puntos=entry.getValue();
				bw.write(nombre+"="+puntos+ "\n");

			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirFicheroJugInscritos(ArrayList<JugInscritos> jug) {
		sFichero = "fichero.txt";
		try {
			File fichero = new File(sFichero);
			FileWriter fi=new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fi);
			
			Iterator<JugInscritos> itr = jug.iterator();
			while (itr.hasNext()) {
				
				
				/*jugadores= itr.next();
				bw.write(jugadores + "\n");*/

			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*public void escribirFicheroJugIns(HashMap<Integer,JugInscritos> jugadores) {
		int num=0;
		JugInscritos jug;
		
		sFichero = "fichero.txt";
		try {
			File fichero = new File(sFichero);
			FileWriter fi=new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fi);
			
			Iterator<Map.Entry<Integer,JugInscritos>> entries = jugadores.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry<Integer,JugInscritos> entry = entries.next();
		        num=entry.getKey();
		        jug=entry.getValue();
				bw.write(num+"="+jug+ "\n");

			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	
	
	
	
	public HashMap<String,String> leerFichero(String fichero) throws IOException {
		HashMap<String, String> hmDatos = new HashMap<String, String>();
		FileReader fr = new FileReader(fichero);
		BufferedReader bf = new BufferedReader(fr);
		String lineaLeida = bf.readLine();
		while (lineaLeida != null) {
			String sar[] = lineaLeida.split("=");
			hmDatos.put(sar[0], sar[1]);
			lineaLeida = bf.readLine();
		}
		bf.close();
		fr.close();
		return hmDatos;
		
		
	}
	
	
	public HashMap<Integer,String> leerFicheroJugEquipo(String fichero) throws IOException {
		HashMap<Integer, String> hmDatos = new HashMap<Integer, String>();
		FileReader fr = new FileReader(fichero);
		BufferedReader bf = new BufferedReader(fr);
		String lineaLeida = bf.readLine();
		while (lineaLeida != null) {
			String sar[] = lineaLeida.split("=");
			//hmDatos.put(Integer.toString(sar[0]), sar[1]);
			lineaLeida = bf.readLine();
		}
		bf.close();
		fr.close();
		return hmDatos;
		
		
	}
	
	public ArrayList<String> leerFicheroList(String fichero) throws IOException {
		FileReader f = new FileReader(fichero);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			al1.add(cadena);
			//System.out.println(al1);
		}

		b.close();
		
		return al1;
	}
	
	
	
}
