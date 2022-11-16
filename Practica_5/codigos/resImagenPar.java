/**
 * Esta clase contiene los atributos y metodos para realizar el tratamiento de una imagen de manera paralela
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */

import java.util.*;

public class resImagenPar implements Runnable
{
    private int ini;
    private int fin;
    private static int tam = 10000;
    private static int imagenMatrix[][];
    private static int imagenMatrixResultado[][];

    /**
     * Constructor parametrizado de la clase resImagenPar
     * @param imagenMatrix Matriz de entrada
     * @param imagenMatrixResultado Matriz de salida
     * @param ini Entero que determina el inicio de la partición de los datos correspondientes a la hebra
     * @param fin Entero que determina el fin de la partición de los datos correspondientes a la hebra
     */
    public resImagenPar(int imagenMatrix[][], int imagenMatrixResultado[][], int ini, int fin)
    {
        this.imagenMatrix = imagenMatrix;
        this.imagenMatrixResultado = imagenMatrixResultado;
        this.ini = ini;
        this.fin = fin;
    }

    /**
     * Función que rellena la matriz
     */
    public void rellenaMat ()
    {
        
        Random ran = new Random();

        for (int i=ini; i<fin; i++)
        {
            for (int j=0; j<tam; j++)
            {
                imagenMatrix[i][j] = ran.nextInt(6) + 5;
            }
        }

        System.out.println("Partición rellenada");
    }
    
    /**
     * Función que aplica la operación de tratamiento solo a los pixeles centrales, estableciendo los del borde a 0.
     */
    public void tratamiento ()
    {
        for (int i=ini; i<fin; i++)
            for (int j=0; j<tam; j++)
            {
                if (i == 0 || i == tam - 1 || j == 0 || j == tam - 1)
                    imagenMatrixResultado[i][j] = 0;
                else 
                    imagenMatrixResultado[i][j] = ( (4*imagenMatrix[i][j]) - imagenMatrix[i+1][j] - imagenMatrix[i][j+1] - imagenMatrix[i-1][j] - imagenMatrix[i][j-1]) / 8;

            }
        
        System.out.println("Partición tratada");
        
    }

    /**
     * Función que ejecutará cada una de las hebras con su puesta en funcionamiento.
     */
    public void run()
    {
        rellenaMat();
        tratamiento();
    }

    /**
     * Función principal que llama a los métodos de la clase.
     * @param args Define el número de hebras a emplear.
     * @throws Exception
     */
    public static void main(String[] args) 
       throws Exception
    {        
        int N;
        int imagenMatrix [][] = new int[tam][tam];
        int imagenMatrixResultado[][] = new int[tam][tam];
        resImagenPar vHebras[];
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

        vHebras = new resImagenPar[N];
        vThreads = new Thread[N];

        for (int i=0; i<N-1; i++)
        {
            vHebras[i] = new resImagenPar(imagenMatrix, imagenMatrixResultado, particion * i, particion * (i + 1));
            vThreads[i] = new Thread(vHebras[i]);
        }

        vHebras[N-1] = new resImagenPar(imagenMatrix, imagenMatrixResultado, particion * N - 2, tam - 1);
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

