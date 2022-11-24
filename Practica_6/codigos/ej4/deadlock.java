/**
 * Esta clase contiene los atributos y metodos para conseguir que tres hebras entren en deadlock usando sychronized.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */


public class deadlock 
    extends Thread
{
    /**
     * Método main de la clase donde crearemos tres hebras así como tres objetos diferentes para los cerrojos synchronized.
     * Para lograrlo haremos que el funcionamiento de las hebras dependan de las ejecuciones del resto.
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        final Object region_A = new Object();
        final Object region_B = new Object();
        final Object region_C = new Object();

        Thread hA = new Thread()
        {
            public void run()
            {
                synchronized(region_A)
                {
                    synchronized(region_B)
                    {
                        synchronized(region_C)
                        {
                            System.out.println("Este es el hilo A");
                        }
                    }
                }        
            }
        };
        
        Thread hB = new Thread()
        {
            public void run()
            {
                synchronized(region_B)
                {
                    synchronized(region_C)
                    {
                        synchronized(region_A)
                        {
                            System.out.println("Este es el hilo B");
                        }
                    }
                }          
            }
        };

        Thread hC = new Thread()
        {
            public void run()
            {
                synchronized(region_C)
                {
                    synchronized(region_A)
                    {
                        synchronized(region_B)
                        {
                            System.out.println("Este es el hilo C");
                        }
                    }
                }           
            }
        };

        hA.start();
        hB.start();
        hC.start();

        hA.join();
        hB.join();
        hC.join();
    }
}
