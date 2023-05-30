/**
 * Esta clase contiene los atributos y metodos para realizar el calculo del números de números perfectos en un rango determinado de forma paralela.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.callable
 */

import java.util.*;
import java.util.concurrent.*;

 public class numPerfectosParalelo implements Callable<Integer>
 {
    private int ini;
    private int fin;

    /**
     * Constructor parametrizado de la clase numPerfectosParalelo
     * @param ini   Inicio de la hebra 
     * @param fin   Fin de la hebra
     */
    public numPerfectosParalelo(int ini, int fin)
    {
        this.ini = ini;
        this.fin = fin;
    }

    /**
     * Función que ejecuta el cuerpo de los diferentes Callables
     */
    public Integer call()
    {
        Integer cantidad = 0;

        for (int i=ini; i<=fin; i++)
        {
            int sumadivisores = 0;
            
            for (int divisor=1; divisor<=i/2; divisor++)
            {
                
                if(i%divisor==0 && i!=divisor)
                {
                    sumadivisores+= divisor;
                }   
            }

            if (sumadivisores == i)
            {
                cantidad++;
            }
            
        }

        return cantidad;
    }

    public static void main(String[] args) 
        throws Exception
    {

        Integer contador = 0;

        if (args.length == 0)
        {
            System.out.print("Introduce el rango de números y el número de hebras 1 | 2 | 4 | 8 | 10 | 12 | 16");
            System.exit(-1);
        }
        
        int inicio = Integer.valueOf(args[0]);
        int finalo = Integer.valueOf(args[1]);
        int N = Integer.valueOf(args[2]);

        int i = 0;

        int particion = (finalo-inicio)/N;

        Date d = new Date();
        
        long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
        d.setTime(inicCronom); //se activa el cronometro

        ExecutorService sPools = Executors.newFixedThreadPool(N);
        List<Future<Integer>> lFutures = new ArrayList<Future<Integer>>();

        for (i = 0; i < (N - 1); i++) {
            lFutures.add(sPools
                    .submit(new numPerfectosParalelo((inicio + (particion * i)), (inicio + (particion * (i + 1))))));
        }

        lFutures.add(sPools.submit(new numPerfectosParalelo((inicio + (i * particion)), finalo)));

        for (int j = 0; j < lFutures.size(); j++) {
            contador += lFutures.get(j).get();
        }
        
        long finCronom = System.currentTimeMillis(); //se para el cronometro
        d.setTime(finCronom);

        System.out.println("La cantidad números perfectos en un rango de [" + inicio + ", " + finalo + "] números naturales es de " +  contador);
        System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");

        sPools.shutdown();



    }
    
 }
