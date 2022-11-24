/**
 * Esta clase contiene los atributos y metodos para escribir de manera segura en un array a través de usar synchronized
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.thread
 */

public class arrSeguro 
    extends Thread
{
    static int tam = 100;
    static int array[][] = new int[tam][tam];
    private int ini;
    private int fin;
    private int datoEscribir;

    /**
     * Constructor parametrizado de la clase arrSeguro  
     * @param ini Entero que determinará desde donde empezará a trabajar la hebra
     * @param fin Entero que determinará desde donde dejará de trabajar la hebra
     * @param datoEscribir Entero que determinará el dato a escribir
     * @param array Array 2d de enteros donde escribirán las hebras
     */
    public arrSeguro(int ini, int fin, int datoEscribir, int array[][])
    {
        this.ini = ini;
        this.fin = fin;
        this.datoEscribir = datoEscribir;
        this.array = array;
    }

    /**
     * Método synchronized al tratarse del que escribe sobre la matriz
     */
    public synchronized void escribeDatos()
    {
        for (int i=ini; i<fin; i++)
        {
            for (int j=0; j<tam; j++)
            {
                array[i][j] = datoEscribir;
            }
        }

        System.out.println("Partición escrita");
    }

    /**
     * Método run que llama a los métodos a ejecutar por la hebra
     */
    public void run()
    {
        escribeDatos();
    }

    /**
     * Método main de la clase que inicializará la matriz y las hebras y las pondrá a funcionar
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        int nCores = Runtime.getRuntime().availableProcessors();
        int i = 0;
        int array[][] = new int[tam][tam];
        arrSeguro vHebras[] = new arrSeguro[nCores];
        Thread vThreads[] = new Thread[nCores];

        int particion = tam / nCores;

        for(i = 0; i<nCores-1; i++)
        {
            vHebras[i] = new arrSeguro(i * particion, (i + 1) * particion + (tam/10), i, array); //haciendo esto entramos a escribir en el dominio de otra hebra
            vThreads[i] = new Thread(vHebras[i]);                                                //por lo que si el resultado es correcto comprobaremos que efectivamente synchronized hace su funcion
        }

        vHebras[i] = new arrSeguro(particion * (nCores - 1) , tam, i, array);
        vThreads[i] = new Thread(vHebras[i]);

        for (i=0; i<nCores; i++)
            vThreads[i].start();

        for (i=0; i<nCores; i++)
            vThreads[i].join();

    /** Código para ver por pantalla el resultado de las operaciones
     * 
        for(i = 0; i<tam; i++)
        {
            for (int j=0; j<tam; j++)
                System.out.print(array[i][j] + "");
            System.out.println();
        }
    */      
            
    }


}
