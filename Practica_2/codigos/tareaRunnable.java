/**
 * Esta clase contiene los atributos y metodos de tareaRunnable a través de la interfaz Runnable
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Runnable
 */

public class tareaRunnable implements Runnable
{
    private int tipoTarea;
    private static int n = 0;

    /**
     * Metodo constructor parametrizado
     * @param tipoTarea Define el tipo de tarea que será
     */
    public tareaRunnable(int tipoTarea) {this.tipoTarea = tipoTarea;}

    /**
     * Método inc encargado de incrementar y n
     */
    public void inc(){n++;}

    /**
     * Método run encargado de decrementar n
     */
    public void dec(){n--;}

    /**
     * Metodo run que llama al metodo inc() o dec() en función de la variable tipoTarea de tareaRunnable
     */
    public void run()
    {
        switch(tipoTarea)
        {
            case 0: for(int i=0; i<100000; i++)inc(); break;
            case 1: for(int i=0; i<100000; i++)dec(); break;
        }    
    }

    /**
     * Método vDato encargado de devolver n
     * @return Devuelve n
     */
    public int vDato(){return(n);}
    
}
