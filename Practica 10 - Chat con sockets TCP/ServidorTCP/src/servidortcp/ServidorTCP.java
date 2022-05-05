
package servidortcp;
import java.io.*;
import java.net.*;
public class ServidorTCP {

   public static final int PORT = 4444;
  public static void main(String[] args) throws IOException {
    // el puerto en el que escucha peticiones
    ServerSocket socketServidor = null;
    try {
      socketServidor = new ServerSocket(PORT);
    } catch (IOException e) {
      System.out.println("No puede escuchar en el puerto: " + PORT);
      System.exit(-1);
    }

    Socket socketCliente = null;
    BufferedReader entrada = null;
    PrintWriter salida = null;

    System.out.println("Escuchando: " + socketServidor);
    try {
      // hasta que recibe alguna petición de un cliente abre un socket para el cliente
      socketCliente = socketServidor.accept();
      //mensaje al aceptar la conexion del cliente
      System.out.println("Connexión acceptada: "+ socketCliente);
      // canal de entrada
      entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
      // canal de salida
      salida = new PrintWriter(new BufferedWriter(new 
	  OutputStreamWriter(socketCliente.getOutputStream())),true);
      
      // Mientras recibe un mensaje este la imprime, si es adios se cierra 
      while (true) {  
        String str = entrada.readLine();
	System.out.println("Cliente: " + str);
	salida.println(str);
	if (str.equals("Adios")) break;
      }

    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }  
    salida.close();
    entrada.close();
    socketCliente.close();
    socketServidor.close();
  }
}