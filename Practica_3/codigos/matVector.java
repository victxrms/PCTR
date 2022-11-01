/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos para el producto de una matriz por un vector.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see Runnable, Random
 */

import java.util.*;

public class matVector
{
    private double mat[][];
    private double vec[];
    private double mult[];

    /**
     * Constructor parametrizado de la clase matVector
     * @param mat Matriz a multiplicar
     * @param vec Vector a multiplicar
     */
    public matVector(double mat[][], double vec[])
    {
        this.mat = mat;
        this.vec = vec;
        this.mult = new double[vec.length];
    }

    /**
     * Función que rellena la matriz a multiplicar
     */
    public void rellenaMat()
    {
        Random  r = new Random();

        for(int i=0; i < vec.length; i++)
        {
            for(int j=0; j < vec.length; j++)
            {
                mat[i][j] = r.nextDouble();
            }
        }

        System.out.println("Matriz rellena");

    }

    /**
     * Función que rellena el vector a multiplicar
     */
    public void rellenaVec()
    {
        Random  r = new Random();

        for(int i=0; i < vec.length; i++)
        {
            vec[i] = r.nextDouble();
        }

        System.out.println("Vector relleno");

    }

    /**
     * Función que multiplica la matriz por el vector y almacena los datos en el vector mult
     */
    public void multiplicaMatVec()
    {

        for(int i=0; i < vec.length; i++)
        {
            for(int j=0; j < vec.length; j++)
            {
                mult[i] += mat[i][j] * vec[i];
            }
        }

        System.out.println("Multiplicacion finalizada");

    }

    /**
     * Función principal de la clase que llama al resto para calcular el producto de la matriz y el vector
     */
    public void funcPrinp()
    {
        rellenaMat();
        rellenaVec();
        multiplicaMatVec();
    }

}
