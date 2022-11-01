/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos para el producto de una matriz por un vector.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Runnable, Random
 */

import java.util.*;

public class matVectorConcurrente implements Runnable 
{
    private static double mat[][];
    private static double vec[];
    private static double mult[];
    private int ini;
    private int fin;
    private int tam;

    /**
     * Constructor parametrizado de la clase matVectorConcurrente
     * @param mat Matriz a multiplicar
     * @param vec Vector a multiplicar
     * @param mult Vector de resultados
     * @param ini Entero que determina el inicio de la partición de los datos correspondiente a la hebra
     * @param fin Entero que determina el fin de la partición de los datos correspondiente a la hebra
     */
    public matVectorConcurrente( double mat[][], double vec[], double mult[], int ini, int fin)
    {
        this.mat = mat;
        this.vec = vec;
        this.mult = mult;
        this.ini = ini;
        this.fin = fin;
        this.tam = vec.length;
    }

    /**
     * Función que rellena la matriz
     */
    public void rellenaMat()
    {
        Random  r = new Random();

        for (int i=ini; i<fin; i++)
        {
            for (int j=0; j<tam; j++)
            {
                mat[i][j] = r.nextDouble();
            }
        }

        System.out.println("Partición rellenada");
    }

    /**
     * Función que multiplica la matriz y el vector
     */
    public void multiplicaMatVec()
    {
        for (int i=ini; i<fin; i++)
        {
            for (int j=0; j<tam; j++)
            {
                mult[i] += mat[i][j] * vec[i];
            }
        }

        System.out.println("Partición multiplicada");
    }

    /**
     * Función principal de la clase que llama al resto para calcular el producto de la matriz y el vector
     */
    public void run()
    {
        rellenaMat();
        multiplicaMatVec();
    }
    
}
