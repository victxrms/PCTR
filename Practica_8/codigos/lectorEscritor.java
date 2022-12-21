/**
 * Esta clase contiene los atributos y metodos para implementar los métodos de los objetos lectorEscritor
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/
public class lectorEscritor
{
    private static boolean escribiendo;
    private int lectores;
    private int esperando;

    /**
     * Constructor sin parámetros que establece los valores de los diferentes objetos de la clase lectorEscritor
     */
    public lectorEscritor()
    {
        lectores = 0;
        esperando = 0;
        escribiendo = false;
    }

    /**
     * Función que iniciará la lectura
     */
    synchronized public void iniciaLectura()
    {
        esperando++;
            while (escribiendo)
            {
                try {
                    wait();    
                    } catch (Exception e){}
            }

            lectores++;
            notifyAll();  
            esperando--;
        
    }

    /**
     * Función que finalizará la lectura
     */
    synchronized public void acabarLectura()
    {
        lectores--;
        if (lectores == 0)
        {
            notifyAll();
        }
    }

    /**
     * Función que iniciará la escritura
     */
    synchronized public void iniciaEscritura()
    {
        while (lectores != 0 || escribiendo)
        {
            
            try {
                wait(); 
            } catch (Exception e){}
        }  
        escribiendo = true;
    }

    /**
     * Función que finalizará la escritura
     */
    synchronized public void acabarEscritura()
    {
        escribiendo = false;
        if(esperando == 0)
            {
                notifyAll();
            }
        else 
            {
                notifyAll();
            }
    }

}
