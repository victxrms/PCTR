/**
 * Esta clase contiene los atributos y metodos para implementar un cajero con cerrojos reentrantes
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.concurrent.locks.ReentrantLock;

public class cCRL
{
    private int nCuenta;
    private float saldo;
    public static ReentrantLock lock;

    /**
     * Constructor parametrizado de la clase cCRL
     * @param constNCuenta Introduce el nCuenta 
     * @param constSaldo Introduce el saldo
     * @param lock Cerrojo reentrante 
     */
    public cCRL (int constNCuenta, float constSaldo, ReentrantLock lock)
    {
        this.nCuenta = constNCuenta;
        this.saldo = constSaldo;
        this.lock = lock;
    }

    /**
     * Función con la que depositar a un nCuenta
     * @param nCuenta Entero que sirve como nCuenta sobre el que depositar una cantidad
     * @param cantidad Decimal usado como cantidad a depositar sobre el nCuenta
     */
    public void deposito (float cantidad)
    {
        lock.lock();
        try {this.saldo += cantidad;} finally {lock.unlock();}
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
            try {this.saldo -= cantidad;} finally {lock.unlock();}
        }
    }

    /**
     * Método que muestra el saldo por pantalla
     */
    public void mSaldo ()
    {
        System.out.println("El saldo de la cuenta es " + this.saldo);
    }
}