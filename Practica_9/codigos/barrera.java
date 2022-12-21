/**
 * Esta clase contiene los atributos y metodos para implementar tres hebras que se citen en una barrera
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.concurrent.CyclicBarrier;

public class barrera implements Runnable
{
    public static CyclicBarrier barreraCic;
    private static int element = 0;

    /**
     * Constructor parametrizado de la clase barrera
     * @param barrera Parámetro de tipo CyclicBarrier que establecerá una barrera para el objeto de la clase
     */
    public barrera(CyclicBarrier barrera)
    {
        this.barreraCic = barrera;
    }

    /**
     * Método run de la clase barrera que ejecutrá al hacer funcionar la hebra, aumentando el valor del atributo element.
     */
    public void run()
    {
        this.element++;
    }    
    
    /**
     * Método main de la clase barrera que se encarga de crear los objetos CyclicBarrier así como el objeto de la clase barrera para posteriormente
     * pasarselo a los constructores de las hebras para su inicialización y puesta en funcionamiento.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception 
    {
        CyclicBarrier barreraCiclica = new CyclicBarrier(3);
        barrera barrier = new barrera(barreraCiclica);

        Thread tBarrera1 = new Thread(barrier);
        Thread tBarrera2 = new Thread(barrier);
        Thread tBarrera3 = new Thread(barrier);

        tBarrera1.start(); tBarrera2.start(); tBarrera3.start();
        tBarrera1.join(); tBarrera2.join(); tBarrera3.join();
    }
}
