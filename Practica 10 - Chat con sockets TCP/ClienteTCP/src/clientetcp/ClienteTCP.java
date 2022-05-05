
package clientetcp;
//La clase java.net.InetAddress nos permite representar en Java direcciones IP
import java.net.*;
import java.io.*;
public class ClienteTCP {

    public static void main(String[] args)  throws IOException {
      Socket socketCliente = null;
      BufferedReader entrada = null;
      PrintWriter salida = null;

      // hacer el socket del lado cliente enlazado con un servidor que está en la misma máquina que el cliente 
      //y que escucha en el puerto 4444
      try {
        socketCliente = new Socket("localhost", 4444);
        //canal de entrada
        entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        //canal de salida
        salida = new PrintWriter(new BufferedWriter(new 
	OutputStreamWriter(socketCliente.getOutputStream())),true);
      } catch (IOException e) {
        System.err.println("No puede establer canales de E/S para la conexión");
	System.exit(-1);
      }
      BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
  
      String linea;
      // El programa cliente no analiza los mensajes enviados por el
      // usario solo los reenvía al servidor hasta que este se despide con "Adios"

      try {
        while (true) {
         // Leer la entrada del usuario
         linea = stdIn.readLine();
         // La envia al servidor
         salida.println(linea);
         // Envía a la salida la respuesta del servidor
         linea = entrada.readLine();
         System.out.println("Respuesta servidor: " + linea);
	 // Si es "Adios" es que finaliza la comunicación
	 if (linea.equals("Adios")) break;
	}
      } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
      }
      salida.close();
      entrada.close();
      stdIn.close();
      socketCliente.close();
   }
}
		