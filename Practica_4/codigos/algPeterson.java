/**
 * Esta clase contiene los atributos y metodos para ejecutar el algoritmo de Peterson
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */

public class algPeterson extends Thread
{
    static private int idHebra;
    static private volatile boolean wantp = false;
    static private volatile boolean wantq = false;
    static private volatile int last = 1;
    static public volatile int critico = 0; 

    /**
     * Constructor parametrizado de la clase algDekker
     * @param id Entero que determina el id de la hebra y con ello el funcionamiento de la misma
     */
    public algPeterson(int id)
    {
        this.idHebra = id;
    }

    /**
     * Método que ejecuta el cuerpo de la hebra
     */
    public void run()
    {   
        switch (idHebra) 
        {
            case 0:
                
                while (true)
                {
                    wantp = true;
                    last = 1;
                    while (!wantq || last == 2);
                    critico +=100;  //seccion critica
                    System.out.println(getName());
                    System.out.println(critico);
                    wantp = false;
                }


            case 1:

                while (true)
                {
                    wantq = true;
                    last = 2;
                    while (!wantp || last == 1);
                    critico -=100;  //seccion critica
                    System.out.println(getName());
                    System.out.println(critico);
                    wantq = false;
                }

            default:
                break;
        }
    }

    /**
     * Función principal de la clase
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        Thread h1 = new tryThree(0);
        Thread h2 = new tryThree(1);

        h1.start(); h2.start();
        h1.join(); h2.join();

        System.out.println(critico);
    
    }
}
