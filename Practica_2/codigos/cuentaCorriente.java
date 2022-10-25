/**
 * Esta clase contiene los atributos y metodos de una cuenta corriente
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
 * @see cajero
 */

public class cuentaCorriente 
{
    private int nCuenta;
    private float saldo;

    /**
     * Constructor parametrizado de la clase cuentaCorriente
     * @param constNCuenta Introduce el nCuenta 
     * @param constSaldo Introduce el saldo
     */
    public cuentaCorriente (int constNCuenta, float constSaldo)
    {
        this.nCuenta = constNCuenta;
        this.saldo = constSaldo;
    }

    /**
     * Función con la que depositar a un nCuenta
     * @param nCuenta Entero que sirve como nCuenta sobre el que depositar una cantidad
     * @param cantidad Decimal usado como cantidad a depositar sobre el nCuenta
     */
    public void deposito (float cantidad)
    {
        this.saldo += cantidad;
    }

    /**
     * Función con la que sacar una cantidad de un nCuenta
     * @param nCuenta Entero que sirve como nCuenta sobre el que retirar una cantidad
     * @param cantidad Decimal usado como cantidad a retirar sobre el nCuenta
     */
    public void reintegro (float cantidad)
    {
        if (this.saldo > cantidad)
        {
            this.saldo -= cantidad;
        }
    }

    public void mSaldo ()
    {
        System.out.println("El saldo de la cuenta es " + this.saldo);
    }
}
