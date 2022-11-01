/**
 * Esta clase contiene los atributos y metodos para ejecutar los cálculos de un producto escalar entre dos vectores.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */


public class prodEscalarParalelo extends Thread
{
    static double[] vec1;
    static double[] vec2;
    static double[] productoParcial;
    private int ini;
    private int fin;
    private int idHebra;

    /**
     * Constructor parametrizado de la clase prodEscalarParalelo
     * @param idHebra Entero que determina el id de la hebra
     * @param ini Entero que determina el inicio de la particion
     * @param fin Entero que determina el fin de la particion
     * @param vec1[] Primer vector
     * @param vec2[] Segundo vector
     * @param productoParcial[] Vector donde se guardará en la posicion idHebra, el producto escalar de la particion correspondiente
     */
    public prodEscalarParalelo (int idHebra, int ini, int fin, double vec1[], double vec2[], double productoParcial[])
    {   
        this.idHebra = idHebra;
        this.ini = ini;
        this.fin = fin;

        this.vec1 = vec1;
        this.vec2 = vec2;
        this.productoParcial = productoParcial;
        
    }

    /**
     * Función que rellena los vectores con elementos aleatorios 
     */
    public void  rellena()
    {
        for (int i = ini; i < fin; i++){vec1[i] = Math.random(); vec2[i] = Math.random();}
    }

    /**
     * Función que calcula el escalar del vector
     */
    public void  prod()
    {
        for (int i = ini; i < fin; i++){productoParcial[idHebra] = vec1[i] * vec2[i];}
    }

    /**
     * Función principal de la clase en la que se llama a rellena() y escala().
     */
    public void run()
    {
        rellena();
        prod();
        System.out.println("Partición escalada.");
    }
}
