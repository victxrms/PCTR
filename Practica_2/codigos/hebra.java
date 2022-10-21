
/**
 * Esta clase contiene los atributos y metodos de una hebra
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see java.lang.Thread
 */

public class hebra extends Thread
{
    private int tipoHebra;
    private int nVueltas;
    private static int n = 0;
    
    /**
     * Metodo constructor parametrizado
     * @param nVueltas número de vueltas a realizar por la hebra
     * @param tipoHebra Define el tipo de hebra que será 
     */
    public hebra (int nVueltas, int tipoHebra)
    {this.nVueltas = nVueltas; this.tipoHebra = tipoHebra;}

    /**
     * Método vDato encargado de devolver n
     * @return Devuelve n
     */
    public int vDato(){return(n);}
    
    /**
     * Método run encargado de incrementar y decrementar n
     */
    public void run()
    {
        switch(tipoHebra)
        {
            case 0: for(int i=0; i<nVueltas; i++)hebra.n++; break;
            case 1: for(int i=0; i<nVueltas; i++)hebra.n--; break;
        }    
    }
}
