
package lectors;
import java.net.*;
import java.io.*;
public class LectorS {

    public static void main(String[] args) {
       Socket canal =null; //Socket para establecer el canal de conexcion con el escritor
       BufferedReader entrada =null;
       String valorEntrada =null;//Valores que iremos leyendo del canal
       
       try{//contructor de socket que se le asigna una direecion ip 
           //localhost porque estan en el mismo equipo y nos conectamos en el puerto 
           //es lo que se utilizara para comunicarse
           canal=new Socket("localhost", 12345 );
       }catch (Exception ex){
           System.err.println("No se ha podido establecer conexion");
           System.err.println(ex.toString());
       }
       if(canal !=null)//si el canal existe establecemos la comunicacion
           try{
               entrada = new BufferedReader(new InputStreamReader(canal.getInputStream()));
               while((valorEntrada =entrada.readLine())!=null){
                   //mientras haya valores imprimimos y separados por **
                   System.out.println(valorEntrada);
                   System.out.println("**");
               }
           }catch (Exception ex){
               System.err.println("NO se ha podido establecer conexion");
               System.err.println(ex.toString());
           }finally{//Cerramos la entrada y el socket
               if(entrada !=null)
                   try{
                       entrada.close();
                   }catch (IOException ex){
                       System.err.println("Se ha prodicido un error al cerrar el InputStreamReader");
                       System.err.println(ex.toString());
                   }
               if(canal !=null)
                   try{
                       canal.close();
                   }catch (IOException ex){
                       System.err.println("Se ha producido un error al cerrar el Socket");
                       System.err.println(ex.toString());
                   }
           }
    }
    
}
