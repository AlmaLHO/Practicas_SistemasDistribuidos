
package escritors;
import java.net.*;
import java.io.*;
public class EscritorS {
    
    //El socket escritor es el encargado de escribir en el socket informacion
    public static void main(String[] args) {
       ServerSocket conexion =null;//Socket para aceptar conexion
       Socket canal = null;//socket para establecer el canal de comunicacion
       PrintWriter streamSalida= null;
       
       try{
           conexion =new ServerSocket( 12345 );    
       }catch(IOException ex){
           System.err.println("No se ha podido abrir el puerto");
           System.err.println(ex.toString());
       }
       if (conexion !=null)
           try{//Es el mesaje que imprimira si se logra la conexion
               System.out.println("Proceso escritor,esperando "+
               "la conexion del proceso lector....");
               canal=conexion.accept();
               streamSalida=new PrintWriter(canal.getOutputStream());
               //una vez establacida la conexion
               System.out.println("Conexion establecida, mandando datos"+
                       "al proceso lector...");
               //imprimira los numeros de 0 al 9
               for(int i=0; i<10; i++){
                   streamSalida.println(i);
                   streamSalida.flush();
               }
               System.out.println("Comunicacion finalizada");
           }catch(Exception ex){
               System.err.println("No se ha podido establecer conexion "+
                       "o no ha ocurrido un fallo al escribir en el canal");
               System.err.print(ex.toString());
           }finally{// si esta abierto el socket o el StreamSalida lo que hace es intentar cerrarlo 
               //y capturarlos en caso de que se produzca un error
               if(streamSalida !=null)
                   streamSalida.close();
               if(canal !=null)
                   try{
                       canal.close();
                   }catch (IOException ex){
                       System.err.println("Error al cerrar el socket");
                       System.err.print(ex.toString());
                   }
               if(conexion !=null)
                   try{
                       conexion.close();
                   }catch(IOException ex){
                       System.err.println("Error al cerrar ServerSocket");
                       System.err.print(ex.toString());
                   }
           }
    }
    
}
