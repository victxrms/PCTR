/**
 * Esta clase contiene los atributos y metodos para implementar el servidor del calculo de pi a través del método montecarlo
 * @author Victor Moreno Sola
 * @version 1.0-PCTR
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo
{
    private double cX, cY;
    private int intentos = 0;
    private int nVueltas = 1;

    /**
     * Constructor vacio para poder lanzar la excepecion RemoteException
     * @throws RemoteException
     */
    public sPiMonteCarlo() throws RemoteException {}

    /**
     * Método que suma al número de puntos del objeto los que recibe como parámetro.
     * @param nPuntos Entero que determina el número de puntos a sumar.
     */
    public void masPuntos(int nPuntos)  throws RemoteException
    {
        if (nPuntos == 0)
            reset();
        nVueltas += nPuntos;
        System.out.println(nVueltas);
    }

    /**
     * Método que calcula la aproximación de pi y la devuelve
     * @return Variable de tipo doble con el cálculo de la aproximación de pi.
     */
    public double aproxActual() throws RemoteException
    {
        intentos = 0;

        for(long i=0; i<nVueltas; i++)
        {
            cX = Math.random();
            cY = Math.random();
            if(Math.sqrt(Math.pow(cX, 2)+Math.pow(cY, 2))<=1)
              intentos++;
        }

        return (4.0*intentos/nVueltas);
    }

    /**
     * Reinicia el servidor estableciendo los intentos y el número de vueltas a 0.
     */
    public void reset()
    {
        intentos = 0;
        nVueltas = 0;
        System.out.println("Servidor reiniciado correctamente. \n");
    }

    /**
     * Método principal que inicializa los objetos y monta el servidor.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) 
        throws Exception
    {
        iPiMonteCarlo objRemoto = new sPiMonteCarlo();

        Naming.rebind("Servidor", objRemoto);
        System.out.println("Servidor remoto preparado");
    }
}