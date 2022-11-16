/**
 * Esta clase contiene los atributos y metodos para realizar el producto de dos matrices de forma paralela
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Runnable
 */

import java.util.*;


public class prodMatricesParalelo implements Runnable
{
    private static double mat1[][];
    private static double mat2[][];
    private static double mult[][];
    private int ini;
    private int fin;
    private int tam;

    /**
     * Constructor parametrizado de la clase prodMatricesParalelo
     * @param mat1 Matriz a multiplicar
     * @param mat2 Matriz a multiplicar
     * @param mult Matriz de resultados
     * @param ini Entero que determina el inicio de la partición de los datos correspondiente a la hebra
     * @param fin Entero que determina el fin de la partición de los datos correspondiente a la hebra
     */
    public prodMatricesParalelo( double mat1[][], double mat2[][], double mult[][], int ini, int fin)
    {
        this.mat1 = mat1;
        this.mat2 = mat2;
        this.mult = mult;
        this.ini = ini;
        this.fin = fin;
        this.tam = mat1.length;
    }

    /**
     * Función que rellena las matrices
     */
    public void rellenaMat()
    {
        Random  r = new Random();

        for (int i=ini; i<fin; i++)
        {
            for (int j=0; j<tam; j++)
            {
                mat1[i][j] = r.nextDouble();
                mat2[i][j] = r.nextDouble();
            }
        }

        System.out.println("Partición rellenada");
    }

    /**
     * Función que multiplica las matrices
     */
    public void multiplicamat()
    {
        for (int i=ini; i<fin; i++)
            for (int j=0; j<tam; j++)
                for (int k=0; k<tam;k++)
                     mult[i][j] += mat1[i][k] * mat2[k][j];

        System.out.println("Partición multiplicada");
    }

    /**
     * Función principal de la clase que llama al resto para calcular el producto de las matrices
     */
    public void run()
    {
        rellenaMat();
        multiplicamat();
    }

    /**
     * Main de la clase prodMatricesParalelo en la que se llamarán a las diferentes clases y sus respectivos métodos
     * @param args Define el número de hebras a emplear.
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {

        int N;
        int tam = 1000;
        double mat[][] = new double[tam][tam];
        double vec[][] = new double[tam][tam];
        double mult[][] = new double[tam][tam];
        prodMatricesParalelo vHebras[];
        Thread vThreads[];

        if (args.length == 0)
        {
            System.out.print("Introduce el número de hebras 1 | 2 | 4 | 8 | 10 | 12 | 16");
            System.exit(-1);
        }
        
        N = Integer.valueOf(args[0]);

        int particion = tam/N;

        Date d = new Date();
        
        long inicCronom = System.currentTimeMillis(); //se prepara el cronometro
        d.setTime(inicCronom); //se activa el cronometro
        
        vHebras = new prodMatricesParalelo[N];
        vThreads = new Thread[N];
    
        for (int i=0; i<N-1; i++)
        {
            vHebras[i] = new prodMatricesParalelo(mat, vec, mult, particion * i, particion * (i + 1));
            vThreads[i] = new Thread(vHebras[i]);
        }

        vHebras[N-1] = new prodMatricesParalelo(mat, mat, mult, particion * N - 2, tam - 1);
        vThreads[N-1] = new Thread(vHebras[N]);
        
        for (int i=0; i<N; i++)
            vThreads[i].start();

        for (int i=0; i<N; i++)
            vThreads[i].join();

        long finCronom = System.currentTimeMillis(); //se para el cronometro
        d.setTime(finCronom);

        System.out.println("El tiempo ha sido de " + (finCronom - inicCronom) + "ms");
            
    }
}

