/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos de un producto entre un vector y una matriz.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see matVectorConcurrente, matVector
 */

import java.util.*;

public class matVectorMain 
{
    private int N;
    static private int tam = 10000;
    static private double mat[][] = new double[tam][tam];
    static private double vec[] = new double[tam];
    static private double mult[] = new double[tam];
    static private matVectorConcurrente vHebras[];
    static private Thread vThreads[];

    /**
     * Main de la clase matVectorMain en la que se llamarán a las diferentes clases y sus respectivos métodos
     * @param args Parametros que determinaran el tipo de la función y el número de hebras a emplear.
     * @throws Exception
     */
    public static void main(String[] args)
    throws Exception
    {
        if (args.length == 0)
        {
            System.out.print("Introduce en orden los siguientes argumentos - tipoFuncion (0) Secuencial (1) Paralelismo / El número de hebras 1 | 2 | 4 | 8 | 10 | 12 | 16");
            System.exit(-1);
        }

        int func = Integer.valueOf(args[0]);
        int N = Integer.valueOf(args[1]);

        int particion = tam/N;

        Date d = new Date();

        Random  r = new Random();

        for (int i=0; i<vec.length; i++)
        {
            vec[i] = r.nextDouble();
        }

        switch (func) 
        {
            case 0:

                long inicCron = System.currentTimeMillis(); //se prepara el cronometro
                d.setTime(inicCron); //se activa el cronometro
                
                matVector mV = new matVector(mat, vec);
                mV.funcPrinp();

                long finCron = System.currentTimeMillis(); //se para el cronometro
                d.setTime(finCron);

                System.out.println("El tiempo ha sido de " + (finCron - inicCron) + "ms");

                break;
            
            case 1:

                long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
                d.setTime(inicCronom); //se activa el cronometro
                
                vHebras = new matVectorConcurrente[N];
                vThreads = new Thread[N];
        
                for (int i=0; i<N; i++)
                {
                    vHebras[i] = new matVectorConcurrente(mat, vec, mult, particion * i, particion * (i + 1));
                    vThreads[i] = new Thread(vHebras[i]);
                }
        
                for (int i=0; i<N; i++)
                {
                    vThreads[i].start();
                }

                for (int i=0; i<N; i++)
                {
                    vThreads[i].join();
                }

                long finCronom = System.currentTimeMillis(); //se para el cronometro
                d.setTime(finCronom);

                System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");

                break;
        
            default:
                break;
            
        }
    }
}

