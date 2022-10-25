/**
 * Esta clase contiene los atributos y metodos de cajeros
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see Runnable
 */

public class cajero implements Runnable 
{
    private int tipo;
    static private cuentaCorriente cCorriente;

    /**
     * Constructor parametrizado de la clase cajero
     * @param constTipo Entero que decidirá si el cajero realiza un depósito o un reintegro
     * @param constCCorriente Objeto de la clase cCorriente que establece el atributo cCorriente de la clase
     */
    public cajero (int constTipo, cuentaCorriente constCCorriente)
    {
        this.tipo = constTipo;
        this.cCorriente = constCCorriente;
    }

    public void run()
    {
        switch (tipo) {
            case 0:
                cCorriente.deposito(100);
                break;
        
            case 1:
                cCorriente.reintegro(100);
                break;    
            default:
                break;
        }
    }

}
