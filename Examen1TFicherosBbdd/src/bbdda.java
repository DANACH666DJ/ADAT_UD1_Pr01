import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class bbdda {
	private Connection conexion;
	ArrayList<JugInscritos>  jug;
	ArrayList<Integer>  salarios;
	

	public bbdda() {
		try {
			HashMap<String, String> hmret = loadFichero("fichero.ini");
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(hmret.get("url"),
					hmret.get("login"), null);
			System.out.println("Todo ok");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no cargado");
		} catch (SQLException e) {
			System.out.println("Error de conexion con Sql");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public HashMap<String, String> loadFichero(String nomFichero)
			throws IOException {
		HashMap<String, String> hmDatos = new HashMap<String, String>();
		FileReader fr = new FileReader(nomFichero);
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
	
	public HashMap<String,Integer> ClasCompet() {
		HashMap<String,Integer>clas=new HashMap<String,Integer>();
		try {
			if (conexion != null) {
				String query = "SELECT nombre,puntos From liga.equipos  ORDER BY puntos DESC ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				while (rset.next()) {
                 
				    String nombre = rset.getString("nombre");
				    int puntos = rset.getInt("puntos");
					
				    clas.put(nombre,puntos);
				}
				
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clas;
	}
	
	
	public ArrayList<JugInscritos> LeerJugEquipo() throws IOException {
		Scanner sc=new Scanner(System.in);
		String equipo="";
		jug=new ArrayList<JugInscritos>();
		System.out.println("Seleccione un equipo");
		equipo=sc.nextLine();
		
		
		
		try {
			
			if (conexion != null) {
				String query = "SELECT T.nombre,L.nombre,L.apellido,L.puesto,L.altura From liga.equipos T,liga.jugadores L WHERE T.id_equipo=L.equipo AND T.nombre='"
								+ equipo + "' ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				String sFichero = "fichero.txt";
				FileWriter file = new FileWriter(sFichero);
				BufferedWriter bw = new BufferedWriter(file);
				while (rset.next()) {
                
					 String nombre = rset.getString("L.nombre");
					 
					 JugInscritos jugador = new JugInscritos();
				   
					 jugador.setNombre(nombre);
					 
					 jug.add(jugador);
					 
					 bw.write(jugador.getNombre());
						bw.newLine();
					 
				    
				}
				bw.close();
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jug;
	}
	
	public ArrayList<JugInscritos> leerJugIns() throws IOException {
		jug=new ArrayList<JugInscritos>();
		try {
			if (conexion != null) {
				String query = "SELECT T.nombre,L.nombre,L.apellido,L.puesto,L.altura From liga.equipos T,liga.jugadores L WHERE T.id_equipo=L.equipo ; ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				
				String sFichero = "fichero.txt";
				FileWriter file = new FileWriter(sFichero);
				BufferedWriter bw = new BufferedWriter(file);
				while (rset.next()) {
                 
				    String nombreEquipo = rset.getString("T.nombre");
				    String nombre = rset.getString("L.nombre");
				    String apellido = rset.getString("L.apellido");
				    String puesto = rset.getString("L.puesto");
				    float altura= rset.getFloat("L.altura");
				    
				    JugInscritos jugador = new JugInscritos();	
					
					jugador.setNombreEquipo(nombreEquipo);
					jugador.setNombre(nombre);
					jugador.setApellido(apellido);
					jugador.setPuesto(puesto);
					jugador.setAltura(altura);
					
					jug.add(jugador);
					
					
					bw.write("El nombre del equipo es "+jugador.getNombreEquipo()+ 
							" " +" , nombreJugador: " + jugador.getNombre() 
							+" " +",apellido: "+ jugador.getApellido() +" " 
							+",puesto:"+ jugador.getPuesto() +" " 
							+",y la altura es de : "+ jugador.getAltura());
					bw.newLine();
				}
				bw.close();
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jug;
	}
	
	
	public ArrayList<JugInscritos> Salarios() throws IOException {
		jug=new ArrayList<JugInscritos>();
		try {
			if (conexion != null) {
				String query = "SELECT MIN(salario), MAX(salario), round(AVG(salario)) From liga.jugadores ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				String sFichero = "fichero.txt";
				FileWriter file = new FileWriter(sFichero);
				BufferedWriter bw = new BufferedWriter(file);
				
				while (rset.next()) {
					int salMin = rset.getInt("MIN(salario)");
					int salMax = rset.getInt("MAX(salario)");
					int salMed = rset.getInt("round(AVG(salario))");
					
					
                    JugInscritos jugador = new JugInscritos();	
					
					jugador.setSalario(salMin);
					bw.write("El salario mínimo es " +jugador.getSalario());
					bw.newLine();
					
					
					jugador.setSalario(salMax);
					bw.write("El salario máximo es "+jugador.getSalario());
					bw.newLine();

					jugador.setSalario(salMed);
					bw.write("El salario medio es "+jugador.getSalario());
					bw.newLine();
					
					jug.add(jugador);
					
					bw.newLine();
					
				}
				bw.close();
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jug;
	}
	
	
	
	
	
	/*public HashMap<Integer,JugInscritos> leerJugIns() {
		HashMap<Integer,JugInscritos>jugadores=new HashMap<Integer,JugInscritos>();
		try {
			if (conexion != null) {
				String query = "SELECT T.nombre,L.nombre,L.apellido,L.puesto,L.altura From liga.equipos T,liga.jugadores L WHERE T.id_equipo=L.equipo ;";
				PreparedStatement pstmt = conexion.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();
				while (rset.next()) {
                 
				    String nombreEquipo = rset.getString("nombre");
				    String nombreJugador = rset.getString("nombre");
				    String apellido=rset.getString("apellido");
				    String puesto=rset.getString("puesto");
				    float altura=rset.getFloat("altura");
				    
				    JugInscritos jug=new JugInscritos(nombreEquipo,nombreJugador,apellido,
				    		puesto,altura);
					
					jugadores.put(1,jug);
				}
				
				pstmt.close();
				rset.close();
			} else {
				System.out.println("conexion Nula");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadores;
	}

	*/
	
	
	
	
	
	
	
			
		
		
	}


