/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos de un producto escalar entre dos vectores.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see prodEscalarParalelo
 */


public class prodEscalar 
{
    private static double[] vec1;
    private static double[] vec2;
    private int tam;

    /**
     * Constructor parametrizado de la clase prodEscalarParalelo
     * @param vec1[] Primer vector
     * @param vec2[] Segundo vector
     */
    public prodEscalar (double vec1[], double vec2[], int N)
    {   
        this.vec1 = vec1;
        this.vec2 = vec2;
        this.tam = N;
    }

    /**
     * Función que rellena los vectores
     */
    public void rellena()
    {
        for (int i=0; i<tam; i++){vec1[i] = Math.random(); vec2[i] = Math.random();}
    }

    /**
     * Función principal que realiza el producto escalar y lo muestra por pantalla
     */
    public void funcPrinp()
    {
        double res = 0;

        rellena();

        for (int i=0; i<tam; i++){res += vec1[i] * vec2[i];}

        System.out.println("El valor del producto escalar de los dos vectores es: " + res);

    }
}
