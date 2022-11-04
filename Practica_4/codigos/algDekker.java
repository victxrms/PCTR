/**
 * Esta clase contiene los atributos y metodos para ejecutar el algoritmo de Dekker
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */


public class algDekker extends Thread
{
    static private int idHebra;
    static private volatile boolean wantp = false;
    static private volatile boolean wantq = false;
    static private volatile int turn = 1;
    static public volatile int critico = 0; 

    /**
     * Constructor parametrizado de la clase algDekker
     * @param id Entero que determina el id de la hebra y con ello el funcionamiento de la misma
     */
    public algDekker(int id)
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
                        if (turn == 2)
                        {
                            wantp = false;
                            while (turn != 1);
                            wantp = true;
                        }
                    critico +=100;  //seccion critica
                    System.out.println(getName());
                    System.out.println(critico);
                    turn = 2;
                    wantp = false;
                }


            case 1:

                while (true)
                {
                    wantq = true;
                    while (wantp);
                        if (turn == 1)
                        {
                            wantq = false;
                            while (turn != 2);
                            wantq = true;
                        }
                    critico -=100;  //seccion critica
                    System.out.println(getName());
                    System.out.println(critico);
                    turn = 1;
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
