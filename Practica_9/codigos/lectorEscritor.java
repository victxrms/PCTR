/**
 * Esta clase contiene los atributos y metodos para implementar un lector
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class lectorEscritor
{
    private static boolean escribiendo;
    private int lectores;
    private int esperando;
    private ReentrantLock L;
    private Condition escritor;
    private Condition lector;

    /**
     * Constructor no parametrizado.
     */
    public lectorEscritor()
    {
        lectores = 0;
        esperando = 0;
        escribiendo = false;
        L = new ReentrantLock();
        lector = L.newCondition();
        escritor = L.newCondition();
    }

    /**
     * Función que iniciará la lectura
     */
    public void iniciaLectura()
    {
        L.lock();
        esperando++;
        while (escribiendo)
        {
            try {
                lector.await();  
                } catch (Exception e){}
        }
        lectores++;
        lector.signal();
        esperando--;
        L.unlock();
    }

    /**
     * Función que finalizará la lectura
     */
    public void acabarLectura()
    {
        L.lock();
        lectores--;
        if (lectores == 0)
        {
            escritor.signal();
        }
        L.unlock();
    }

    /**
     * Función que iniciará la escritura
     */
    public void iniciaEscritura()
    {
        L.lock();
        while (lectores != 0 || escribiendo)
        {
            
            try {
                escritor.await(); 
            } catch (Exception e){}
        }  
        escribiendo = true;
        L.unlock();
    }

    /**
     * Función que finalizará la escritura
     */
    public void acabarEscritura()
    {
        L.lock();
        escribiendo = false;
        if(esperando == 0)
        {
            escritor.signal();
        }
        else 
        {
            lector.signal();
        }
        L.unlock();
    }   

}