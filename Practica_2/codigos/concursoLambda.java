/**
 * Esta clase contiene los atributos y metodos de concursoLambda
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see Runnable
 */

public class concursoLambda
{   
    private static int concursoEntero[] = {1};

    /**
     * Función que inicia dos hilos que acceden a la vez a la variable compartida concursoEntero
     * @param args
     * @throws Exception
     */
    public static void main (String[] args) throws Exception
    {
      Runnable runnable0 = () -> {
        for (int i=0; i<= 100000; i++) concursoEntero[0]++;
      };
      Runnable runnable1 = () -> {
        for (int i=0; i<= 100000; i++) concursoEntero[0]--;
      };
  
    Thread thread0 = new Thread(runnable0);
    Thread thread1 = new Thread(runnable1);
    thread0.start();
    thread1.start();
    thread0.join();
    thread1.join();
    System.out.println("El valor de la variable compartida es: " + concursoEntero[0]);
    }
  }