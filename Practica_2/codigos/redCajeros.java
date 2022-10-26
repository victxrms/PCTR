/**
 * Esta clase contiene los atributos y metodos de una cuenta corriente
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see cuentaCorriente cajero
 */

public class redCajeros 
{

    /**
     * Main que crea y ejecuta los diferentes hilos que se encargan de sustraer y depositar una cantidad, mostrando por pantalla al final el saldo de la cuenta
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        cuentaCorriente c = new cuentaCorriente(1601, 0);
        cajero r = new cajero(0, c);
        cajero s = new cajero(1, c);
        Thread u1 = new Thread(r);
        Thread u2 = new Thread(s);
        u1.start();
        u2.start();

        c.mSaldo();
    }
}