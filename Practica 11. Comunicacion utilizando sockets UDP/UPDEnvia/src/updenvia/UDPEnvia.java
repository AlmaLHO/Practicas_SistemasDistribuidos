
package updenvia;

import java.net.*;
public class UDPEnvia{
 public static void main(String args[]){
 try{
 DatagramSocket MiSocket = new DatagramSocket();
 byte[] buffer= new byte[15];
 String Mensaje = "Saludos desde el 2022";
 buffer = Mensaje.getBytes();
 DatagramPacket Paquete = new DatagramPacket(buffer,
Mensaje.length(), InetAddress.getByName("localhost"),1400);
 MiSocket.send(Paquete);
 MiSocket.close();
 }catch (Exception exc){
 System.out.println("Error");
 }
}
}