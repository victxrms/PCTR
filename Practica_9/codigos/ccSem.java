/**
 * Esta clase contiene los atributos y metodos para implementar un cajero con semaforos
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.util.concurrent.Semaphore;

public class ccSem 
{
    private int nCuenta;
    private float saldo;
    public static Semaphore sem;

    /**
     * Constructor parametrizado de la clase cCRL
     * @param constNCuenta Introduce el nCuenta 
     * @param constSaldo Introduce el saldo
     * @param lock Cerrojo reentrante 
     */
    public ccSem (int constNCuenta, float constSaldo, Semaphore sem)
    {
        this.nCuenta = constNCuenta;
        this.saldo = constSaldo;
        this.sem = sem;
    }

    /**
     * Función con la que depositar a un nCuenta
     * @param nCuenta Entero que sirve como nCuenta sobre el que depositar una cantidad
     * @param cantidad Decimal usado como cantidad a depositar sobre el nCuenta
     */
    public void deposito (float cantidad)
    {
        try{sem.acquire();} catch (InterruptedException e) {};
        try {this.saldo += cantidad;} finally {sem.release();}
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
            try{sem.acquire();} catch (InterruptedException e) {};
            try {this.saldo -= cantidad;} finally {sem.release();}
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
