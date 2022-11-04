/**
 * Esta clase contiene los atributos y metodos para ejecutar el cuarto intento del algoritmo de Dekker
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */


public class tryFour extends Thread
{
    static private int idHebra;
    static private volatile boolean wantp = false;
    static private volatile boolean wantq = false;
    static public volatile int critico = 0; 

    /**
     * Constructor parametrizado de la clase tryFour
     * @param id Entero que determina el id de la hebra y con ello el funcionamiento de la misma
     */
    public tryFour(int id)
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
                    while (wantq);
                    wantp = false;
                    wantp = true;
                    critico +=100;  //seccion critica
                    System.out.println(getName());
                    System.out.println(critico);
                    wantp = false;
                }


            case 1:

                while (true)
                {
                    wantq = true;
                    while (wantq);
                    wantq = false;
                    wantq = true;
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
