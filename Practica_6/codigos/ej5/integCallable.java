/**
 * Esta clase contiene los atributos y metodos para realizar la integración paralela de Monte-Carlo para paroximar la integral definida de la función f(X) = cos(x) en [0, 1]
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.util.concurrent.Callable, java.util.concurrent.Future
 */

 import java.util.*;
 import java.util.concurrent.*;;

public class integCallable 
    implements Callable<Integer>
{
    private int vueltas;
    
    public integCallable(int n)
    {vueltas = n;}

    /**
     * Método call que ejecutará el cuerpo de los objetos Callable
     */
    public Integer call()
    {
        Integer intentos = 0;

        Random r = new Random();

        double cx = r.nextDouble();
        double cy = r.nextDouble();

        for(int i=0; i<vueltas; i++)
        {
            cx = r.nextDouble();
            cy = r.nextDouble();

            if (cy <= Math.cos(cx))
                intentos++;
                
        }

        return intentos;
    }

    /**
     * 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        int nVueltas = 10000000;
        int nThreads = Runtime.getRuntime().availableProcessors();

        Integer intentos = 0;

        ExecutorService sPools = Executors.newFixedThreadPool(nThreads);
        List<Future<Integer>> lFutures = new ArrayList<Future<Integer>>();

        for (int i = 0; i < nThreads; i++) 
        {
            lFutures.add(sPools.submit(new integCallable(nVueltas/nThreads)));
        }

        for (int j = 0; j < lFutures.size(); j++) 
        {
            intentos += lFutures.get(j).get();
        }

        sPools.shutdown();

        while(!sPools.isTerminated());
        
        System.out.println("Aproximacion: " + ((double)intentos/nVueltas));

        
    }
}