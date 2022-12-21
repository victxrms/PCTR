/**
 * Esta clase contiene los atributos y metodos para implementar diferentes métodos para comprobar los tiempos de ejecución
 * dependiendo de diferentes métodos de sincronización.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class tiempos 
{   
    /**
     * Método que implementa el uso de semáforos para comprobar el tiempo que tarda en realizar las diferentes iteraciones
     * @param iter Variable de tipo long que determina el número de iteraciones a realizar.
     * @return
     */
    public static long f(long iter){
        int n = 0;
        Semaphore s = new Semaphore(1);
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++){
        try{s.acquire();}catch(InterruptedException e){}
        try{n++;}
        finally{s.release();}
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }

    /**
     * Método que implementa el uso de cerrojos synchronized para comprobar el tiempo que tarda en realizar las diferentes iteraciones
     * @param iter Variable de tipo long que determina el número de iteraciones a realizar.
     * @return
     */
    public static long g(long iter){
        int n = 0;
        Object o = new Object();
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++){
        synchronized(o){n++;}
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }
    
    /**
     * Método que implementa el uso de cerrojos reentrantes para comprobar el tiempo que tarda en realizar las diferentes iteraciones
     * @param iter Variable de tipo long que determina el número de iteraciones a realizar.
     * @return
     */
    public static long h(long iter){
        int n = 0;
        ReentrantLock rE = new ReentrantLock();
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++)
        {
            rE.lock();
            try {n += n;} finally {rE.unlock();}
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }

    /**
     * Método que implementa el uso de objetos de tipo atómico para comprobar el tiempo que tarda en realizar las diferentes iteraciones
     * @param iter Variable de tipo long que determina el número de iteraciones a realizar.
     * @return
     */
    public static long i(long iter){
        AtomicInteger n = new AtomicInteger(0);
        long ini=System.nanoTime();
        for(long i=0; i<iter; i++)
        {
            n.incrementAndGet();
        }
        long fin=System.nanoTime();
        return(fin-ini);
    }

    /**
     * Método principal que llama a los diferentes métodos aumentando el número de iteraciones y muestra el tiempo de ejecución de cada una de estos.
     * @param args
     */
      public static void main(String[] args){

        for (long i = 10; i <= 100000000; i = i*10)
        {
            System.out.println(i + " " + f(i) + " " + g(i) + " " + h(i) + " " + i(i));
        }
      }  
}
