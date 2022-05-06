
package udprecibe;

import java.net.*;
public class UDPRecibe{
 public static void main(String args[]){
 try{
 DatagramSocket MiSocket = new DatagramSocket(1400);
 byte[] buffer= new byte[15];
 DatagramPacket Paquete = new
DatagramPacket(buffer, buffer.length);
 MiSocket.receive(Paquete);
 System.out.println(new String(Paquete.getData()));
 MiSocket.close();
 }catch (Exception e){
 System.out.println("Error");
 }
}
}
