/**
 * Esta clase contiene los atributos y metodos para llamar a los métodos de la clase heterogenea y usar sus métodos
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */


public class usaheterogenea 
    extends Thread
{

    static private heterogenea vHebras[];
    
    /**
     * Método main de la clase que inicializa las hebras y las ejecuta, mostrando los valores de n y m.
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        int nCores = Runtime.getRuntime().availableProcessors();
        vHebras = new heterogenea[nCores];

        for(int i = 0; i<nCores; i++)
        {
            vHebras[i] = new heterogenea();
        }

        for (int i=0; i<nCores; i++)
            vHebras[i].start();

        for (int i=0; i<nCores; i++)
            vHebras[i].join();

        System.out.println("El valor de n es " + vHebras[0].muestraN());
        System.out.println("El valor de m es " + vHebras[0].muestraM());
            
    }
}
