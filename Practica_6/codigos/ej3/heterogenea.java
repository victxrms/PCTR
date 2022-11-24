/**
 * Esta clase contiene los atributos y metodos para incrementar las variables n y m con diferentes métodos.
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 */


public class heterogenea 
    extends Thread
{
    private static int n = 0;
    private static int m = 0;

    /**
     * Método que devuelve el valor de N para poder mostrarlo en la clase que empleará objetos de esta
     * @return Devuelve el valor de N
     */
    public int muestraN()
    {
        return this.n;
    }

    /**
     * Método que devuelve el valor de M para poder mostrarlo en la clase que empleará objetos de esta
     * @return Devuelve el valor de M
     */
    public int muestraM()
    {
        return this.m;
    }

    /**
     * Método synchronized que incrementa el valor de n
     */
    public synchronized void incrementaN()
    {
        n++;
    }

    /**
     * Método que incrementa el valor de m
     */
    public void incrementaM()
    {
        m++;
    }

    /**
     * Método run que llamará a los otros métodos de la clase
     */
    public void run()
    {
        incrementaN();
        incrementaM();
    }

}   
