/**
 * Esta clase contiene los atributos y metodos de cajeros
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see Runnable
 */

public class cajero implements Runnable 
{
    private int tipo;

    public cajero (int constTipo)
    {
        this.tipo = constTipo;
    }

    public void run()
    {
        switch (tipo) {
            case 0:
                cCorr.deposito(100);
                break;
        
            case 1:
                cCorr.reintegro(100);
                break;    
            default:
                break;
        }
    }

}
