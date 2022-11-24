/**
 * Esta clase contiene los atributos y metodos para realizar el calculo del números de números perfectos en un rango determinado.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */



import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class clienteMultiple
    implements Runnable
{
    /**
     * Método run de las diferentes hebras que ejecutan el código principal de las mismas, la conexión al host
     */
    public void run()
    {
        int i = (int)(Math.random()*10);
        int puerto = 2001;
        try{
            System.out.println("Realizando conexion...");
            Socket cable = new Socket("localhost", puerto);
            System.out.println("Realizada conexion a "+ cable);
            PrintWriter salida= new PrintWriter(
                                    new BufferedWriter(
                                        new OutputStreamWriter(
            cable.getOutputStream())));
            salida.println(i);
            salida.flush();
            System.out.println("Cerrando conexion...");
            cable.close();

            }//try
                catch (Exception e)
        {System.out.println("Error en sockets...");}
    }

    /**
     * Método main de la clase que se encarga de crear la pool de Threads, inicializar las hebras para posteriormente ejecutarlas y finalizar de forma satisfactoria la pool..
     * @throws Exception
     */
    public static void main (String[] args)
        throws Exception
    {
        int tamPool = 10;
        ExecutorService poolThreads = Executors.newFixedThreadPool(tamPool);

        for (int i=0; i<tamPool; i++)
        {
            poolThreads.execute(new clienteMultiple());
        }
        
        poolThreads.shutdown();
        
    }//main
}//Cliente_Hilos

