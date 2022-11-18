/**
 * Esta clase contiene los atributos y metodos para funcionar como servidor que recibe peticiones a través de una poolThread
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.runnable
 */



import java.net.*;
import java.util.concurrent.*;
import java.io.*;

public class ServidorHiloconPool
  implements Runnable
{
    Socket enchufe;

    /**
     * Constructor parametrizado de la clase ServidorHiloconPool
     * @param s Socket que determina a que puerto se conectará el objeto de la clase
     */
    public ServidorHiloconPool(Socket s)
    {enchufe = s;}

    /**
     * Método run de las diferentes hebras que ejecutan el código principal de las mismas, estableciendo como disponible la conexión al host
     */
    public void run()
    {
    try{
        BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
        String datos = entrada.readLine();
        int j;
        int i = Integer.valueOf(datos).intValue();
        for(j=1; j<=20; j++){
        System.out.println("El hilo "+ Thread.currentThread().getName() +" escribiendo el dato "+i);
        Thread.sleep(1000);}
        enchufe.close();
        System.out.println("El hilo "+ Thread.currentThread().getName() +"cierra su conexion...");
    } catch(Exception e) {System.out.println("Error...");}
    }//run

    /**
     * Método main de la clase que se encarga de crear la pool de Threads, inicializar las hebras y posteriormente ejecutarlas.
     */
    public static void main (String[] args)
    {
        ExecutorService poolThreads = Executors.newFixedThreadPool(10);

        int puerto = 2001;
            try{
                ServerSocket chuff = new ServerSocket (puerto, 3000);

                while (true)
                {
                    System.out.println("Esperando solicitud de conexion...");
                    Socket cable = chuff.accept();
                    System.out.println("Recibida solicitud de conexion...");
                    poolThreads.execute(new ServidorHiloconPool(cable));  
                }//while
        } catch (Exception e)
            {System.out.println("Error en sockets...");}
        
    }//main

}//Servidor_Hilos

