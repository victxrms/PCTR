/**
 * Esta clase contiene los atributos y metodos para ejecutar el tercer intento del algoritmo de Dekker
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */

public class tryThree extends Thread
{    
    static private boolean wantp = false;
    static private boolean wantq = false;
    static public int critico = 0; 
    static private int idHebra;

    /**
     * Constructor parametrizado de la clase tryThree
     * @param id Entero que determina el id de la hebra y con ello el funcionamiento de la misma
     */
    public tryThree(int id)
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
