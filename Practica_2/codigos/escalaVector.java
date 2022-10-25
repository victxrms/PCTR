/**
 * Esta clase contiene los atributos y metodos de escalaVector, es decir, la versión secuencial
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */


public class escalaVector 
{
    static private int N;
    private int escalar;
    private int i = 0;

    /**
     * Constructor parametrizado de la clase escalaVector
     * @param N Entero que funciona como tamaño del vector
     * @param escalar Entero que funciona como scalar por el que multiplicar los elementos del vector
     */
    escalaVector(int N, int escalar)
    {
        this.N = N;
        this.escalar = escalar;

    }

    /**
     * Función que rellena el vector con elementos aleatorios 
     * @param vec Vector a rellenar
     */
    public void rellena(double vec[])
    {
        for (i = 0; i < vec.length; i++) {vec[i] = Math.random();};
        System.out.println("Vector relleno.");
        
    }

    /**
     * Función que calcula el escalar del vector
     * @param vec Vector a escalar
     */
    public void escala(double vec[])
    {
        for (i = 0; i < vec.length; i++) {vec[i] = vec[i] * escalar;};
    }

    /**
     * Función principal de la clase en la que se llama a rellena() y escala().
     * @param vec Vector a llenar y escalar
     */
    public void funcPrinp(double vec[])
    {
        rellena(vec);
        escala(vec);
        System.out.println("Vector escalado.");
    }


}
